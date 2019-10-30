package br.senac.go.aprendendoroom.data.repository.task;

import android.os.AsyncTask;
import br.senac.go.aprendendoroom.data.model.User;
import br.senac.go.aprendendoroom.data.repository.IUserRepository;
import br.senac.go.aprendendoroom.data.repository.source.UserApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class LoadAllUser extends AsyncTask<String, Integer, List<User>> {
	private UserApi userApi;
	private IUserRepository.Callback<List<User>> callback;

	public LoadAllUser(UserApi userApi, IUserRepository.Callback<List<User>> callback) {
		this.userApi = userApi;
		this.callback = callback;
	}

	@Override
	protected List<User> doInBackground(String... strings) {
		try {
			ArrayList<User> userList = new ArrayList<>();
			userList.add(userApi.getUser().execute().body());
			return userList;
		} catch (IOException e) {
			callback.onError(e);
		} catch (Exception e) {
			callback.onError(e);
		}

		return null;
	}

	@Override
	protected void onPostExecute(List<User> users) {
		if (users == null || users.isEmpty()) {
			callback.onEmpty();
		} else {
			callback.onResult(users);
		}
	}
}
