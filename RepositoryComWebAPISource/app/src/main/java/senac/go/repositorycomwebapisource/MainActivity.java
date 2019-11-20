package senac.go.repositorycomwebapisource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import senac.go.repositorycomwebapisource.data.ICarroRepository;
import senac.go.repositorycomwebapisource.data.RepositorioCallback;
import senac.go.repositorycomwebapisource.data.model.Carro;

public class MainActivity extends AppCompatActivity {

    private ICarroRepository carroRepository;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
    }

    @Override
    protected void onStart() {
        super.onStart();

        carroRepository.getAll(new RepositorioCallback<List<Carro>>() {
            @Override
            public void onResult(List<Carro> model) {
                rv.setAdapter(new CarroAdapter(getApplicationContext(), model));
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onEmpty() {
                Toast.makeText(MainActivity.this, "Não a dados", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
