package br.senac.go.aprendendoroom.data.repository;

import android.os.AsyncTask;
import android.util.Log;
import br.senac.go.aprendendoroom.data.model.User;
import br.senac.go.aprendendoroom.data.repository.source.UserApi;
import br.senac.go.aprendendoroom.data.repository.source.dao.UserDaoSource;
import br.senac.go.aprendendoroom.data.repository.task.SaveAllUser;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

public final class UserRepository implements IUserRepository {

	public static final String TAG = UserRepository.class.getName();

	private final UserApi userApi;
	private final UserDaoSource daoSource;

	public UserRepository(UserApi userApi, UserDaoSource daoSource) {
		this.userApi = userApi;
		this.daoSource = daoSource;
	}

	@Override
	public void getAll(final Callback<List<User>> callback) {
		if (internet) {
			userApi.getUser().enqueue(new retrofit2.Callback<User>() {
				@Override
				public void onResponse(Call<User> call, Response<User> response) {
					if (response.isSuccessful()) {
						User user = response.body();
						AsyncTask<String, Integer, List<User>> asyncTask = new SaveAllUser(daoSource,
								callback, user);
						asyncTask.execute();
					}
				}

				@Override
				public void onFailure(Call<User> call, Throwable t) {
					Log.e(TAG, "Erro ao tentar salvar user em dao", t);
				}
			});
		} else {
			// busca no banco
		}
	}

	@Override
	public void crie(User model, Callback<User> callback) {

	}

	@Override
	public void delete(final User model, final Callback<User> callback) {
	}

	@Override
	public void recupere(Long identificador, Callback<User> callback) {

	}

	@Override
	public void atualize(User model, Callback<User> callback) {

	}
}
