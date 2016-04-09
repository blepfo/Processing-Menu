package menutest;

import processing.core.PApplet;
import java.util.ArrayList;

public class OtherWindow extends PApplet {
	ArrayList<Float> coordinates;
	
	public OtherWindow(ArrayList<Float> coordinates) {
		this.coordinates = coordinates;
	}
	
	public void settings() {
		size(1000, 1000);
	}
	
	public void setup() {
		background(0);
		
	}
	
	public void draw() {
		coordinates.set(0,  (float) mouseX);
		coordinates.set(1, (float) mouseY);
		
	}
}
