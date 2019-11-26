package senac.go.repositorycomwebapisource.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senac.go.repositorycomwebapisource.data.model.Carro;

public class CarroRepository implements ICarroRepository {

    private LocadoraApiSource api;

    public CarroRepository(LocadoraApiSource api) {
        this.api = api;
    }

    @Override
    public void getAll(final RepositorioCallback<List<Carro>> callback) {
        api.getAll().enqueue(new Callback<List<Carro>>() {
            @Override
            public void onResponse(Call<List<Carro>> call, Response<List<Carro>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Carro>> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }

    @Override
    public void postCarro(Carro carro, final RepositorioCallback<Carro> callback) {
//        api.postCarro(carro).enqueue(new Callback<Carro>() {
//            @Override
//            public void onResponse(Call<Carro> call, Response<Carro> response) {
//                callback.onResult(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Carro> call, Throwable t) {
//
//            }
//        });
    }
}
