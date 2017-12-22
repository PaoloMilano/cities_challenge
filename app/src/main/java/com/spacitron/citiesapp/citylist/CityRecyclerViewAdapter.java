package com.spacitron.citiesapp;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.spacitron.citiesapp.databinding.CityItemBinding;

import java.util.ArrayList;
import java.util.List;


public class CityRecyclerViewAdapter extends RecyclerView.Adapter<CityRecyclerViewAdapter.CityViewHolder> {

    private List<City> cities;

    public CityRecyclerViewAdapter(){
        cities = new ArrayList<>();
    }

    public void setItems(final List<City> cities){
        this.cities.clear();
        this.cities.addAll(cities);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public CityRecyclerViewAdapter.CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CityViewHolder(DataBindingUtil.<CityItemBinding>inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.city_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.bind(cities.get(position));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }


    public class CityViewHolder extends RecyclerView.ViewHolder {

        private final CityItemBinding binding;

        public CityViewHolder(CityItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(City cityItem) {
            binding.setCity(cityItem);
            binding.executePendingBindings();
        }
    }
}
