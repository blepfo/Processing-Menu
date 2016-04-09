/**
 * ProcessingWindow.java
 * @author AdamAnderson
 * 
 * ProcessingWindow from which DrawingWindow and MenuWindow are derrived.
 * A ProcessingWindow has a width, height and title, and it can be 
 * created using the createWindow() method.
 */

package menu_package;

import processing.core.PApplet;

abstract class ProcessingWindow extends PApplet {
	public final int width;
	public final int height;
	public final String title;
	
	/**
	 * Constructor for a ProcessingWindow takes in the window dimensions 
	 * as well as the title of the window.
	 * @param width
	 * @param height
	 * @param title
	 */
	public ProcessingWindow(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	/**
	 * Launches the window as a PApplet
	 */
	public void createWindow() {
		String[] title = {this.title};
		PApplet.runSketch(title, this);
	}
	
	/**
	 * Initializes the ProcessingWindow's dimensions
	 */
	public void settings() {
		size(width, height);
	}	
}