package com.example.sveta.firstproject.Pages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.sveta.firstproject.R;


public class HostelsPage extends AppCompatActivity {

    private Navbar navbar;

    String[] hostels = {"Общежитие №1",
                        "Общежити №2",
                        "Общежитие №3",
                        "Общежитие №5",
                        "Общежитие №6",
                        "Общежитие №7.1",
                        "Общежитие №7.2",
                        "Общежитие №8.1",
                        "Общежитие №8.2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hostels_list);

        navbar = new Navbar(this);

        Spinner spinner = (Spinner) findViewById(R.id.hostels);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hostels);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
    }
}
