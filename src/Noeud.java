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
public class Noeud {
    
    /**
     * Identifiant du noeud.
     */
    private int id;
    
    /**
     * Le parent.
     */
    private Noeud noeudPere;
    
    /**
     * Tableau des clés.
     */
    private String[] tabCle;
    
    /**
     * Tableau de pointeurs.
     */
    private int[] tabPointeurs;
    
    /**
     * Est-ce que ce Noeud est la racine de l'arbre ?
     */
    private boolean racine;
    
    /**
     * Ce Noeud est-il une feuille ?
     */
    private boolean feuille;
    
    /**
     * Ordre de l'arbre.
     */
    private int ordre;
    
    /**
     * Le taux de remplissage.
     */
    private int tauxRemplissage;
}
