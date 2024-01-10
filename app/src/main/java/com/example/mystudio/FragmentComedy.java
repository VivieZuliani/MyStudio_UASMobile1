package com.example.mystudio;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentComedy extends Fragment {
    private static final String TAG ="FragmentComedy";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_comedy, container, false);

        Button luckButton = view.findViewById(R.id.luck);
        Button thebig4Button = view.findViewById(R.id.theBig4);
        Button thepiratesButton = view.findViewById(R.id.thePirates);
        Button familyswitchButton = view.findViewById(R.id.familySwitch);

        // Set click listener for each button
        luckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "luck button clicked");
                playVideo(R.raw.movieluck);
            }
        });

        thebig4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "The Big 4 button clicked");
                playVideo(R.raw.moviethebig4);
            }
        });

        familyswitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Family Switch button clicked");
                playVideo(R.raw.moviefamilyswitch);
            }
        });

        thepiratesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "The pirates button clicked");
                playVideo(R.raw.moviethepirates);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_tab, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tab_comedy) {
            Toast.makeText(getActivity(), "Clicked on " + item.getTitle(), Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }

    private void playVideo(int videoResource) {
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + videoResource;
        Intent intent = new Intent(getActivity(), VideoPlayerActivity.class);
        intent.putExtra("VIDEO_PATH", videoPath);
        startActivity(intent);
    }
}


