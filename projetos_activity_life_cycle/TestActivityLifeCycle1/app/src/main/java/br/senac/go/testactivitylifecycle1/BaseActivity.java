package br.senac.go.testactivitylifecycle1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Timber.i("Entrou em onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Timber.i("Entrou em onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.i("Entrou em onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.i("Entrou em onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Timber.i("Entrou em onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("Entrou em onDestroy");
    }
}
