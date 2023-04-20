package com.example.health_north_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ppe_app_mobile.controleur.Control;
import com.example.ppe_app_mobile.modele.Customer;

import java.util.ArrayList;


public class profileActivity extends AppCompatActivity {

    private Control controle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        init();
    }

    /**
     * Permet d'initialiser l'activity
     */
    private void init() {
        controle = Control.getInstance(this);
        controle.setCustomerActivity(this);
        controle.getCustomerData();
        ecouteMenu((ImageButton)findViewById(R.id.btnBackProfileImg), DashBoardActivity.class);
    }


    /**
     * Permet d'ecouter le click sur un object de type ImageButton
     * @param imageButton l'object sur lequel il faut ecouté le click
     * @param classe l"activity a lancé si le button est clické
     */
    private void ecouteMenu(ImageButton imageButton, final Class classe){
        imageButton.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v){
                Log.d("Customer", "recuperation des clients");
                Intent intent = new Intent(profileActivity.this, classe);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    /**
     * creer la liste adapteur pour afficher la liste de tous les utilisateur de type Customer
     */
    public void creerList(){
        ArrayList<Customer> lesCustomer = controle.getAllProfile();
        if (lesCustomer != null){
            ListView lstHisto = findViewById(R.id.lstProfile);
            ProfileListAdapter adapter = new ProfileListAdapter(this, lesCustomer);
            lstHisto.setAdapter(adapter);
        }
    }

    /**
     * demande d'afficher le client dans ViewProfileActivity
     * @param customer Un object de type Customer
     */
    public void afficheCustomer(Customer customer){
        controle.setProfile(customer);
        Intent intent = new Intent(profileActivity.this, ViewProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    /**
     * Permet d'afficher un toast contenant un message d'erreur
     */
    public void customerDisplayError(){
        Toast.makeText(profileActivity.this, "Une erreur c'est produite, impossible d'afficher la liste des produit.", Toast.LENGTH_SHORT).show();
    }
}
