package com.example.baikt1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Facebook","Whatsapp","Gmail","Instagram","Youtube"};
    String mDescription[] = {"Facebook Description","Whatsapp Description","Gmail Description","Instagram Description","Youtube Description"};
    int images[] = {R.drawable.fb, R.drawable.whatsapp, R.drawable.gmail, R.drawable.im, R.drawable.youtube};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter( this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position ==0){
                    Toast.makeText( ListActivity.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if(position ==0){
                    Toast.makeText( ListActivity.this, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if(position ==0){
                    Toast.makeText( ListActivity.this, "Gmail Description", Toast.LENGTH_SHORT).show();
                }
                if(position ==0){
                    Toast.makeText( ListActivity.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if(position ==0){
                    Toast.makeText( ListActivity.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        MyAdapter(Context c, String title[], String description[], int imgs[]){
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convretView, @Nullable ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View  row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;


        }
    }
}