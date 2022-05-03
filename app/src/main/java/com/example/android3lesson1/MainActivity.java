package com.example.android3lesson1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.android3lesson1.recycler.adapter.DataAdapter;
import com.example.android3lesson1.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel mainViewModel = new MainViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        addObserver();
        setListener();
    }

    private void addObserver() {
        mainViewModel.mutableLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    DataAdapter adapter = new DataAdapter(mainViewModel.list);
                    binding.recycler.setAdapter(adapter);
                }
            }
        });
    }

    private void setListener() {
        binding.btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnGetData.setVisibility(View.INVISIBLE);
                mainViewModel.onClickBtn();
            }
        });
    }

}