package com.spacitron.citiesapp.utils;

import java.util.List;


public interface Callback<T> {

    void onSuccess(List<T> result);

    void onError(Throwable t);

}
