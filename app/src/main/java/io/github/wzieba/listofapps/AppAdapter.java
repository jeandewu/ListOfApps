package io.github.wzieba.listofapps;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import lombok.Data;

@Data
public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {
    private final List<AppInfo> appInfos;

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_row, null);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        AppInfo appInfo = appInfos.get(position);
        holder.name.setText(appInfo.getName());
        holder.icon.setImageDrawable(appInfo.getIcon());
    }

    @Override
    public int getItemCount() {
        return appInfos.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name;

        public AppViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.row_imageview);
            name = itemView.findViewById(R.id.row_textview);
        }
    }
}
