package com.exe.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MasterListActivity extends FragmentActivity implements MasterListFragment.OnListItemSelectedListener {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the fragment as the content
        // A regular layout, and 600+ dp version exists
        setContentView(R.layout.master_list_fragment);        
    }
	

	@Override
	public void onListItemSelected(String comicID) {
		
		// Load the Fragment in an activity if its not present,
		// otherwise just update the fragment.
		DetailViewFragment detailView = (DetailViewFragment) getSupportFragmentManager()
			.findFragmentById(R.id.fragment_detailview);
		//detailView == null || !detailView.isInLayout()
		 
		if (!getResources().getBoolean(R.bool.isTablet)) {
			Intent showContent = new Intent(getApplicationContext(),
					DetailViewActivity.class);
			showContent.setData(Uri.parse(comicID));
			startActivity(showContent);
		} else {
			detailView.updateComic(comicID);
		}
	}
	
}