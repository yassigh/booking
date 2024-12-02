package com.example.myhotel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AmenityAdapter extends RecyclerView.Adapter<AmenityAdapter.AmenityViewHolder> {

    private List<Amenity> amenities;

    public AmenityAdapter(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    @Override
    public AmenityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_amenity, parent, false);
        return new AmenityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AmenityViewHolder holder, int position) {
        Amenity amenity = amenities.get(position);
        holder.nameTextView.setText(amenity.getName());
        holder.iconImageView.setImageResource(amenity.getIcon());
    }

    @Override
    public int getItemCount() {
        return amenities.size();
    }

    public static class AmenityViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        ImageView iconImageView;

        public AmenityViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.amenity_name);
            iconImageView = itemView.findViewById(R.id.phone_icon);
        }
    }
}
