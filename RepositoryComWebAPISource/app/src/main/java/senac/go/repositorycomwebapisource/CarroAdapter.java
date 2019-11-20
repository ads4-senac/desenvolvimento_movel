package senac.go.repositorycomwebapisource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import senac.go.repositorycomwebapisource.data.model.Carro;

public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Carro> carroList;

    public CarroAdapter(Context context, List<Carro> carroList) {
        this.inflater = LayoutInflater.from(context);
        this.carroList = carroList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_carro, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(carroList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return carroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView descricaoTV = itemView.findViewById(R.id.tv_descricao);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(Carro carro, int position) {
            descricaoTV.setText(carro.getDescricao());
        }
    }
}
