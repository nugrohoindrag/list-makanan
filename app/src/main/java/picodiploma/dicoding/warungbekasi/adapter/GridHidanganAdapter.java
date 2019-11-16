package picodiploma.dicoding.warungbekasi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import picodiploma.dicoding.warungbekasi.R;
import picodiploma.dicoding.warungbekasi.model.Hidangan;

import java.util.ArrayList;


public class GridHidanganAdapter extends RecyclerView.Adapter<GridHidanganAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Hidangan> listHidangans;

    private ArrayList<Hidangan> getListHidangans() {
        return listHidangans;
    }

    public void setListHidangans(ArrayList<Hidangan> listHidangans) {
        this.listHidangans = listHidangans;
    }

    public GridHidanganAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hidangan, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListHidangans().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListHidangans().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
