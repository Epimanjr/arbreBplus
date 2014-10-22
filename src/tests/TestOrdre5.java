/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Arbre.Arbre;
import graphique.AffichageConsole;
import java.util.Scanner;

/**
 *
 * @author Maxime
 */
public class TestOrdre5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Création d'un arbre
        Arbre b = new Arbre(5, "5", "toto");
        for (int i = 0; i < 100; i++) {
            int cle = (int) (Math.random() * 100);
            String scle = "" + cle;
            b.insertion(scle, "VALEUR");

            // Affichage de l'arbre
            AffichageConsole.afficherArbre(b);

            sc.nextLine();
        }

        System.out.println("\nTaille de la racine : " + b.getRacine().getTabCle().size());

        // Affichage de l'arbre
        AffichageConsole.afficherArbre(b);

    }
}
