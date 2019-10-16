package dev.alexferreira.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import dev.alexferreira.R;
import dev.alexferreira.model.Aluno;
import dev.alexferreira.ui.adapter.StringAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 18/09/19 - Criar obj do tipo Usuario
        // 18/09/19 - Criar uma lista vazia do tipo Usuario
        // 18/09/19 Iniciar lista com objeto criado antes
        if (getIntent().hasExtra("chave do me argumento")) {
            double chave_do_arq = getIntent().getExtras().getDouble("chave do arq");
            fasddfasdf
        } else {
            Toast.makeText(this, "asdfasfdsf", Toast.LENGTH_SHORT).show();
            finish();
        }
        List<Aluno> listaAluno = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Aluno aluno = new Aluno();
            aluno.setDisciplina("Android-" + i);
            listaAluno.add(aluno);
        }
        RecyclerView recycler = findViewById(R.id.recyclerView);
        List<String> items = Arrays.asList("Dado 1", "Dado 2");
        recycler.setLayoutManager(new LinearLayoutManager(this));
        StringAdapter adapter = new StringAdapter(this, listaAluno, new StringAdapter.Listener() {
            @Override
            public void selectItem(Aluno item) {
                Toast.makeText(MainActivity.this, "Aluno: " + item.getDisciplina(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SegundaTela.class);
                int idade = 60;
                intent.putExtra("idade intent chave", idade);
                startActivity(intent);
            }
        });
        recycler.setAdapter(adapter);

        Fragment fragmentInstance = FragmentTeste.getInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_container, fragmentInstance)
                .commitNow();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}


