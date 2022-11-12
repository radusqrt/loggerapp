package com.example.loggerapp.recycler_views;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.R;
import com.example.loggerapp.content.SupplementsContent.SupplementsItem;
import com.example.loggerapp.databinding.FragmentSupplementsItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SupplementsItem}.
 */
public class MySupplementsItemRecyclerViewAdapter extends RecyclerView.Adapter<MySupplementsItemRecyclerViewAdapter.ViewHolder> {

    private final List<SupplementsItem> mValues;
    private final Fragment mReferencedFragment;

    public MySupplementsItemRecyclerViewAdapter(List<SupplementsItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentSupplementsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public SupplementsItem mItem;

        public ViewHolder(FragmentSupplementsItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}