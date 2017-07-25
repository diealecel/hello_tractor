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
    static final String CSV_FILE = "edit.csv";
    final int WINDOW_SIZE = 5;
    final int PACKET_END = 400;
    final int PACKET_START = 0;

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


    static ArrayList<Instance> createPoints(String filename) throws IOException {
        ArrayList<String[]> data = csvReader(filename);
        ArrayList<Instance> points = new ArrayList<Instance>();

        for(String[] row : data) {
            Instance point = new Instance(Integer.parseInt(row[1]),
                                          Integer.parseInt(row[4]),
                                          row[7]);
            points.add(point);
        }

        Collections.sort(points);

        return points;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<Instance> points = createPoints(CSV_FILE);
    }
}
