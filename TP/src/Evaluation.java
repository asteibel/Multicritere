/**
 * Tableau de notes pour un critère
 * Taille : k (nombre d'évaluateurs)
 * @author Audric
 *
 */
public class Evaluation {

	Note[] listeNotes;
	
	

	public Evaluation(int k){
		initialisation(k);
	}
	
	public void initialisation(int k){
		listeNotes = new Note[k];
		for(int i =0;i<listeNotes.length;i++)
			listeNotes[i] = new Note();
	}
	
	public double[] calculDistProb(){
		double[] tab= new double[4];
		double a=1000000;
		double d=0,b=0,c=0;


		if(listeNotes[0].getMax()<listeNotes[1].getMin()){
			b=listeNotes[1].getMin();
			c=listeNotes[0].getMax();
		}
		else if(listeNotes[0].getMax()>listeNotes[1].getMin()){
			b=listeNotes[0].getMin();
			c=listeNotes[1].getMax();
		}

		for(int i=0;i<listeNotes.length;i++){

			if(listeNotes[i].getMax()<b || listeNotes[i].getMin()>c){

			}
			else{

				if(listeNotes[i].getMin()<a){
					a=listeNotes[i].getMin();
				}
				if(listeNotes[i].getMax()>d){
					d=listeNotes[i].getMax();
				}

				if(listeNotes[i].getMin()>b){
					b=listeNotes[i].getMin();
				}
				if(listeNotes[i].getMax()<c){
					c=listeNotes[i].getMax();
				}
			}
		}
		tab[0]=a;
		tab[1]=b;
		tab[2]=c;
		tab[3]=d;
		return tab;
	}
	
	public String toString(){
		String retour = "";
		//if(listeNotes!=null)
			for(int i=0;i<listeNotes.length;i++)
				retour+=listeNotes[i].toString();
		return retour;
	}
	
	public Note[] getEvaluation() {
		return listeNotes;
	}

	public void setEvaluation(Note[] evaluation) {
		this.listeNotes = evaluation;
	}
	
}
