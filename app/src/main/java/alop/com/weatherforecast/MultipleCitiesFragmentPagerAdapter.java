package alop.com.weatherforecast;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;

/**
 * Created by justbe on 4/9/15.
 */
/*
* Single fragment to the multiple city forecast on horizontal swipe
* */
public class MultipleCitiesFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] cityList;

    public MultipleCitiesFragmentPagerAdapter(android.support.v4.app.FragmentManager fm, String[] cities) {
        super(fm);
        this.cityList = cities;
    }

    @Override
    public int getCount() {
        return cityList.length;
    }

    @Override
    public Fragment getItem(int position) {
        return SingleCityPageFragment.newInstance(cityList[position]);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return cityList[position];
    }
}
