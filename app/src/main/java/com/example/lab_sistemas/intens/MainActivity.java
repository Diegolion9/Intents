package com.example.lab_sistemas.intens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrir;
    private Button btnEnviar;
    private Button btnRecivir;
    private Button btnMarcado;
    private Button btnLlamar;
    private Button btnGmaps;
    private Button btnWeb;
    private Button btnCompartirTexto;
    private Button btnCompartirImagen;
    private Button btnEmail;
    private Button btnAbrirApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAbrir = (Button) findViewById(R.id.btnAbrir);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnRecivir = (Button) findViewById(R.id.btnRecivir);
        btnMarcado = (Button) findViewById(R.id.btnMarcado);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        btnGmaps = (Button) findViewById(R.id.btnGmaps);
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnCompartirTexto = (Button) findViewById(R.id.btnCompartirTexto);
        btnCompartirImagen = (Button) findViewById(R.id.btnCompartirImag);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnAbrirApp = (Button) findViewById(R.id.btnAbrirApp);

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                startActivity(intent);
            }
        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                intent.putExtra("dato1","Android Unifranz");
                startActivity(intent);
            }
        });
        btnRecivir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                getIntent().putExtra("dato1","Es un string");
                startActivityForResult(intent,2);
            }
        });
        btnMarcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 60588973"));
                startActivity(intent);
            }
        });
        btnGmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:-16.25451,-68.45215"));
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2){
            if(resultCode == RESULT_OK){
                String res = data.getStringExtra("respuesta").toString();
                Toast.makeText(getApplicationContext(),"RECIVIIDO: "+res,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"CANCELO LA OPERACION",Toast.LENGTH_LONG).show();
            }
        }
    }
}
