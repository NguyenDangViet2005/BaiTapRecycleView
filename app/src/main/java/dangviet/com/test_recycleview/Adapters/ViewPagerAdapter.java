package dangviet.com.test_recycleview.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import dangviet.com.test_recycleview.Fragments.GridFragment;
import dangviet.com.test_recycleview.Fragments.LinearFragment;
import dangviet.com.test_recycleview.Fragments.StaggeredFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LinearFragment();
            case 1:
                return new GridFragment();
            case 2:
                return new StaggeredFragment();
            default:
                return new LinearFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Số lượng tabs
    }
}
