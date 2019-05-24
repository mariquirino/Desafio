package com.mariana.cesar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    final List<String> myDataset = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDataset.add("Teste");
        myDataset.add("Teste2");
        myDataset.add("Outro");
        myDataset.add("You");


        setUpRecyclerView();


        //Quando clicar no botao de pesquisar
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                List<String> words = new ArrayList<>();

//                for (String word : myDataset) {
//                    Verify verify = new Verify();
//                    //Verificar pois so pega a palavra correta
//                    if (verify.verifyPermuted(word, editText.getText().toString()) || verify.verifyTypo(word, editText.getText().toString())) {
////                        if (verify.verifyTypo(word, editText.getText().toString())) {
//                        words.add(word);
////                        }
//                    }
//                }

//                mAdapter = new Adapter(words);
//                adapter = new Adapter(myDataset);

                EditText editText = (EditText) findViewById(R.id.search);
                adapter.getFilter().filter(editText.getText().toString());
            }
        });
//        mAdapter = new Adapter(myDataset);
//        recyclerView.setAdapter(mAdapter);
    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(adapter);
    }


}
