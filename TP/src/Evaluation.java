/**
 * Tableau de notes pour un crit�re
 * Taille : k (nombre d'�valuateurs)
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
