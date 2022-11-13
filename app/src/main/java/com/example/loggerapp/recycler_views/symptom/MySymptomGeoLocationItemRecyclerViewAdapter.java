package com.example.loggerapp.recycler_views.symptom;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.symptom.SymptomGeoLocationContent.SymptomGeoLocationItem;
import com.example.loggerapp.databinding.FragmentSymptomGeoLocationItemBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SymptomGeoLocationItem}.
 */
public class MySymptomGeoLocationItemRecyclerViewAdapter extends RecyclerView.Adapter<MySymptomGeoLocationItemRecyclerViewAdapter.ViewHolder> {

    private final List<SymptomGeoLocationItem> mValues;
    private final Fragment mReferencedFragment;

    public MySymptomGeoLocationItemRecyclerViewAdapter(List<SymptomGeoLocationItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentSymptomGeoLocationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
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
                logsRef.child(key).child("type").setValue("symptom");
                logsRef.child(key).child("symptom").child("type").setValue(mReferencedFragment.getArguments().getString("symptomType").toLowerCase().replace(" ", "_"));
                logsRef.child(key).child("symptom").child("bodyLocation").setValue(mReferencedFragment.getArguments().getString("symptomBodyLocation").toLowerCase().replace(" ", "_"));
                logsRef.child(key).child("symptom").child("geoActivity").setValue(holder.mItem.content.toLowerCase().replace(" ", "_"));

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