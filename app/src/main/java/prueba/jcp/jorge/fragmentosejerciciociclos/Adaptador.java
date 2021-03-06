package prueba.jcp.jorge.fragmentosejerciciociclos;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ClientViewHolder> {
 private ArrayList<CicleFlorida> aListado_ciclos;

 // Contructor
 public Adaptador(ArrayList<CicleFlorida> listado){
     aListado_ciclos = listado;
 }
    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Creamos el View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_ciclos,parent,false);

        // Retornamos el view
        return new ClientViewHolder(v);
    }

    // Obtenemos la posicion de cada uno y se lo seteamos y le pasamos la clase interna
    @Override
    public void onBindViewHolder(ClientViewHolder holder, final int position) {
        holder.tvTitulo.setText(aListado_ciclos.get(position).getTitol());
        holder.tvDesc.setText(aListado_ciclos.get(position).getDescripcio());
        holder.tvTipo.setText(aListado_ciclos.get(position).getTipus());
        holder.tvFam.setText(aListado_ciclos.get(position).getFamiliaProfessional());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aListado_ciclos.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return aListado_ciclos.size();
    }

    /**
     * Clase Interna : hereda de RecycleView
     */
    public class ClientViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitulo, tvDesc,tvTipo, tvFam;
        private ImageButton btnImage;
        private CardView card_view;
        private int pos;
        private ImageButton btnDelete, btnAñadir;

        public ClientViewHolder(View itemView) {
            super(itemView);
            card_view = itemView.findViewById(R.id.CardViewListado);

            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDesc = itemView.findViewById(R.id.tvDescripcion);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvFam = itemView.findViewById(R.id.tvFamilia);
            btnDelete = itemView.findViewById(R.id.imageButtonDelete);
            btnAñadir = itemView.findViewById(R.id.imageButtonAñadir);
        }
    }
}
