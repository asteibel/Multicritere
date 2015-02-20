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
	
	double[][] tabPref;
	
	public TableauPref(int n){
		this.n=n;
		
		tabPref=new double[n][n];
	}
	
	public void setPref(int i, int j, float pref){
		tabPref[i][j]=pref;
	}
	
	public double[][] getTabPref(){
		return tabPref;
	}
	public void setTabPref(double[][] tabPref){
		this.tabPref=tabPref;
	}
}
