/**
 * La classe <code>Partie</code> est la classe maitresse de notre modèle, 
 * elle contient tout les éléments nécessaire à la modélisation d'une partie (Grille, etc..).
 * 
 * 
 * @version 1.0
 * @author Nicolas Petronis et Yuness Soussi
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import java.util.Scanner;

public class Partie {

    /**
     * Enumeration des statuts possible pour une partie. 
     */
    enum EtatPartie {
        EN_COURS,
        GAGNE,
        PERDU
    }
    /**
     * Etat de la partie.
     */
    EtatPartie etat;

    /**
     * Objet grille de la partie.
     */
    Grille grille;

    Parametre para;

    
    /**
     * Nombre de mines. 
     */
    int nbMines;

    /**
     * Nombre de cases révélées. 
     */
    int casesRevelees = 0;

    /**
     * Nombre de drapeaux. 
     */
    int drapeaux = 0;

    /**
     * Objet de la classe Random, qui stock un nombre aléatoire
     */
    Random r = new Random();

    /**
     * Renvoie le nombre de lignes de la grille
     */
    public int getNbLignes() {
        return grille.getNbLignes();
    }

    /**
     * Renvoie le nombre de colonnes de la grille
     */
    public int getNbColonnes() {
        return grille.getNbColonnes();
    }

    /**
     * Constructeur qui genere un nouvelle objet Partie en fonction du nombre de lignes, de colonnes et de mines aléatoires.
     * 
     * @param nbLignes nombres de lignes
     * @param nbColonnes nombres de colonnes
     * @param nbMines nombres de mines
     */
    public Partie(int nbLignes, int nbColonnes, int nbMines){
        this.nbMines = nbMines;

        Random r = new Random();
        int a,b;
        this.grille = new Grille(nbLignes, nbColonnes);
        for(int i = 0; i < nbMines; i++){
            a = r.nextInt(nbLignes);
            b = r.nextInt(nbColonnes);

            while(grille.getCase(a,b).getMine()){
                a = r.nextInt(nbLignes);
                b = r.nextInt(nbColonnes);
            }
            grille.ajouterMine(a,b);

        }

        this.etat = EtatPartie.EN_COURS;
    }

    
   
    /**
     * Constructeur qui construit un nouvelle objet Partie en fonction d'un fichier.
     * @param chemin chemin du fichier
     */
    public Partie(String chemin){
        try{
            File fichierSauvegarde =  new File("fichier.txt");
            Scanner s = new Scanner(fichierSauvegarde);


            Scanner s3;
            String coordonnees;
            int i,j;


            int nbLignes = Integer.valueOf(s.nextLine());
            int nbColonnes = Integer.valueOf(s.nextLine());
            this.grille = new Grille(nbLignes,nbColonnes);
            String caseMine = s.nextLine();

            Scanner s2 = new Scanner(caseMine);
            s2.useDelimiter(";");

            this.nbMines = 0;


            while(s2.hasNext()){
                this.nbMines += 1;
                coordonnees = s2.next();
                s3 = new Scanner(coordonnees);
                s3.useDelimiter(",");
                i = Integer.valueOf(s3.next());
                j = Integer.valueOf(s3.next());
                s3.close();

                grille.getCase(i,j).setMine();

            }

            String caseRevelee = s.nextLine();
            s2.close();
            s2 = new Scanner(caseRevelee);

            s2.useDelimiter(";");

            while(s2.hasNext()){
                //this.casesRevelees += 1;
                coordonnees = s2.next();
                s3 = new Scanner(coordonnees);
                s3.useDelimiter(",");
                i = Integer.valueOf(s3.next());
                j = Integer.valueOf(s3.next());
                s3.close();
                grille.revelerCase(i,j);
            }

            s2.close();
            String drapeaux = s.nextLine();
            s2 = new Scanner(drapeaux);
            s2.useDelimiter(";");

            while(s2.hasNext()){
                this.drapeaux += 1;
                coordonnees = s2.next();
                s3 = new Scanner(coordonnees);
                s3.useDelimiter(",");
                i = Integer.valueOf(s3.next());
                j = Integer.valueOf(s3.next());
                s3.close();
                grille.ajouterDrapeau(i,j,true);
            }

          
            s.close();
            s2.close();
    
            

            this.etat = EtatPartie.EN_COURS;

        }catch(Exception e){
            e.printStackTrace();
        }

    }


    /**
     * Fonction qui renvoie l'objet Grille associé à la partie.
     */
    public Grille getGrille(){
        return grille;
    }

    /**
     * Fonction qui incrémente la valeur de drapeau.
     */
    public void ajouterDrapeau(){
        this.drapeaux += 1;
    }

    /**
     * Fonction qui décrémente la valeur de drapeau.
     */
    public void retirerDrapeau(){
        this.drapeaux -= 1;
    }


    /**
     * Fonction qui incrémente la valeur de casesRevelees et qui renvoie true si la partie est terminée
     * i.e si le nombre de case revelée est égale au nombre de case total - le nombre de mine.
     */
    public boolean caseRevelee(){
        this.casesRevelees += 1;
       // System.out.println(casesRevelees);
        if(this.casesRevelees == (this.grille.getNbLignes() * this.grille.getNbColonnes()) - this.nbMines){
            this.etat = EtatPartie.GAGNE;
            return true;
        }
        return false;
    }


    /**
     * Renvoie le nombre de mines dans la partie.
     */
    public int getMine(){
        return this.nbMines;
    }

    /**
     * Renvoie le nombre de drapeaux dans la partie.
     */
    public int getDrapeaux(){
        return this.drapeaux;
    }

    /**
     * Fonction qui permet de sauvegarder une partie
     */
    public void sauvegarder(){
        String s = "";
        String mine = "";
        String revelee = "";
        String drapeau = "";
        Case c;
        int nbLignes = grille.getNbLignes();
        int nbColonnes = grille.getNbColonnes();
      
        s += nbLignes + "\n" + nbColonnes + "\n";
        for(int i = 0; i < nbLignes; i++){
            for(int j = 0; j < nbColonnes; j++){
                c = grille.getCase(i,j);
                if(c.getMine()){
                    mine += i + "," + j + ";";
                }
                if(c.getReveler()){
                    revelee += i + "," + j + ";";
                }
                if(c.getDrapeau()){
                    drapeau += i + "," + j + ";";
                }
            }
        }
        s += mine + "\n" + revelee + "\n" + drapeau + "\n";

        try{
            File fichierSauvegarde = new File("fichier.txt");
            if(!fichierSauvegarde.exists()){
                fichierSauvegarde.createNewFile();
            }

            FileWriter fw = new FileWriter(fichierSauvegarde.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.close();
            fw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui permet de supprimer une sauvegarde.
     */
    public void supprimerSauvegarde(){
        File fichierSauvegarde = new File("fichier.txt");
        if(fichierSauvegarde.exists()){
            fichierSauvegarde.delete();
        }
       
    }
  /* public static void main(String[] args){
       Partie p = new Partie(10,10,15);
       Grille g = p.getGrille();
       g.revelerCase(5,5);
       g.revelerCase(5,7);
       g.revelerCase(3,2);

       System.out.println(g);

    } */
}
