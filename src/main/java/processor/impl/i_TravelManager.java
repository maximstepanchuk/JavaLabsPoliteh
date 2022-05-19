package processor.impl;
import model.Travel;
import model.TravelType;

import java.util.ArrayList;
import java.util.List;

public interface i_TravelManager  {
    List<Travel> addTravelToTheList(Travel travel);
    void deleteTravelFromList(Travel travel);
    List<Travel> sortListByPrice();
    List<Travel> sortListByDuration();
    void  printListOfTravel();
    List<Travel >findTravelByType(TravelType travelType);
    ArrayList<String> getNewText();
}

