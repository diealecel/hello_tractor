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

    static ArrayList<String[]> csv_reader(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        ArrayList<String[]> data = new ArrayList<String[]>();
        String line = null;
        String delimiter = ",";

        while( (line = reader.readLine()) != null ) {
            String[] cells = line.split(delimiter);
            data.add(cells);
        }

        reader.close();

        return data;
    }


    public static void main(String[] args) throws IOException {
        int[] headings;
        int[] averages;

        //instance data = new instance('edit.csv');
        //data.sort(key = lambda point: point[7]);

        ArrayList<String[]> data = csv_reader("edit.csv");

        for(String[] thing : data) {
            for(String other_thing : thing) {
                System.out.println(other_thing);
            }
        }
    }
}
