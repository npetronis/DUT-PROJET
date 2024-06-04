/**
 * La classe <code>Case</code> est utilisée pour modéliser une case de la grille
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */

public class Case {
    /**
     * Boolean qui nous indique si la case contient une mine.
     */
    boolean mine;
    /**
     * Boolean qui nous indique si la case a été révélée.
     */
    boolean reveler;
    /**
     * Boolean qui nous indique si la case contient un drapeau.
     */
    boolean drapeau;
    
    /**
     * Boolean qui nous indique si la case contient une interrogation.
     */
    boolean interrogation;
    /**
     * Entier qui nous indique le nombre de mines adjacentes.
     */
    int minesAdjacentes;

    /**
     * Constructeur unique qui initialise tout les champs à false.
     */
    public Case(){
        this.mine = false;
        this.reveler = false;
        this.drapeau = false;
    }

    /**
     * Met le champ mine à true.
     */
    public void setMine(){
        this.mine = true;
    }
    /**
     * Fonction qui met le nombre de mines adjacentes et qui met le boolen révéler à true
     *
     * @param mineAdjacentes nombre mines adjacentes
     */
    public void setReveler(int minesAdjacentes){
        this.minesAdjacentes = minesAdjacentes;
        this.reveler = true;
    }

    /**
     * Change la valeur du boolean drapeau par la valeur passée en parametre .
     * 
     * @param drapeau valeur voulue pour le boolean drapeau
     */
    public void setDrapeau(boolean drapeau){
        this.drapeau = drapeau;
    }

     /**
     * Change la valeur du boolean interrogation par la valeur passée en parametre .
     * 
     * @param interrogation valeur voulue pour le boolean interrogation
     */
    public void setInterrogation(boolean interrogation){
        this.interrogation = interrogation;
    }

    /**
     * Renvoie la valeur du boolean drapeau.
     */
    public boolean getDrapeau(){
        return this.drapeau;
    }

     /**
     * Renvoie la valeur du boolean drapeau.
     */
    public boolean getInterrogation(){
        return this.interrogation;
    }

    /**
     * Renvoie la valeur du boolean mine.
     */
    public boolean getMine(){
        return this.mine;
    }

    /**
     * Renvoie la valeur du boolean reveler.
     */
    public boolean getReveler(){
        return this.reveler;
    }

    /**
     * Renvoie une représentation de la case.
     */
    public String toString(){
        if(!reveler){
            return "_";
        }
        if(mine){
            return "X";
        }
            return String.valueOf(minesAdjacentes);

    }

    /**
     * Renvoie la valeur de l'entier minesAdjacentes.
     */
    public int getMinesAdjacentes(){
        return minesAdjacentes;
    }

}
