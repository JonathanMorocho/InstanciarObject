package com.example.listcontactos;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contacto> {

    private Context context;
    private List<Contacto> contactArrayList;

    public ContactAdapter(Context context, List<Contacto> contactArrayList){
        super(context, R.layout.list_contact);
        this.context=context;
        this.contactArrayList=contactArrayList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        final ViewHolder viewHolder;
        if(convertView == null || convertView.getTag() == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_contact,parent, false);
            viewHolder.mContactName = (TextView) view.findViewById(R.id.adapterContactName);
            view.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            view=convertView;
        }
        viewHolder.mContactName.setText(contactArrayList.get(position).getNombre());

        return null;
    }

    static class ViewHolder{
        protected TextView mContactName;
    }

    public void instanciarObjec(){
        Contacto cont = new Contacto();
        cont.setNombre("Jonathan");
        cont.setApellido("Morocho");
        cont.setDireccion("El valle");
        cont.setEmail("jamorocho@tecnologicoloja.edu.ec");
        cont.setTelefono("0969084769");

    }
}
