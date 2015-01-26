import java.awt.Dimension;

import javax.swing.JFrame;


public class TabAlternUI extends JFrame{
	
	TableauAlternatives tab;

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

	public void initialisation(){
		
	}
	
}
