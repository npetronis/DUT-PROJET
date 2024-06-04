/**
 * La classe <code>Parametre</code> est utilisée pour demander à l'utilisateur le nombre de mines, de lignes et de colonnes souhaité.
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Parametre extends JFrame implements ActionListener {
    /**
     * Trois objet JTextField.
     */
    JTextField nbLignes;
    JTextField nbColonnes;
    JTextField nbMines;
    /**
     * Objet JButton qui sert à valider.
     */
    JButton valider;

    /**
     * Trois objet JLabel.
     */
    JLabel lignes;
    JLabel colonnes;
    JLabel mines;

    Partie p;

    FenetrePartie fp;

    /**
     * Constrtucteur
     */
    public Parametre(){
        
        nbLignes = new JTextField();
        nbColonnes = new JTextField();
        nbMines = new JTextField();
        valider = new JButton("Valider");

        lignes = new JLabel("Lignes (4-30)");
        colonnes = new JLabel("Colonnes (4-30)");
        mines = new JLabel("Mines");

        
        

        this.add(lignes);
        lignes.setBounds(40,170,90,30);
        lignes.setForeground(new Color(204,102,0));
        this.add(colonnes);
        colonnes.setBounds(200,170,90,30);
        colonnes.setForeground(new Color(204,102,0));
        this.add(mines);
        mines.setBounds(360,170,90,30);
        mines.setForeground(new Color(204,102,0));

        
        nbLignes.setColumns(10);
        nbColonnes.setColumns(10);
        nbMines.setColumns(10);

        this.add(nbLignes);
        nbLignes.setBounds(40,200,90,30);
        this.add(nbColonnes);
        nbColonnes.setBounds(200,200,90,30);
        this.add(nbMines);
        nbMines.setBounds(360,200,90,30);
        this.add(valider);
        valider.setBounds(200,300,100,30);
        valider.setFocusPainted(false);
        valider.setBackground(new Color(204,102,0));

        nbLignes.setPreferredSize(new Dimension(0,30));
        nbColonnes.setPreferredSize(new Dimension(0,30));
        nbMines.setPreferredSize(new Dimension(0,30));

        valider.setFocusPainted(false);
        valider.addActionListener(this);
        this.getContentPane().setBackground(new Color(47,79,79));
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        //this.setLayout(new FlowLayout(FlowLayout.CENTER,20,200));
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }

    public JButton getValider(){
        return valider;
    }

    /**
     * Quand on valide, on créer l'objet Partie 
     * (Si l'utilisateur n'entre pas 3 entiers, on créer une grille par défaut de taille 10x10 avec 15 mines).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == valider){
    
         //new Parametre();
           
            try{
                
                int lignes = Integer.valueOf(nbLignes.getText());
                int colonnes = Integer.valueOf(nbColonnes.getText());
                int mines = Integer.valueOf(nbMines.getText());

                
                if(lignes < 4 || lignes > 30 && colonnes < 4 || colonnes > 30){
                  
                    new Parametre();
                    
                      
                }
                else if(lignes >= 4 && colonnes < 4){
                    new Parametre();
                }
               
                else{
                    new FenetrePartie(new Partie(lignes,colonnes,mines));
                }

            }catch(Exception ex){
                new Parametre();
              /*
                int lignes = 10;
                int colonnes = 10;
                int mines = 15;

                new FenetrePartie(new Partie(lignes,colonnes,mines));
                */
                
                
            }
           
            this.dispose();
            
        }
    }
}
