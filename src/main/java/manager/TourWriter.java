package manager;

import model.Tour;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TourWriter {


    public static void writeToFile(List<Tour> tours, String fileName) throws IOException {

        FileWriter writer = new FileWriter(fileName);
        writer.write(Tour.getHeaders());

        for (Tour tour : tours) {
            writer.write(tour.toSCV());
        }
        writer.close();
    }



}
