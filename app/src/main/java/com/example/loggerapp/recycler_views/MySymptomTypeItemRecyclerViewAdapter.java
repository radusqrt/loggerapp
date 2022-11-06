package com.example.loggerapp.recycler_views;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loggerapp.content.SymptomTypeContent.SymptomTypeItem;
import com.example.loggerapp.databinding.FragmentSymptomTypeItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SymptomTypeItem}.
 */
public class MySymptomTypeItemRecyclerViewAdapter extends RecyclerView.Adapter<MySymptomTypeItemRecyclerViewAdapter.ViewHolder> {

    private final List<SymptomTypeItem> mValues;

    public MySymptomTypeItemRecyclerViewAdapter(List<SymptomTypeItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentSymptomTypeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public SymptomTypeItem mItem;

        public ViewHolder(FragmentSymptomTypeItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}