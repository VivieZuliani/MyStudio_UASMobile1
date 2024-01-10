package com.example.mystudio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewAdapter extends FragmentStateAdapter {
    public ViewAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position){
        switch (position){
            case 0:
                return new FragmentAction();
            case 1:
                return new FragmentComedy();
            case 2:
                return new FragmentHoror();
            default:
                return new FragmentAction();
        }
    }
    @Override
    public int getItemCount(){
        return 3;
    }
}
