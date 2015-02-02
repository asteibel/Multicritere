import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;


public class TabPrefListener implements MouseListener{

	int i;
	int j;
	TabPrefUI tab;
	
	public TabPrefListener(int i, int j, TabPrefUI tab){
		this.i=i;
		this.j=j;
		this.tab=tab;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Préférence de "+tab.getListeCriteres()[i-1]+" par rapport à "+tab.getListeCriteres()[j-1]);
		Scanner sc = new Scanner(System.in);
		tab.getTab().setPref(i-1, j-1, sc.nextFloat());
		tab.paint2();
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
