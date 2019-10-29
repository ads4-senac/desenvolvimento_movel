package br.senac.go.aprendendoretrofit.data.repository.source;

import br.senac.go.aprendendoretrofit.data.model.User;

import java.util.List;

public final class UserMemorySourceImpl implements UserMemorySource {

	private List<User> userList;

	@Override
	public User crie(User model) {
		userList.add(model);
		return null;
	}

	@Override
	public User delete(User model) {
		boolean removed = userList.remove(model);
		if (removed) {
			return model;
		} else {
			return null;
		}
	}

	@Override
	public User recupere(Long identificador) {
		return recoverUser(identificador);
	}

	private User recoverUser(Long identificador) {
		for (User user : userList) {
			if (user.getId().equals(identificador)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User atualize(User model) {
		User user = recoverUser(model.getId());
		if (user != null) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getId().equals(model.getId())) {
					userList.set(i, model);
				}
			}
		}

		return null;
	}

	@Override
	public List<User> getAll() {
		return userList;
	}
}
