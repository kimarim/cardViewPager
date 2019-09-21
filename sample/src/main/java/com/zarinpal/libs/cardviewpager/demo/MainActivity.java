package com.zarinpal.libs.cardviewpager.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zarinpal.libs.cardviwepager.CardViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardViewPager viewPager = findViewById(R.id.card_view_pager);

        Model item1 = new Model("Title 1", Color.parseColor("#1abc9c"));
        Model item2 = new Model("Title 2", Color.parseColor("#9b59b6"));
        Model item3 = new Model("Title 3", Color.parseColor("#e74c3c"));
        Model item4 = new Model("Title 4", Color.parseColor("#3498db"));
        Model item5 = new Model("Title 5", Color.parseColor("#2c3e50"));

        final Adapter adapter = new Adapter();
        adapter.addCardItem(item1);
        adapter.addCardItem(item2);
        adapter.addCardItem(item3);
        adapter.addCardItem(item4);
        adapter.addCardItem(item5);

        adapter.setElevation(0.6f);
        viewPager.setAdapter(adapter);
        viewPager.isShowShadowTransformer(true);

        viewPager.getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Toast.makeText(MainActivity.this, adapter.getItem(i).getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}
