
public class Cell {
	private final int x, y;
	private Figura figura;
	public Cell(int x, int y, Figura figura){
		this.x = x;
		this.y = y;
		this.figura = figura;
	}
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		figura = null;
	}
	public Figura getFigura(){
		return figura;
	}
	public void setFigure(Figura figura){
		this.figura = figura;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}