package com.example.frank.boletic.eventos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.frank.boletic.R;
import com.example.frank.boletic.models.Evento;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by FRANK on 2/09/2017.
 */

public class EventsListAdapter extends BaseAdapter {

    List<Evento> events;
    Context context;

    public EventsListAdapter(List<Evento> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int i) {
        return events.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v;

        if(view == null)
            v = view.inflate(context, R.layout.item_list, null);
        else
            v = view;

        Evento event = (Evento) getItem(i);

        TextView nombre = (TextView) v.findViewById(R.id.txtNombreEvento);
        TextView direccion = (TextView) v.findViewById(R.id.txtDireccion);
        TextView date = (TextView) v.findViewById(R.id.txtDate);

        nombre.setText(event.getNombre());
        direccion.setText(event.getCiudad() + " " + event.getDireccion());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        String dateStr = formatter.format(event.getFecha());

        date.setText(dateStr + " Boletas: " + event.getCantidadBoletos());

        return v;

    }
}
