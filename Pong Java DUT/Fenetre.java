import javax.swing.JComponent;
import java.awt.*;
import java.lang.Thread;
import javax.swing.*;

public class Fenetre extends JFrame{
    Surface s;
    boolean jouer = true;

    public Fenetre(){   
        s = new Surface();
        this.getContentPane().add(s);
        this.getContentPane().setBackground(new Color(150,150,150));
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
       // this.setResizable(false);
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        Fenetre f = new Fenetre();
        f.jeu();
    }

    public void jeu(){
      
        while(jouer){ //tant que la fenetre est ouverte, faire bouger la balle
            s.actualiser();
        }
      
    
   
    }
}