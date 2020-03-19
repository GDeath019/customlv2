package com.example.ctlvbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.ET1);
        listView = (ListView)findViewById(R.id.lv1);

        ArrayList<data> listData = new ArrayList<>();
        listData.add(new data("khong co",R.drawable.test));
        listData.add(new data("Cristiano Ronaldo",R.drawable.hmm));

        final ListviewBaseAdapter adapter = new ListviewBaseAdapter(MainActivity.this, listData);

        listView.setAdapter(adapter);

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
