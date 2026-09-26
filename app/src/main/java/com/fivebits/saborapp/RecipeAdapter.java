package com.fivebits.saborapp;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Holder> {
    public interface OnRecipeClick { void onClick(Recipe recipe); }
    private final List<Recipe> data;
    private final OnRecipeClick listener;

    public RecipeAdapter(List<Recipe> data, OnRecipeClick listener){
        this.data = data; this.listener = listener;
    }

    @NonNull @Override public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new Holder(v);
    }
    @Override public void onBindViewHolder(@NonNull Holder h, int position){
        Recipe r = data.get(position);
        h.name.setText(r.getName());
        h.time.setText(r.getTime());
        h.itemView.setOnClickListener(v -> listener.onClick(r));
    }
    @Override public int getItemCount(){ return data.size(); }

    static class Holder extends RecyclerView.ViewHolder {
        TextView name, time;
        Holder(View v){
            super(v);
            name = v.findViewById(R.id.txtRecipeName);
            time = v.findViewById(R.id.txtRecipeTime);
        }
    }
}
