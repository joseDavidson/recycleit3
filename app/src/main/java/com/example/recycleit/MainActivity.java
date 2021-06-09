package com.example.recycleit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ServiceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentTransaction transaction;
    Fragment mainFragment;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Button btnAtras,btnAtrasReciclaje,btnReciclajeTipo;

    //Commit con boton flotante cambiado UwU

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.Contenedor, mainFragment).commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
            Perfil();
        }/**Esta Parte del codigo es conflictiva.
         else if(id == R.id.item2){
         Toast.makeText(this, "Mapa", Toast.LENGTH_SHORT).show();
         Mapa();
         }**/
        return super.onOptionsItemSelected(item);

    }

    //Popup Menu
    public void Perfil() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popupperfil, null);
        //Codigo layout popup
        btnAtras = (Button) contactPopupView.findViewById(R.id.btnAtras);
        //Codigo layout popup
        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();
        //botones
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    //Popup Reciclar
    public void BtnReciclaje() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popupreciclaje, null);
        //Codigo layout popup
        btnAtrasReciclaje = (Button) contactPopupView.findViewById(R.id.btnAtrasR);
        //Codigo layout popup
        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();
        //botones
        btnAtrasReciclaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
    public void BtnReciclajeTipo() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popupreciclajeforma, null);
        //Codigo layout popup
        btnReciclajeTipo= (Button) contactPopupView.findViewById(R.id.btnAceptarPopUp2);
        //Codigo layout popup
        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.show();
        //botones
        btnReciclajeTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }
   public void reciclaje(View v){
        Toast.makeText(this, "Reciclaje", Toast.LENGTH_SHORT).show();
        BtnReciclaje();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Reciclaje", Toast.LENGTH_SHORT).show();
        BtnReciclaje();
    }
    public void reciclajeSiguiente(View v){
        Toast.makeText(this, "Forma de reciclar", Toast.LENGTH_SHORT).show();
        BtnReciclajeTipo();
    }
}






    /**Menu Mapa
    public void Mapa(){
        Intent contacto = new Intent(this,MainActivity.class);
        startActivity(contacto);
    }**/

