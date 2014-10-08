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
     * Notre objet arbre.
     */
    public Arbre arbre;

    /**
     * Initialisation d'un objet qui permet l'affichage en mode console.
     *
     * @param b Notre objet arbre
     */
    public AffichageConsole(Arbre b) {
        this.arbre = b;
    }

    /**
     * Méthode qui permet d'afficher l'arbre.
     *
     * @param b Un arbre.
     */
    public void afficherArbre(Arbre b) {
        // On affiche la racine
        afficherNoeud(b.getRacine(), 1);
    }

    /**
     * Méthode qui permet d'afficher un Noeud.
     *
     * @param n un Noeud.
     * @param niveau niveau d'affichage (pour l'indentation)
     */
    public void afficherNoeud(Noeud n, int niveau) {
        /* Traitement des cas particuliers */
        
        // Si c'est une feuille
        if(n.isFeuille()) {
            
        }
    }
}
