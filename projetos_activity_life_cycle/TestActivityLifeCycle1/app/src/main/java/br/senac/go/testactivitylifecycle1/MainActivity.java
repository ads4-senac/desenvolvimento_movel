package br.senac.go.testactivitylifecycle1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openBT = findViewById(R.id.bt_open);
        openBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        Button openDialogBT = findViewById(R.id.bt_open_dialog);
        openDialogBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("Teste de dialog")
                        .setCancelable(true)
                        .setNegativeButton("OK", null)
                        .setMessage("Veja o log agora, antes de fechar o dialog")
                        .create().show();
            }
        });
    }
}
