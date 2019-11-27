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
import dev.alexferreira.model.Aluno;

import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.ViewHolder> {

    private Context context;
    // TODO: 18/09/19 Alterar para ser lista de usuarios
    private List<Aluno> items;
    private Listener listener;

    // TODO: 18/09/19 - Alterar para receber uma lista de usuarios
    public StringAdapter(Context context, List<Aluno> items, Listener listener) {
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

        // TODO: 18/09/19 Alterar para receber objeto usuario
        public void bind(final Aluno item, int pos) {
            // TODO: 18/09/19 Alterar view para ter 2 textView
            // TODO: 18/09/19 um para nome e outro para sobrenome
            // TODO: 18/09/19 fazer set text de view com dado do obj usuario
            TextView title = itemView.findViewById(R.id.tv_title);
            TextView disciplinaTV = itemView.findViewById(R.id.tv_disciplina);
            title.setText("2019");
            String disciplina = item.getDisciplina();
            disciplinaTV.setText(disciplina);

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
        void selectItem(Aluno item);
    }

}
