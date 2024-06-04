
/**
 * La classe <code>Grille</code> est utilisée pour modéliser une grille.
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis et Yuness Soussi
 */


import java.util.ArrayList;

public class Grille {

    /**
     * Entier qui représente le nombre de ligne.
     */
    int nbLignes;

    /**
     * Entier qui représente le nombre de colonne.
     */
    int nbColonnes;

    /**
     * Tableau à deux dimensions contenant les objets cases.
     */
    Case[][] cases;


    /**
     * Constructeur qui créer une grille à partir du nombre de ligne et du nombre de colonne.
     * @param nbLignes
     * @param nbColonnes
     */
    public Grille(int nbLignes, int nbColonnes){
        
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;

        this.cases = new Case[nbLignes][nbColonnes];

        for(int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.cases[i][j] = new Case();
            }
        }
    }

    /**
     * Methode qui représente la grille sous la forme d'une chaine de caractere.
     */
    public String toString(){
        String str = "";
        for(int i = 0; i < nbLignes; i++){
            for(int j = 0; j < nbColonnes; j++){
                str += this.cases[i][j].toString() + " ";
            }
            str += "\n";
        }
        return str;
    }

    /**
     * Fonction qui revele une case et calcule son nombre de mines adjacentes.
     * @param i numero de la ligne
     * @param j numero de la colonne
     */
    public void revelerCase(int i, int j){
        if(this.cases[i][j].getReveler()){
            return;
        }
        ArrayList<ArrayList<Integer>> adjacentes = casesAdjacentes(i,j);
        int minesAdjacentes = 0;
        for(ArrayList<Integer> c : adjacentes){
            if(this.cases[c.get(0)][c.get(1)].getMine()){
                minesAdjacentes += 1;

            }
        }
        this.cases[i][j].setReveler(minesAdjacentes);

        if(minesAdjacentes == 0){
            for(ArrayList<Integer> c : adjacentes){
                revelerCase(c.get(0),c.get(1));
            }
        }
    }


    /**
     * Fonction qui ajoute une mine dans une case.
     * @param i numero de la ligne
     * @param j numero de la colonne
     */
    public void ajouterMine(int i, int j){
        this.cases[i][j].setMine();
    }


    /**
     * Fonction qui trouve toute les cases adjacentes.
     * @param i numero de la ligne
     * @param j numero de la colonne
     * @return une liste de couple a,b voisine de la case i,j
     */
    public ArrayList<ArrayList<Integer>> casesAdjacentes(int i , int j){
        ArrayList<ArrayList<Integer>> adjacentes = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp;
        for(int a = -1; a <= 1; a++){
            for(int b = -1; b <= 1; b++){
                if(a == 0 && b == 0){
                    continue;
                }
                if(dansLaGrille(i+a,j+b)){
                    tmp = new ArrayList<Integer>();
                    tmp.add(i+a);
                    tmp.add(j+b);
                    adjacentes.add(tmp);
                }
            }
        }
        return adjacentes;
    }

    /**
     * Fonction qui change la valeur du boolean drapeau de la case i,j.
     * @param i numero de la ligne
     * @param j numero de la colonne
     * @param drapeau valeur voulu pour le boolean drapeau
     */
    public void ajouterDrapeau(int i, int j, boolean drapeau){
        this.cases[i][j].setDrapeau(drapeau);
    }
   

    /**
     * Fonction qui vérifie que un couple i,j soit dans la grille.
     * @param i numero de la ligne
     * @param j numero de la colonne
     * @return true si le couple est dans la grille, false sinon
     */
    public boolean dansLaGrille(int i, int j){
        return i >= 0 && i < nbLignes && j >= 0 && j < nbColonnes;
    }

    /**
     * Fonction qui renvoie l'objet case à la position i,j.
     * @param i numero de la ligne
     * @param j numero de la colonne
     * @return case à la position i,j
     */
    public Case getCase(int i , int j){
        return this.cases[i][j];
    }

    /**
     * Renvoie le nombre de lignes
     * @return le nombre de lignes.
     */
    public int getNbLignes(){
        return nbLignes;
    }

    /**
     * Renvoie le nombre de colonnes
     * @return le nombre de colonnes
     */
    public int getNbColonnes(){
        return nbColonnes;
    }

}
