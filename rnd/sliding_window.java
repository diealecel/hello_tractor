// Wow this is incredible
import java.util.*;
import java.io.*;



class instance {
    private int heading;
    private int speed;

    instance(int heading, int speed) {
        this.heading = heading;
        this.speed = speed;
    }

    int get_heading() {
        return heading;
    }

    int get_speed() {
        return speed;
    }
}



public class sliding_window {
    int WINDOW_SIZE = 5;
    int PACKET_END = 400;
    int PACKET_START = 0;

    ArrayList<String[]> csv_reader(String filename) {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line = null;

        
    }


    public static void main(String[] args) {
	int[] headings; 
	int[] averages; 
	
	instance data = new instance('edit.csv'); 
	data.sort(key = lambda point: point[7]);

	for(int i=0; i < ; i++){

	    }




        // Main method.
    }

}
