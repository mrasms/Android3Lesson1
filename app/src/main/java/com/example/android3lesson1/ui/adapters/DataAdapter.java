package com.example.android3lesson1.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3lesson1.databinding.DataHolderBinding;
import com.example.android3lesson1.interfaces.OnItemClickListener;
import com.example.android3lesson1.models.DataModel;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Holder> {

    private OnItemClickListener onItemClickListener;
    private ArrayList<DataModel> list = new ArrayList<>();

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataHolderBinding binding = DataHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DataAdapter.Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

        @SuppressLint("NotifyDataSetChanged")
    public void setList(ArrayList<DataModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private DataHolderBinding binding;

        public Holder(@NonNull DataHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(DataModel model) {
            binding.tvData.setText(model.getText());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(model);
                }
            });
        }
    }
}

