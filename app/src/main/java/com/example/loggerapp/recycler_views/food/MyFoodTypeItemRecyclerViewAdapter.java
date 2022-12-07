package com.example.loggerapp.recycler_views.food;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.R;
import com.example.loggerapp.content.food.FoodTypeContent.FoodTypeItem;
import com.example.loggerapp.databinding.FragmentFoodTypeItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link FoodTypeItem}.
 */
public class MyFoodTypeItemRecyclerViewAdapter extends RecyclerView.Adapter<MyFoodTypeItemRecyclerViewAdapter.ViewHolder> {

    private final List<FoodTypeItem> mValues;
    private final Fragment mReferencedFragment;

    public MyFoodTypeItemRecyclerViewAdapter(List<FoodTypeItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentFoodTypeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (holder.mItem.content) {
                    case "Dairy":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_dairyItemFragment);
                        break;
                    case "Fruits":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_fruitsItemFragment);
                        break;
                    case "Grains":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_grainsItemFragment);
                        break;
                    case "Meat":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_meatItemFragment);
                        break;
                    case "Vegetables":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_vegetablesItemFragment);
                        break;
                    case "Drinks":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_drinksItemFragment);
                        break;
                    case "Pantry":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_pantryItemFragment);
                        break;
                    case "Nuts":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_nutsItemFragment);
                        break;
                    case "Specific meals":
                        NavHostFragment.findNavController(mReferencedFragment)
                                .navigate(R.id.action_foodTypeItemFragment_to_specificMealsItemFragment);
                        break;
                    default:
                        Snackbar.make(view, "Not implemented yet", 500).setAction("action", null).show();
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
        public FoodTypeItem mItem;

        public ViewHolder(FragmentFoodTypeItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}