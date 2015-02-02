/**
 * Tableau exprimant la pref d'un critère par rapport à un autre pour un évaluateur
 * @author Audric
 *
 */
public class TableauImp {

	/**
	 * Nombre de critères
	 */
	int n;
	
	float[][] tabImp;
	
	public TableauImp(int n){
		this.n=n;
		
		tabImp=new float[n][n];
		
		for(int i =0;i<n;i++)
			for(int j=0;j<n;j++)
				tabImp[i][j]=0;
		
		for(int i =0;i<n;i++)
			tabImp[i][i]=1;
	}
	
	public void setImp(int i, int j, float imp){
		tabImp[i][j]=imp;
	}
	
	public float[][] getTabImp(){
		return tabImp;
	}
	
	public void checkCalcul(){
		int compteur = 0;
		for(int i =0;i<n;i++)
			for(int j=0;j<n;j++)
				if(tabImp[i][j]!=0)
					compteur+=1;
		if(compteur==n*n)
			calcul();
		else
			System.out.println("Tout n'est pas rempli");
	}
	
	public void calcul(){
		System.out.println("Lancement du calcul");
		
		//1 Somme col
		float[] sommeCol = new float[n];
		for(int i =0;i<n;i++)
			for(int j=0;j<n;j++)
				sommeCol[i]+=tabImp[i][j];
		
		System.out.println("SOMME COLONNES");
		for(int i=0;i<n;i++)
			System.out.println("Col "+i+" "+sommeCol[i]);
			
		//2 matrice normalisée 
		
		float[][] matrice = new float[n][n];
		for(int i =0;i<n;i++)
			for(int j=0;j<n;j++)
				matrice[i][j]=tabImp[i][j]/sommeCol[j];
		
		System.out.println("MATRICE NORMALISEE");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				System.out.print(matrice[i][j]+ " ");
			System.out.println(" ");
		}
		//3 vecteur propre normalisé
			float[] sommeL = new float[n];
			for(int i =0;i<n;i++)
				for(int j=0;j<n;j++)
					sommeL[i]+=matrice[i][j]/n;
		
			System.out.println("VECTEUR PROPRE NORMALISE");
			for(int i=0;i<n;i++)
				System.out.println("Col "+i+" "+sommeL[i]);
			
			
	}
}
