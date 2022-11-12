package com.example.loggerapp.recycler_views.food;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.food.MeatContent.MeatItem;
import com.example.loggerapp.databinding.FragmentMeatItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link MeatItem}.
 */
public class MyMeatItemRecyclerViewAdapter extends RecyclerView.Adapter<MyMeatItemRecyclerViewAdapter.ViewHolder> {

    private final List<MeatItem> mValues;
    private final Fragment mReferencedFragment;

    public MyMeatItemRecyclerViewAdapter(List<MeatItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentMeatItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public MeatItem mItem;

        public ViewHolder(FragmentMeatItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}