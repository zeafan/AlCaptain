package com.zeafan.alcaptain;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.zeafan.alcaptain.group_pckg.GroupsActivity;
import com.zeafan.alcaptain.items_pckg.ItemsActivity;

public class Main extends AppCompatActivity {
    Button btn_items,btn_category;
    ImageButton iBtn_add_item,iBtn_add_group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.add_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this,AddItemsActivity.class));
            }
        });
        findViewById(R.id.add_group).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this,AddCategoryActivity.class));
            }
        });
        findViewById(R.id.items).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this, ItemsActivity.class));
            }
        });
       findViewById(R.id.groups).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(Main.this, GroupsActivity.class));
           }
       });

    }

}
