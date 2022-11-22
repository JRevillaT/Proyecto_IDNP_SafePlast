package com.example.safeplast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    MiConsumo miConsumoFragment = new MiConsumo();
    Informate informateFragment = new Informate();
    Estadisticas estadisticasFragment = new Estadisticas();
    Perfil perfilFragment = new Perfil();
    Nosotros nosotrosFragment = new Nosotros();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, miConsumoFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.MiConsumo);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.MiConsumo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, miConsumoFragment).commit();
                    case R.id.Informate:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, informateFragment).commit();
                    case R.id.Estadisticas:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, estadisticasFragment).commit();
                    case R.id.MiCuenta:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, perfilFragment).commit();
                    case R.id.Nosotros:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, nosotrosFragment).commit();
                }
                return false;
            }
        });
    }
}