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
	
	double[][] pref;
	
	public TableauPref(int n){
		this.n=n;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(j==i)
					pref[i][j]=1;
	}
	
}
