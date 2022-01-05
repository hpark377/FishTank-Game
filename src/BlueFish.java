//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Blue Fish Button
// Course: CS 300 Fall 2021
//
// Author: Hyunmin Park
// Email: hpark377@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import processing.core.PImage;


/**
 * this class creates bluefish objects
 */
public class BlueFish extends Fish{
	public int turnheight = 0;
	public int turnwidth = 0;
	public int x = 0;
  
  /**
   * Constructor that uses the blue fish image 
   */
  BlueFish(){

    super(2,"images" + File.separator + "blue.png",10, 300);

  }
  

  
  /**
   * move the fish to the left
   * if the fish meets the left end appear on the right side of the tank.
   * overrides fish.swim()
   */
  @Override
  public void swim() {
	  if(turnwidth ==0 & turnheight == 0) {
		  this.setX(this.getX()-this.speed());
		  this.setY(this.getY()-(this.speed()/2));
		  if(this.getX()<0) {
			  ++turnwidth;
			  this.flip();
		  }
		  else if(this.getY()<=0) {
			  ++turnheight;
		  }
	  }
	  else if(turnwidth != 0 & turnheight == 0){
		  this.setX(this.getX()+this.speed());
		  this.setY(this.getY()-(this.speed()/2));
		  if(this.getX() >= tank.width) {
			  --turnwidth;
			  this.flip();
		  }
		  else if(this.getY()<=0) {
			  ++turnheight;
		  }
	  }
	  else if(turnwidth == 0 & turnheight != 0){
		  this.setX(this.getX()-this.speed());
		  this.setY(this.getY()+(this.speed()/2));
		  if(this.getX() < 0) {
			  ++turnwidth;
			  this.flip();
		  }
		  else if(this.getY() >= tank.height) {
			  --turnheight;
		  }
	  }
	  else {
		  this.setX(this.getX()+this.speed());
		  this.setY(this.getY()+(this.speed()/2));
		  if(this.getX() >= tank.width) {
			  --turnwidth;
			  this.flip();
		  }
		  else if(this.getY() >= tank.height) {
			  --turnheight;
		  }
	  }

	  
  }
	  
  
  public void flip() {
	  this.image = getReversePImage(image);
      
  }
      
  public PImage getReversePImage( PImage image ) {
	  PImage reverse = new PImage(image.width, image.height,2);
	  for( int i=0; i < image.width; i++ ){
	   for(int j=0; j < image.height; j++){
		   if(image.get(i,j) <= 0) {
			   reverse.set(image.width - 1 - i, j, image.get(i, j));  
		   }
		   else {
			   reverse.set(image.width - 1 - i, j, image.get(0, 0));
		   }
	   }   
	  }
	  return reverse;
	 }
  
}