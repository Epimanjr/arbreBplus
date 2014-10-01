/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 */
public class Arbre {
    
    private Noeud racine;
    
    public Arbre(int ordre, String cle, String valeur) {
        // Initialisation de la racine
        this.racine = Noeud.creerNoeudRacine(ordre, cle, valeur);
    }

    public Noeud getRacine() {
        return racine;
    }

    public void setRacine(Noeud racine) {
        this.racine = racine;
    }
    
    
}
