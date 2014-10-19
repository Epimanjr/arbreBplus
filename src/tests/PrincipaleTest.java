/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Arbre.Arbre;
import graphique.AffichageConsole;

/**
 *
 * @author Maxime
 */
public class PrincipaleTest {

    public static void main(String[] args) {
        // Création d'un arbre
        Arbre b = new Arbre(3, "5", "toto");
        b.insertion("20", "antoine");
        b.insertion("10", "maxime");
        //b.insertion("40", "Denniss");
        //b.insertion("30", "geoffrey");
        //b.insertion("25", "monsieur");
        //b.insertion("35", "UN");
        //b.insertion("15", "TROIS");
       // b.insertion("80", "NEUF");
        //b.insertion("90", "DIX");
        //b.insertion("55", "ONZE");

        System.out.println("\nTaille de la racine : " + b.getRacine().getTabCle().size());

        // Affichage de l'arbre
        AffichageConsole.afficherArbre(b);
    }
}
