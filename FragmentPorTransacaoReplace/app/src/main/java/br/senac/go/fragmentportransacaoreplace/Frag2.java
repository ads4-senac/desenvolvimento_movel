package br.senac.go.fragmentportransacaoreplace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View inflate = inflater.inflate(R.layout.frag2, container, false);
		TextView msgTV = inflate.findViewById(R.id.tv_msg);
		String text = getArguments().getString("param");
		msgTV.setText(text);

		return inflate;
	}
}
