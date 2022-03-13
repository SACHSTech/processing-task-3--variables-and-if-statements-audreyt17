import processing.core.PApplet;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Sketch extends PApplet {


	/**
  * Description: 
  * Write a program that utilizes your own variables to create a more dynamic drawing, draws objects in random location, and uses if statements.
  * @author: Tao A
  */

  int dimension = 400;  // set this for a global dimension value >= 100
  int randomX = ((int)(50 + Math.random() * 300)) * dimension / 400;
  int randomY = ((int)(100 + Math.random() * 100)) * dimension / 400; 

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(dimension, dimension);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    String currentTime = getCurrentTime();

    int hour = Integer.parseInt(currentTime.substring(0, 2));
    if (hour >= 6 && hour < 18) {
      // during the day
      background(randomX % 80 + 120, randomY % 80 + 120, (randomX + randomY) % 80 + 160);
    } else {
      // night fall
      background(randomX % 60 + 40, randomY % 60 + 40, (randomX + randomY) % 60 + 80);  
    }
    
    // clock
    text("UFO X-File. Time: " + currentTime, dimension / 40, dimension / 20);
  }

  public static String getCurrentTime() {    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
    return dtf.format(LocalDateTime.now(ZoneId.of("US/Eastern")));
  }

  public void drawUFO(int x, int y) {
    // UFO glass
    stroke(0);
    fill(237, 234, 228);
    ellipse(x * dimension / 400, y * dimension / 400,
            37 * dimension / 400, 40 * dimension / 400);

    // UFO
    stroke(0);
    fill(185, 187, 189);
    ellipse(x * dimension / 400, (y + 5) * dimension / 400,
            60 * dimension / 400, 20 * dimension / 400);

    // UFO beam
    fill(x % 128 + 128, y % 128 + 128, 70);
    triangle(x * dimension / 400, (y + 15) * dimension / 400,
             (x - 20) * dimension / 400, (y + 110) * dimension / 400,
             (x + 20) * dimension / 400, (y + 110) * dimension / 400);
  }
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
    float flowerX = 300 * dimension / 400;
    float flowerY = 270 * dimension / 400;
    float petalSize = 50 * dimension / 400;
    float petalDistance = petalSize / 2;

    fill(195, 149, 199);

    // upper-left petal
    ellipse(flowerX - petalDistance, flowerY - petalDistance,
        petalSize, petalSize);

    // upper-right petal
    ellipse(flowerX + petalDistance, flowerY - petalDistance,
        petalSize, petalSize);

    // lower-left petal
    ellipse(flowerX - petalDistance, flowerY + petalDistance,
        petalSize, petalSize);

    // lower-right petal
    ellipse(flowerX + petalDistance, flowerY + petalDistance,
        petalSize, petalSize);

    // center petal
    fill(248, 252, 131);
    ellipse(flowerX, flowerY,
        petalSize, petalSize);

    // flower stem
    stroke(128);
    strokeWeight(3/2);
    line(300 * dimension / 400, dimension,
         300 * dimension / 400, 305 * dimension / 400);

    // rectangle of the house
    fill(189, 154, 102);
    rect(50 * dimension / 400, 149 * dimension / 400,
         180 * dimension / 400, 250 * dimension / 400);
    
    // door of the house
    fill(135, 108, 68);
    rect(95 * dimension / 400, 270 * dimension / 400,
         90 * dimension / 400, 125 * dimension / 400);
    
    // roof of the house
    fill(135, 108, 68);
    triangle(50 * dimension / 400, 150 * dimension / 400,
             135 * dimension / 400, 60 * dimension / 400,
             230 * dimension / 400, 150 * dimension / 400);
    
    // grass
    fill(97, 173, 97);
    rect(0, 365 * dimension /400,
         dimension, 35 * dimension / 400);
  
    // UFO
    drawUFO(randomX, randomY);
  }
  // define other methods down here.
}