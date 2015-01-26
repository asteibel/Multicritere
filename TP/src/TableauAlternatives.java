import java.util.List;


public class TableauAlternatives {

	/**
	 * Nombre de crit�res
	 */
	int n;
	/**
	 * Nombre d'alternatives
	 */
	int m;
	/**
	 * Nombre d'�valuateurs
	 */
	int k;
	
	String[] listeCriteres;
	
	Alternative[] listeAlternatives;
	/**
	 * Initialisation des param�tres
	 * @param n nombre de crit�res
	 * @param m nombre d'alternatives
	 * @param k nombre d'�valuateurs
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
	
}
