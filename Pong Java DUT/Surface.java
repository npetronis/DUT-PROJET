import javax.swing.JComponent;
import java.lang.Thread;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Surface extends JComponent implements MouseMotionListener{
    Raquette raquette;
    Raquette raquette2;
    Balle balle;
    Graphics g2;
    Graphics g3;
    Boolean mouseMoved;
    Boolean mouseDragged;
       
    int mx, my;
    
  public Surface(){
	    raquette = new Raquette(0,0,20,200);
      raquette2 = new Raquette(964,0,20,200);
      balle = new Balle(500,400,40,40);
      this.addMouseMotionListener(this);
    	
    }
        public void paint(Graphics g){
       
        	
        	g2 = g.create();  
        	g3 = g.create();
        	
            
            //couleur
            g.setColor(Color.blue);   
            g2.setColor(Color.red);
            g3.setColor(Color.white);
            
            //dessine les raquettes et la balle
            g.fillRect(raquette.x,raquette.y,raquette.largeur,raquette.hauteur);
            g2.fillRect(raquette2.x,raquette2.y,raquette2.largeur,raquette2.hauteur);
            g3.fillOval(balle.x, balle.y, balle.hauteur, balle.largeur);
                              
    }
		@Override
		public void mouseDragged(MouseEvent e) {
			
	
		}
		@Override
		//evenement quand je bouge la souris
		public void mouseMoved(MouseEvent e) { //� chaque mouvement de la souris mouseMoved est appel�e
			
			mx = e.getX(); //j'attrape le X de la souris � chaque fois  qu'elle bouge et le stock dans mx
			my = e.getY(); //j'attrape le y de la souris et le stock dans my
			
			//comme MouseMoved est appel�e � chaque fois que je bouge la souris,
			//les valeurs de mx et my vont chang�e � chaque fois aussi avec l'appel de la fonction
			
      if(mx > 500){
          if(my < 965 - raquette.hauteur){
              raquette2.setY(my);

          }
      }
      else if(mx < 500){
          if(my < 965 - raquette.hauteur){
              raquette.setY(my);

          } //les déplacements de la souris se mettent dans la raquette, donc la raquette suis les mouvements de la souris
      }
			mouseDragged = false; //je n'utilise pas MouseDragged
			
			e.consume();
			repaint(); //repaint
		}

    public void actualiser(){
            if(collision(balle,raquette,1)){
                balle.changeDirectionX();
                if(balle.y < (raquette.y + raquette.hauteur / 2) && balle.y > raquette.y){
                    balle.setDirectionY(-1);
                }
                else{
                    balle.setDirectionY(1);
                }
            }
        if(collision(balle,raquette2,-1)){
            balle.changeDirectionX();
            if(balle.y < (raquette2.y + raquette2.hauteur / 2) && balle.y > raquette2.y){
                balle.setDirectionY(-1);
            }
            else{
                balle.setDirectionY(1);
            }
        }

      balle.deplacerBalle();
      try{
        Thread.sleep(1);
      } catch(Exception e){
        System.out.println(e);
      }
      this.repaint();
    }


    public boolean collision(Balle b, Raquette r, int n){
      if(b.x == r.x  + r.largeur * n){
          if((b.y <= r.y + r.hauteur && b.y >= r.y) ||
                  (b.y + b.hauteur <= r.y + r.hauteur&& b.y >= r.y)){
              return true;
          }
      }

        return false;
    }

}
