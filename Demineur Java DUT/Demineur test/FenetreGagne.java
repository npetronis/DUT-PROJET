/**
 * La classe <code>FenetreGagne</code> est utilisée pour afficher la fenetre Gagné.
 * 
 *  
 * @version 1.0
 * @author Nicolas Petronis
 */

import javax.swing.*;
import java.awt.*;

public class FenetreGagne extends JFrame {
    
    /**
     * Constructeur qui crée et affiche la fenetre gagné.
     */
    JLabel gagne;
    public FenetreGagne(){
        Font f = new Font("Comic Sans MS", Font.PLAIN, 30);
        gagne = new JLabel("Gagnée!");
        gagne.setFont(f);
        this.add(gagne);
        gagne.setHorizontalAlignment(JLabel.CENTER);

        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FenetreGagne();
    }
}
