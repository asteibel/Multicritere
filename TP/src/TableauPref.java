/**
 * Tableau exprimant la pref d'un crit�re par rapport � un autre pour un �valuateur
 * @author Audric
 *
 */
public class TableauPref {

	/**
	 * Nombre de crit�res
	 */
	int n;
	
	float[][] tabPref;
	
	public TableauPref(int n){
		this.n=n;
		
		tabPref=new float[n][n];
	}
	
	public void setPref(int i, int j, float pref){
		tabPref[i][j]=pref;
	}
	
	public float[][] getTabPref(){
		return tabPref;
	}
	
}
