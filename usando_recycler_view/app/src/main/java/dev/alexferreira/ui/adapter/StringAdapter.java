package dev.alexferreira.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dev.alexferreira.R;

import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.ViewHolder> {

    private Context context;
    private List<String> items;
    private Listener listener;

    public StringAdapter(Context context, List<String> items, Listener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_string, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(items.get(i), i);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(final String item, int pos) {
            TextView title = itemView.findViewById(R.id.tv_title);
            title.setText(item);

            if (pos % 2 == 0) {
                title.setTypeface(title.getTypeface(), Typeface.BOLD);
            } else {
                title.setTypeface(null, Typeface.NORMAL);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.selectItem(item);
                }
            });
        }
    }

    public interface Listener {
        void selectItem(String item);
    }

}
