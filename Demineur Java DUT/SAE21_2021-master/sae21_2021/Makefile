JFLAGS = -g
JC = javac
JVM= java 
FILE=

.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        BarreComposant.java \
        Case.java \
        ComposantCase.java \
        Controleur.java \
        FenetreGagne.java \
		FenetrePerdu.java \
        Grille.java \
        Menu.java \
        Parametre.java \
        Partie.java \
		VueGrille.java

MAIN = Menu

default: classes

classes: $(CLASSES:.java=.class)

run: $(MAIN).class
	$(JVM) $(MAIN) $(FILE)

clean:
	$(RM) *.class
