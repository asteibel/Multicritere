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
