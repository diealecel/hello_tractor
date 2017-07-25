// Wow this is incredible
import java.util.*;
import java.io.*;

class Instance implements Comparable<Instance> {
    private int heading;
    private int speed;
    private String date;

    Instance(int heading, int speed, String date) {
        this.heading = heading;
        this.speed = speed;
        this.date = date;
    }

    int getHeading() {
        return heading;
    }

    int getSpeed() {
        return speed;
    }

    String getDate() {
        return date;
    }

    public int compareTo(Instance point) {
        return this.getDate().compareTo(point.getDate());
    }
}


public class sliding_window {
    int WINDOW_SIZE = 5;
    int PACKET_END = 400;
    int PACKET_START = 0;

    static ArrayList<String[]> csvReader(String filename) throws IOException {
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

        ArrayList<String[]> data = csvReader("edit.csv");

        ArrayList<Instance> points = new ArrayList<Instance>();

        for(String[] row : data) {
            Instance point = new Instance(Integer.parseInt(row[1]),
                                          Integer.parseInt(row[4]),
                                          row[7]);
            points.add(point);
        }

        Collections.sort(points);

        for(Instance point : points) {
            System.out.println(point.getDate());
        }
    }
}
