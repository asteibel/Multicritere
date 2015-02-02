import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;


public class TableauListener implements MouseListener{

	int i;
	int j;
	TabAlternUI tab;
	
	public TableauListener(int i, int j, TabAlternUI tab){
		this.i=i;
		this.j=j;
		this.tab=tab;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Alternative "+j+", critère "+i);
		System.out.println("Il faut rentrer "+tab.getTab().getK()+" notes");
		Scanner sc = new Scanner(System.in);
		
		for(int l=0;l<tab.getTab().getK();l++){
			System.out.println("Rentrez la note max "+l+1);
			tab.getTab().getListeAlternatives()[j-1].getListeEvaluation()[i-1].getEvaluation()[l].setMax(sc.nextInt());
			System.out.println("Rentrez la note min "+l+1);
			tab.getTab().getListeAlternatives()[j-1].getListeEvaluation()[i-1].getEvaluation()[l].setMin(sc.nextInt());
			System.out.println(tab.getTab().getListeAlternatives()[j-1].getListeEvaluation()[i-1].getEvaluation()[l].getMin() +"min");
		}

		tab.paint2();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
