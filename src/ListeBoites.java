/*
* Nom de classe : ListeElements
*
* Description : liste de bo�tes
*
* Version : 1.0
*
* Date : 04/02/2013
*
* Auteur : Chams LAHLOU
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListeBoites {
	private List<Boite> liste;	// liste de bo�tes
	
	// constructeur par d�faut (liste vide)
	public ListeBoites() {
		liste = new ArrayList<Boite>();
	}
	
	public int getNbBoites() {
		return liste.size();
	}

	// renvoie la bo�te d'indice i
	public Boite getBoite(int i) {
		return liste.get(i-1);	// les listes d�marrent � l'indice 0 mais les Boites � l'indice 1
	}

	public void setBoite(Boite b) {
		liste.add(b);
	}
	
	public ListeBoites copie() {
		ListeBoites l = new ListeBoites();
		int n = getNbBoites();
		for (int i = 1; i <= n; i++) {
			Boite b = getBoite(i).copie();
			l.setBoite(b);
		}
		return l;
	}

	// trie la liste selon les places libres croissantes
    public void trierPlacesLibresCroissantes() {
        Collections.sort(liste);
    }
    public void trierPlacesLibresDecroissantes(){
    	this.trierPlacesLibresCroissantes();
    	Collections.reverse(liste);
    }
    

    public void afficher() {
    	int n = getNbBoites();
        for (int i = 1; i <= n; i++) {
        	Boite b = getBoite(i);
        	b.afficher();
        	System.out.println();
        }
	}

	// EXO 2
	// ajoute une bo�te vide
	public void ajouterBoite(int capacite) {
		this.setBoite(new Boite(this.getNbBoites()+1,capacite));
	}
	
}
