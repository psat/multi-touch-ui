package shapes;

public class Rectangle extends AbstractShape{
	
	private int width, height;

	public Rectangle(int posX, int posY, int height, int width){
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;		
	}
	
	public void display(){
		rect(posX, posY, height, width);
	}
	
	public boolean overRect(int x, int y, int width, int height) {
		if (mouseX >= x && mouseX <= x+width && 
				mouseY >= y && mouseY <= y+height) {
			return true;
		} else {
			return false;
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}