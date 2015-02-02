import java.util.ArrayList;


public class Forme {
	private ArrayList<double[]> listePoints = new ArrayList<double[]>();
	public Forme() {
		// TODO Auto-generated constructor stub
	}
	public void modifListe(double[] points){
		listePoints.add(points);
	}
	public ArrayList<double[]> getListePoints() {
		return listePoints;
	}
	public void setListePoints(ArrayList<double[]> listePoints) {
		this.listePoints = listePoints;
	}
	
}
