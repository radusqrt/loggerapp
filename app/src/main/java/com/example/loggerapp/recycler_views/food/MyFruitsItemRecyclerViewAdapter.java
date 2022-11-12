package com.example.loggerapp.recycler_views.food;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.food.FruitsContent.FruitsItem;
import com.example.loggerapp.databinding.FragmentFruitsItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link FruitsItem}.
 */
public class MyFruitsItemRecyclerViewAdapter extends RecyclerView.Adapter<MyFruitsItemRecyclerViewAdapter.ViewHolder> {

    private final List<FruitsItem> mValues;
    private final Fragment mReferencedFragment;

    public MyFruitsItemRecyclerViewAdapter(List<FruitsItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentFruitsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public FruitsItem mItem;

        public ViewHolder(FragmentFruitsItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}