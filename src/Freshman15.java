/**
 *Feed a freshman until he explodes.
 * @author Terri Burns, NYU
 */

import processing.core.*;

public class Freshman15 extends PApplet {
    static final int WINDOW_WIDTH = 1200;
    static final int WINDOW_HEIGHT = 800;
	int bodyWidth = 170;
	int bodyLength = 230;
	int hairHeight = 30;
	int faceHeight = hairHeight + 100;
	int bodyHeight = faceHeight + 180;
	int eyeHeight = faceHeight - 15;
	int legLength = 240;
	int legWidth = 36;
	int legHeight = bodyHeight + bodyLength / 2 - 50;
	int shoeWidth = 90;
    int count = 0;
    PFont font;
    PImage pizza;
    
	/**
	 * This function creates/loads the font and the pizza image.
	 * It also initializes the background and size for of the window.
	 */
    public void setup() {
		font = createFont("Georgia", 48);
		pizza = loadImage("pizza.png");
		
		size(WINDOW_WIDTH, WINDOW_HEIGHT);
		background(0, 204, 102);
		smooth();
        
    }
	/**
	 * mouseClicked() has our freshman growing with each bite of pizza.
	 * Click the cursor (pizza) within the range of the freshman's mouth,
	 * and the method is called.
	 */
    public void mouseClicked(){ //count each time the mouse is clicked
		if (count <= 15) { 
						
			//IF MOUSECLICKED @ MOUTH
			if ((mouseX > WINDOW_WIDTH/2 - 20 && mouseX < WINDOW_WIDTH/2 +40) && 
				(mouseY > eyeHeight + 30 && mouseY < eyeHeight + 60)) {
				count++;
				bodyWidth = bodyWidth + 2*count;
				legWidth = legWidth + 1/3*count;
				shoeWidth = shoeWidth + 1/3*count;
				
			}
			

		}
		//update the body with each call of mouseClicked()
		//body();

	}
    /**
     * draw() calls drawObject() and body(). It is what updates the shape of our freshman,
     * and also creates an explosion (of colors and stars) when the 16th click is hit
     */
    public void draw() {
    	textAlign(CENTER, CENTER);
    	textFont(font, 48);
    	fill(0, 0, 0);
		text("FRESHMAN FIFTEEN", WINDOW_WIDTH/2-20, 10);
		textFont(font, 20);
		fill(0, 0, 0);
		text("Don't feed our freshman too much pizza!", WINDOW_WIDTH/2-20, WINDOW_HEIGHT-150);
		textFont(font, 12);
		text("Make sure the slice goes directly into his mouth. Keep clicking and see what happens.", WINDOW_WIDTH/2-20, WINDOW_HEIGHT-130);
		cursor(pizza); 
		
		int red = (int)(Math.random() * 256); // Color range is always between 0-255
	    int green = (int)(Math.random() * 256);
	    int blue = (int)(Math.random() * 256);
	    int xPos = (int)(Math.random() * WINDOW_WIDTH);
	    int yPos = (int)(Math.random() * WINDOW_HEIGHT);
	    
		drawObject();
		body(); 
		textAlign(CENTER, CENTER);
    	textFont(font, 48);
    	fill(0, 0, 0);
		text(count, WINDOW_WIDTH / 2, bodyHeight);
	
		if (count == 16) { //after 15 bites, EXLPODE!
			background(red, green, blue);//random colors
			//creates a star shape
			this.fill(red, green, blue);//random star colors
		    pushMatrix();
		    translate(xPos, yPos);
		    stroke(255);//star outline
		    strokeWeight(20);
		    beginShape();//calls PShape
		    vertex(0, -500);
		    vertex(140, -200);
		    vertex(470, -150);
		    vertex(230,70);
		    vertex(290, 400);
		    vertex(0, 250);
		    vertex(-290, 400);
		    vertex(-230, 70);
		    vertex(-470, -150);
		    vertex(-140, -200);
		    endShape(CLOSE);
		    popMatrix();
		}


	}
    /**
	 * draws the freshman body using 2D primitives
	 */
	public void drawObject() {	
		noStroke();		
		// HAIR
		int hairWidth = 135;
		int hairLength = 100;
		fill(0, 0, 0); // color
		rect(WINDOW_WIDTH / 2 - (hairWidth / 2), hairHeight, hairWidth, hairLength);

		// FACE
		fill(102, 51, 0); // color
		ellipse(WINDOW_WIDTH / 2, faceHeight, 140, 130); // shape of face

		// MOUTH AND EYES
		fill(255, 0, 0); // color
		arc(WINDOW_WIDTH / 2, eyeHeight + 30, 40, 30, 0, PI, CHORD);		
		// [whites]
		fill(255, 255, 255); // whites color
		ellipse(WINDOW_WIDTH / 2 - 23, eyeHeight, 24, 30); // left eye
		ellipse(WINDOW_WIDTH / 2 + 23, eyeHeight, 24, 30); // right eye
		// [pupils]
		fill(0, 0, 0); // pupil color
		ellipse(WINDOW_WIDTH / 2 - 23, eyeHeight, 12, 14); // left eye
		ellipse(WINDOW_WIDTH / 2 + 23, eyeHeight, 12, 14); // right eye

		// ARMS
		int armHeight = faceHeight + bodyHeight / 2 - 60;
		int armLength = bodyLength - 45;
		fill(102, 51, 0); // color
		rect(WINDOW_WIDTH / 2 - bodyWidth / 2 - 30, armHeight, 30, armLength); // left arm
		rect(WINDOW_WIDTH / 2 + bodyWidth / 2, armHeight, 30, armLength); // right  arm
		
		//SHOULDERS
		fill(102, 51, 0); // color
		rect(WINDOW_WIDTH / 2 - bodyWidth / 2 - 30, armHeight, 60, 30); // left shoulder
		rect(WINDOW_WIDTH / 2 + bodyWidth / 2 - 60, armHeight, 60, 30); // right  shoulder
		
		// HANDS
		fill(102, 51, 0); // color
		ellipse(WINDOW_WIDTH / 2 - bodyWidth / 2 - 30 - 10, armHeight + armLength, 80, 30); // left hand
		ellipse(WINDOW_WIDTH / 2 + bodyWidth / 2 - 30 + 70, armHeight + armLength, 80, 30); // right hand

		// LEGS
		fill(51, 51, 255); // color
		rect(WINDOW_WIDTH / 2 - bodyWidth / 2 + 28, legHeight, legWidth, legLength); // left leg
		rect(WINDOW_WIDTH / 2 + bodyWidth / 2 - 70, legHeight, legWidth, legLength); // right leg

		// SHOES
		fill(0, 0, 0); rect(WINDOW_WIDTH / 2 - bodyWidth / 2 -26, legHeight + legLength -20, shoeWidth, 40, 20, 0, 15, 20); //left foot
		rect(WINDOW_WIDTH / 2 + bodyWidth / 2 - 70, legHeight + legLength - 20,
				shoeWidth, 40, 0, 20, 20, 15);
		

		body();
	}
	/**
	 * body() draws the belly - the most important body part. 
	 */
	public void body() {
		fill(255, 128, 0); // shirt color
		ellipse(WINDOW_WIDTH / 2, bodyHeight, bodyWidth, bodyLength);

	}

}