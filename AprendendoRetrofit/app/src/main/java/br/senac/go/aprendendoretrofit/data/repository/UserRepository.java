package br.senac.go.aprendendoretrofit.data.repository;

import android.os.AsyncTask;
import br.senac.go.aprendendoretrofit.data.model.User;
import br.senac.go.aprendendoretrofit.data.repository.source.UserApi;
import br.senac.go.aprendendoretrofit.data.repository.source.UserMemorySource;
import br.senac.go.aprendendoretrofit.data.repository.task.LoadAllUser;

import java.util.List;

public final class UserRepository implements IUserRepository {
	private UserMemorySource userMemorySource;
	private UserApi userApi;

	public UserRepository(UserMemorySource userMemorySource, UserApi userApi) {
		this.userMemorySource = userMemorySource;
		this.userApi = userApi;
	}

	@Override
	public void getAll(final Callback<List<User>> callback) {
		AsyncTask<String, Integer, List<User>> asyncTask = new LoadAllUser(userApi, callback);
		asyncTask.execute();
	}

	@Override
	public void crie(User model, Callback<User> callback) {

	}

	@Override
	public void delete(final User model, final Callback<User> callback) {
		AsyncTask<String, Integer, User> asyncTask = new AsyncTask<String, Integer, User>() {
			@Override
			protected User doInBackground(String... strings) {

				return userMemorySource.delete(model);
			}

			@Override
			protected void onPostExecute(User user) {
				if (user == null) {
					callback.onEmpty();
				} else {
					callback.onResult(user);
				}
			}
		};
		asyncTask.execute();
	}

	@Override
	public void recupere(Long identificador, Callback<User> callback) {

	}

	@Override
	public void atualize(User model, Callback<User> callback) {

	}
}
