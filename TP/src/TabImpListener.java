import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;


public class TabImpListener implements MouseListener{

	int i;
	int j;
	TabImpUI tab;
	
	public TabImpListener(int i, int j, TabImpUI tab){
		this.i=i;
		this.j=j;
		this.tab=tab;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Importance relative de "+tab.getListeCriteres()[i-1]+" par rapport à "+tab.getListeCriteres()[j-1]);
		Scanner sc = new Scanner(System.in);
		float f = sc.nextFloat();
		tab.getTab().setImp(i-1, j-1, f);
		tab.getTab().setImp(j-1, i-1, 1/f);
		tab.paint2();
		tab.getTab().checkCalcul();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
