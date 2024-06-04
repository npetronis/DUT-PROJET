/**
 * La classe <code>FenetrePartie</code> est la classe maitresse de notre Vue.
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FenetrePartie extends JFrame {

    /**
     * Objet Partie
     */
    Partie partie;

    /**
     * Objet JLabel qui contient la phrase "il reste x mines".
     */
    JLabel infos;

    /**
     * Objet VueGrille.
     */
    VueGrille v;

    /**
     * Objet BarreComposant.
     */
    BarreComposant bc;


    /**
     * Constructeur qui construit la FenetrePartie à partir d'un objet Partie.
     * @param partie Objet Partie
     */
    public FenetrePartie(Partie partie){
        this.partie = partie;
        this.infos = new JLabel("Il reste " + String.valueOf((partie.getMine() - partie.getDrapeaux())) + " mines");

        bc = new BarreComposant();
        this.add(bc);
        v = new VueGrille(this.partie.getNbLignes(),this.partie.getNbColonnes());
        JScrollPane jsp = new JScrollPane(v);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(jsp);
        this.add(infos);


        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.getContentPane().setBackground(new Color(190, 185, 185));
        this.pack();
        setVisible(true);
    
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Controleur(this.partie,this);

    }

    /**
     * Fonction qui renvoie le bouton sauvetEtQuitter.
     * @return le bouton sauverEtQuitter
     */
    public JButton getSauverEtQuitter(){
        return bc.getSauverEtQuitter();
    }

    /**
     * Fonction qui renvoie l'objet VueGrille.
     * @return VueGrille.
     */
    public VueGrille getVueGrille() {
        return v;
    }

    /**
     * Fonction qui met à jour la chaine de caractere du JLabel infos.
     */
    public void updateInfos(){
        this.infos.setText("Il reste " + String.valueOf((partie.getMine() - partie.getDrapeaux())) + " mines");
    }

    /*
    public static void main(String[] args) {
       //Partie p = new Partie(10,10,30);
        Partie p = new Partie("fichier.txt");
        //p.sauvegarder();
       new FenetrePartie(p);


    }*/
}
