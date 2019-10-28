package br.senac.go.repository.data.repository;

import android.os.AsyncTask;
import br.senac.go.repository.data.model.User;
import br.senac.go.repository.data.repository.source.UserMemorySource;

import java.util.List;

public final class UserRepository implements IUserRepository {
	private UserMemorySource userMemorySource;

	public UserRepository(UserMemorySource userMemorySource) {
		this.userMemorySource = userMemorySource;
	}

	@Override
	public void getAll(final Callback<List<User>> callback) {
		AsyncTask<String, Integer, List<User>> asyncTask = new AsyncTask<String, Integer, List<User>>() {
			@Override
			protected List<User> doInBackground(String... strings) {

				return userMemorySource.getAll();
			}

			@Override
			protected void onPostExecute(List<User> users) {
				if (users == null || users.isEmpty()) {
					callback.onEmpty();
				} else {
					callback.onResult(users);
				}
			}
		};
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
