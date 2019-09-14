package dev.alexferreira.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
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
        List<String> items = Arrays.asList("Dado 1", "Dado 2");
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new StringAdapter(this, items, new StringAdapter.Listener() {
            @Override
            public void selectItem(String item) {
                Toast.makeText(MainActivity.this, "Item selecionado: " + item, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
