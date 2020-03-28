package model;

public class Player {
	private int team;
	
	//exceptions done later
	public Player(int team) throws teamException {
		if (team == 0 || team == 1) {
			this.team = team;
		}else {
		 throw new teamException();
				}
			}
}
	
