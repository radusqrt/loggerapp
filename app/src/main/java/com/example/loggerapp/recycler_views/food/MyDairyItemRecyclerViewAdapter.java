package com.example.loggerapp.recycler_views.food;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.food.DairyContent.DairyItem;
import com.example.loggerapp.databinding.FragmentDairyItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DairyItem}.
 */
public class MyDairyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyDairyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DairyItem> mValues;
    private final Fragment mReferencedFragment;

    public MyDairyItemRecyclerViewAdapter(List<DairyItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
        Log.i("DairyDebug", "MyDairyItemRecyclerViewAdapter:constructor");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentDairyItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.i("DairyDebug", String.valueOf(position) + ":" + mValues.get(position));
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public DairyItem mItem;

        public ViewHolder(FragmentDairyItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}