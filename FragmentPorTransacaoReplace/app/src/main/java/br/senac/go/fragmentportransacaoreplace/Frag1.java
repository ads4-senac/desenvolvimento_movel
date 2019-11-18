package br.senac.go.fragmentportransacaoreplace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View inflate = inflater.inflate(R.layout.frag1, container, false);
		Button button = inflate.findViewById(R.id.button);
		final EditText editText = inflate.findViewById(R.id.editText);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "Msg para o user", Toast.LENGTH_SHORT).show();
				String text = editText.getText().toString();
				if (text.isEmpty()) {
					Toast.makeText(getContext(), "Digite algo", Toast.LENGTH_SHORT).show();
					return;
				}

				Fragment frag2 = new Frag2();
				Bundle bundle = new Bundle();
				bundle.putString("param", text);
				frag2.setArguments(bundle);
				getFragmentManager().beginTransaction().replace(R.id.fl_container, frag2)
						.commit();
			}
		});

		return inflate;
	}
}
