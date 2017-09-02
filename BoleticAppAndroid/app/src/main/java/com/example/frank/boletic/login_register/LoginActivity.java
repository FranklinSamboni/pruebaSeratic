package com.example.frank.boletic.login_register;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.frank.boletic.eventos.MainActivity;
import com.example.frank.boletic.R;
import com.example.frank.boletic.models.Usuario;
import com.example.frank.boletic.net.ApiClient;
import com.example.frank.boletic.net.ApiInterface;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTxtUsername, editTxtPassword;
    Button btnSignIn, btnSignUp;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getViews();
    }


    public void getViews() {

        editTxtUsername = (EditText) findViewById(R.id.editTxtUsername);
        editTxtPassword = (EditText) findViewById(R.id.editTxtPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnSignIn = (Button) findViewById(R.id.btnSignin);
        btnSignUp = (Button) findViewById(R.id.btnSignup);

        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

    }

    public void enableInputs() {
        setInputs(true);
    }

    public void disableInputs() {
        setInputs(false);
    }

    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    public void navigateToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void navigateToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void loginError(String error) {
        editTxtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        editTxtPassword.setError(msgError);
    }

    public void handleSignIn(String username, String password){

        if(username.isEmpty() || password.isEmpty())
        {
            loginError("Todos los campos son requeridos.");
        }
        else{
            disableInputs();
            showProgress();

            JsonObject json = new JsonObject();
            json.addProperty("usuario",username);
            json.addProperty("clave",password);

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<JsonObject> call = apiInterface.validateLogin(json);

            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    enableInputs();
                    hideProgress();
                    if(response.code() == 200)
                    {
                        JsonObject json = response.body();
                        String status = json.get("status").getAsString();
                        if(Integer.parseInt(status) == -1)
                        {
                            loginError(json.get("message").getAsString());
                        }
                        else{
                            JsonObject object = json.getAsJsonObject("object");
                            saveInformationUser(Usuario.getUserFromJSON(object));
                            navigateToMainScreen();
                        }
                        Log.e("response", json.toString());

                    }else{
                        loginError(getString(R.string.general_error));
                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    enableInputs();
                    hideProgress();
                    loginError(t.getMessage());
                }
            });
        }
    }

    private void saveInformationUser(Usuario user) {

        SharedPreferences preference = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();

        editor.putBoolean("Sesion",user.isHabilitado());
        editor.putString("user", user.toString());
        editor.commit();

    }

    private void setInputs(boolean enabled){
        btnSignIn.setEnabled(enabled);
        btnSignUp.setEnabled(enabled);
        editTxtUsername.setEnabled(enabled);
        editTxtPassword.setEnabled(enabled);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignin:
                handleSignIn(editTxtUsername.getText().toString(), editTxtPassword.getText().toString());
                break;
            case R.id.btnSignup:
                navigateToRegister();
                break;
        }
    }
}
