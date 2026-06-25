package com.example.multihayday;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button open = findViewById(R.id.openGame);
        ListView list = findViewById(R.id.listView);

        open.setOnClickListener(v -> {
            Intent i = getPackageManager()
                    .getLaunchIntentForPackage("com.supercell.hayday");

            if (i != null) startActivity(i);
        });

        ArrayList<String> accounts = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            accounts.add("🍏 Hay Day Account " + i + " (Supercell ID)");
        }

        list.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                accounts
        ));
    }
}