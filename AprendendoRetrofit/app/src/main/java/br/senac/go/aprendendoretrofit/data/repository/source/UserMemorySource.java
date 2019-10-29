package br.senac.go.aprendendoretrofit.data.repository.source;

import br.senac.go.aprendendoretrofit.data.model.User;

import java.util.List;

public interface UserMemorySource extends CrudSource<User, Long> {
	List<User> getAll();
}
