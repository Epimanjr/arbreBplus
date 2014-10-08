package Arbre;


import java.util.ArrayList;

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
     * Le parent.
     */
    private Noeud noeudPere;

    /**
     * Tableau des clés.
     */
    private ArrayList<String> tabCle;

    /**
     * Tableau de pointeurs.
     */
    private ArrayList<Object> tabPointeurs;

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

    
    public static Noeud creerNoeudRacine(int ordre, String cle, String valeur) {
        // Création du noeud
        Noeud noeud = new Noeud();
        noeud.setRacine(true);
        noeud.setFeuille(true);
        noeud.setOrdre(ordre);
        noeud.ajouterCle(cle);
        noeud.ajouterPointeur(valeur);
        
        return noeud;
    }
    
    /**
     * Méthode split.
     * @return le nouveau noeud
     */
    public Noeud split() {
        // Création du nouveau Noeud
        Noeud nouveauNoeud = new Noeud();
        nouveauNoeud.setNoeudPere(noeudPere);
        nouveauNoeud.setRacine(false);
        nouveauNoeud.setFeuille(feuille);
        nouveauNoeud.setOrdre(ordre);

        // Ajout des valeurs
        int indice = tabCle.size() / 2;
        String cle = tabCle.get(indice);
        for (int i = indice; i < tabCle.size(); i++) {
            // Ajout de la clé dans le nouveau Noeud
            nouveauNoeud.ajouterCle(tabCle.get(indice));

            // Suppression de cette clé du Noeud actuel
            this.tabCle.remove(indice);
        }

        // Mise à jour des deux taux de remplissage
        this.calculTauxRemplissage();
        nouveauNoeud.calculTauxRemplissage();

        // Modification du noeud parent
        if(this.racine) {
            // On créer un nouveau pour la racine
            noeudPere = new Noeud();
        }
        
        noeudPere.ajouterCle(cle);
        
        
        // On renvoit le nouveau noeud
        return nouveauNoeud;
    }
    
    /**
     * Méthode fusion de la classe Noeud, fusionne deux noeuds en un seul noeud
     * 
     * @param n le noeud qui doit disparaître
     */
    public void fusion(Noeud n) {
        n.getTabCle().stream().forEach((str) -> {
            ajouterCle(str);
        });
    }
    
    /**
     * Recherche de l'indice d'une valeur cherchée
     * 
     * @param str valeur cherché
     * @return indice
     */
    public int rechercheIndice(String str) {
        return this.tabCle.indexOf(str);
    }
    
    
    /**
     * Fonction recherche de la classe Noeud
     * 
     * @param str la valeur cherchée
     * @return le résultat
     */
    public String recherche(String str) {
        // TODO
        return "";
    }
    
    /**
     * Recherche le noeud suivant pour trouver la valeur en paramètre
     * 
     * @param str valeur cherchée
     * @return le noeud en question
     */
    public Noeud rechercheNoeudSuivant(String str) {
        // Initialisation du résultat
        Noeud n = null;
        
        // Parcours de la liste des clés
        for(int i=0;i<tabCle.size();i++) {
            if(str.compareTo(tabCle.get(i)) == (-1)) {
                n = (Noeud) tabPointeurs.get(i);
            }
        }
        
        // Si non initialisé, alors c'est le dernier pointeur
        // <-> str est plus grande que la dernière clé
        if(n == null) {
            n = (Noeud) tabPointeurs.get(tabPointeurs.size() - 1);
        }
        
        return n;
    }

    /**
     * Ajoute la valeur dans le noeud
     * 
     * @param str la valeur
     */
    public void ajouterCle(String str, Object pointeur) {
        // On ajoute la valeur au bon endroit
        boolean ajouter = false;
        
        // Si plus petit que le premier élément, alors on l'insère au début
        if(str.compareTo(tabCle.get(0)) == (-1)) {
             tabCle.add(0, str);
        } else {
            for (int i = 1; i < tabCle.size(); i++) {
                // Si plus petit, on l'ajoute avant
                if(str.compareTo(tabCle.get(i)) == (-1)) {
                    tabCle.add(i, str);
                    ajouter = true;
                    break;
                }
            }
            
            // Cas de fin
            if(!ajouter) {
                // Ajout de fin de liste
                tabCle.add(str);
            }
        }

        // Si il y a un débordement
        if (tabCle.size() > ordre) {
            this.split();
        }
    }
    
    /**
     * Méthode d'ajout d'un pointeur à un noeud intermédiaire
     * 
     * @param n le pointeur
     */
    public void ajouterPointeur(Object n) {
        Noeud noeudCaste;
        Noeud nn = (Noeud)n;
        
        // Parcours de la liste des pointeurs
        int indice = -1;
        for(int i=0;i<tabPointeurs.size();i++) {
            noeudCaste  = (Noeud) tabPointeurs.get(i);
            if(nn.getTabCle().get(0).compareTo(noeudCaste.getTabCle().get(0)) == (-1)) {
                indice = i;
                break;
            }
        }
        
        if(indice == (-1)) {
            tabPointeurs.add(n);
        } else {
            tabPointeurs.add(indice, n);
        }
    }

    public void calculTauxRemplissage() {
        this.tauxRemplissage = this.tabCle.size() * 100 / this.ordre;
    }

    public Noeud getNoeudPere() {
        return noeudPere;
    }

    public void setNoeudPere(Noeud noeudPere) {
        this.noeudPere = noeudPere;
    }

    public ArrayList<String> getTabCle() {
        return tabCle;
    }

    public void setTabCle(ArrayList<String> tabCle) {
        this.tabCle = tabCle;
    }

    public ArrayList<Object> getTabPointeurs() {
        return tabPointeurs;
    }

    public void setTabPointeurs(ArrayList<Object> tabPointeurs) {
        this.tabPointeurs = tabPointeurs;
    }

    

    

    public boolean isRacine() {
        return racine;
    }

    public void setRacine(boolean racine) {
        this.racine = racine;
    }

    public boolean isFeuille() {
        return feuille;
    }

    public void setFeuille(boolean feuille) {
        this.feuille = feuille;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public int getTauxRemplissage() {
        return tauxRemplissage;
    }

    public void setTauxRemplissage(int tauxRemplissage) {
        this.tauxRemplissage = tauxRemplissage;
    }

    void insererFeuille(String cle, String valeur) {
    }


}
