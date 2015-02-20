import java.awt.Color;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {
	
	/**
	 * Nombre de critères
	 */
	static int n;
	static String[] listeCriteres;
	static TabAlternUI tabUI;
	static TableauAlternatives tabAlt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		System.out.println("Charger l'exemple ? (o/n)");
		if(sc.next().equals("o"))
			chargerExemple();
		else{
			creerTabAlternatives(sc);
			
			creerTabPreferences(n, listeCriteres);
		}
			
		
		creerTabImportances(n,listeCriteres);
	}
	
	public static void chargerExemple(){
		
		tabUI = new TabAlternUI();
		n=5;
		int m=2;
		int k=5;
		tabUI.initialisation(k, m, k);
		listeCriteres=new String[5];
		listeCriteres[0]="Physical";
		listeCriteres[1]="Psychological";
		listeCriteres[2]="Economic";
		listeCriteres[3]="Media";
		listeCriteres[4]="Environmental";
		
		tabAlt = new TableauAlternatives();
		tabAlt.initialisation(k, m, k);
		tabAlt.setListeCriteres(listeCriteres);
		
		Alternative alt1 = new Alternative(n, k);
		Note[] notes11 = { new Note(6, 9), new Note(6, 9), new Note(5, 9),
				new Note(4, 8), new Note(4, 7) };
		Note[] notes12 = { new Note(6, 9), new Note(7, 10), new Note(6, 9),
				new Note(6, 9), new Note(7, 9) };
		Note[] notes13 = { new Note(6, 9), new Note(6, 9), new Note(6, 9),
				new Note(4, 7), new Note(4, 7) };
		Note[] notes14 = { new Note(9, 10), new Note(9, 10), new Note(9, 10),
				new Note(8, 11), new Note(8, 11) };
		Note[] notes15 = { new Note(4, 7), new Note(4, 7), new Note(6, 7),
				new Note(4, 7), new Note(6, 7) };
		alt1.getListeEvaluation()[0].setEvaluation(notes11);
		alt1.getListeEvaluation()[1].setEvaluation(notes12);
		alt1.getListeEvaluation()[2].setEvaluation(notes13);
		alt1.getListeEvaluation()[3].setEvaluation(notes14);
		alt1.getListeEvaluation()[4].setEvaluation(notes15);

		Alternative alt2 = new Alternative(n, k);
		Note[] notes21 = { new Note(10, 13), new Note(12, 15),
				new Note(12, 15), new Note(12, 15), new Note(9, 13) };
		Note[] notes22 = { new Note(13, 16), new Note(13, 16),
				new Note(15, 17), new Note(15, 16), new Note(14, 16) };
		Note[] notes23 = { new Note(15, 17), new Note(15, 17),
				new Note(15, 17), new Note(15, 17), new Note(15, 17) };
		Note[] notes24 = { new Note(8, 11), new Note(8, 11), new Note(8, 11),
				new Note(7, 10), new Note(7, 10) };
		Note[] notes25 = { new Note(15, 17), new Note(15, 17),
				new Note(13, 16), new Note(13, 16), new Note(13, 16) };
		alt2.getListeEvaluation()[0].setEvaluation(notes21);
		alt2.getListeEvaluation()[1].setEvaluation(notes22);
		alt2.getListeEvaluation()[2].setEvaluation(notes23);
		alt2.getListeEvaluation()[3].setEvaluation(notes24);
		alt2.getListeEvaluation()[4].setEvaluation(notes25);
		
		Alternative[] listeAlt = {alt1, alt2};
		tabAlt.setListeAlternatives(listeAlt);
		
		tabAlt.getListeAlternatives()[0].setNom("Evacuate");
		tabAlt.getListeAlternatives()[1].setNom("Sheltering");
		
		tabUI.setTab(tabAlt);
		
		tabUI.paint();
		tabUI.setVisible(true);
		
		
		TabPrefUI tabPrefUI = new TabPrefUI(n,listeCriteres,tabUI);
		double[][] tabPref = { { 0.3, 0, 0, 0.1, 0.05 },
				{ 0, 0.2, 0, 0.1, 0.05 }, { 0, 0, 0, 0.1, 0.05 },
				{ 0, 0, 0, 0.2, 0 }, { 0, 0, 0, 0, 0.1 } };
		tabPrefUI.getTab().setTabPref(tabPref);
		tabPrefUI.paint();
		tabPrefUI.setVisible(true);
		tabUI.setTabPref(tabPrefUI.getTab());
		
		
		System.out.println("Exemple chargé");
	}
	
	
	
	public static void creerTabAlternatives(Scanner sc){
			tabUI = new TabAlternUI();

			/**
			 * Tout d'abord, l'utilisateur est invité à rentrer le nombre de critères et leurs noms
			 */
			
			System.out.println("Combien de critères?");
			n=sc.nextInt();
			tabUI.setN(n);
			listeCriteres = new String[n];
			for(int i =0;i<listeCriteres.length;i++){
				System.out.println("Entrez le critère n°"+(i+1));
				listeCriteres[i]=sc.next();
			}
			/**
			 * L'utilisateur rentre ensuite le nombre d'évaluateurs et d'alternatives
			 */
			int k;
			System.out.println("Combien d'évaluateurs?");
			k=sc.nextInt();
			tabUI.setK(k);
			int m;
			System.out.println("Combien d'alternatives?");
			m=sc.nextInt();
			tabUI.setM(m);
			
			
			tabUI.getTab().initialisation(n, m, k);
			tabUI.getTab().setListeCriteres(listeCriteres);
			/**
			 * L'utilisateur rentre le noms des alternatives
			 */
			for(int i =0;i<m;i++){
				System.out.println("Entrez l'alternative n°"+(i+1));
				tabUI.getTab().getListeAlternatives()[i].setNom(sc.next());
			}
			/**
			 * Récap dans la console
			 */
			System.out.println(n+" critères, "+m+" alternatives, "+k+" évaluateurs.");
			
			
			tabAlt=tabUI.getTab();
			tabUI.paint();
			tabUI.setVisible(true);
	}
	
	public static void creerTabPreferences(int n, String[] listeCriteres){
		TabPrefUI tabPrefUI = new TabPrefUI(n,listeCriteres,tabUI);
		tabPrefUI.paint();
		tabPrefUI.setVisible(true);
		tabUI.setTabPref(tabPrefUI.getTab());
	}
	
	public static void creerTabImportances(int n, String[] listeCriteres){
		TabImpUI tabImpUI = new TabImpUI(n, listeCriteres);
		tabImpUI.paint();
		tabImpUI.setVisible(true);
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
