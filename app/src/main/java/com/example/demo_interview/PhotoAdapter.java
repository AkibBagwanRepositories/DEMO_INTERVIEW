package com.example.demo_interview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Bagwan Akib on 2/4/2020.
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List<Photo> photos;
    private Context context;

    public PhotoAdapter(List<Photo> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (photos.get(position).getThumbnailUrl() == null) {
            holder.IvIcon.setVisibility(View.INVISIBLE);
        } else {
            Picasso.get().load(photos.get(position).getThumbnailUrl() + ".png").into(holder.IvIcon);
        }
        if (photos.get(position).getUrl() == null) {
            holder.IvImage.setVisibility(View.INVISIBLE);
        } else {
            Picasso.get().load(photos.get(position).getUrl() + ".png").into(holder.IvImage);
        }
        String title = photos.get(position).getId() + ": " + photos.get(position).getTitle();
        holder.txtTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView IvIcon, IvImage;
        TextView txtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IvIcon = itemView.findViewById(R.id.iv_icon);
            IvImage = itemView.findViewById(R.id.iv_photo_view);
            txtTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
