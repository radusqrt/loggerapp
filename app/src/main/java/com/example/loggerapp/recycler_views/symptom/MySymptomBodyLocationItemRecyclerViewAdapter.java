package com.example.loggerapp.recycler_views.symptom;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.R;
import com.example.loggerapp.content.symptom.SymptomBodyLocationContent.SymptomBodyLocationItem;
import com.example.loggerapp.databinding.FragmentSymptomBodyLocationItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SymptomBodyLocationItem}.
 */
public class MySymptomBodyLocationItemRecyclerViewAdapter extends RecyclerView.Adapter<MySymptomBodyLocationItemRecyclerViewAdapter.ViewHolder> {

    private final List<SymptomBodyLocationItem> mValues;
    private final Fragment mReferencedFragment;

    public MySymptomBodyLocationItemRecyclerViewAdapter(List<SymptomBodyLocationItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentSymptomBodyLocationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("symptomBodyLocation", holder.mItem.content);
                bundle.putString("symptomType", mReferencedFragment.getArguments().getString("symptomType"));
                NavHostFragment.findNavController(mReferencedFragment)
                        .navigate(R.id.action_symptomBodyLocationItemFragment_to_symptomGeoLocationItemFragment, bundle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public SymptomBodyLocationItem mItem;

        public ViewHolder(FragmentSymptomBodyLocationItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}