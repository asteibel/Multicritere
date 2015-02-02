import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TabAlternUI extends JFrame{
	
	TableauAlternatives tab;
	int n;
	int m;
	int k;
	
	JPanel grille;

	public TabAlternUI(){
		super();
		setTitle("Tableau des Alternatives");
		setPreferredSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		tab = new TableauAlternatives();
		
		pack();
	}
	
	public TableauAlternatives getTab() {
		return tab;
	}

	public void setTab(TableauAlternatives tab) {
		this.tab = tab;
	}
	
	public void initialisation(int i, int j, int k){
		
	}

	public void paint(){

		
		
		/**
		 * Creation du GridLayout + creation d'un tab de jPanel
		 */
		grille = new JPanel(new GridLayout(m+1,n+1));
		JPanel[][] tabPanel = new JPanel[m+1][n+1];
		for(int i =0;i<m+1;i++)
			for(int j=0;j<n+1;j++){
				tabPanel[i][j]=new JPanel();
				tabPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				tabPanel[i][j].addMouseListener(new TableauListener(i, j, this));
			}
				
		/**
		 * Ajout des noms des alternatives
		 */
		for(int i =1;i<m+1;i++){
			JPanel nvPanel = new JPanel();
			JLabel nvLab = new JLabel(tab.getListeAlternatives()[i-1].getNom());
			nvPanel.add(nvLab);
			tabPanel[i][0].add(nvPanel);
		}
		/**
		 * Ajout des noms des criteres
		 */
		for(int i =1;i<n+1;i++){
			JPanel nvPanel = new JPanel();
			JLabel nvLab = new JLabel(tab.getListeCriteres()[i-1]);
			nvPanel.add(nvLab);
			tabPanel[0][i].add(nvPanel);
		}
		
		/**
		 * Ajout des notes
		 */
		for(int i =1;i<m+1;i++)
			for(int j=1;j<n+1;j++){
				JPanel nvPanel = new JPanel();
				JLabel nvLab = new JLabel(tab.getListeAlternatives()[i-1].getListeEvaluation()[j-1].toString());
				nvPanel.add(nvLab);
				tabPanel[i][j].add(nvPanel);
				System.out.println("notes "+tab.getListeAlternatives()[i-1].getListeEvaluation()[j-1].toString());
			}
		
		for(int i =0;i<m+1;i++){
			for(int j=0;j<n+1;j++){
				grille.add(tabPanel[i][j]);
			}
			
		}
		
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		this.add(grille,bl.CENTER);
		JButton bouton = new JButton("Lancer le calcul");
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("click");
			}
		});
		this.add(bouton,bl.SOUTH);
		
	}
	
	public void paint2(){
		this.remove(grille);
		paint();
		this.pack();
		this.repaint();
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}
	
	
}
