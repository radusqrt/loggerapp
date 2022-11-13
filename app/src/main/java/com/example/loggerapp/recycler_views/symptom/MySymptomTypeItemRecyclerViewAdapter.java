package com.example.loggerapp.recycler_views.symptom;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loggerapp.R;
import com.example.loggerapp.content.symptom.SymptomTypeContent.SymptomTypeItem;
import com.example.loggerapp.databinding.FragmentSymptomTypeItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SymptomTypeItem}.
 */
public class MySymptomTypeItemRecyclerViewAdapter extends RecyclerView.Adapter<MySymptomTypeItemRecyclerViewAdapter.ViewHolder> {

    private final List<SymptomTypeItem> mValues;
    private final Fragment mReferencedFragment;

    public MySymptomTypeItemRecyclerViewAdapter(List<SymptomTypeItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentSymptomTypeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("symptomType", holder.mItem.content);
                NavHostFragment.findNavController(mReferencedFragment)
                        .navigate(R.id.action_symptomTypeItemFragment_to_symptomBodyLocationItemFragment, bundle);

            }
        });
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