import java.awt.Color;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {

	static int n;
	static String[] listeCriteres;
	static TableauAlternatives tabAlt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		creerTabAlternatives();
		
		creerTabPreferences(n, listeCriteres);
		
		creerTabImportances(n,listeCriteres);
	}
	
	public static void creerTabAlternatives(){
		TabAlternUI tab = new TabAlternUI();
		
		//	int n;
			Scanner sc = new Scanner(System.in);
			System.out.println("Combien de critères?");
			n=sc.nextInt();
			tab.setN(n);
			//System.out.println(tab.getTab().getN()+" critères");
			//String[] listeCriteres = new String[n];
			listeCriteres = new String[n];
			for(int i =0;i<listeCriteres.length;i++){
				System.out.println("Entrez le critère n°"+(i+1));
				listeCriteres[i]=sc.next();
			}
			
			int m;
			System.out.println("Combien d'alternatives?");
			m=sc.nextInt();
			tab.setM(m);
			//System.out.println(tab.getTab().getM()+" alternatives");
			
			int k;
			System.out.println("Combien d'évaluateurs?");
			k=sc.nextInt();
			tab.setK(k);
			//System.out.println(tab.getTab().getK()+" évaluateurs");
			
			tab.getTab().initialisation(n, m, k);
			tab.getTab().setListeCriteres(listeCriteres);
			System.out.println(n+" critères, "+m+" alternatives, "+k+" évaluateurs.");
			for(int i =0;i<listeCriteres.length;i++)
				System.out.println(listeCriteres[i]);
			
			for(int i =0;i<m;i++){
				System.out.println("Entrez l'alternative n°"+(i+1));
				tab.getTab().getListeAlternatives()[i].setNom(sc.next());
			}
			
			tab.paint();
			tab.setVisible(true);
	}
	
	public static void creerTabPreferences(int n, String[] listeCriteres){
		TabPrefUI tabPrefUI = new TabPrefUI(n,listeCriteres);
		tabPrefUI.paint();
		tabPrefUI.setVisible(true);
	}
	
	public static void creerTabImportances(int n, String[] listeCriteres){
		TabImpUI tabImpUI = new TabImpUI(n, listeCriteres);
		tabImpUI.paint();
		tabImpUI.setVisible(true);
	}
	

	public void nouveau(){
		
		Evaluation[] eval1 = new Evaluation[3];//Rajouté par Audric pour par erreur 
		
		int[] tab1 = eval1[0].calculDistProb();
//		System.out.println(tab1[0]+" ;"+tab1[1]+" ;"+tab1[2]+" ;"+tab1[3]);
		
		Trapeze[] lTrap1 = new Trapeze[tabAlt.getN()];
		
		for(int i=0;i<eval1.length;i++){
			
				lTrap1[i] = new Trapeze(eval1[i].calculDistProb());
			
		}
		agregation(lTrap1);
	}
	
	public int[] agregation(Trapeze[] listeTrap){
		double[][] tabInterPoid = {{0.3,0,0,0.1,0.05},{0,0.2,0,0.1,0.05},{0,0,0.2,0.1,0.05},{0.1,0.1,0.1,0.2,0},{0.05,0.05,0.05,0,0.1}};
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		
		for(int i=0;i<tabInterPoid.length;i++){
			a+=tabInterPoid[i][i]*listeTrap[i].getPointTrap()[0];
			b+=tabInterPoid[i][i]*listeTrap[i].getPointTrap()[1];
			c+=tabInterPoid[i][i]*listeTrap[i].getPointTrap()[2];
			d+=tabInterPoid[i][i]*listeTrap[i].getPointTrap()[3];
				for(int j=0;j<listeTrap.length;j++){
					if(i>j)
					a+=1/2*tabInterPoid[i][j]*(Math.abs(listeTrap[i].getPointTrap()[0]-listeTrap[j].getPointTrap()[0]));
					b+=1/2*tabInterPoid[i][j]*(Math.abs(listeTrap[i].getPointTrap()[1]-listeTrap[j].getPointTrap()[1]));
					c+=1/2*tabInterPoid[i][j]*(Math.abs(listeTrap[i].getPointTrap()[2]-listeTrap[j].getPointTrap()[2]));
					d+=1/2*tabInterPoid[i][j]*(Math.abs(listeTrap[i].getPointTrap()[3]-listeTrap[j].getPointTrap()[3]));
				}
		}

			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);



		
		return null;
	}
	
	
}
