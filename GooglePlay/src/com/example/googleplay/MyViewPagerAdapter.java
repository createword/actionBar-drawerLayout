package com.example.googleplay;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

	public MyViewPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		if(position==0){
			return new HomeFragment();
		}else{
			return new NavigateFragment();
		}
		
	}

}
