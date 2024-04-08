package com.example.practice6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private ImageView breedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация ImageView и DrawerLayout из layout-файла
        breedImageView = findViewById(R.id.breed_image_view);
        drawer = findViewById(R.id.drawer_layout);

        // Создание ActionBarDrawerToggle для управления DrawerLayout
        toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.drawer_open, R.string.drawer_close);

        // Добавление DrawerListener для DrawerLayout
        drawer.addDrawerListener(toggle);

        // Синхронизация состояния ActionBarDrawerToggle с DrawerLayout
        toggle.syncState();

        // Отображение кнопки меню в ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Инициализация NavigationView из layout-файла и установка NavigationItemSelectedListener
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    // Обработка нажатия на кнопку меню в ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Обработка нажатия на элемент меню в NavigationView
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // В зависимости от выбранного элемента меню устанавливается заголовок ActionBar и отображается соответствующее изображение
        if (id == R.id.nav_large_breeds) {
            getSupportActionBar().setTitle("Большие породы");
            showBreedImage(R.drawable.large_breeds);
        } else if (id == R.id.nav_medium_breeds) {
            getSupportActionBar().setTitle("Средние породы");
            showBreedImage(R.drawable.medium_breeds);
        } else if (id == R.id.nav_small_breeds) {
            getSupportActionBar().setTitle("Маленькие породы");
            showBreedImage(R.drawable.small_breeds);
        } else if (id == R.id.nav_next_activity) {
            // При выборе элемента меню "Переход на следующую активность" запускается новая активность
            startActivity(new Intent(this, NextActivity.class));
        }

        // Закрытие выдвижной панели после выбора элемента меню
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    // Метод для отображения изображения в ImageView
    private void showBreedImage(int imageResource) {
        breedImageView.setImageResource(imageResource);
        breedImageView.setVisibility(View.VISIBLE);
        breedImageView.setAdjustViewBounds(true);
        breedImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        breedImageView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER
        ));
    }
}