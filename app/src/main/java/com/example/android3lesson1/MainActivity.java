package com.example.android3lesson1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.android3lesson1.recycler.adapter.DataAdapter;
import com.example.android3lesson1.databinding.ActivityMainBinding;
import com.example.android3lesson1.recycler.models.DataModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        initAdapter();
        addObserver();
        setListener();
    }

    private void addObserver() {
        mainViewModel.mutableLiveData.observe(this, new Observer<ArrayList<DataModel>>() {
            @Override
            public void onChanged(ArrayList<DataModel> dataModels) {
                dataAdapter.setList(dataModels);
            }
        });
    }

    private void setListener() {
        binding.btnFillList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnFillList.setVisibility(View.INVISIBLE);
                mainViewModel.fillList();
            }
        });
    }

    private void initAdapter() {
        dataAdapter = new DataAdapter();
        binding.recycler.setAdapter(dataAdapter);
    }
}