/**
* DrawingWindow.java 
* @author AdamAnderson
*
* A DrawingWindow is a window used by Processing that is paired with a MenuWindow
* to allow for easy adjustment of parameters during the execution of a Processing sketch.
* Parameters are stored in a Map that assigns parameter names to doubles representing their
* value. The Parameters map is shared by the DrawingWindow and MenuWindow, so the
* DrawingWindow will update one frame after values are changed in the MenuWindow
* 
* To use DrawingWindows in your own creation, simply change the draw() method so the 
* DrawingWindow will perform whatever actions you desire. The methods 
* setup(), and draw() are located at the bottom of the class source file.
* By default, they contain code for relevant to the ExampleDriver, but you can change it
* to make your own Processing sketches with menus!
*/

package menu_package;

import java.util.Map;

public class DrawingWindow extends ProcessingWindow {
	private Map<String, Double> parameters;	
	private MenuWindow menu;
	private static final String DEFAULT_TITLE = "Drawing Window";

	/**
	* Base constructor for a DrawingWindow. Takes in the window width and height as parameters
	* and sets the size of the DrawingWindow accordingly, as well as a a String title for the
	* DrawingWindow, a Map of parameters, and the dimensions of the MenuWindow
	* DrawingWindow.
	* @param width
	* @param height
	* @param title
	* @param parameters
	* @param menu
	*/
	public DrawingWindow(int width, int height, String title, Map<String, Double> parameters,
						int menuWidth, int menuHeight) {
		super(width, height, title);
		this.parameters = parameters;
		createMenu(menuWidth, menuHeight);
	}
	
	/**
	* Constructor for DrawingWindow where only width, height, title, and menu 
	* dimensions are given
	* @param width
	* @param height
	* @param title
	* @param menu
	*/
	public DrawingWindow(int width, int height, Map<String, Double> parameters, int menuWidth, int menuHeight) {
		this(width, height, DEFAULT_TITLE, parameters, menuWidth, menuHeight);
	}
	
	/**
	 * Constructor for DrawingWindow for window dimensions and a map
	 * containing parameters
	 * @param width
	 * @param height
	 * @param parameters
	 */
	public DrawingWindow(int width, int height, Map<String, Double> parameters) {
		this(width, height, parameters, width, height);
	}
	
	/**
	 * Creates the DrawingWindow as well as its accompanying MenuWindow. 
	 */
	@Override
	public void createWindow() {
		super.createWindow();
		menu.createWindow();
	}
	
	/*
	 * Helper method creates a MenuWindow object for the parameters stored by
	 * the DrawingWindow. The input parameters represent the dimensions
	 * of the menu to be drawn
	 */
	private void createMenu(int menuWidth, int menuHeight) {
		menu = new MenuWindow(menuWidth, menuHeight, "Menu for " + title, parameters);
	}


	///////////////////////////////////////////////////////////////////////////////////////
	/* Below are methods that customize the DrawingWindow's appearance and functionality.*/
	///////////////////////////////////////////////////////////////////////////////////////

	/*
	 * Initialize the DrawingWindow the same way we would a normal Processing sketch
	 */
	public void setup() {
		background(255);
		fill(0);
		noStroke();
		rectMode(CENTER);
	}
	/*
	 * The draw function should be updated so that the DrawingWindow creates
	 * whatever the user desires.
	 */
	public void draw() {
		
		//Below is an example to demo the MenuWindow based on the 
		// parameters set in the ExampleDriver.
		float centerX = parameters.get("Center X").floatValue();
		float centerY = parameters.get("Center Y").floatValue();
		float radius = parameters.get("Radius").floatValue();
		background(255);
		ellipse(centerX, centerY, radius*2, radius*2);
		
	}


}
