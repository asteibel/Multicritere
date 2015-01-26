/**
 * Liste d'évaluations par des experts (autant que de critères)
 * @author Audric
 *
 */
public class Alternative {

	String nom;
	Evaluation[] listeEvaluation;
	
	/**
	 * 
	 * @param n Nombre de critères
	 * @param k Nombre d'évaluateurs
	 */
	public Alternative(int n, int k){
		initialisation(n,k);
	}
	
	/**
	 * 
	 * @param n Nombre critères
	 * @param k Nombre d'évaluateurs
	 */
	public void initialisation(int n, int k){
		listeEvaluation = new Evaluation[n];
		for(int i =0;i<listeEvaluation.length;i++)
			listeEvaluation[i].initialisation(k);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Evaluation[] getListeEvaluation() {
		return listeEvaluation;
	}

	public void setListeEvaluation(Evaluation[] listeEvaluation) {
		this.listeEvaluation = listeEvaluation;
	}
	
	
	
}
