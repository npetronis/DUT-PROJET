/**
 * La classe <code>Menu</code> est utilisée pour afficher le menu de départ.
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Menu extends JFrame implements MouseListener, ActionListener {
    /**
     * Objet JLabel
     */
    JLabel menu;

    /**
     * Trois boutons. 
     */
    JButton nouvellePartie;
    JButton reprendre;
    JButton quitter;

    /**
     * Constructeur qui créer la fenetre du menu.
     */
    public Menu(){
        Font f = new Font("Comic Sans MS", Font.PLAIN, 30);
        
        menu = new JLabel("Menu");
        menu.setHorizontalAlignment(JLabel.CENTER);
        menu.setVerticalAlignment(JLabel.TOP);
        menu.setForeground(new Color(97,176,99));
        menu.setBackground(Color.BLACK);
        menu.setFont((new Font("Comic Sans MS", Font.PLAIN, 30)));
        //this.add(menu, BorderLayout.NORTH);
       // this.getContentPane();
       // menu.setBounds(234,100,100,100);
        this.add(menu);
        this.setContentPane(menu); //affiche le JLabel menu

        nouvellePartie = new JButton("Nouvelle partie");
        nouvellePartie.setBounds(145,150,200,50);
        nouvellePartie.setBackground(new Color(204,102,0));
        nouvellePartie.setForeground(new Color(82,43,15));
        nouvellePartie.setFont((new Font("Comic Sans MS", Font.PLAIN, 20)));
        nouvellePartie.setFocusPainted(false);
        this.add(nouvellePartie);

        reprendre = new JButton("Reprendre");
        reprendre.setBounds(145,250,200,50);
        reprendre.setBackground(new Color(204,102,0));
        reprendre.setForeground(new Color(82,43,15));
        reprendre.setFont((new Font("Comic Sans MS", Font.PLAIN, 20)));
        reprendre.setFocusPainted(false);
        if(!new File("fichier.txt").exists()){
            reprendre.setEnabled(false);
        }
        this.add(reprendre);

        quitter = new JButton("Quitter");
        quitter.setBounds(145,350,200,50);
        quitter.setBackground(new Color(204,102,0));
        quitter.setForeground(new Color(82,43,15));
        quitter.setFont((new Font("Comic Sans MS", Font.PLAIN, 20)));
        quitter.setFocusPainted(false);
        this.add(quitter);

        nouvellePartie.addMouseListener(this);
        reprendre.addMouseListener(this);
        quitter.addMouseListener(this);
        nouvellePartie.addActionListener(this);
        reprendre.addActionListener(this);
        quitter.addActionListener(this);

        this.setBackground(new Color(47,79,79));
        this.setLayout(new BorderLayout()); //pour que le bouton ne prenne pas toute la place
        this.setResizable(false); //pour ne pas redimentionner la fenetre
        this.setSize(500,500); //taille fenetre
        this.setLocationRelativeTo(null); //location de la fenetre
        this.setVisible(true); //affiche la fenetre à l'écran
    }

    public static void main(String[] args) {
        new Menu();
    }

    /**
     * Change la couleur du boutons quand on clique dessus.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == nouvellePartie){
            nouvellePartie.setBackground(new Color(61, 203, 95));
            nouvellePartie.setOpaque(true);
        }
        if(e.getSource() == reprendre){
            reprendre.setBackground(new Color(61, 203, 95));
            reprendre.setOpaque(true);
        }
        if(e.getSource() == quitter){
            quitter.setBackground(new Color(61, 203, 95));
            quitter.setOpaque(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Change la couleur du boutons quand on passe la souris dessus.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == nouvellePartie){
            nouvellePartie.setBackground(new Color(250,120,20));
        }
        if(e.getSource() == reprendre){
            reprendre.setBackground(new Color(250,120,20));
        }
        if(e.getSource() == quitter){
            quitter.setBackground(new Color(250,120,20));
        }

    }

    /**
     * Remet la couleur de base quand on quitte le bouton avec la souris.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        nouvellePartie.setBackground(new Color(204,102,0));
        reprendre.setBackground(new Color(204,102,0));
        quitter.setBackground(new Color(204,102,0));
    }   


    /**
     * Fonction qui gere les clics sur les boutons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nouvellePartie){
            new Parametre();
            this.dispose();
        }
        if(e.getSource() == reprendre){
            Partie p = new Partie("fichier.txt");
            new FenetrePartie(p);
            this.dispose();
        }
        if(e.getSource() == quitter){
            this.dispose();
        }
    }
}
