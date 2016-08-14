package com.example.googleplay;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnQueryTextListener {
	DrawerLayout mDrawerLayout;
	ActionBarDrawerToggle mDrawerToggle;
	ViewPager mViewPager;

	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getSupportActionBar();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);

		Tab tab = actionBar.newTab().setText("标签一").setTabListener(new MyTabListener());
		actionBar.addTab(tab);
		Tab tab2 = actionBar.newTab().setText("标签二").setTabListener(new MyTabListener());
		actionBar.addTab(tab2);
		Tab tab3 = actionBar.newTab().setText("标签一").setTabListener(new MyTabListener());
		actionBar.addTab(tab3);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer_am, R.string.drawer_open) {

			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				Toast.makeText(getApplication(), "close", 1).show();
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				Toast.makeText(getApplication(), "open", 1).show();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		mDrawerToggle.syncState();
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				super.onPageSelected(position);
				getSupportActionBar().setSelectedNavigationItem(position);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		searchView.setOnQueryTextListener(this);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_search) {
			return true;
		}
		return mDrawerToggle.onOptionsItemSelected(item) | super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		Toast.makeText(getApplication(), "query", 0).show();
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}

	public void click(View v) {
		Intent intents = new Intent(this, infoActivity.class);
		this.startActivity(intents);
	}

	class MyTabListener implements TabListener {

		@Override
		public void onTabReselected(Tab arg0, android.support.v4.app.FragmentTransaction arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabSelected(Tab tab, android.support.v4.app.FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			mViewPager.setCurrentItem(tab.getPosition());
			Toast.makeText(getBaseContext(), tab.getPosition() + "", 0).show();
		}

		@Override
		public void onTabUnselected(Tab arg0, android.support.v4.app.FragmentTransaction arg1) {
			// TODO Auto-generated method stub

		}
	}

}
