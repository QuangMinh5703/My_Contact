package com.example.mycontact;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new fragment_nhan_vien();
            case 1: return new fragment_don_vi();
            default: return new fragment_nhan_vien();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
