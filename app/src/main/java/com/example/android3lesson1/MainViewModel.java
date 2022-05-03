package com.example.android3lesson1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson1.recycler.models.DataModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    public MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
    public ArrayList<DataModel> list = new ArrayList<>();
    public boolean btnIsClicked = false;

    public void onClickBtn() {
        btnIsClicked = true;
        mutableLiveData.setValue(btnIsClicked);
        list.add(new DataModel("Привет"));
        list.add(new DataModel("qwert"));
        list.add(new DataModel("asdfg"));
        list.add(new DataModel("zxcvb"));
        list.add(new DataModel("/.,mn"));
        list.add(new DataModel("lkjhgf"));

    }

}
