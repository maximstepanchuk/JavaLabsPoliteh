package manager;

import model.TravelType;
import processor.impl.i_TravelManager;
import model.Travel;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelManager implements i_TravelManager {
    public String nameOfNameManager;
    public static List<Travel> listOfTravel = new ArrayList<>();


    public TravelManager(String nameOfNameManager) {
        this.nameOfNameManager = nameOfNameManager;
    }

    @Override
    public List<Travel> addTravelToTheList(Travel travel) {
        listOfTravel.add(travel);
        return listOfTravel;
    }


    @Override
    public void deleteTravelFromList(Travel travel) {
        listOfTravel.remove(travel);
    }

    @Override
    public List<Travel> sortListByPrice() {
        listOfTravel.sort(Comparator.comparingInt(Travel::getPrice_in_uah));
        return listOfTravel;
    }


    @Override
    public List<Travel> sortListByDuration () {
        Collections.sort(listOfTravel, Comparator.comparingInt(Travel::getDuration_in_days));
        return listOfTravel;
    }

    @Override
    public void printListOfTravel () {
        for (Travel travel : listOfTravel) {
            System.out.println(travel.toString());
        }
    }

    @Override
    public List<Travel> findTravelByType (TravelType travelType) {
        List<Travel> filteredList = listOfTravel.stream()
                .filter(travel -> travel.getType() == travelType).collect(Collectors.toList());
        return filteredList;
    }

    public List<Travel> getListOfTravel() {
        return listOfTravel;
    }




    public static void writeCSV() throws IOException {
        try (FileWriter writer = new FileWriter("result.csv")){

            String previousClassName = "";
            for (var travel: listOfTravel){

                if(!travel.getClass().getSimpleName().equals(previousClassName)){
                    writer.write(travel.getHeaders());
                    writer.write("\r\n");
                    previousClassName = travel.getClass().getSimpleName();
                }

                writer.write(travel.toCSV());
                writer.write("\r\n");


            }
        }
    }


}
