/**
 * Tableau de notes pour un critère
 * Taille : k (nombre d'évaluateurs)
 * @author Audric
 *
 */
public class Evaluation {

	Note[] evaluation;
	
	public Evaluation(int k){
		initialisation(k);
	}
	
	public void initialisation(int k){
		evaluation = new Note[k];
	}
	
}
