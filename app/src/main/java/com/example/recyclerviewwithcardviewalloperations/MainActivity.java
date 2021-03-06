package com.example.recyclerviewwithcardviewalloperations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemOperations> mExampleList;
    private RecyclerView mRecyclerView;

    // need to create object of the class to access the custom methods of this class.
    private ItemOperationAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();
        setButtons();
        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);



    }
    public void insertItem(int position) {
        mExampleList.add(position, new ItemOperations(R.drawable.ic_android, "New Item At Position" + position, "This is Line 2"));
        mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
    /*created separate method for changing item text */
    public void changeItem(int position, String text) {
        mExampleList.get(position).changeText1(text);
        //notifying adapter about item change
        mAdapter.notifyItemChanged(position);
    }
    public void buildRecyclerView() {
        //        /*calling main recycler view*/
        mRecyclerView = findViewById(R.id.mainRecyclerView);
        /*setting the fixed size to true to show limited contains.*/
        mRecyclerView.setHasFixedSize(true);
        /*calling layout manage to set recycler view*/
        mLayoutManager = new LinearLayoutManager(this);
        /*setting adapter to recycler view that we have created*/
        mAdapter = new ItemOperationAdapter(mExampleList);
        /*need to set layout manager for the recycler view*/
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*setting adapter to recycler view*/
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ItemOperationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position,"TEXT CHANGED AT "+position);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);

            }
        });


    }
    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ItemOperations(R.drawable.ic_android, "Android", "Machine line codes"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_ac_unit, "Ac Unit", "thermal codes"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_adb, "ADB", "emulator codes"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_agriculture, "Agricultural", "farming samples"));

        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_airport_shuttle, "Shuttle bus", "get info about buses"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_apartment, "Appartment", "Location available"));
        mExampleList.add(new ItemOperations(R.drawable.ic_android, "Android", "Machine line codes"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_ac_unit, "Ac Unit", "thermal codes"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_adb, "ADB", "emulator codes"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_agriculture, "Agricultural", "farming samples"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_airport_shuttle, "Shuttle bus", "get info about buses"));
        mExampleList.add(new ItemOperations(R.drawable.ic_baseline_apartment, "Appartment", "Location available"));

    }
    public void setButtons() {
        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        //this will be operation fo remove button.
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }
}