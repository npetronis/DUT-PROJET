import java.awt.Color;
import java.awt.Graphics;

public class Balle{
    int x,y,largeur,hauteur;
    int directionX = 1;
    int directionY = 0;

    public Balle(int x, int y, int largeur, int hauteur){
        this.x = x;
        this.y = y;
        this.largeur = largeur;        //info sur la balle
        this.hauteur = hauteur;
    }

    public void deplacerBalle(){ //fonction pour déplacer la balle
        x += directionX; //x de la balle s'incrémente de 1
        y += directionY; //y de la balle s'incrémente de 1

        if(x + largeur > 1000){
            directionX *= -1;
        }
       /* if(x < 0){
            directionX *= -1;
        }*/
        if(y + hauteur > 965 )
            directionY *= -1;
        if (y < 0)
            directionY *= -1;
    }

    public void changeDirectionX(){
        this.directionX *= -1;
    }

    public void setDirectionY(int dy){
        this.directionY = dy;
    }

}