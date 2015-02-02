import java.awt.Color;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {

	static int n;
	static String[] listeCriteres;
	
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
	
	public void initialisation(){
		
		
		
		/**
		 * Creation du GridLayout + creation d'un tab de jPanel
		 *//**
		JPanel grille = new JPanel(new GridLayout(m+1,n+1));
		JPanel[][] tabPanel = new JPanel[m+1][n+1];
		for(int i =0;i<m+1;i++)
			for(int j=0;j<n+1;j++){
				tabPanel[i][j]=new JPanel();
				tabPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				tabPanel[i][j].addMouseListener(new TableauListener(i, j, tab));
			}
				
		/**
		 * Ajout des noms des alternatives
		 *//**
		for(int i =1;i<m+1;i++){
			JPanel nvPanel = new JPanel();
			JLabel nvLab = new JLabel(tab.getTab().getListeAlternatives()[i-1].getNom());
			nvPanel.add(nvLab);
			tabPanel[i][0].add(nvPanel);
		}
		/**
		 * Ajout des noms des criteres
		 *//**
		for(int i =1;i<n+1;i++){
			JPanel nvPanel = new JPanel();
			JLabel nvLab = new JLabel(listeCriteres[i-1]);
			nvPanel.add(nvLab);
			tabPanel[0][i].add(nvPanel);
		}
		
		for(int i =1;i<m+1;i++)
			for(int j=1;j<n+1;j++){
				JPanel nvPanel = new JPanel();
				JLabel nvLab = new JLabel(tab.getTab().getListeAlternatives()[i-1].getListeEvaluation()[i-1].toString());
				nvPanel.add(nvLab);
				tabPanel[i][j].add(nvPanel);
			}
		
		for(int i =0;i<m+1;i++){
			for(int j=0;j<n+1;j++){
				grille.add(tabPanel[i][j]);
			}
			
		}
		
		tab.add(grille);
		 */
	}

}
