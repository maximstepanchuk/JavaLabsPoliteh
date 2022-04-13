package manager;

import model.TravelType;
import processor.impl.i_TravelManager;
import model.Travel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelManager implements i_TravelManager {
    public String nameOfNameManager;
    private List<Travel> listOfTravel = new ArrayList<>();


    public TravelManager(String nameOfNameManager) {
        this.nameOfNameManager = nameOfNameManager;
    }

    @Override
    public void addTravelToTheList(Travel travel) {
        listOfTravel.add(travel);
    }


    @Override
    public void deleteTravelFromList(Travel travel) {
        listOfTravel.remove(travel);
    }

    @Override
    public void sortListByPrice() {
        Collections.sort(listOfTravel, new Comparator<Travel>() {
            @Override
            public int compare(Travel t1, Travel t2) {
                return t1.getPrice_in_uah() - t2.getPrice_in_uah();
            }
        });
    }


    @Override
    public void sortListByDuration () {
        Collections.sort(listOfTravel, new Comparator<Travel>() {
            @Override
            public int compare(Travel t1, Travel t2) {
                return t1.getDuration_in_days() - t2.getDuration_in_days();
            }
        });
    }

    @Override
    public void printListOfTravel () {
        for (Travel travel : listOfTravel) {
            System.out.println(travel.toString());
        }
    }

    @Override
    public void findTravelByType (TravelType travelType) {
        List<Travel> filteredList = listOfTravel.stream()
                .filter(travel -> travel.getType() == travelType).collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
