package menutest;

import processing.core.PApplet;


public class MenuTest extends PApplet {
	java.util.ArrayList<Float> coordinates;

	public void settings() {
		size(1000, 1000);
	}
	
	public void setup() {
		background(255);
		fill(0);
		coordinates = new java.util.ArrayList<Float>();
		coordinates.add(500f);
		coordinates.add(500f);
		OtherWindow test = new OtherWindow(coordinates);
		String[] name = {"Name"};
		PApplet.runSketch(name,  test);
		
		
	}

	public void draw() {
		ellipse(coordinates.get(0), coordinates.get(1), 50, 50);
	}
	
	
	
	
	public static void main(String[] args) {
		MenuTest test = new MenuTest();
		String[] name = {"Name"};
		PApplet.runSketch(name,  test);
	}
}
