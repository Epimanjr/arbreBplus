package Arbre;

import graphique.AffichageConsole;
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
    private ArrayList<String> tabCle = new ArrayList<>();

    /**
     * Tableau de pointeurs.
     */
    private ArrayList<Object> tabPointeurs = new ArrayList<>();

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

    public Arbre arbre;

    public Noeud(Arbre a) {
        this.arbre = a;
    }

    public static Noeud creerNoeudRacine(int ordre, String cle, String valeur, Arbre b) {
        // Création du noeud
        Noeud noeud = new Noeud(b);
        noeud.setRacine(true);
        noeud.setFeuille(true);
        noeud.setOrdre(ordre);
        noeud.ajouterValeur(cle, valeur);

        return noeud;
    }

    /**
     * Méthode split.
     *
     * @return le nouveau noeud
     */
    public Noeud split() {

        // Si le Noeud père n'existe pas, alors on le créer
        boolean nouvelleRacine = false;
        if (noeudPere == null) {
            noeudPere = new Noeud(arbre);
            noeudPere.setRacine(true);
            noeudPere.setOrdre(ordre);
            noeudPere.setFeuille(false);
            // C'est la nouvelle racine de l'arbre
            arbre.setRacine(noeudPere);
            nouvelleRacine = true;
        }
        // Création du nouveau Noeud
        Noeud nouveauNoeud = new Noeud(arbre);
        nouveauNoeud.setNoeudPere(noeudPere);
        nouveauNoeud.setRacine(false);
        nouveauNoeud.setFeuille(feuille);
        nouveauNoeud.setOrdre(ordre);

        // Ajout des valeurs
        int indice = tabCle.size() / 2;

        String cle = tabCle.get(indice);

        if (nouveauNoeud.isFeuille()) {
            for (int i = indice; i < tabCle.size(); i++) {
                // Ajout de la clé dans le nouveau Noeud
                nouveauNoeud.ajouterValeur(tabCle.get(i), tabPointeurs.get(i));
            }
        } else {
            for (int i = indice; i < tabCle.size(); i++) {
                // Changement du noeud père
                ((Noeud) (tabPointeurs.get(i + 1))).setNoeudPere(nouveauNoeud);
                nouveauNoeud.getTabPointeurs().add(tabPointeurs.get(i + 1));
            }

            //old line :
            //nouveauNoeud.getTabCle().add(tabCle.get(tabCle.size()-1));
            
            //TEST DE RESOLUTION
            int compteur = nouveauNoeud.getOrdre();
            while (compteur >= 3) {
                nouveauNoeud.getTabCle().add(tabCle.get(tabCle.size() - (compteur - 2)));
                compteur--;
            }

        }

        int indiceTmp = (ordre % 2 == 0) ? indice + 1 : indice;
        for (int i = 0; i < indiceTmp; i++) {
            // Suppression de cette clé du Noeud actuel
            this.tabCle.remove(indice);

            if (this.isFeuille()) {
                this.tabPointeurs.remove(indice);
            } else {
                this.tabPointeurs.remove(indice + 1);
            }

        }

        // Mise à jour des deux taux de remplissage
        this.calculTauxRemplissage();
        nouveauNoeud.calculTauxRemplissage();

        noeudPere.ajouterValeur(cle, nouveauNoeud);
        if (nouvelleRacine) {
            noeudPere.getTabPointeurs().add(0, this);
        }

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
        for (int i = 0; i < tabCle.size(); i++) {
            try {
                // On essaie de voir si c'est un nombre
                int nstr = new Integer(str);
                int ncle = new Integer(tabCle.get(i));

                if (nstr < ncle) {
                    n = (Noeud) tabPointeurs.get(i);
                    break;
                }
            } catch (Exception e) {
                if (str.compareTo(tabCle.get(i)) < 0) {
                    n = (Noeud) tabPointeurs.get(i);
                    break;
                }
            }

        }

        // Si non initialisé, alors c'est le dernier pointeur
        // <-> str est plus grande que la dernière clé
        if (n == null) {
            n = (Noeud) tabPointeurs.get(tabPointeurs.size() - 1);
        }

        return n;
    }

    /**
     * Ajoute la valeur dans le noeud
     *
     * @param str la valeur
     */
    public void ajouterValeur(String str, Object pointeur) {
        // On ajoute la valeur au bon endroit
        boolean ajouter = false;
        int indice = -1;

        //On teste si c'est un entier
        boolean entier = false;
        Integer nstr = 0;
        try {
            nstr = new Integer(str);
            entier = true;
        } catch (Exception e) {
        }

        // Si plus petit que le premier élément, alors on l'insère au début
        if (!tabCle.isEmpty()) {
            if (entier) {
                Integer tmp = new Integer(tabCle.get(0));
                if (nstr < tmp) {
                    ajouter = true;

                }
            } else {
                if (str.compareTo(tabCle.get(0)) < 0) {
                    ajouter = true;
                }

            }

            if (ajouter) {
                tabCle.add(0, str);
                indice = 0;
            }

            if (!ajouter) {
                for (int i = 1; i < tabCle.size(); i++) {
                    // Si plus petit, on l'ajoute avant

                    if (entier) {
                        Integer tmp = new Integer(tabCle.get(i));
                        if (nstr < tmp) {
                            ajouter = true;
                        }
                    } else {
                        if (str.compareTo(tabCle.get(i)) < 0) {
                            ajouter = true;

                        }

                    }

                    if (ajouter) {
                        tabCle.add(i, str);
                        indice = i;
                        break;
                    }
                }

                // Cas de fin
                if (!ajouter) {
                    // Ajout de fin de liste
                    tabCle.add(str);
                }
            }
        } else {
            tabCle.add(str);
        }

        if (indice == (-1)) {
            this.tabPointeurs.add(pointeur);
        } else {
            if (this.isFeuille()) {
                this.tabPointeurs.add(indice, pointeur);

            } else {
                if (indice + 1 >= this.tabPointeurs.size()) {
                    this.tabPointeurs.add(pointeur);
                } else {
                    this.tabPointeurs.add(indice + 1, pointeur);

                }

            }
        }

        // Si il y a un débordement
        if (tabCle.size() > ordre) {
            this.split();
        }
    }

    /**
     * Ajoute une clé dans l'arbre et gère les pointeurs
     *
     * @param str clé à ajouter
     */
    public void ajouterCle(String str) {
        // On ajoute la valeur au bon endroit
        boolean ajouter = false;
        int indice = -1;

        // Si plus petit que le premier élément, alors on l'insère au début7
        if (!tabCle.isEmpty()) {
            if (str.compareTo(tabCle.get(0)) < 0) {
                tabCle.add(0, str);
                indice = 0;
            } else {
                for (int i = 1; i < tabCle.size(); i++) {
                    // Si plus petit, on l'ajoute avant
                    if (str.compareTo(tabCle.get(i)) < 0) {
                        tabCle.add(i, str);
                        indice = i;
                        ajouter = true;
                        break;
                    }
                }

                // Cas de fin
                if (!ajouter) {
                    // Ajout de fin de liste
                    tabCle.add(str);
                }
            }
        } else {
            // Ajout de fin de liste
            tabCle.add(str);
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
        Noeud nn = (Noeud) n;

        // Parcours de la liste des pointeurs
        if (!tabPointeurs.contains(nn)) {
            int indice = -1;
            for (int i = 0; i < tabPointeurs.size(); i++) {
                noeudCaste = (Noeud) tabPointeurs.get(i);
                if (nn.getTabCle().get(0).compareTo(noeudCaste.getTabCle().get(0)) < 0) {
                    indice = i;
                    break;
                }
            }

            if (indice == (-1)) {
                tabPointeurs.add(n);
            } else {
                tabPointeurs.add(indice, n);
            }
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

    /*
     void insererFeuille(String cle, String valeur) {
     // S'il y a de la place dans la feuille
     if (this.tauxRemplissage < 100) {
     // On insère la clé
            
     // On fait pointer la clé vers la valeur
            
     // S'il n'y a plus de place
     } else {
     // On split le noeud plein
     Noeud nouveau_noeud = this.split();
            
     // On insère dans le nouveau noeud
     nouveau_noeud.insererFeuille(cle, valeur);
     }
     }
     */
}
