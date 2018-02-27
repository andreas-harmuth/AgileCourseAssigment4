package assigment4;

public class Piece {
	private int x;
	private int y;
	
	private Player player;
	public Piece(Player player,int x, int y) {
		this.setPlayer(player);
		this.setX(x);
		this.setY(y);
	}
	// Empty piece
	public Piece(int x, int y) {
		this.setPlayer(null);
		this.setX(x);
		this.setY(y);
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	
}
