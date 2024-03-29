package com.example.danielviagens.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielviagens.util.DiasUtil;
import com.example.danielviagens.util.ImagensUtil;
import com.example.danielviagens.util.MoedasUtil;
import com.example.danielviagens.R;
import com.example.danielviagens.model.Pacote;

import java.util.List;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

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

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.activity_preco);
        String precoFormatado = MoedasUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoFormatado);
    }


    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.activity_dias);
        String diasEmTexto = DiasUtil.diasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }


    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.imagem_pacote);
        Drawable drawableImagemPacote = ImagensUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }


    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.nome_cidade);
        local.setText(pacote.getLocal());
    }
}
