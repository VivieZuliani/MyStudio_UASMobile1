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

public class FragmentHoror extends Fragment {

    private static final String TAG ="FragmentHoror";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_horor, container, false);

        Button unlockedButton = view.findViewById(R.id.unlocked);
        Button sewudinoButton = view.findViewById(R.id.sewudino);
        Button themediumButton = view.findViewById(R.id.themedium);
        Button screamButton = view.findViewById(R.id.mov_scream);

        // Set click listener for each button
        unlockedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "unlocked button clicked");
                playVideo(R.raw.movieunlocked);
            }
        });

        sewudinoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Sewu Dino button clicked");
                playVideo(R.raw.moviesewudino);
            }
        });

        themediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "The Medium button clicked");
                playVideo(R.raw.moviethemedium);
            }
        });

        screamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Scream button clicked");
                playVideo(R.raw.moviescream);
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
        if (item.getItemId() == R.id.tab_Horor) {
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