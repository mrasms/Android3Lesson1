package com.example.android3lesson1.ui.fragments.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson1.recycler.models.DataModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    public ArrayList<DataModel> list = new ArrayList<>();
    public MutableLiveData<ArrayList<DataModel>> mutableLiveData = new MutableLiveData<>();

    public void fillList() {
        list.add(new DataModel("Привет"));
        list.add(new DataModel("qwert"));
        list.add(new DataModel("asdfg"));
        list.add(new DataModel("zxcvb"));
        list.add(new DataModel("/.,mn"));
        list.add(new DataModel("lkjhgf"));
        mutableLiveData.setValue(list);
    }
}
