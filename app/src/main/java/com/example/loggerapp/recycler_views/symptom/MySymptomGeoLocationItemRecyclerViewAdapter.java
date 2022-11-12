package com.example.loggerapp.recycler_views.symptom;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.symptom.SymptomGeoLocationContent.SymptomGeoLocationItem;
import com.example.loggerapp.databinding.FragmentSymptomGeoLocationItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SymptomGeoLocationItem}.
 */
public class MySymptomGeoLocationItemRecyclerViewAdapter extends RecyclerView.Adapter<MySymptomGeoLocationItemRecyclerViewAdapter.ViewHolder> {

    private final List<SymptomGeoLocationItem> mValues;

    public MySymptomGeoLocationItemRecyclerViewAdapter(List<SymptomGeoLocationItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentSymptomGeoLocationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
        public SymptomGeoLocationItem mItem;

        public ViewHolder(FragmentSymptomGeoLocationItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}