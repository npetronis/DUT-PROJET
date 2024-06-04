/**
 * La classe <code>ComposantCase</code> est utilisée pour l'affichage d'un objet Case.
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */

import javax.swing.*;
import java.awt.*;

public class ComposantCase extends JComponent {

    /**
     * Taille d'une case en pixel
     */
   static int TAILLE_CASE = 50;
    /**
     * Nombre de mines adjacentes affichés sur la case.
     */
    int nbMinesAdjacentes = 0;
    /**
     * Boolean qui nous dit si il faut afficher une mine ou pas.
     */
    boolean mine = false;
    /**
     *  Boolean qui nous dit si il faut afficher un drapeau ou pas.
     */
    boolean drapeau = false;
    /**
     * Boolean qui nous dit si la partie est terminée.
     */
    boolean finDePartie = false;
    /**
     * Boolean qui nous dit si on a atterit sur une mine.
     */
    boolean mort = false;
    /**
     * L'image qui représente un drapeau.
     */

     /**
      * Boolean qui nous dit si on doit reveler la case ou pas.
      */
    boolean reveler = false;

    boolean interrogation = false;

    /**
     * L'image qui s'affiche lorsque l'on pose un drapeau.
     */

    Image imgDrapeau;

    /**
     * L'image qui s'affiche lorsqu'il y avait un drapeau mais pas de mine quand on a perdu.
     */
    Image drapeauMort;
    /**
     * L'image qui s'affiche lorsqu'il y avait une mine sous un drapeau quand on a perdu.
     */
    Image check;


    /**
     * L'image qui s'affiche lorsqu'il y avait une mine mais pas de drapeau quand on a perdu.
     */
    Image imgMine;

    Image imgInterrogation;

    /**
     * Police de caractere.
     */
    Font font = new Font("Serif", Font.PLAIN, 30);

    /**
     * Fonction qui change la valeur de l'attribut nbMinesAdjacentes.
     * @param nbMinesAdjacentes
     */
    public void setNbMinesAdjacentes(int nbMinesAdjacentes) {
        this.nbMinesAdjacentes = nbMinesAdjacentes;
    }

    /**
     * Fonction qui change la valeur de l'attribut mine.
     * @param mine
     */
    public void setMine(boolean mine) {
        this.mine = mine;
    }

    /**
     * Fonction qui change la valeur de l'attribut reveler.
     * @param reveler
     */
    public void setReveler(boolean reveler) {
        this.reveler = reveler;
    }

    /**
     * Fonction qui change la valeur de l'attribut drapeau.
     * @param drapeau
     */
    public void setDrapeau(boolean drapeau){
        this.drapeau = drapeau;
    }

    /**
     * Fonction qui change la valeur de l'attribut interrogation.
     * @param interrogation
     */

    public void setInterrogation(boolean interrogation){
        this.interrogation = interrogation;
    }

    /**
     * Fonction qui renvoie la valeur de l'attribut drapeau.
     * @return la valeur de l'attribut drapeau
     */
    public boolean getDrapeau(){
        return this.drapeau;
    }

    /**
     * Fonction qui renvoie la valeur de l'attribut interrogation.
     * @return la valeur de l'attribut interrogation
     */
    public boolean getInterrogation(){
        return this.interrogation;
    }

   

    /**
     * Constructeur qui initialise notre composant et charge les images
     */
    public ComposantCase(){
        setPreferredSize(new Dimension(TAILLE_CASE,TAILLE_CASE));
        imgDrapeau = Toolkit.getDefaultToolkit().getImage("interrogation.png");
        check = Toolkit.getDefaultToolkit().getImage("check.png");
        imgMine = Toolkit.getDefaultToolkit().getImage("bombe2.png");
        drapeauMort = Toolkit.getDefaultToolkit().getImage("drapeauMort.png");
        imgInterrogation = Toolkit.getDefaultToolkit().getImage("drapeau.png");

    }

    /**
     * Fonction qui met à true la valeur du boolean fin de partie.
     */
    public void finDePartie(){
        this.finDePartie = true;
    }

    /**
     * Fonction qui change la valeur de l'attribut mort.
     */
    public void setMort(){
        this.mort = true;
    }

    /**
     * Fonction qui renvoie la valeur du boolean reveler.
     * @return valeur du boolean reveler
     */
    public boolean getReveler(){
        return this.reveler;
    }

    /**
     * Fonction qui dessine notre composant en fonction des booleans en attribut.
     */
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);

        if(!finDePartie){
            if(reveler){

                if(mine){

                    g.setColor(Color.RED);
                    g.fillRect(0,0,TAILLE_CASE,TAILLE_CASE);
                    
                }
                else{

                    g.setColor(Color.GREEN);
                    g.fillRect(0,0,TAILLE_CASE,TAILLE_CASE);
                    g.setFont(font);
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(nbMinesAdjacentes),(TAILLE_CASE/2)-10,(TAILLE_CASE/2)+10);

                }
            }
            else{
                g.setColor(Color.WHITE);
                g.fillRect(0,0,TAILLE_CASE,TAILLE_CASE);
                if(drapeau){
                    g.drawImage(this.imgDrapeau,0,0,TAILLE_CASE,TAILLE_CASE,this);

                }

                else if(interrogation){
                    g.drawImage(this.imgInterrogation,0,0,TAILLE_CASE,TAILLE_CASE,this);
                }

            }

        }

        else{
            if(mine && !drapeau){
                if(!mort){
                    //g.drawLine(0,0,TAILLE_CASE,TAILLE_CASE);
                    //g.drawLine(0,TAILLE_CASE,TAILLE_CASE,0);
                    g.drawImage(this.imgMine,0,0,TAILLE_CASE,TAILLE_CASE,this); 
                }
                else{
                    
                    g.setFont(font);
                    g.setColor(Color.BLACK);
                    g.drawString("RIP",(TAILLE_CASE/2)-22,(TAILLE_CASE/2)+10);
                      
                }


            }
            else if(drapeau && !mine){
                //g.drawOval(0,0,TAILLE_CASE,TAILLE_CASE);
                g.drawImage(this.drapeauMort,0,0,TAILLE_CASE,TAILLE_CASE,this);
            }

            else if(drapeau && mine){
                g.drawImage(this.check,0,0,TAILLE_CASE,TAILLE_CASE,this);
            }

        }


        g.setColor(Color.BLACK);
        g.drawRect(0,0,TAILLE_CASE,TAILLE_CASE);

    }



}

