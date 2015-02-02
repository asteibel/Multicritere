import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TabPrefUI extends JFrame{

	TableauPref tab;
	/**
	 * nom critères
	 */
	int n;
	/**
	 * liste critères
	 */
	String[] listeCriteres;
	
	JPanel grille;
	
	public TabPrefUI(int n,String[] listeCriteres){
		
		super();
		setTitle("Préférences");
		setPreferredSize(new Dimension(250, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		
		
		this.n=n;
		this.listeCriteres=listeCriteres;
		tab = new TableauPref(n);
		
		pack();
	}
	
public void paint(){

		
		/**
		 * Creation du GridLayout + creation d'un tab de jPanel
		 */
		grille = new JPanel(new GridLayout(n+1,n+1));
		JPanel[][] tabPanel = new JPanel[n+1][n+1];
		for(int i =0;i<n+1;i++)
			for(int j=0;j<n+1;j++){
				tabPanel[i][j]=new JPanel();
				tabPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				tabPanel[i][j].addMouseListener(new TabPrefListener(i, j, this));
			}
				
		/**
		 * Ajout des noms des criteres
		 */
		for(int i =1;i<n+1;i++){
			JPanel nvPanel = new JPanel();
			JLabel nvLab = new JLabel(listeCriteres[i-1]);
			nvPanel.add(nvLab);
			tabPanel[i][0].add(nvPanel);
		}
		/**
		 * Ajout des noms des criteres
		 */
		for(int i =1;i<n+1;i++){
			JPanel nvPanel = new JPanel();
			JLabel nvLab = new JLabel(listeCriteres[i-1]);
			nvPanel.add(nvLab);
			tabPanel[0][i].add(nvPanel);
		}
		
		/**
		 * Ajout des notes
		 */
		for(int i =1;i<n+1;i++)
			for(int j=1;j<n+1;j++){
				JPanel nvPanel = new JPanel();
				JLabel nvLab = new JLabel(String.valueOf(tab.getTabPref()[i-1][j-1]));
				nvPanel.add(nvLab);
				tabPanel[i][j].add(nvPanel);
			}
		
		for(int i =0;i<n+1;i++){
			for(int j=0;j<n+1;j++){
				grille.add(tabPanel[i][j]);
			}
			
		}
		
		this.add(grille);
		
	}

public void paint2(){
	this.remove(grille);
	paint();
	pack();
	repaint();
}

public TableauPref getTab() {
	return tab;
}

public void setTab(TableauPref tab) {
	this.tab = tab;
}

public int getN() {
	return n;
}

public void setN(int n) {
	this.n = n;
}

public String[] getListeCriteres() {
	return listeCriteres;
}

public void setListeCriteres(String[] listeCriteres) {
	this.listeCriteres = listeCriteres;
}

public JPanel getGrille() {
	return grille;
}

public void setGrille(JPanel grille) {
	this.grille = grille;
}
	
}
