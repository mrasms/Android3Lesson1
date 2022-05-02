package com.example.android3lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.android3lesson1.adapter.DataAdapter;
import com.example.android3lesson1.databinding.ActivityMainBinding;
import com.example.android3lesson1.models.DataModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<DataModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        setListener();
    }


    private void initAdapter() {
        DataAdapter adapter = new DataAdapter(list);
        binding.recycler.setAdapter(adapter);
    }

    private void setListener() {
        binding.btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnGetData.setVisibility(View.INVISIBLE);
                list.add(new DataModel("Привет"));
                list.add(new DataModel("qwert"));
                list.add(new DataModel("asdfg"));
                list.add(new DataModel("zxcvb"));
                list.add(new DataModel("/.,mn"));
                list.add(new DataModel("lkjhgf"));
                initAdapter();
            }
        });
    }

}