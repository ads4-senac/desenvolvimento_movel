package br.senac.go.fragment_replace;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button showFragBT = findViewById(R.id.bt_show_fragment);
		showFragBT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Fragment fragmentInstance = new Frag1();
				Bundle argumentos = new Bundle();
				argumentos.putString("argumento-key", "Este é o argumento: Aprendi Transação de fragment");
				fragmentInstance.setArguments(argumentos);
				getSupportFragmentManager().beginTransaction()
						.add(R.id.fl_container, fragmentInstance, "tag-frag1")
						.commit();
			}
		});

		Button troqueFragBT = findViewById(R.id.bt_troque_fragment);
		troqueFragBT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Fragment fragmentInstance = new FragReplaced();
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.fl_container, fragmentInstance, "tag-frag2")
						.commit();
			}
		});
	}
}
