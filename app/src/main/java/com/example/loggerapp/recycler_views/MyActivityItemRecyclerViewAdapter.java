package com.example.loggerapp.recycler_views;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.ActivityContent.ActivityItem;
import com.example.loggerapp.databinding.FragmentActivityItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ActivityItem}.
 */
public class MyActivityItemRecyclerViewAdapter extends RecyclerView.Adapter<MyActivityItemRecyclerViewAdapter.ViewHolder> {

    private final List<ActivityItem> mValues;
    private final Fragment mReferencedFragment;

    public MyActivityItemRecyclerViewAdapter(List<ActivityItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentActivityItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public ActivityItem mItem;

        public ViewHolder(FragmentActivityItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}