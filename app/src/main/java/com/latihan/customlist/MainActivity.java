package com.latihan.customlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String [] titles = {"Judul1","Judul2","Judul3","judul4","judul5"};
    String [] descriptions = {"Deskripsi1","Deskripsi2","Deskripsi3","Deskripsi4","Deskripsi5"};
    int [] images = {R.drawable.insta,R.drawable.facebook,R.drawable.placeholder,R.drawable.twitter,R.drawable.insta};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.idListView);
        MyAdapter adapter = new MyAdapter(this,titles,descriptions,images);
        lv.setAdapter(adapter);
    }
}

class MyAdapter extends ArrayAdapter {
    int [] imageArray;
    String [] titleArray;
    String [] descArray;
    public MyAdapter(Context context, String[] titles1, String[] descriptions1, int[] img1 ){
        super(context, R.layout.cuslisview_row,R.id.Title,titles1);
        this.imageArray=img1;
        this.titleArray=titles1;
        this.descArray=descriptions1;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //inflating layout
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.cuslisview_row,parent,false);

        //Get reference to the view object
        ImageView myImage = (ImageView) row.findViewById(R.id.idPic);
        TextView myTitle = (TextView) row.findViewById(R.id.Title);
        TextView myDescriptions = (TextView) row.findViewById(R.id.idDescription);

        //Providing the element of array by speciping its position
        myImage.setImageResource(imageArray[position]);
        myTitle.setText(titleArray[position]);
        myDescriptions.setText(descArray[position]);
        return  row;
    }
}

