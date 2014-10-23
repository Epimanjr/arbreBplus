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
public class PrincipalTest {

    public static void main(String[] args) {
        // Création d'un arbre
        Arbre b = new Arbre(3, "5", "toto");
        for (int i = 0; i < 300; i++) {
            int cle = (int) (Math.random() * 100);
            String scle = ""+cle;
            b.insertion(scle, "VALEUR");
        }

        System.out.println("\nTaille de la racine : " + b.getRacine().getTabCle().size());

        // Affichage de l'arbre
        AffichageConsole.afficherArbre(b);
    }
}
