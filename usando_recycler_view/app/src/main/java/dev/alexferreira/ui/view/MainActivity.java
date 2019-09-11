package dev.alexferreira.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import dev.alexferreira.R;
import dev.alexferreira.ui.adapter.StringAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recyclerView);
        List<String> items = Arrays.asList("Dado 1", "Dado 2", "Dado 3");
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new StringAdapter(this, items));
    }
}
