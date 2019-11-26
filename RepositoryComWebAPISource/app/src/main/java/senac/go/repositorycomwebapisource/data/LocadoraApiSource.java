package senac.go.repositorycomwebapisource.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import senac.go.repositorycomwebapisource.data.model.Carro;

public interface LocadoraApiSource {

    @GET("/carro")
    Call<List<Carro>> getAll();

//    @POST("/carro")
//    Call<Carro> postCarro(@Body Carro carro);
}
