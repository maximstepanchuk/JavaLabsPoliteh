import manager.TravelManager;
import model.Country;
import model.Travel;
import model.TravelType;
import org.junit.*;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;


public class TravelManagerTest {

    private final Travel Ukraine = new Travel(Country.Ukraine, 4, TravelType.recreation, true, 2);
    private final Travel USA = new Travel(Country.USA, 2, TravelType.sport, false, 3);
    private final Travel France = new Travel(Country.France, 3, TravelType.family, true, 1);
    private final Travel Spain = new Travel(Country.Spain, 14, TravelType.recreation, true, 5);
    private final Travel China = new Travel(Country.China, 7, TravelType.sport, false, 4);
    private final Travel[] sortedTravel = {France, Ukraine, USA, China, Spain};
    private final Travel[] sortedTravelByDuration = {USA, France, Ukraine,  China, Spain};
    private TravelManager travelManager = new TravelManager("BOB");

    @Before
    public void setUp() {
        travelManager.addTravelToTheList(USA);
        travelManager.addTravelToTheList(Ukraine);
        travelManager.addTravelToTheList(France);
        travelManager.addTravelToTheList(Spain);
        travelManager.addTravelToTheList(China);
    }

    @Test
    public void sortListByPrice() {
        assertArrayEquals(sortedTravel, travelManager.sortListByPrice().toArray());
    }

    @Test
    public void sortListByDuration(){assertArrayEquals(sortedTravelByDuration, travelManager.sortListByDuration().toArray());}

    @Test
    public void addTravelToTheList() {
        Travel[] travel = {USA,Ukraine, France, Spain, China};
        assertArrayEquals(travel, travelManager.getListOfTravel().toArray());
    }

    @Test
    public void deleteTravelFromList(){
        Travel[] travel = {USA,Ukraine, France, Spain};
        travelManager.deleteTravelFromList(China);
        assertArrayEquals(travel, travelManager.getListOfTravel().toArray());
    }

    @Test
    public void findTravelByType(){
        Travel[] travel = {USA, China};
        travelManager.findTravelByType(TravelType.sport);
        assertArrayEquals(travel, travelManager.findTravelByType(TravelType.sport).toArray());
    }



}