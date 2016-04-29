package com.example.segvr.healthydog.healthy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.segvr.healthydog.*;

import java.util.ArrayList;
import java.util.List;

public class Kategorien extends AppCompatActivity {
    private List<KatRezepte> mKatRezeptes = new ArrayList<KatRezepte>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorien);

        Button katButton = (Button) findViewById(R.id.kat_button);

        kategorienList();
        populateListView();


    }


    private void kategorienList() {
        mKatRezeptes.add(new KatRezepte("Hundefutter", R.drawable.hundefutter));
        mKatRezeptes.add(new KatRezepte("Hundesnack", R.drawable.hundefutter));
        mKatRezeptes.add(new KatRezepte("Fleischgerichte", R.drawable.hundefutter));
        mKatRezeptes.add(new KatRezepte("Energiereich", R.drawable.hundefutter));
    }

    private void populateListView() {
        ArrayAdapter<KatRezepte> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.kat_listview);
        assert list != null;
        list.setAdapter(adapter);
    }



    private class MyListAdapter extends ArrayAdapter<KatRezepte>{
        public MyListAdapter(){
            super(Kategorien.this, R.layout.item_view, mKatRezeptes);
            //super(Kategorien.this, R.layout.item_view, mKatRezeptes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            // Kategorie zuweisen
            KatRezepte currentKat = mKatRezeptes.get(position);

            //Image zuweisen
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentKat.getIconID());

            //Titel zuweisen
            TextView katText = (TextView) itemView.findViewById(R.id.item_katText);
            katText.setText(currentKat.getNameRez());
            return itemView;
        }
    }

}
