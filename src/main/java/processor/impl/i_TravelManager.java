package processor.impl;
import model.Travel;
import model.TravelType;

public interface i_TravelManager  {
    void addTravelToTheList(Travel travel);


    void deleteTravelFromList(Travel travel);
    void sortListByPrice();
    void sortListByDuration();
    void  printListOfTravel();
    void findTravelByType(TravelType travelType);
}

