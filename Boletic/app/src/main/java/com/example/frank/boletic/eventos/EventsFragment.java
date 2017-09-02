package com.example.frank.boletic.eventos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.frank.boletic.R;
import com.example.frank.boletic.models.Evento;
import com.example.frank.boletic.net.ApiClient;
import com.example.frank.boletic.net.ApiInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventsFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    EventsListAdapter eventsListAdapter;

    List<Evento> dataList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_events, container, false);

        eventsListAdapter = new EventsListAdapter(dataList,getContext());

        listView = v.findViewById(R.id.id_list);
        listView.setAdapter(eventsListAdapter);
        listView.setOnItemClickListener(this);

        getAllEvents();

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onResume() {
        eventsListAdapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void getAllEvents() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> call = apiInterface.getAllEvents();

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.code() == 200)
                {
                    JsonObject json = response.body();
                    String status = json.get("status").getAsString();
                    if(Integer.parseInt(status) == -1)
                    {
                        eventsError(json.get("message").getAsString());
                    }
                    else{
                        JsonArray object = json.getAsJsonArray("object");

                        for (int i =0; i<object.size();i++){
                            dataList.add(Evento.getEventoFromJSON((JsonObject) object.get(i)));
                        }
                        eventsListAdapter.notifyDataSetChanged();
                    }
                    Log.e("response", json.toString());

                }else{
                    eventsError(getString(R.string.general_error));
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                eventsError(t.getMessage());
            }
        });


    }


    public void eventsError(String error){
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        Toast.makeText(getActivity(),msgError,Toast.LENGTH_LONG).show();
    }
}
