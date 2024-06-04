/**
 * La classe <code>Controleur</code> est utilisée pour faire la liaison entre le modele (l'objet Partie) et la vue (l'objet FenetrePartie).
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controleur implements MouseListener, ActionListener {
    /**
     * Objet Grille.
     */
    Grille g;

    /**
     * Objet VueGrille.
     */
    VueGrille v;

    /**
     * Objet Partie.
     */
     Partie p;

     /**
      * Objet FenetrePartie.
      */
    FenetrePartie f;

    Parametre para;

    int compteurClique = 0;

    /**
     * Constructeur qui remplit les attributs de notre objet, 
     * et récupère notamment les objets Grille et VueGrille à partir des objets Partie et FenetrePartie.
     * @param p Objet Partie
     * @param f Objet FenetrePartie
     */
    public Controleur(Partie p, FenetrePartie f){
        this.g = p.getGrille();
        this.v = f.getVueGrille();
        this.p = p;
        this.f = f;
        updateVue();
        v.addMouseListener(this);
        f.getSauverEtQuitter().addActionListener(this);
    }

    /**
     * Fonction qui gère les clics sur notre grille.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(p.etat == Partie.EtatPartie.EN_COURS){

            /**
             * On commence par retrouver le ComposantCase et la Case correspondant à l'endroit ou on a cliqué
             * en fonction de la position du clic.
             */
            int i = e.getY()/50;
            int j = e.getX()/50;
            Case c = g.getCase(i,j);
            ComposantCase vc = v.getComposantCase(i,j);
            
            if(e.getButton() == 1){
                
                /**
                 * Si on a fait un clic gauche...
                 */
                if(vc.getDrapeau()){

                    /**
                     * si il y a un drapeau sur la case, on ne revele pas la case.
                     */
                    return;
                }

                g.revelerCase(i,j);
                vc.setReveler(true);
               // System.out.println(e.getButton());

                if(c.getMine()){
                    /**
                     * Si il y a une mine que on essaye de reveler, alors on a perdu.
                     */

                    p.etat = Partie.EtatPartie.PERDU;
                    p.supprimerSauvegarde();
                    new FenetrePerdu();
                    partiePerdue();
                    vc.setMine(true);
                    vc.setMort();
                    f.getSauverEtQuitter().setEnabled(false);
                }
                else{
                    /**
                     * Si il n'y a pas de mine, alors on calcule le nombre de mines adjacentes
                     * et on le donne au ComposantCase correspondant.
                     */
                    vc.setNbMinesAdjacentes(c.getMinesAdjacentes());
                    updateVue();

                    if(p.caseRevelee()){
                        /**
                         * Si on a gagné, alors on affiche fenetre de victoire
                         */

                        p.etat = Partie.EtatPartie.GAGNE;
                        p.supprimerSauvegarde();
                        new FenetreGagne();
                        f.getSauverEtQuitter().setEnabled(false);
                    }
                }
            }


            if(e.getButton() == 3){
                compteurClique++;
                System.out.println(compteurClique);
                /**
                 * Si on a fait un clic droit, si il n'y a pas d'interrogation sur la case
                 * sinon on ajoute un drapeau. Si on clique une troixieme fois le drapeau disparait.
                 */
                /*if(vc.getDrapeau()){
                    c.setDrapeau(false);
                    p.retirerDrapeau();
                }*/
                if(vc.getInterrogation()){
                    c.setInterrogation(false);
                
                }

                 /**
                 * Si on a fait un clic droit, si il y a une d'interrogation sur la case
                 * on ajoute un drapeau.
                 * 
                 */
            
                 //else if(compteurClique%2 == 0 && !vc.getInterrogation()){
                else{
                    //c.setDrapeau(false);
                    System.out.println("DEUX");
                    c.setDrapeau(true); //mettre true
                    vc.setDrapeau(!vc.getDrapeau());
                    
                /*else{
                    c.setDrapeau(true);
                    p.ajouterDrapeau();
                    */

                }
                vc.setDrapeau(vc.getDrapeau());
                vc.setInterrogation(!vc.getInterrogation());
                f.updateInfos();
            }
        }


        v.repaint();
    }

    /**
     * Fonction qui actualise la vue par rapport au modèle.
     */
    public void updateVue(){

        /**
         * On boucle sur toute les cases de notre grille.
         */
        for(int a = 0; a < p.getNbLignes(); a++){
            for(int b = 0; b < p.getNbColonnes(); b++){
                if(g.getCase(a,b).getReveler() && !v.getComposantCase(a,b).getReveler()){
                    /**
                     * Si une case est revelée dans le modèle et pas dans la vue, on la revele dans la vue.
                     */
                    v.getComposantCase(a,b).setReveler(true);
                    v.getComposantCase(a,b).setNbMinesAdjacentes(g.getCase(a,b).getMinesAdjacentes());
                    if(p.caseRevelee()){
                        new FenetreGagne();
                    }
                }
                if(g.getCase(a,b).getDrapeau() && !v.getComposantCase(a,b).getDrapeau()){
                    /**
                     * Si il y a une case qui a un drapeau sur le modèle et pas dans la vue, on ajout le drapeau dans la vue.
                     */
                    v.getComposantCase(a,b).setDrapeau(true);
                }
            }
        }
    }

    /**
     * Fonction qui va "prévenir" les composants cases que la partie est perdu.
     */
    public void partiePerdue(){
        ComposantCase c;
        for(int i = 0; i < p.getNbLignes(); i++){
            for(int j = 0; j < p.getNbColonnes(); j++){
                c = v.getComposantCase(i,j);
                c.finDePartie();
                if(g.getCase(i,j).getMine()){
                    c.setMine(true);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Quand on clique sur sauverEtQuitter, on sauvegarde la partie et on ferme la fenetre.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == f.getSauverEtQuitter()){
            p.sauvegarder();
            f.dispose();
        }
    }
}
