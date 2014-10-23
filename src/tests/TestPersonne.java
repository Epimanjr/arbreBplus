/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Arbre.Arbre;
import data.Personne;
import graphique.AffichageConsole;
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
            // Il faut mettre le dossier des données dans C:/DONNEES
            // Ex : C:/DONNEES/F1.txt
            chemin = "C:\\DONNEES\\F" + i + ".txt";
            liste.add(Personne.chargerDepuisFichier(chemin));
            System.out.println(liste.get(i-1));
        }
        
        System.out.println("");
        
        // Création d'un arbre
        Arbre b = new Arbre(3, liste.get(0).getAge() + "", liste.get(0).getNom());
        // Insertions
        for(int i=1;i<50;i++) {
            b.insertion(liste.get(i).getAge() + "", liste.get(i).getNom());
        }
        System.out.println("\nTaille de la racine : " + b.getRacine().getTabCle().size());
        // Affichage de l'arbre
        AffichageConsole.afficherArbre(b);
        
        // Création d'un arbre
        Arbre b2 = new Arbre(3, liste.get(0).getNom(), liste.get(0).getAge() + "");
        // Insertions
        for(int i=1;i<50;i++) {
            //b2.insertion(liste.get(i).getNom(), liste.get(i).getAge() + "");
        }
        //System.out.println("\nTaille de la racine : " + b2.getRacine().getTabCle().size());
        // Affichage de l'arbre
        //AffichageConsole.afficherArbre(b2);
        
    }
    
}
