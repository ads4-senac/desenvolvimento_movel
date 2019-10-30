package br.senac.go.aprendendoroom.data.repository.source;

import br.senac.go.aprendendoroom.data.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

	@GET("todos/1")
	Call<User> getUser();
}
