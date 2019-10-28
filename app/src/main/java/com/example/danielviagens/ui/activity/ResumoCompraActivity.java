
package com.example.danielviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danielviagens.R;
import com.example.danielviagens.model.Pacote;
import com.example.danielviagens.util.DataUtil;
import com.example.danielviagens.util.ImagensUtil;
import com.example.danielviagens.util.MoedasUtil;

import java.math.BigDecimal;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle("Resumo da compra");


        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        ImageView imagem = findViewById(R.id.resumo_compra_imagem_local);
        Drawable drawableDoPacote = ImagensUtil.devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);

        TextView data = findViewById(R.id.resumo_compra_data);
        String diasEmTexto = DataUtil.periodoEmTexto(pacoteSaoPaulo.getDias());
        data.setText(diasEmTexto);

        TextView preco = findViewById(R.id.resumo_compra_preco);
        String precoNoFormato = MoedasUtil.formataParaBrasileiro(pacoteSaoPaulo.getPreco());
        preco.setText(precoNoFormato);
    }
}
