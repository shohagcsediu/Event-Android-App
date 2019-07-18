package com.shohagapp.eventnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shohagapp.eventnote.adapter.EventAdapter;
import com.shohagapp.eventnote.model.Event;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText eventname, eventdetails;
    Button button;
    RecyclerView recyclerView;
    EventAdapter adapter;
    ArrayList<Event> events =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialize();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eventname.getText().toString().equals("")||eventdetails.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Insert Event First", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name, details;
                    name = eventname.getText().toString();
                    details = eventdetails.getText().toString();

                    Event temp = new Event(name,details);
                    events.add(temp);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void Initialize() {
        eventname = findViewById(R.id.eventnameET);
        eventdetails = findViewById(R.id.eventdetailsET);
        button = findViewById(R.id.btnET);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventAdapter(events);
        recyclerView.setAdapter(adapter);
    }
}
