import javax.swing.JOptionPane;

/*
 * This is a super class that provides a blueprint for various animal subclasses to be created, extending this one.
 * Author: Krish Punjabi
 * Date: May 2 2024
 */

public class Animal {
   String type = "Animal";

   
   public Animal () { //default constructor, if no type provided
	   JOptionPane.showMessageDialog(null, "Default constructor, type Animal!", "TYPE", JOptionPane.INFORMATION_MESSAGE);
	}
   
    public Animal (String type) { //constructor if type is provided
    	  this.type = type;
    	  JOptionPane.showMessageDialog(null, "Default constructor, type " + getType() + "!", "TYPE", JOptionPane.INFORMATION_MESSAGE);
	}
   
    //setter method
    public void setType(String type) {
        this.type = type;
     }
    
    //getter method
    public String getType() {
        return type;
     }
    
   public String eat() {
      String eat = "Animal - I need to eat!";
      return eat;
   }
   
   public String eat(String food) {//method override - with parameter, different signature to eat method above
	   String eat = "Animal - I love to eat " + food + "! Give me some!";
	   return eat;
   }

   public String sleep() {
	   String food = "Animal - I can sleep!";
	   return food;
   }
   
   public String play() {
	   String play = "Animal - I can play!";
	   return play;
   }
   
   public String sound() {
	   String sound = "Animal - I make sounds!";
	   return sound;
   } 
}
