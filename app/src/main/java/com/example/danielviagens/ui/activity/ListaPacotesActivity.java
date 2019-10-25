package com.example.danielviagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.danielviagens.R;
import com.example.danielviagens.dao.PacoteDAO;
import com.example.danielviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    PacoteDAO dao = new PacoteDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle("Pacotes");

        ListView listaDePacotes = findViewById(R.id.actyvity_layout_lista);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(dao.lista(), this));
    }
}
