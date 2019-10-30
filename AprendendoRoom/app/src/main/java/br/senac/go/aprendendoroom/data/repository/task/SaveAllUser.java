package br.senac.go.aprendendoroom.data.repository.task;

import android.os.AsyncTask;
import br.senac.go.aprendendoroom.data.model.User;
import br.senac.go.aprendendoroom.data.repository.IUserRepository;
import br.senac.go.aprendendoroom.data.repository.source.UserDaoSource;

import java.util.ArrayList;
import java.util.List;

public final class SaveAllUser extends AsyncTask<String, Integer, List<User>> {
	private final UserDaoSource userDao;
	private IUserRepository.Callback<List<User>> callback;
	private User user;

	public SaveAllUser(UserDaoSource userDaoSource, IUserRepository.Callback<List<User>> callback,
					   User user) {
		this.userDao = userDaoSource;
		this.callback = callback;
		this.user = user;
	}

	@Override
	protected List<User> doInBackground(String... strings) {
		try {
			ArrayList<User> userList = new ArrayList<>();
			userList.add(userDao.saveUser(user));
			return userList;
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
