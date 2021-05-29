package com.example.recycleit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    Fragment mainFragment;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Button btnAtras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.Contenedor,mainFragment).commit();
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1) {
            Toast.makeText(this, "Perfil", Toast.LENGTH_SHORT).show();
            createNewContacDialog();

        }
        return super.onOptionsItemSelected(item);

    }
    //Popup Menu
    public void createNewContacDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.popupperfil,null);
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
}