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

public class FragmentAction extends Fragment {
    private static final String TAG ="FragmentAction";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_action, container, false);

        Button huntButton = view.findViewById(R.id.hunt);
        Button timetohuntButton = view.findViewById(R.id.timetohunt);
        Button fastxButton = view.findViewById(R.id.fastx);
        Button guardianButton = view.findViewById(R.id.guardian);

        // Set click listener for each button
        huntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Hunt button clicked");
                playVideo(R.raw.moviehunt);
            }
        });

        timetohuntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Time to hunt button clicked");
                playVideo(R.raw.movietimetohunt);
            }
        });

        fastxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Fast X button clicked");
                playVideo(R.raw.moviefastx);
            }
        });

        guardianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Guardian button clicked");
                playVideo(R.raw.movieguardianofgalaxy);
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
        if (item.getItemId() == R.id.tab_action) {
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