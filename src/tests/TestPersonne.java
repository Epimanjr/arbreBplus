/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import data.Personne;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class TestPersonne {

    public static void main(String[] args) {
        
        //Parcourir tous les fichiers      
        //Utiliser la méthode charger de Personne
        //Stocker les personnes (liste)
        //Créer l'arbre de personnes
        
        String chemin;
        ArrayList<Personne> liste = new ArrayList<>();
        
        for(int i=1;i<51;i++) {
            chemin = "C:\\DONNEES\\F" + i + ".txt";
            System.out.println(chemin);
            liste.add(Personne.chargerDepuisFichier(chemin));
            System.out.println(liste.get(i-1));
        }
        
        
        
    }
    
}
