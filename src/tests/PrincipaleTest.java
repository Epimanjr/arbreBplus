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
        b.insertion("6", "antoine");
        b.insertion("4", "maxime");
        b.insertion("7", "Denniss");
        b.insertion("2", "geoffrey");
        //b.insertion("8", "monsieur");

        System.out.println("\nTaille de la racine : " + b.getRacine().getTabCle().size());

        // Affichage de l'arbre
        AffichageConsole.afficherArbre(b);
    }
}
