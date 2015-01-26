import java.util.List;


public class TableauAlternatives {

	/**
	 * Nombre de critères
	 */
	int n;
	/**
	 * Nombre d'alternatives
	 */
	int m;
	/**
	 * Nombre d'évaluateurs
	 */
	int k;
	
	String[] listeCriteres;
	
	Alternative[] listeAlternatives;
	/**
	 * Initialisation des paramètres
	 * @param n nombre de critères
	 * @param m nombre d'alternatives
	 * @param k nombre d'évaluateurs
	 */
	public void initialisation(int n, int m, int k){
		this.m=m;
		this.n=n;
		this.k=k;
		listeCriteres = new String[n];
		listeAlternatives = new Alternative[m];
		
		for(int i =0;i<listeAlternatives.length;i++){
			listeAlternatives[i] = new Alternative(n,k);
		}
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public String[] getListeCriteres() {
		return listeCriteres;
	}
	public void setListeCriteres(String[] listeCriteres) {
		this.listeCriteres = listeCriteres;
	}
	public Alternative[] getListeAlternatives() {
		return listeAlternatives;
	}
	public void setListeAlternatives(Alternative[] listeAlternatives) {
		this.listeAlternatives = listeAlternatives;
	}
	
}
