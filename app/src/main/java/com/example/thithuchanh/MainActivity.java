package com.example.thithuchanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView selectedFoodTextView;
    private List<Food> foodList;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedFoodTextView = findViewById(R.id.selectedFoodTextView);

        RecyclerView foodRecyclerView = findViewById(R.id.foodRecyclerView);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodList = new ArrayList<>();
        foodList.add(new Food("Bread", R.drawable.bread));
        foodList.add(new Food("Cherry Cheesecake", R.drawable.cherrycheesecake));
        foodList.add(new Food("Gingerbread House", R.drawable.gingerbreadhouse));
        foodList.add(new Food("Hamburger", R.drawable.hamburger));
        foodList.add(new Food("Sunny Side Up Eggs", R.drawable.sunnysideupeggs));

        Collections.reverse(foodList);

        foodAdapter = new FoodAdapter(this, foodList);
        foodRecyclerView.setAdapter(foodAdapter);
    }

    public void showFood(String foodName) {
        selectedFoodTextView.setText("Món đã chọn: " + foodName + "\n" + selectedFoodTextView.getText());
    }
}