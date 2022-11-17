package com.example.loggerapp.recycler_views.food;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.food.DrinksContent.DrinksItem;
import com.example.loggerapp.databinding.FragmentDrinksItemBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Map;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DrinksItem}.
 */
public class MyDrinksItemRecyclerViewAdapter extends RecyclerView.Adapter<MyDrinksItemRecyclerViewAdapter.ViewHolder> {

    private final List<DrinksItem> mValues;
    private final Map<String, String> mDrinkType;
    private final Fragment mReferencedFragment;

    public MyDrinksItemRecyclerViewAdapter(List<DrinksItem> items, Map<String, String> drinkType, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
        mDrinkType = drinkType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentDrinksItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.i("DrinksDebug", String.valueOf(position) + ":" + mValues.get(position));
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://loggerapp-68c5b-default-rtdb.europe-west1.firebasedatabase.app");
                DatabaseReference logsRef = database.getReference().child("logs").child("test");
                String key = logsRef.push().getKey();

                logsRef.child(key).child("timestamp").setValue(System.currentTimeMillis() / 1000);
                logsRef.child(key).child("type").setValue("drink");
                logsRef.child(key).child("drink").child("type").setValue(mDrinkType.get(holder.mItem.content).toLowerCase().replace(" ", "_"));
                logsRef.child(key).child("drink").child("drinkItem").setValue(holder.mItem.content.toLowerCase().replace(" ", "_"));

                Toast.makeText(view.getContext(), String.format("Added to database: %s", holder.mItem.content.toLowerCase().replace(" ", "_")), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mContentView;
        public DrinksItem mItem;

        public ViewHolder(FragmentDrinksItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}