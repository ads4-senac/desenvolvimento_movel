package br.senac.go.testactivitylifecycle1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		Timber.i("Entrou em onCreate %s", this.getClass().getCanonicalName());
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onRestart() {
		Timber.i("Entrou em onRestart %s", this.getClass().getCanonicalName());
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Timber.i("Entrou em onResume %s", this.getClass().getCanonicalName());
		super.onResume();
	}

	@Override
	protected void onStart() {
		Timber.i("Entrou em onStart %s", this.getClass().getCanonicalName());
		super.onStart();
	}

	@Override
	protected void onStop() {
		Timber.i("Entrou em onStop %s", this.getClass().getCanonicalName());
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Timber.i("Entrou em onDestroy %s", this.getClass().getCanonicalName());
		super.onDestroy();
	}
}
