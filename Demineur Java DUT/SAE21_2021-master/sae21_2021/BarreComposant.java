/**
 * La classe <code>BarreComposant</code> est utilisée pour afficher les composants qui permettent de sauver et quitter une partie
 * ainsi que de voir le nombre de mines restantes.
 * 
 *  
 * @version 1.0
 * @author Yuness Soussi
 */

import javax.swing.*;
import java.awt.*;

public class BarreComposant extends JPanel {
    JButton sauverEtQuitter = new JButton("Sauver et quitter");
    JLabel infos =  new JLabel();

    public BarreComposant(){
        //sauverEtQuitter.setMaximumSize(new Dimension(200,100));
        this.add(infos);
        this.add(sauverEtQuitter);
        sauverEtQuitter.setBackground(new Color(250, 155, 80));
        sauverEtQuitter.setFocusPainted(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,1,0));
        this.setBackground(new Color(190, 185, 185));
    }


    /**
     * Fonction qui renvoie le JButton sauverEtQuitter.
     */
    public JButton getSauverEtQuitter(){
        return sauverEtQuitter;
    }

    /**
     * Fonction qui affiche le nombre de mines restantes.
     * @param minesRestantes Entier nombre de mine restantes.
     */
    public void setMinesRestantes(int minesRestantes){
        infos.setText("Il reste " + minesRestantes + " mines");
    }
}
