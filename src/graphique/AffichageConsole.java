/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;

import Arbre.Arbre;
import Arbre.Noeud;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 */
public class AffichageConsole {


    /**
     * Méthode qui permet d'afficher l'arbre.
     *
     * @param b Un arbre.
     */
    public static void afficherArbre(Arbre b) {
        // On affiche la racine
        afficherNoeud(b.getRacine(), 1);
    }

    /**
     * Méthode qui permet d'afficher un Noeud.
     *
     * @param n un Noeud.
     * @param niveau niveau d'affichage (pour l'indentation)
     */
    public static void afficherNoeud(Noeud n, int niveau) {
        // Gestion des indentations
        String indent = "";
        for (int i = 0; i <= niveau; i++) {
            indent += "\t";
        }

        /* Traitement des cas particuliers */
        // Si c'est une feuille ou bien une racine
        if (n.isFeuille() || n.getTabPointeurs().isEmpty()) {
            // On affiche les clés.
            for (String str : n.getTabCle()) {
                System.out.println(indent + "--->" +str);
            }
        } else {
            /* Cas général : avec une liste de pointeurs vers les Noeuds intermédiaires */
            int i = 0;
            System.out.println("Taille clé : "+n.getTabCle().size());
            System.out.println("Taille pointeurs : "+n.getTabPointeurs().size());
            for (i = 0; i < n.getTabCle().size(); i++) {
                // Appel récursif
                afficherNoeud((Noeud) n.getTabPointeurs().get(i), (niveau + 1));

                // Affichage de la clé
                System.out.println(indent + n.getTabCle().get(i));
            }
            // Il reste le dernier Noeud à afficher
            afficherNoeud((Noeud) n.getTabPointeurs().get(i), (niveau + 1));
        }

    }
}
