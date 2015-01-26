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
	
	double[][] pref;
	
	public TableauPref(int n){
		this.n=n;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(j==i)
					pref[i][j]=1;
	}
	
}
