package processor;

import manager.TravelManager;
import model.Country;
import model.Travel;
import model.TravelAgency;
import model.TravelType;
import java.io.IOException;


public class Main extends TravelManager {

    public Main(String nameOfNameManager) {
        super(nameOfNameManager);
    }

    public static void main(String[] args) throws IOException {
        TravelAgency Mirtur = new TravelAgency("BLABLABLA");

        Travel Ukraine = new Travel(Country.Ukraine, 4, TravelType.recreation, true, 15000);
        Travel USA = new Travel(Country.USA, 7, TravelType.sport, false, 75000);
        Travel France = new Travel(Country.France, 3, TravelType.family, true, 30000);
        Travel Spain = new Travel(Country.Spain, 14, TravelType.recreation, true, 800000);
        Travel China = new Travel(Country.China, 7, TravelType.sport, false, 48600);

        TravelManager travelManager = new TravelManager("Boris_Johnsonuk");
        travelManager.addTravelToTheList(USA);
        travelManager.addTravelToTheList(Ukraine);
        travelManager.addTravelToTheList(France);
        travelManager.sortListByPrice();
        travelManager.printListOfTravel();

        travelManager.findTravelByType(TravelType.family);
        travelManager.findTravelByType(TravelType.sport);

        writeCSV();
    }
}

