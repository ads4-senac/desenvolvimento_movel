package br.senac.go.aprendendoroom.data.repository.source;

import androidx.room.Dao;
import androidx.room.Insert;
import br.senac.go.aprendendoroom.data.model.User;

@Dao
public interface UserDaoSource {

	@Insert
	User saveUser(User user);
}
