/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphique;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Maxime BLAISE
 */
public class Fenetre extends JFrame {
    
    /**
     * Construit la fenêtre dans laquelle on va afficher notre Arbre.
     */
    private Fenetre() {
        super();
        
        // Caractéristiques principales de la fenêtre
        this.setTitle("Manipulation d'un arbre B+");
        
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        this.setVisible(true);
    }
    
    
    public static void initialiserFenetreAvecArbre(Arb b) {
        
    }
}
