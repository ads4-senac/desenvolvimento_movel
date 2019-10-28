package br.senac.go.repository.data.repository;

import br.senac.go.repository.data.model.User;

import java.util.List;

public interface IUserRepository {

	void crie(User model, Callback<User> callback);

	void delete(User model, Callback<User> callback);

	void recupere(Long identificador, Callback<User> callback);

	void atualize(User model, Callback<User> callback);

	void getAll(Callback<List<User>> callback);

	public interface Callback<ResultType> {

		void onResult(ResultType result);

		void onError(Exception e);

		void onEmpty();
	}
}
