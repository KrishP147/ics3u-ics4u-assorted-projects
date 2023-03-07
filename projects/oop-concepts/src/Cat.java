import javax.swing.JOptionPane;

public class Cat extends Animal {
    
    public Cat() { //Cat uses Animal constructor 
        super("Cat");
    }
    
    @Override
    public String eat() {  //Cat override method
        String food = "Cat - I eat cat food!";
    	return food;
    }
    
    @Override
    public String play() {  //Cat override method
        String play = "Cat - I love to play with a string!";
    	return play;
    }
    
    @Override
    public String sound() {  //Cat override method
    	String sound =  "Cat - I meow!";
		return sound;
    } 
    
    public String clean() {  //Cat specialized method
    	String clean =  "Cat - I'm super clean!";
		return clean;
    } 
    
    public String purr() {  //Cat specialized method
    	String purr = "Cat - I purr when I'm happy!";
		return purr;
    }
    
    public String displayInfo() {  //Cat specialized method
        
    	String result = "";
        result += sleep() + "\n"; //superclass
        result += sound() + "\n"; //Cat override method
        result += eat() + "\n"; //Cat override method
        result += eat("FOOD") + "\n"; //superclass 
        result += play() + "\n"; //Cat override method
        result += clean() + "\n"; //Cat specialized method
        result += purr(); //Cat specialized method
        
        // Show the results in a message dialog
        JOptionPane.showMessageDialog(null, result, "Cat Information", JOptionPane.INFORMATION_MESSAGE);
		
        return result;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.displayInfo();

    }
}
