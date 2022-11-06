package com.example.loggerapp.recycler_views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.R;
import com.example.loggerapp.content.FoodTypeContent.FoodTypeItem;
import com.example.loggerapp.databinding.FragmentFoodTypeItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link FoodTypeItem}.
 */
public class MyFoodTypeItemRecyclerViewAdapter extends RecyclerView.Adapter<MyFoodTypeItemRecyclerViewAdapter.ViewHolder> {

    private final List<FoodTypeItem> mValues;
    private final Fragment mReferencedFragment;

    public MyFoodTypeItemRecyclerViewAdapter(List<FoodTypeItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentFoodTypeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public FoodTypeItem mItem;

        public ViewHolder(FragmentFoodTypeItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}