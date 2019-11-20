package br.senac.go.ui.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.senac.go.R;

public class PrimeiraTela extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primeira_tela);

		Button calcularBT = findViewById(R.id.bt_calcular);
		calcularBT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText quilometroTV = findViewById(R.id.et_quilometro);
				EditText litroTV = findViewById(R.id.et_litros);

				String quilometrosText = quilometroTV.getText().toString();
				String litrosText = litroTV.getText().toString();
				if (quilometrosText.isEmpty() || litrosText.isEmpty()) {
					Toast.makeText(PrimeiraTela.this, "preencha os dados antes de calcular", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(PrimeiraTela.this, "está sendo calculado...", Toast.LENGTH_SHORT).show();
					Double quilometros = Double.valueOf(quilometrosText);
					Double litros = Double.valueOf(litrosText);
					Double consumo = quilometros/litros;
					Intent intent = new Intent(PrimeiraTela.this, TelaResultado.class);
					intent.putExtra("consumo intent key", consumo);
					startActivity(intent);
				}
			}
		});
	}
}


