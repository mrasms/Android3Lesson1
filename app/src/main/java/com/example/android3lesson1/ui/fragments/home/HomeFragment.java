package com.example.android3lesson1.ui.fragments.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android3lesson1.databinding.FragmentHomeBinding;
import com.example.android3lesson1.interfaces.OnItemClickListener;
import com.example.android3lesson1.ui.adapters.DataAdapter;
import com.example.android3lesson1.models.DataModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel = new HomeViewModel();
    private DataAdapter dataAdapter = new DataAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        initAdapter();
        addObserver();
        checkList();
    }

    private void initAdapter() {
        binding.recycler.setAdapter(dataAdapter);
        dataAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(DataModel dataModel) {
                Navigation.findNavController(requireView()).navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(dataModel));
            }
        });
    }

    private void addObserver() {
        homeViewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<DataModel>>() {
            @Override
            public void onChanged(ArrayList<DataModel> dataModels) {
                dataAdapter.setList(dataModels);
            }
        });
    }

    private void checkList() {
        if (homeViewModel.mutableLiveData.getValue() == null) {
            setListener();
        } else {
            binding.btnFillList.setVisibility(View.INVISIBLE);
        }
    }

    private void setListener() {
        binding.btnFillList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnFillList.setVisibility(View.INVISIBLE);
                homeViewModel.fillList();
            }
        });
    }
}