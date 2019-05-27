package br.com.digitalhouse.exerciciofragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.exerciciofragment.fragment.Fragment1;
import br.com.digitalhouse.exerciciofragment.fragment.Fragment2;

public class MainActivity extends AppCompatActivity {

    private Button buttonGreen;
    private Button buttonRed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //Inicializa com o primeiro fragment
        addFragment(new Fragment1());

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFragment(new Fragment1());

            }
        });

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFragment(new Fragment2());

            }
        });

    }

    // Adiciona um fragmento da tela no lugar do container
    private void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack("FRAGMENTS");
        transaction.commit();

        //Pode ser feito assim
		        /*getSupportFragmentManager()
		                .beginTransaction()
		                .replace(R.id.container, fragment)
		                .addToBackStack("FRAGMENTS")
		                .commit();
		        */
    }

    private void initViews() {

        buttonGreen = findViewById(R.id.buttonGreen);
        buttonRed = findViewById(R.id.buttonRed);

    }

}
