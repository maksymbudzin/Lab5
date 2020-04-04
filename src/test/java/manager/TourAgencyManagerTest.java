package manager;

import model.Family;
import model.Tour;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TourAgencyManagerTest {

    @Test
    void add() throws ParseException {


        TourAgencyManager tourAgencyManager = new TourAgencyManager();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());
        Date startDate = format.parse("2009-12-31");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString1 = format1.format(new Date());
        Date endDate = format1.parse("2019-01-12");
        tourAgencyManager.add(new Tour("Journey", "Ryainair", "Operatorname", "GuideParis",
                startDate, endDate, 10000));
        tourAgencyManager.add(new Tour("Abc", "AccordTour", "Maksym", "GuideDubai",
                startDate, endDate, 5000));
        tourAgencyManager.add(new Tour("UkraineJourney", "Ryainair", "UkraineTrip",
                "GuideParis", startDate, endDate, 9500));

        tourAgencyManager.sortByName();
        String expected = "NAME : Maksym OPERATOR: AccordTour AGENT: Abc GUIDE: GuideDubai STARTDATE: Thu Dec 31 00:00:00 EET 2009 ENDDATE:Sat Jan 12 00:00:00 EET 2019 PRICE :5000 \n" +
                "NAME : Operatorname OPERATOR: Ryainair AGENT: Journey GUIDE: GuideParis STARTDATE: Thu Dec 31 00:00:00 EET 2009 ENDDATE:Sat Jan 12 00:00:00 EET 2019 PRICE :10000 \n" +
                "NAME : UkraineTrip OPERATOR: Ryainair AGENT: UkraineJourney GUIDE: GuideParis STARTDATE: Thu Dec 31 00:00:00 EET 2009 ENDDATE:Sat Jan 12 00:00:00 EET 2019 PRICE :9500 \n";
        String actual = tourAgencyManager.toString();
        assertEquals(expected, actual);

    }


    @Test
    void findFamilyTour() throws ParseException {

        TourAgencyManager tourAgencyManager = new TourAgencyManager();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(new Date());
        Date startDate = format.parse("2009-12-31");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString1 = format1.format(new Date());
        Date endDate = format1.parse("2019-01-12");
        tourAgencyManager.add(new Tour("Journey", "Ryainair", "Operatorname", "GuideParis",
                startDate, endDate, 10000));
        tourAgencyManager.add(new Tour("Abc", "AccordTour", "Maksym", "GuideDubai",
                startDate, endDate, 5000));
        tourAgencyManager.add(new Family("Abc", "AccordTour", "Roman", "GuideDubai",
                startDate, endDate, 4700, 5,
                Arrays.asList("Radison", "grandHotel"), 5, false, "hotel"));
        tourAgencyManager.add(new Tour("UkraineJourney", "Ryainair", "UkraineTrip",
                "GuideParis", startDate, endDate, 9500));

        List<Tour> actual1 = tourAgencyManager.findFamilyTour();
        String actual = "";
        for (Tour t : actual1
        ) {
            actual += t.toString() + "\n";
        }
        List<Tour> expected1 = new ArrayList<Tour>();
        expected1.add(new Family("Abc", "AccordTour", "Roman", "GuideDubai",
                startDate, endDate, 4700, 5,
                Arrays.asList("Radison", "grandHotel"), 5, false, "hotel"));
        String expected = "";
        for (Tour t : expected1
        ) {
            expected += t.toString() + "\n";
        }
        assertEquals(expected, actual);


    }




}