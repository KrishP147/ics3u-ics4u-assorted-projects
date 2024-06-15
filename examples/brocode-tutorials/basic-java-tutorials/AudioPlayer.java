import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class AudioPlayer {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		Scanner scanner = new Scanner(System.in);
		long playbackTime = 0;
		
		File file = new File("C:\\Users\\LENOVO\\Downloads\\Shanghai.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		String response = "";
			
		while(!response.equals("Q")) {
			System.out.println("O = Pause, P = Play, S = Stop, R = Reset, Q = Quit");
			System.out.print("Enter your choice: ");
			
			response = scanner.next();
			response = response.toUpperCase();
			
			switch(response) {
				case ("P"): 
				clip.setMicrosecondPosition(playbackTime);
				clip.start();
				clip.setLoopPoints(0, Clip.LOOP_CONTINUOUSLY);
				break;
				case ("S"): 
				clip.stop();
				playbackTime = 0;
				break;
				case ("R"): clip.setMicrosecondPosition(0);
				break;
				case ("Q"): clip.close();
				break;
				case ("O"): 
				clip.stop();
				playbackTime = clip.getMicrosecondPosition();
				break;
				default: System.out.println("Not a valid response");
			}
		 }
		System.out.println("Byeeee!");	
		scanner.close();
	}
}