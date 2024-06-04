public class Raquette{
        int x,y,largeur,hauteur;
        public Raquette(int x, int y, int largeur, int hauteur){ //mettre la couleur en parametre surement
            this.x = x;
            this.y = y;
            this.largeur = largeur;            //info sur la raquette
            this.hauteur = hauteur;      
        }
        
        public void setY(int my) {    //fonction qui contient le Y de la souris
        	this.y = my;             
        	//Pour actualiser le Y
        }
}