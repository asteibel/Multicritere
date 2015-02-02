/**
 * Tableau de notes pour un critère
 * Taille : k (nombre d'évaluateurs)
 * @author Audric
 *
 */
public class Evaluation {

	Note[] listeNotes;
	
	public Note[] getEvaluation() {
		return listeNotes;
	}

	public void setEvaluation(Note[] evaluation) {
		this.listeNotes = evaluation;
	}

	public Evaluation(int k){
		initialisation(k);
	}
	
	public void initialisation(int k){
		listeNotes = new Note[k];
		for(int i =0;i<listeNotes.length;i++)
			listeNotes[i] = new Note();
	}
	
	public String toString(){
		String retour = "";
		//if(listeNotes!=null)
			for(int i=0;i<listeNotes.length;i++)
				retour+=listeNotes[i].toString();
		return retour;
	}
	
}
