/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;

import Arbre.Arbre;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 */
public class Fenetre extends JFrame {

    
    public JTree arbre;
    
    /**
     * Construit la fenêtre dans laquelle on va afficher notre Arbre.
     */
    private Fenetre() {
        super();
        
        // Caractéristiques principales de la fenêtre
        this.setTitle("Manipulation d'un arbre B+");
        
        this.setPreferredSize(new Dimension(400, 400));
    }
    
    
    /**
     * Avec notre objet Arbre en paramètre, construit la fenêtre avec la JTree
     * 
     * @param b Notre objet Arbre
     */
    public static void initialiserFenetreAvecArbre(Arbre b) {
        Fenetre f = new Fenetre();
        f.arbre = construitJTree(b);
        f.getContentPane().add(new JScrollPane(f.arbre));
        f.pack();
        f.setVisible(true);
    }
    
    public static JTree construitJTree(Arbre b) {
        // Création de la racine
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode();
        
        
        return new JTree(racine);
    }
}
