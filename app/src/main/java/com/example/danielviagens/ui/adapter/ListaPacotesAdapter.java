package com.example.danielviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielviagens.R;
import com.example.danielviagens.model.Pacote;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacotes.get(position);

        TextView local = viewCriada.findViewById(R.id.nome_cidade);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.imagem_pacote);
        Resources resources = context.getResources();
        int idDoMipMap = resources.getIdentifier(pacote.getImagem(),
                "mipmap", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoMipMap);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.activity_dias);
        String diasEmTexto = "";
        int quantidadeDeDias = pacote.getDias();
        if (quantidadeDeDias > 1) {
            diasEmTexto= quantidadeDeDias+ " dias";
        }else{
            diasEmTexto = quantidadeDeDias+" dia";
        }
        dias.setText(diasEmTexto);

        TextView preco = viewCriada.findViewById(R.id.activity_preco);
        BigDecimal precoDoPacote = pacote.getPreco();
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br"));
        String precoFormatado = formatoBrasileiro.format(precoDoPacote)
                .replace("R$", "R$: ");
        preco.setText(precoFormatado);

        return viewCriada;
    }
}
