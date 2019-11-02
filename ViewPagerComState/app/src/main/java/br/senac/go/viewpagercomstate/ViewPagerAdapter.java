package br.senac.go.viewpagercomstate;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
		super(fm, behavior);
	}

	@NonNull
	@Override
	public Fragment getItem(int position) {
		switch(position){
			case 0:
				return new View1Fragment();
			case 1:
				return new View2Fragment();
				default:
					throw new IllegalArgumentException("Nao existe fragment para esta posicao");
		}
	}

	@Override
	public int getCount() {
		return 2;
	}
}
