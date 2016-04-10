/**
 * MenuWindow.java
 * @author AdamAnderson
 * 
 * A MenuWindow is created alongside a DrawingWindow to allow for parameter
 * tweaking while a Processing Sketch is being run. A MenuWindow displays
 * buttons with the names of all of the parameters specified 
 * the values.
 */

package menu_package;

import java.util.Set;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;

public class MenuWindow extends ProcessingWindow {
	private Map<String, Double> parameters;
	private Map<String, Button> updateButtons;
	private float buttonHeight;
	private static final int TEXT_SIZE = 20;
	
	/**
	 * Base constructor for a MenuWindow. Takes in a width and height for the window dimenstions,
	 * a String title, and a parameter map relating Strings with the names of the parameters to 
	 * doubles representing their values.
	 * @param width
	 * @param height
	 * @param title
	 * @param parameters
	 */
	 public MenuWindow(int width, int height, String title, Map<String, Double> parameters) {
		super(width, height, title);
		
		this.parameters = parameters;
		updateButtons = new LinkedHashMap<String, Button>();
		buttonHeight = (float) ((height / (parameters.keySet().size() * 2)) - (height / 8));		
	 }
	 
	 /**
	  * If the mouse is pressed over one of the update buttons, a dialog prompting
	  * the user for a new value will be launched. If the user does not enter a 
	  * valid number, the parameter value will not be changed.
	  */
	 public void mousePressed() {
		 for (String parameter : updateButtons.keySet()) {
			 // Check if mouse was over an updateButton when pressed
			 if (updateButtons.get(parameter).mouseOver(pmouseX, pmouseY)) {
				 System.out.println("Update requested for: " + parameter);
				 // Prompt user for value to update parameter with
				 Double newValue;
				 String input = JOptionPane.showInputDialog("Enter new value");
				 // Try to set the newValue to the user's input
				 try {
					 newValue = Double.parseDouble(input);
				 }
				 catch (NumberFormatException e) {
					 // If user input was invalid, do not change the value
					 newValue = parameters.get(parameter);
				 }
				 parameters.put(parameter,  newValue);
			 }
		 }
	 }
	 	 
	 /**
	  * Draw the menu to the MenuWindow by spacing all parameters equally given
	  * the window dimensions.
	  */
	 public void draw() {
		 Set<String> parameterNames = parameters.keySet();
		 int numParameters = parameterNames.size();
		 float verticalSpacing = ((float) height / (float) (numParameters * 2));
		 float buttonX = (float) (width / 2.0);
		 float centerY;
		 int parameterNumber = 1;
		 // Iterate through each parameter, create an updateButton for the parameter,
		 // and draw it to the output window
		 for (String parameter : parameterNames) {			 
			 centerY = (parameterNumber * verticalSpacing);
			 updateButtons.put(parameter,  new Button(parameter, buttonX, centerY, buttonHeight));
			 updateButtons.get(parameter).draw();
			 centerY += ++parameterNumber * verticalSpacing;
			 
		 }
		 noLoop();
	 }
	 
	 /*
	  * Inner class representing the updateButtons for the MenuWindow. All
	  * a button needs to know is its location and dimensions, and it can 
	  * calculate whether or not the mouse is currently over it.
	  */
	 private class Button {
		 private String parameter;
		 private float centerX;
		 private float centerY;
		 private float bWidth;
		 private float bHeight;
		 
		 private Button(String parameter, float centerX, float centerY, float buttonHeight) {
			 this.parameter = parameter;
			 this.centerX = centerX;
			 this.centerY = centerY;
			 this.bWidth = buttonHeight*5;
			 this.bHeight = buttonHeight*3;
		 }
		 /*
		  * Draws the button to the output window
		  */
		 private void draw() {
			 rectMode(CENTER);
			 fill(50);
			 rect(centerX, centerY, bWidth, bHeight);
			 fill(255);
			 textAlign(CENTER);
			 text(parameter, centerX, centerY - (bHeight / 20));
			 fill(0);
		 }
		 
		 /*
		  * Returns true if the mouse is over the button on the MenuWindow
		  */
		 private boolean mouseOver(float mouseX, float mouseY) {
			 boolean isPressed = false;
			 float bWidth = this.bWidth / 3;
			 float bHeight = this.bHeight / 2;
			 if ((mouseX > centerX - bWidth) && (mouseX < centerX + bWidth) &&
					 (mouseY > centerY - bHeight) && (mouseY < centerY + bHeight)) {
				 isPressed = true;				 
			 }
			 return isPressed;
		 }
	 }
	
	//////////////////////////////////////////////////////////////////
	/* Below are methods that customize the MenuWindow's appearance */
	//////////////////////////////////////////////////////////////////
	 
	 
	 public void setup() {
		 background(255);
		 fill(0);
		 textSize(TEXT_SIZE);
	 }

	 
	 

}
