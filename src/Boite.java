/*
* Nom de classe : Boite
*
* Description : bo�te dans laquelle placer des �l�ments
*
* Version : 1.0
*
* Date : 04/02/2013
*
* Auteur : Chams LAHLOU
*/

public class Boite implements java.lang.Comparable {
	private int numero;				// identificateur de la bo�te
	private int capacite;			// capacit� de la bo�te
	private int placeLibre;			// taille de l'espace restant (= capacit� lorsque la bo�te est vide)
	private ListeElements liste;	// liste des �l�ments plac�s dans la bo�te
	
	// constructeur par d�faut (bo�te fictive)
	public Boite() {
		numero = 0;
		capacite = 0;
		placeLibre = 0;
		liste = new ListeElements();	// cr�ation d'une liste vide d'�l�ments	
	}

	// constructeur 2 (bo�te vide)
	public Boite(int numero, int capacite) {
		this.numero = numero;
		this.capacite = capacite;
		placeLibre = capacite;
		liste = new ListeElements();	// cr�ation d'une liste vide d'�l�ments	
	}

	public int getNumero() {
		return numero;
	}
		
	public int getCapacite() {
		return capacite;
	}

	public int getPlaceLibre() {
		return placeLibre;
	}

	public void setPlaceLibre(int p) {
		placeLibre = p;
	}

	public int getNbElements() {
		return liste.getNbElements();
	}
		
	public ListeElements getListe() {
		return liste;
	}

	public void setListe(ListeElements l) {
		liste = l;
	}

	// renvoie l'�l�ment d'indice i
	public Element getElement(int i) {
		return liste.getElement(i);
	}

	// supprime l'�l�ment de num�ro n
	public void supprimerElement(int n) {
		int ne = getNbElements();
		for (int i = 1; i <= ne; i++) {
			if (getElement(i).getNumero() == n) {
				placeLibre += getElement(i).getTaille();
				liste.supprimerElement(i);
				break;
			}
		}
	}

	public Boite copie() {
		ListeElements l = liste.copie();
		Boite b = new Boite(numero, capacite);
		b.setListe(l);
		b.setPlaceLibre(placeLibre);
		return b;
	}
    // affiche le contenu de la bo�te : num�ro (capacit� occuppation/capacit� bo�te) : num�ros des �l�ments plac�s
	public void afficher() { 	
    	System.out.print("Boite " + numero + " (" + (capacite-placeLibre) + "/" + capacite + ") : ");
    	int n = getNbElements();
        for (int i = 1; i <= n; i++) {
        	Element e = getElement(i);
        	System.out.print(e.getNumero() + " ");
        }
    }

    /* on a besoin de d�finir un ordre pour utiliser les fonctions 
    * "sort()" et "reverseOrder()" de Java.
    * On utilise la place libre des bo�tes pour les comparer
    */
    public int compareTo(Object obj) {
    	int nombre1 = ((Boite) obj).getPlaceLibre();
    	int nombre2 = placeLibre;
    	if (nombre1 > nombre2) {
    		return -1;
    	}
    	else if (nombre1 == nombre2) {
    		return 0;
    	}
    	else {
    		return 1;
    	}
    }

    // EXO 1
	// Attention : on suppose qu'il y a la place pour mettre l'�l�ment
    public void ajouterElement(Element e) {
		this.getListe().ajouterElement(e);
		this.setPlaceLibre(this.getPlaceLibre()-e.getTaille());

    }


}
