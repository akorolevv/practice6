package com.example.practice6;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NextActivity extends AppCompatActivity
{
    // Объявление переменной для BottomNavigationView
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Инициализация BottomNavigationView из layout-файла
        bottomNavigation = findViewById(R.id.bottom_navigation);

        // Установка OnNavigationItemSelectedListener для BottomNavigationView
        bottomNavigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        // Загрузка фрагмента по умолчанию
        loadFragment(new Fragment4());
    }

    // Обработка нажатия на элемент меню в BottomNavigationView
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        // В зависимости от выбранного элемента меню устанавливается заголовок ActionBar и загружается соответствующий фрагмент
        if (id == R.id.nav_item_1) {
            getSupportActionBar().setTitle("Кнопка 1");
            loadFragment(new Fragment1());
        } else if (id == R.id.nav_item_2) {
            getSupportActionBar().setTitle("Кнопка 2");
            loadFragment(new Fragment2());
        } else if (id == R.id.nav_item_3) {
            getSupportActionBar().setTitle("Кнопка 3");
            loadFragment(new Fragment3());
        }
        return true;
    }

    // Метод для загрузки фрагмента в контейнер
    private void loadFragment(Fragment fragment)
    {
        // Начало транзакции фрагментов
        getSupportFragmentManager().beginTransaction()
                // Замена фрагмента в контейнере на новый фрагмент
                .replace(R.id.fragment_container, fragment)
                // Фиксация транзакции
                .commit();
    }
}
