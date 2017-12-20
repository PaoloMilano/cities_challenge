package com.spacitron.citiesapp;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spacitron.citiesapp.databinding.FragmentCityListBinding;


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
    public static void bindList(RecyclerView view, ObservableArrayList<CityViewModel.FilterableCity> list) {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(new CityRecyclerViewAdapter(list));
    }
}
