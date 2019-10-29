package br.senac.go.aprendendoretrofit.data.repository.source;

import br.senac.go.aprendendoretrofit.data.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

	@GET("todos/1")
	Call<User> getUser();
}
