package com.begentgroup.samplecustomlist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new PersonAdapter();
        mAdapter.setOnAdapterItemClickListener(new PersonAdapter.OnAdapterItemClickListener() {
            @Override
            public void onItemImageClick(PersonAdapter apdater, PersonView view, Person person) {
                Toast.makeText(MainActivity.this, "item image click : " + person.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, Person person) {
                Toast.makeText(MainActivity.this, "item image click : " + person.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person p = (Person)listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "person : " + p.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        initData();
    }

    private void initData() {
        for (int i = 0 ; i < 40 ; i++) {
            Person p = new Person();
            p.setName("item" + i);
            p.setAge(i);
            p.setPhoto(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
            mAdapter.add(p);
        }
    }
}
