package manager;

import model.Tour;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
 
class TourWriterTest {




    @Test
    public void readFile() throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format(new Date());
        Date startDate = format.parse("2009-12-31");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString1 = format1.format(new Date());
        Date endDate = format1.parse("2019-01-12");
        String input = "List.csv";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        TourAgencyManager tourAgencyManager = new TourAgencyManager();

        tourAgencyManager.add(new Tour( "Journey", "Ryainair", "Operatorname", "GuideParis",
                startDate , endDate,1000));
         tourAgencyManager.add(new Tour( "Journey", "Ryainair", "Operatorname", "GuideParis",
                 startDate , endDate,1000));
         tourAgencyManager.add(new Tour("UkraineJourney", "Ryainair", "UkraineTrip",
                 "GuideParis", startDate, endDate, 9500));
        tourAgencyManager.add(new Tour("Abc", "AccordTour", "Roman", "GuideDubai",
                startDate, endDate, 4700));
        tourAgencyManager.add(new Tour("SportTour", "Ryainair", "SportOperator", "GuideParis",
                startDate, endDate, 10000));
    }

    @Test
    void writeToFile() throws ParseException, IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format(new Date());
        Date startDate = format.parse("2009-12-31");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString1 = format1.format(new Date());
        Date endDate = format1.parse("2019-01-12");
        TourAgencyManager tourAgencyManager = new TourAgencyManager();
        List<Tour> tours = new ArrayList<Tour>();
         tourAgencyManager.add(new Tour( "Journey", "Ryainair", "Operatorname", "GuideParis",
                 startDate , endDate,1000));
        tourAgencyManager.add(new Tour( "UkraineJourney", "Ryainair", "UkraineTrip",
                "GuideParis", startDate, endDate, 9500));
        tourAgencyManager.add(new Tour( "SportTour", "Ryainair", "SportOperator", "GuideParis",
                startDate, endDate, 10000));
        tourAgencyManager.add(new Tour( "Abc", "AccordTour", "Roman", "GuideDubai",
                startDate, endDate, 4700));
        TourWriter.writeToFile(tours, "fileName");
    }

}