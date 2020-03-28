package model;
import java.util.ArrayList;

public class Player {
	private int id;
	ArrayList<Integer>idCheck = new ArrayList<Integer>();
	
	public Player(int id) throws idException {
		if (!idCheck.isEmpty()) {
			for (Integer x: idCheck) {
				if (id != x) {
					this.id = id;
					idCheck.add(this.id);
				}else {
					throw new idException();
				}
			}
		}
	}
}
