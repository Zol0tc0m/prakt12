package com.example.prakt12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);

        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {
                Toast.makeText(getApplicationContext(), "Выбрана " + state.getName(),
                        Toast.LENGTH_SHORT).show();
                if (state.getName() == "Россия") {
                    Intent intent = new Intent(MainActivity.this, RussiaActivity.class);
                    startActivity(intent);
                } else if (state.getName() == "Германия") {
                    Intent intent = new Intent(MainActivity.this, GermanyActivity.class);
                    startActivity(intent);
                } else if (state.getName() == "Япония") {
                    Intent intent = new Intent(MainActivity.this, JapanActivity.class);
                    startActivity(intent);
                } else if (state.getName() == "Италия") {
                    Intent intent = new Intent(MainActivity.this, ItalyActivity.class);
                    startActivity(intent);
                } else if (state.getName() == "Соедененные Штаты Америки") {
                    Intent intent = new Intent(MainActivity.this, UnitedStatesActivity.class);
                    startActivity(intent);
                } else if (state.getName() == "Эквестрия") {
                    Intent intent = new Intent(MainActivity.this, EquestriaActivity.class);
                    startActivity(intent);
                }
            }
        };
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, states, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        states.add(new State ("Россия", "Москва", R.drawable.flag_of_russia));
        states.add(new State ("Германия", "Берлин", R.drawable.flag_of_germany));
        states.add(new State ("Япония", "Токио", R.drawable.flag_of_japan));
        states.add(new State ("Италия", "Рим", R.drawable.flag_of_italy));
        states.add(new State ("Соедененные Штаты Америки", "Вашингтон", R.drawable.flag_of_the_united_states_));
        states.add(new State ("Эквестрия", "Кантерлот", R.drawable.eqs_harmony));

    }
}