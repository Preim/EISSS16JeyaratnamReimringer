package com.example.preim.healthydog.Health;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.preim.healthydog.*;

import java.util.ArrayList;
import java.util.List;

public class RezepteActivity extends AppCompatActivity {

    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button bRezHinzu = (Button) findViewById(R.id.bRezHinz);
        assert bRezHinzu != null;
        /*bRezHinzu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoRezeptHinzu();
            }
        });*/
        setContentView(R.layout.activity_rezepte);
        ListView lv = (ListView) findViewById(R.id.listView);
        generateListContent();
        assert lv != null;
        lv.setAdapter(new MyListAdapter(this, R.layout.list_item, data));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RezepteActivity.this, "Rezept:" + position + " Details", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void gotoRezeptHinzu() {
        Intent rezHinzuIntent = new Intent(RezepteActivity.this, RezeptHinzufuegenActivity.class);
        RezepteActivity.this.startActivity(rezHinzuIntent);
    }
    private void generateListContent() {
        for(int i = 0; i < 10; i++) {
            data.add("Zeile:" + i);
        }
    }

    private class MyListAdapter extends ArrayAdapter<String> {
        private int layout;
        private MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout = resource;
        }
        public View getView(final int position, View convertView, ViewGroup parent){
            ViewHolder mainViewholder = null;
            if (convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
                viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_text);
                viewHolder.button = (Button) convertView.findViewById(R.id.list_item_button);
                viewHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Rezept:"+ position +" hinzufuegen", Toast.LENGTH_SHORT).show();
                    }
                });
                convertView.setTag(viewHolder);
            }else{
                mainViewholder = (ViewHolder) convertView.getTag();
                mainViewholder.title.setText(getItem(position));
            }

            return convertView;
        }
    }

    public class ViewHolder {
        ImageView thumbnail;
        TextView title;
        Button button;
    }
}
