package br.senac.go.aprendendoroom.data.repository.source.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import br.senac.go.aprendendoroom.data.model.User;

@Database(entities = User.class, version = 1)
public abstract class AbstractDatabase extends RoomDatabase {

	public abstract UserDaoSource createDaoSource();
}
