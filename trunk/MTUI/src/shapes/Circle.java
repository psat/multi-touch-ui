package shapes;

public class Circle extends AbstractShape{

	private int diameter;

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public Circle(int posX, int posY, int diameter){
		this.posX = posX;
		this.posY = posY;
		this.diameter = diameter;
		ellipse(140, 80, diameter, diameter);
	}

	private boolean overCircle(int x, int y, int diameter) 
	{
		float disX = x - mouseX;
		float disY = y - mouseY;
		if(sqrt(sq(disX) + sq(disY)) < diameter/2 ) {
			return true;
		} else {
			return false;
		}
	}
}
