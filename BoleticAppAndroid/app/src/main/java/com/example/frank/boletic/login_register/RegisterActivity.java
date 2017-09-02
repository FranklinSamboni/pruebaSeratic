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
import android.widget.Toast;

import com.example.frank.boletic.eventos.MainActivity;
import com.example.frank.boletic.R;
import com.example.frank.boletic.models.Usuario;
import com.example.frank.boletic.net.ApiClient;
import com.example.frank.boletic.net.ApiInterface;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTxtName,editTxtLastName,editTxtPhone,editTxtUsername, editTxtPassword;
    Button btnSignUp;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getViews();
    }

    public void getViews() {

        editTxtName = (EditText) findViewById(R.id.editTxtName);
        editTxtLastName = (EditText) findViewById(R.id.editTxtLastName);
        editTxtPhone = (EditText) findViewById(R.id.editTxtPhone);
        editTxtUsername = (EditText) findViewById(R.id.editTxtUsername);
        editTxtPassword = (EditText) findViewById(R.id.editTxtPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnSignUp = (Button) findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignup:
                handleSignUp(editTxtName.getText().toString(),
                        editTxtLastName.getText().toString(),
                        editTxtPhone.getText().toString(),
                        editTxtUsername.getText().toString(),
                        editTxtPassword.getText().toString());
                break;

        }
    }

    public void handleSignUp(String name, String lastName, String phone,String username, String password){

        if(name.isEmpty() || lastName.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty())
        {
            registerError("Todos los campos son requeridos.");
        }
        else{
            disableInputs();
            showProgress();

            Usuario user = new Usuario();
            user.setNombre(name);
            user.setClave(password);
            user.setApellido(lastName);
            user.setTelefono(phone);
            user.setUsuario(username);

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

            Call<JsonObject> call = apiInterface.registerNewUser(user);

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
                            registerError(json.get("message").getAsString());
                        }
                        else{
                            JsonObject object = json.getAsJsonObject("object");
                            saveInformationUser(Usuario.getUserFromJSON(object));
                            navigateToMainScreen();
                        }
                        Log.e("response", json.toString());

                    }
                    else {
                        registerError(getString(R.string.general_error));
                    }

                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    enableInputs();
                    hideProgress();
                    registerError(t.getMessage());
                }
            });
        }
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    private void disableInputs() {
        setInputs(false);
    }


    private void enableInputs() {
        setInputs(true);
    }

    private void saveInformationUser(Usuario user) {

        SharedPreferences preference = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();

        editor.putBoolean("Sesion",user.isHabilitado());
        editor.putString("user", user.toString());
        editor.commit();
    }

    private void navigateToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void registerError(String error) {
        editTxtPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        Toast.makeText(this,msgError,Toast.LENGTH_LONG).show();

    }

    private void setInputs(boolean enabled){
        editTxtName.setEnabled(enabled);
        editTxtLastName.setEnabled(enabled);
        editTxtPhone.setEnabled(enabled);
        editTxtUsername.setEnabled(enabled);
        editTxtPassword.setEnabled(enabled);
        btnSignUp.setEnabled(enabled);
    }
}
