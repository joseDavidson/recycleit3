package com.example.recycleit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainFragment extends Fragment implements OnMapReadyCallback {

    public MainFragment() {
        // Required empty public constructor
    }

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }
//Mapa
    GoogleMap map;
    MapView miMapa;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        miMapa = view.findViewById(R.id.mapView);
        miMapa.onCreate(null);
        miMapa.onResume();
        miMapa.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        map = googleMap;
        LatLng restaurantSoju = new LatLng(-33.4381297,-70.6487444);
        map.addMarker(new MarkerOptions().position(restaurantSoju).title("Restaurant Soju Vegano Vegetariano").snippet("Dirección: Merced 821, 17, Santiago, Región Metropolitana").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntoreciclajeextraextrachico)));
        LatLng reciclajeReyes = new LatLng(-33.428412526129215,-70.66830728225443);
        map.addMarker(new MarkerOptions().position(reciclajeReyes).title("Punto Limpio Parque de Los Reyes").snippet("Dirección: Santiago, Región Metropolitana").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntoreciclajeextraextrachico)));
        LatLng reciclajeCerrillos = new LatLng(-33.5051505,-70.728599);
        map.addMarker(new MarkerOptions().position(reciclajeCerrillos).title("Punto Limpio TriCiclos - Sodimac Cerrillos").snippet("Dirección: Avenida Américo Vespucio 1501, Cerrillos Estacionamiento Homecenter Sodimac Mall Plaza Oeste, Santiago, Región Metropolitana").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntoreciclajeextraextrachico)));
        LatLng reciclajeElBosque = new LatLng(-33.5623518,-70.6768486);
        map.addMarker(new MarkerOptions().position(reciclajeElBosque).title("Punto Limpio TriCiclos - Sodimac El Bosque").snippet("Dirección: Av José Miguel Carrera 10375, El Bosque Estacionamiento Homecenter Sodimac Open Plaza, El Bosque, Santiago, Región Metropolitana").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntoreciclajeextraextrachico)));
        LatLng reciclajeSanJoaquin = new LatLng(-33.5,-70.61667);
        map.addMarker(new MarkerOptions().position(reciclajeSanJoaquin).title("Punto de reciclaje").snippet("Dirección: Uno de Septiembre 308, San Joaquín, Región Metropolitana").icon(BitmapDescriptorFactory.fromResource(R.drawable.puntoreciclajeextraextrachico)));
        //Centrar Mapa
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurantSoju, 11));
    }
}