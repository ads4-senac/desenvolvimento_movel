package br.senac.go.fragment_replace;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragReplaced extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View inflate = inflater.inflate(R.layout.frag1, container, false);
		TextView argumentoTV = inflate.findViewById(R.id.tv_argumento);
		String argumentoText = getArguments().getString("argumento-key");
		argumentoTV.setText(argumentoText);

		return inflate;
	}
}