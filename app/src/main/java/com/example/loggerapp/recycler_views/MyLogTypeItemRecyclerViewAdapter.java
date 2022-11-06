package com.example.loggerapp.recycler_views;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loggerapp.FirstFragment;
import com.example.loggerapp.LogTypeItemFragment;
import com.example.loggerapp.R;
import com.example.loggerapp.content.LogTypeContent.LogTypeItem;
import com.example.loggerapp.databinding.FragmentLogTypeItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link LogTypeItem}.
 */
public class MyLogTypeItemRecyclerViewAdapter extends RecyclerView.Adapter<MyLogTypeItemRecyclerViewAdapter.ViewHolder> {

    private final List<LogTypeItem> mValues;
    private final Fragment mReferencedFragment;

    public MyLogTypeItemRecyclerViewAdapter(List<LogTypeItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentLogTypeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.mItem.content) {
                    case "Symptom":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_logTypeItemFragment_to_symptomTypeItemFragment);
                    default:
                        Snackbar.make(view, "Not implemented yet", 20).setAction("action", null).show();
                }

            }
        });
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