package manager;

import model.Family;
import model.Tour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TourAgencyManager {


    private List<Tour> tours;

    public class InnerComparator implements Comparator<Tour> {

        @Override
        public int compare(Tour o1, Tour o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class InnerComparatorStatic implements Comparator<Tour>{

        @Override
        public int compare(Tour o1, Tour o2) {
            return o1.getAgent().compareTo(o2.getAgent());
        }
    }

    private Comparator<Tour> comparatorByName = new ComparatorByName();
    private Comparator<Tour> comparatorByPrice = new CompareByPrice();

    public List<Tour> getTours() {
        return tours;
    }

    public TourAgencyManager() {

        tours = new ArrayList<Tour>();
    }

    public void setTours() {

        this.tours = new ArrayList<Tour>();
    }

    public void add(Tour tour) {

        this.tours.add(tour);
    }

    public void remove(Tour tour) {
        this.tours.remove(tour);
    }

    public void sortByName() {

        tours.sort(comparatorByName);
    }

    public void sortByPrice() {
        tours.sort(comparatorByPrice);

    }
//anonymos inner class sorting with comparator
    public void sortByOperator () {

        Collections.sort(tours, new Comparator<Tour>() {
            @Override
            public int compare(Tour t1, Tour t2) {
                return t1.getOperator().compareTo(t2.getOperator());
            }
        });
    }
    // inner class
    public void sortByName1(){
        tours.sort(new InnerComparator());
    }
// static inner class
    public void sortByAgent(){
        tours.sort(new TourAgencyManager.InnerComparatorStatic());
    }

    public void sortByOperatorLambda () {

        Collections.sort(tours, ( t1, t2 ) -> t1.getOperator().compareTo(t2.getOperator()));
    }

    public void sortByBasePrise() {

        Collections.sort(tours, ( t1, t2 ) -> t1.getBasePrice()<t2.getBasePrice() ? -1:t1.getBasePrice()==t2.getBasePrice() ? 0:1);
        Collections.reverse(tours);
    }


    @Override
    public String toString() {
        String s = "";
        for (Tour t : tours)

             s+=t.toString()+"\n";


        return s;
    }

    public void show() {
        for (Tour t : tours) {
            System.out.println(t);

        }
    }

    public List<Tour> findFamilyTour() {
        List<Tour> result = new ArrayList<Tour>();
        for (Tour t:tours) {
            if(t instanceof Family)
                result.add(t);
        }
        return result;
    }

    public void writeToSCV (TourWriter tw, String fileName) throws IOException {
        TourWriter.writeToFile(tours, "fileName");
    }




}
