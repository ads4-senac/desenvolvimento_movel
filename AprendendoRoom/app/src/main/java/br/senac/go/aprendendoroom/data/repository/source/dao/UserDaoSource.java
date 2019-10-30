package br.senac.go.aprendendoroom.data.repository.source.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import br.senac.go.aprendendoroom.data.model.User;

@Dao
public interface UserDaoSource {

	@Insert
	Long saveUser(User user);
}
