package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Family extends model.Tour {

    private int familyNumber;

    private List<String> hotels = new ArrayList<String>();

    private int star;

    private boolean nightCrossings;

    private String nameOfAccommodation;

    public Family(String agent, String operator, String name, String guide, Date startDate, Date endDate, int basePrice,
                  int familyNumber, List<String> hotels, int star, boolean nightCrossings, String nameOfAccommodation) {
        super(agent, operator, name, guide, startDate, endDate, basePrice);
        this.familyNumber = familyNumber;
        this.hotels = hotels;
        this.star = star;
        this.nightCrossings = nightCrossings;
        this.nameOfAccommodation = nameOfAccommodation;

    }

    //public Family(String agent, String operator, String name, String guide, Date startDate, Date endDate) {
    //super(agent, operator, name, guide, startDate, endDate);
    //this.familyNumber = fa
    //}

    public int getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(int familyNumber) {
        this.familyNumber = familyNumber;
    }

    public void addHotel(String hotelName) {
        hotels.add(hotelName);
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public boolean isNightCrossings() {
        return nightCrossings;
    }

    public void setNightCrossings(boolean nightCrossings) {
        this.nightCrossings = nightCrossings;
    }

    public String getNameOfAccommodation() {
        return nameOfAccommodation;
    }

    public void setNameOfAccommodation(String nameOfAccommodation) {
        this.nameOfAccommodation = nameOfAccommodation;
    }


    @Override
    public String toString() {
        return super.toString() +
                "familyNumber = " + familyNumber +
                ", hotels = " + hotels +
                ", star = " + star +
                ", nightCrossings = " + nightCrossings +
                ", nameOfAccommodation = " + nameOfAccommodation + " "
                ;
    }

    public static String getHeaders() {
        return Tour.getHeaders() + "familyNumber, hotels, star, nightCrossings, nameOfAccommodation";
    }

    public String toSCV() {
        return super.toSCV() + "," + familyNumber + "," + hotels + "," + star + "," + nightCrossings + "," + nameOfAccommodation;
    }
}
