package br.senac.go.aprendendoroom;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.senac.go.aprendendoroom.data.model.User;
import br.senac.go.aprendendoroom.data.repository.IUserRepository;
import br.senac.go.aprendendoroom.data.repository.UserRepository;
import br.senac.go.aprendendoroom.data.repository.source.UserApi;
import br.senac.go.aprendendoroom.data.repository.source.UserMemorySourceImpl;

import java.util.List;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	private RecyclerView rv;
	private IUserRepository userRepository;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rv = findViewById(R.id.recyclerView);
		UserApi userDao;
		userRepository = new UserRepository(new UserMemorySourceImpl(), userDao);
	}

	@Override
	protected void onStart() {
		super.onStart();
		userRepository.getAll(new IUserRepository.Callback<List<User>>() {
			@Override
			public void onResult(List<User> result) {
				RecyclerView.Adapter adapter = new UserAdapter(MainActivity.this, result);
				rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
				rv.setAdapter(adapter);
			}

			@Override
			public void onError(Exception e) {
				Log.e("mainAct", "Erro em carregar lista", e);
			}

			@Override
			public void onEmpty() {
				rv.setAdapter(null);
			}
		});
	}

	private class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
		private final List<User> userList;
		private final LayoutInflater layoutInflater;

		public UserAdapter(MainActivity activity, List<User> userList) {
			layoutInflater = activity.getLayoutInflater();
			this.userList = userList;
		}

		@NonNull
		@Override
		public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new ViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false));
		}

		@Override
		public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
			holder.bind(userList.get(position), position);
		}

		@Override
		public int getItemCount() {
			return userList.size();
		}

		private class ViewHolder extends RecyclerView.ViewHolder {

			private final TextView tv;

			public ViewHolder(View item) {
				super(item);
				tv = item.findViewById(R.id.textView);
			}

			public void bind(User user, int position) {
				tv.setText(user.getTitle() + " " + user.getUserId());
			}
		}
	}
}
