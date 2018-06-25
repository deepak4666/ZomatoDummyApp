package saggi.deepak.com.zomatodummyapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData implements Parcelable
{

    @SerializedName("results_found")
    @Expose
    private int resultsFound;
    @SerializedName("results_start")
    @Expose
    private int resultsStart;
    @SerializedName("results_shown")
    @Expose
    private int resultsShown;
    @SerializedName("restaurants")
    @Expose
    private List<Restaurant> restaurants = null;
    public final static Parcelable.Creator<ResponseData> CREATOR = new Creator<ResponseData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResponseData createFromParcel(Parcel in) {
            return new ResponseData(in);
        }

        public ResponseData[] newArray(int size) {
            return (new ResponseData[size]);
        }

    }
            ;

    protected ResponseData(Parcel in) {
        this.resultsFound = ((int) in.readValue((int.class.getClassLoader())));
        this.resultsStart = ((int) in.readValue((int.class.getClassLoader())));
        this.resultsShown = ((int) in.readValue((int.class.getClassLoader())));
        in.readList(this.restaurants, (saggi.deepak.com.zomatodummyapp.models.Restaurant.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseData() {
    }

    /**
     *
     * @param resultsShown
     * @param resultsFound
     * @param resultsStart
     * @param restaurants
     */
    public ResponseData(int resultsFound, int resultsStart, int resultsShown, List<Restaurant> restaurants) {
        super();
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

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(resultsFound);
        dest.writeValue(resultsStart);
        dest.writeValue(resultsShown);
        dest.writeList(restaurants);
    }

    public int describeContents() {
        return 0;
    }

}