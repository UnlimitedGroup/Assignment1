package model;
import java.util.ArrayList;

public class Player {
	private String team;
	
	//exceptions done later
	public Player(String team) throws teamException {
		if (team == "red" || team == "black") {
			this.team = team;
		}else {
		 throw new teamException();
				}
			}
}
	
