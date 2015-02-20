/**
 * Intervalle
 * @author Audric
 *
 */
public class Note {

	

	int min;
	int max;
	
	public Note(int min, int max){
		this.min = min;
		this.max = max;
	}

	
	public Note() {
		// TODO Auto-generated constructor stub
	}


	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public String toString(){
		return "["+min+","+max+"]";
	}
}
