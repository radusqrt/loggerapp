package com.example.loggerapp.recycler_views;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggerapp.content.ActivityContent.ActivityItem;
import com.example.loggerapp.databinding.FragmentActivityItemBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ActivityItem}.
 */
public class MyActivityItemRecyclerViewAdapter extends RecyclerView.Adapter<MyActivityItemRecyclerViewAdapter.ViewHolder> {

    private final List<ActivityItem> mValues;
    private final Fragment mReferencedFragment;

    public MyActivityItemRecyclerViewAdapter(List<ActivityItem> items, Fragment referencedFragment) {
        mValues = items;
        mReferencedFragment = referencedFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentActivityItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] activityContent = holder.mItem.content.toLowerCase().split(":");
                try {
                    activityContent[1] = activityContent[1].replace("m", "").replace(" ", "");
                } catch (Exception e) {
                    Toast.makeText(view.getContext(), "Activity not like (<ACTIVITY>: <DURATION>m)", Toast.LENGTH_LONG).show();
                }

                Log.d("FirebaseActivity", "[" + activityContent[0] + " " + activityContent[1] + "]");

                FirebaseDatabase database = FirebaseDatabase.getInstance("https://loggerapp-68c5b-default-rtdb.europe-west1.firebasedatabase.app");
                DatabaseReference logsRef = database.getReference().child("logs");
                String key = logsRef.push().getKey();

                logsRef.child(key).child("timestamp").setValue(System.currentTimeMillis() / 1000);
                logsRef.child(key).child("type").setValue("activity");
                logsRef.child(key).child("activity").child("type").setValue(activityContent[0]);
                logsRef.child(key).child("activity").child("duration").setValue(activityContent[1]);

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
        public ActivityItem mItem;

        public ViewHolder(FragmentActivityItemBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}