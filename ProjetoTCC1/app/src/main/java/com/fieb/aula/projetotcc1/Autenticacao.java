package com.fieb.aula.projetotcc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Autenticacao extends AppCompatActivity {

    EditText edtID;
    Button btnOK;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacao);

        edtID=findViewById(R.id.edtID);
        btnOK=findViewById(R.id.btnOK);



        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validarCampos()) {
                    ID = edtID.getText().toString();

                    if(ID.equals("1234")){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else {
                        alert("ID incorreto!");
                        edtID.setText("");
                        edtID.requestFocus();
                    }
                }
            }
        });
    }


    public void alert(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private boolean validarCampos(){
        Boolean sucesso=false;

        if ((!edtID.getText().toString().isEmpty())){
            sucesso=true;
        }
        return sucesso;

    }
}