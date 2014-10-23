package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Antoine NOSAL
 * @author Maxime BLAISE
 */
public class Personne {

    private String nom;
    private int age;

    public Personne() {
        this.nom = "";
        this.age = 0;
    }
    
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public static Personne chargerDepuisFichier(String cheminFichier) {
        Personne p;
        String no = "";
        int ag = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(cheminFichier));
            try {
                String ligne;
                ligne = br.readLine();
                no = ligne.substring(4);
                ligne = br.readLine();
                ag = Integer.parseInt(ligne.substring(4));
            } finally {
                br.close();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        }
        p = new Personne(no,ag);
        return p;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", age=" + age + '}';
    }

}
