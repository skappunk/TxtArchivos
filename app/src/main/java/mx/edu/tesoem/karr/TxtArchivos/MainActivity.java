package mx.edu.tesoem.karr.TxtArchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

EditText txtnombre;
TextView lblContenido;

    private final String nomarch="DatosKevinNash.txt";
    private ArrayList<String> TextoCompleto = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = findViewById(R.id.TxtNombre);
        lblContenido= findViewById(R.id.contenido);



    }
        public void recargar(View v){
        ManejoArchivo objmanar= new ManejoArchivo();
        objmanar.agrega(txtnombre.getText().toString(),TextoCompleto);
        TextoCompleto= objmanar.getContenido();

        if(objmanar.grabar(this,TextoCompleto,nomarch)){
            Toast.makeText(this, "Se grabó correctamente...",Toast.LENGTH_SHORT).show();
            llamadatos();
        } else{
            Toast.makeText(this, "No se grabó la informacion", Toast.LENGTH_SHORT).show();
        }
        }

        public void cargardatos(View v){
        llamadatos();
        }
        private void llamadatos(){
            ManejoArchivo informacion= new ManejoArchivo();

            if (informacion.VerificaArch(this,nomarch)){
                Toast.makeText(this, "Si existe... ", Toast.LENGTH_SHORT).show();
                if(informacion.leer(this,nomarch)){
                    TextoCompleto=informacion.getContenido();
                    String temp="";
                    for(String cadena: TextoCompleto) temp+="\n"+cadena;
                    lblContenido.setText(temp);
                }
            } else{
                Toast.makeText(this, "No existe...", Toast.LENGTH_SHORT).show();

            }

        }
        }



