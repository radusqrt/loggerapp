package com.example.loggerapp.recycler_views.food;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.food.GrainsContent.GrainsItem;
import com.example.loggerapp.databinding.FragmentGrainsItemBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link GrainsItem}.
 */
public class MyGrainsItemRecyclerViewAdapter extends RecyclerView.Adapter<MyGrainsItemRecyclerViewAdapter.ViewHolder> {

    private final List<GrainsItem> mValues;
    private final Fragment mReferencedFragment;

    public MyGrainsItemRecyclerViewAdapter(List<GrainsItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentGrainsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://loggerapp-68c5b-default-rtdb.europe-west1.firebasedatabase.app");
                DatabaseReference logsRef = database.getReference().child("logs");
                String key = logsRef.push().getKey();

                logsRef.child(key).child("timestamp").setValue(System.currentTimeMillis() / 1000);
                logsRef.child(key).child("type").setValue("food");
                logsRef.child(key).child("food").child("type").setValue("grains");
                logsRef.child(key).child("food").child("foodItem").setValue(holder.mItem.content.toLowerCase().replace(" ", "_"));

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
        public GrainsItem mItem;

        public ViewHolder(FragmentGrainsItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}