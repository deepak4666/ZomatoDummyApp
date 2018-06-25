package saggi.deepak.com.zomatodummyapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant implements Parcelable
{

    @SerializedName("restaurant")
    @Expose
    private RestaurantData restaurant;
    public final static Parcelable.Creator<Restaurant> CREATOR = new Creator<Restaurant>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        public Restaurant[] newArray(int size) {
            return (new Restaurant[size]);
        }

    }
            ;

    protected Restaurant(Parcel in) {
        this.restaurant = ((RestaurantData) in.readValue((RestaurantData.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Restaurant() {
    }

    /**
     *
     * @param restaurant
     */
    public Restaurant(RestaurantData restaurant) {
        super();
        this.restaurant = restaurant;
    }

    public RestaurantData getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantData restaurant) {
        this.restaurant = restaurant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(restaurant);
    }

    public int describeContents() {
        return 0;
    }

}


