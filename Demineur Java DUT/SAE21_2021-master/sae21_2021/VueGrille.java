/**
 * La classe <code>VueGrille</code> est utilisée pour l'affichage d'un objet Grille.
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */

import javax.swing.*;
import java.awt.*;

public class VueGrille extends JPanel {
    /**
     * Nombre de lignes
     */
    int nbLignes;

    /**
     * Nombre de colonnes
     */
    int nbColonnes;

    /**
     * Tableau à deux dimensions qui contient les composants cases.
     */
    ComposantCase[][] composants_cases;



    /**
     * Constructeur qui crée le panneau qui affiche la grille.
     * 
     * @param nbLignes nombres de lignes
     * @param nbColonnes nombres de colonnes
     */
    public VueGrille(int nbLignes, int nbColonnes) {

        //this.setLayout(new BorderLayout());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(nbColonnes * ComposantCase.TAILLE_CASE, nbLignes * ComposantCase.TAILLE_CASE));

        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;

        this.composants_cases = new ComposantCase[nbLignes][nbColonnes];

        this.add(new ComposantCase());
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.composants_cases[i][j] = new ComposantCase();
                this.composants_cases[i][j].setBounds(j * ComposantCase.TAILLE_CASE, i * ComposantCase.TAILLE_CASE, ComposantCase.TAILLE_CASE, ComposantCase.TAILLE_CASE);
                this.add(this.composants_cases[i][j]);
            }
        }
       // this.composants_cases[nbLignes - 1][nbColonnes - 1].setBounds(nbLignes - 1 * ComposantCase.TAILLE_CASE, nbColonnes - 1 * ComposantCase.TAILLE_CASE, ComposantCase.TAILLE_CASE, ComposantCase.TAILLE_CASE);
      //  this.add(this.composants_cases[nbLignes - 1][nbColonnes - 1]);
        repaint();

    }

    /**
     * Renvoie le composant case à la position i,j.
     * @param i numero de la ligne
     * @param j numero de la colonne
     * @return le composant case à la position i,j
     */
    public ComposantCase getComposantCase(int i, int j){
        return this.composants_cases[i][j];
    }
}
