package saggi.deepak.com.zomatodummyapp.models;

import java.util.HashMap;
import java.util.List;

public class CuisineData {

    private int resultsFound;

    private int resultsStart;

    private int resultsShown;

    private HashMap<String, List<RestaurantData>> restaurants;

    public CuisineData(int resultsFound, int resultsStart, int resultsShown, HashMap<String, List<RestaurantData>> restaurants) {
        this.resultsFound = resultsFound;
        this.resultsStart = resultsStart;
        this.resultsShown = resultsShown;
        this.restaurants = restaurants;
    }

    public int getResultsFound() {
        return resultsFound;
    }

    public void setResultsFound(int resultsFound) {
        this.resultsFound = resultsFound;
    }

    public int getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(int resultsStart) {
        this.resultsStart = resultsStart;
    }

    public int getResultsShown() {
        return resultsShown;
    }

    public void setResultsShown(int resultsShown) {
        this.resultsShown = resultsShown;
    }

    public HashMap<String, List<RestaurantData>> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(HashMap<String, List<RestaurantData>> restaurants) {
        this.restaurants = restaurants;
    }
}
