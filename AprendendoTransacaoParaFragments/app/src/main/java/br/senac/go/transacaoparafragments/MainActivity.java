package br.senac.go.transacaoparafragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
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
						.add(fragmentInstance, "tag-frag1")
						.commit();
			}
		});
	}
}
