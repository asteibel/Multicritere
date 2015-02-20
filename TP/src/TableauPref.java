/**
 * Tableau exprimant la pref d'un critère par rapport à un autre pour un évaluateur
 * @author Audric
 *
 */
public class TableauPref {

	/**
	 * Nombre de critères
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
