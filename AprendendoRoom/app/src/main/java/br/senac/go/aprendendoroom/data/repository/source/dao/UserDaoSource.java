package br.senac.go.aprendendoroom.data.repository.source.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.senac.go.aprendendoroom.data.model.User;

@Dao
public interface UserDaoSource {

	@Insert
	Long saveUser(User user);

	@Query("select * from user")
	List<User> getAll(String valor);

}
