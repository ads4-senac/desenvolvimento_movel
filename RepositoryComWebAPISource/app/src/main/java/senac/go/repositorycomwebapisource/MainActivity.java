package senac.go.repositorycomwebapisource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import senac.go.repositorycomwebapisource.data.CarroRepository;
import senac.go.repositorycomwebapisource.data.ICarroRepository;
import senac.go.repositorycomwebapisource.data.LocadoraApiSource;
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("localhost:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LocadoraApiSource api = retrofit.create(LocadoraApiSource.class);
        carroRepository = new CarroRepository(api);
        Button botao = findViewById(R.id.button);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carro carro = new Carro();
                carro.setDescricao("Qualquer desc");
                carroRepository.postCarro(carro, new RepositorioCallback<Carro>() {
                    @Override
                    public void onResult(Carro model) {
                        Toast.makeText(MainActivity.this, "Foi enviado", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onEmpty() {

                    }
                });
            }
        });
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
