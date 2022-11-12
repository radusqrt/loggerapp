package com.example.loggerapp.recycler_views.food;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.food.VegetablesContent.VegetablesItem;
import com.example.loggerapp.databinding.FragmentVegetablesItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link VegetablesItem}.
 */
public class MyVegetablesItemRecyclerViewAdapter extends RecyclerView.Adapter<MyVegetablesItemRecyclerViewAdapter.ViewHolder> {

    private final List<VegetablesItem> mValues;
    private final Fragment mReferencedFragment;

    public MyVegetablesItemRecyclerViewAdapter(List<VegetablesItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentVegetablesItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public VegetablesItem mItem;

        public ViewHolder(FragmentVegetablesItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}