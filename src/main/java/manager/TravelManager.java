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
    public  List<Travel> listOfTravel = new ArrayList<>();
    public static List<String> newText = new ArrayList<>();

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
        listOfTravel.sort(Comparator.comparingInt(Travel::getPriceInUah));
        return listOfTravel;
    }


    @Override
    public List<Travel> sortListByDuration () {
        Collections.sort(listOfTravel, Comparator.comparingInt(Travel::getDurationInDays));
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

    @Override
    public List<String> getNewText() {
        regexPlanet();
        return newText;
    }

    public List<Travel> getListOfTravel() {
        return listOfTravel;
    }




    public void writeCSV() throws IOException {
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

    public static List<String> regexPlanet(){
        String [] text = {"b12345b", "aa1234c", "AC4714EX", "bas1-2-3-4-5bas", "blasdA12-12Asbdf", "ABSdfda12-47-56basdA"};
        String regex = "([a-zA-Z]{1,}\\d{1,4}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{1}-\\d{1}-\\d{1}-\\d{1}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{1}-\\d{1}-\\d{1}[a-zA-Z]{1,})|([a-zA-Z]\\d{1}-\\d{1}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{2}-\\d{1}-\\d{1}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{1}-\\d{2}-\\d{1}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{1}-\\d{1}-\\d{2}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{1}-\\d{2}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{2}-\\d{1}[a-zA-Z]{1,})|([a-zA-Z]{1,}\\d{2}-\\d{2}[a-zA-Z]{1,})";
        for (String temp : text){
            if (!temp.matches(regex)){
                newText.add(temp);
            }
        }
        System.out.println(newText);
        return newText;
    }


}
