package com.spacitron.citiesapp.citylist;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spacitron.citiesapp.R;
import com.spacitron.citiesapp.citymodel.City;
import com.spacitron.citiesapp.cityviewmodel.CityViewModel;
import com.spacitron.citiesapp.databinding.FragmentCityListBinding;
import com.spacitron.citiesapp.utils.OnItemSelectedListener;

import java.util.List;


public class CityListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final FragmentCityListBinding fragmentCityListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_city_list, container, false);

        // ViewModel is shared with the parent activity
        fragmentCityListBinding.setCityViewModel(ViewModelProviders.of(getActivity()).get(CityViewModel.class));
        return fragmentCityListBinding.getRoot();
    }


    @BindingAdapter("bind:items")
    public static void bindList(final RecyclerView view, final List<City> list) {
        getRecyclerViewAdapter(view).setItems(list);
    }

    @BindingAdapter("bind:onItemSelected")
    public static void bindOnItemSelected(final RecyclerView view, final OnItemSelectedListener<City> onItemSelectedListener) {
        getRecyclerViewAdapter(view).setOnItemSelectedLustever(onItemSelectedListener);
    }


    private static CityRecyclerViewAdapter getRecyclerViewAdapter(final RecyclerView view) {
        if (view.getAdapter() == null) {
            final LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
            view.setLayoutManager(layoutManager);
            view.setAdapter(new CityRecyclerViewAdapter());
        }
        return ((CityRecyclerViewAdapter) view.getAdapter());
    }
}
