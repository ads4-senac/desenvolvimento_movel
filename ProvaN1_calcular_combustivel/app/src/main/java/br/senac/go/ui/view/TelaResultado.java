package br.senac.go.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import br.senac.go.R;

public class TelaResultado extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_resultado);

		Intent intent = getIntent();
		if (intent.getExtras() == null) {
			Toast.makeText(this, "O consumo não pode ser calculado, verifique os dados inseridos e tente novamente", Toast.LENGTH_SHORT).show();
			TelaResultado.this.finish();
		} else {
			String consumo_intent_key = "consumo intent key";
			if (intent.hasExtra(consumo_intent_key)) {
				double consumo = intent.getExtras().getDouble(consumo_intent_key);
				TextView consumoTV = findViewById(R.id.tv_consumo);
				consumoTV.setText(String.valueOf(consumo));
			}
		}
	}
}

