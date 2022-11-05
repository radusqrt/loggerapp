package com.example.loggerapp.recycler_views;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loggerapp.content.LogTypeContent.LogTypeItem;
import com.example.loggerapp.databinding.FragmentLogTypeItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link LogTypeItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLogTypeItemRecyclerViewAdapter extends RecyclerView.Adapter<MyLogTypeItemRecyclerViewAdapter.ViewHolder> {

    private final List<LogTypeItem> mValues;

    public MyLogTypeItemRecyclerViewAdapter(List<LogTypeItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentLogTypeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public LogTypeItem mItem;

        public ViewHolder(FragmentLogTypeItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}