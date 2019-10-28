package br.senac.go.repository.data.repository.source;

import br.senac.go.repository.data.model.User;

import java.util.List;

public interface UserMemorySource extends CrudSource<User, Long> {
	List<User> getAll();
}
