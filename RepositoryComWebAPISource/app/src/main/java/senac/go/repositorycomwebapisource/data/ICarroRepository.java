package senac.go.repositorycomwebapisource.data;

import java.util.List;

import senac.go.repositorycomwebapisource.data.model.Carro;

public interface ICarroRepository {

    void getAll(RepositorioCallback<List<Carro>> callback);

    void postCarro(Carro carro, RepositorioCallback<Carro> callback);
}
