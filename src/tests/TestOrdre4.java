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
public class TestOrdre4 {

    public static void main(String[] args) {

        // Création d'un arbre
        Arbre b = new Arbre(4, "5", "toto");
        b.insertion("20", "antoine");
        b.insertion("10", "maxime");
        b.insertion("40", "Denniss");
        b.insertion("30", "geoffrey");
        //b.insertion("25", "monsieur");
        //b.insertion("35", "UN");
//        b.insertion("15", "TROIS");
//        b.insertion("80", "NEUF");
//        b.insertion("90", "DIX");
//        b.insertion("55", "ONZE");
//        b.insertion("33", "DOUZE");
//        b.insertion("34", "TREIZE");
//        b.insertion("60", "SOIXANTE");
//        b.insertion("85", "85");
//        b.insertion("86", "86");
//        b.insertion("82", "82");
//        b.insertion("32", "32");
  //      b.insertion("58", "58");
//        b.insertion("12", "DOUZE");

        System.out.println("\nTaille de la racine : " + b.getRacine().getTabCle().size());

        // Affichage de l'arbre
        AffichageConsole.afficherArbre(b);

    }
}
