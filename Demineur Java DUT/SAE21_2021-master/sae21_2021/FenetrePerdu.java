/**
 * La classe <code>FenetrePerdu</code> est utilisée pour afficher la fenetre Perdu
 * 
 *  
 * @version 1.0
 * @author Yuness Soussi
 */

import javax.swing.*;
import java.awt.*;



public class FenetrePerdu extends JFrame {
    JLabel perdu;

    /**
     * Constructeur qui crée et affiche la fenetre perdu.
     */
    public FenetrePerdu(){
        Font f = new Font("Comic Sans MS", Font.PLAIN, 30);
        perdu = new JLabel("Perdu");
        perdu.setFont(f);
        this.add(perdu);
        perdu.setHorizontalAlignment(JLabel.CENTER);


        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FenetrePerdu();
    }
}
