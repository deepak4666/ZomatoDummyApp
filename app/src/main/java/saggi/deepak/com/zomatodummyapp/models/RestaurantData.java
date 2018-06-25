package saggi.deepak.com.zomatodummyapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class RestaurantData implements Parcelable {

    public final static Parcelable.Creator<RestaurantData> CREATOR = new Creator<RestaurantData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RestaurantData createFromParcel(Parcel in) {
            return new RestaurantData(in);
        }

        public RestaurantData[] newArray(int size) {
            return (new RestaurantData[size]);
        }

    };
    @SerializedName("R")
    @Expose
    private R r;
    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("switch_to_order_menu")
    @Expose
    private int switchToOrderMenu;
    @SerializedName("cuisines")
    @Expose
    private String cuisines;
    @SerializedName("average_cost_for_two")
    @Expose
    private int averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    private int priceRange;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("offers")
    @Expose
    private List<String> offers = null;
    @SerializedName("opentable_support")
    @Expose
    private int opentableSupport;
    @SerializedName("is_zomato_book_res")
    @Expose
    private int isZomatoBookRes;
    @SerializedName("mezzo_provider")
    @Expose
    private String mezzoProvider;
    @SerializedName("is_book_form_web_view")
    @Expose
    private int isBookFormWebView;
    @SerializedName("book_form_web_view_url")
    @Expose
    private String bookFormWebViewUrl;
    @SerializedName("book_again_url")
    @Expose
    private String bookAgainUrl;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("user_rating")
    @Expose
    private UserRating userRating;
    @SerializedName("photos_url")
    @Expose
    private String photosUrl;
    @SerializedName("menu_url")
    @Expose
    private String menuUrl;
    @SerializedName("featured_image")
    @Expose
    private String featuredImage;
    @SerializedName("has_online_delivery")
    @Expose
    private int hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    @Expose
    private int isDeliveringNow;
    @SerializedName("include_bogo_offers")
    @Expose
    private boolean includeBogoOffers;
    @SerializedName("deeplink")
    @Expose
    private String deeplink;
    @SerializedName("is_table_reservation_supported")
    @Expose
    private int isTableReservationSupported;
    @SerializedName("has_table_booking")
    @Expose
    private int hasTableBooking;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("establishment_types")
    @Expose
    private List<String> establishmentTypes = null;
    @SerializedName("order_url")
    @Expose
    private String orderUrl;
    @SerializedName("order_deeplink")
    @Expose
    private String orderDeeplink;

    protected RestaurantData(Parcel in) {
        this.r = ((R) in.readValue((R.class.getClassLoader())));
        this.apikey = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.switchToOrderMenu = ((int) in.readValue((int.class.getClassLoader())));
        this.cuisines = ((String) in.readValue((String.class.getClassLoader())));
        this.averageCostForTwo = ((int) in.readValue((int.class.getClassLoader())));
        this.priceRange = ((int) in.readValue((int.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.offers, (String.class.getClassLoader()));
        this.opentableSupport = ((int) in.readValue((int.class.getClassLoader())));
        this.isZomatoBookRes = ((int) in.readValue((int.class.getClassLoader())));
        this.mezzoProvider = ((String) in.readValue((String.class.getClassLoader())));
        this.isBookFormWebView = ((int) in.readValue((int.class.getClassLoader())));
        this.bookFormWebViewUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.bookAgainUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.thumb = ((String) in.readValue((String.class.getClassLoader())));
        this.userRating = ((UserRating) in.readValue((UserRating.class.getClassLoader())));
        this.photosUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.menuUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.featuredImage = ((String) in.readValue((String.class.getClassLoader())));
        this.hasOnlineDelivery = ((int) in.readValue((int.class.getClassLoader())));
        this.isDeliveringNow = ((int) in.readValue((int.class.getClassLoader())));
        this.includeBogoOffers = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.deeplink = ((String) in.readValue((String.class.getClassLoader())));
        this.isTableReservationSupported = ((int) in.readValue((int.class.getClassLoader())));
        this.hasTableBooking = ((int) in.readValue((int.class.getClassLoader())));
        this.eventsUrl = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.establishmentTypes, (String.class.getClassLoader()));
        this.orderUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.orderDeeplink = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public RestaurantData() {
    }

    /**
     * @param mezzoProvider
     * @param eventsUrl
     * @param location
     * @param userRating
     * @param hasOnlineDelivery
     * @param orderDeeplink
     * @param includeBogoOffers
     * @param isDeliveringNow
     * @param isTableReservationSupported
     * @param currency
     * @param apikey
     * @param id
     * @param isBookFormWebView
     * @param name
     * @param cuisines
     * @param hasTableBooking
     * @param orderUrl
     * @param offers
     * @param bookAgainUrl
     * @param switchToOrderMenu
     * @param url
     * @param averageCostForTwo
     * @param priceRange
     * @param isZomatoBookRes
     * @param r
     * @param opentableSupport
     * @param photosUrl
     * @param menuUrl
     * @param deeplink
     * @param bookFormWebViewUrl
     * @param establishmentTypes
     * @param thumb
     * @param featuredImage
     */
    public RestaurantData(R r, String apikey, String id, String name, String url, Location location, int switchToOrderMenu, String cuisines, int averageCostForTwo, int priceRange, String currency, List<String> offers, int opentableSupport, int isZomatoBookRes, String mezzoProvider, int isBookFormWebView, String bookFormWebViewUrl, String bookAgainUrl, String thumb, UserRating userRating, String photosUrl, String menuUrl, String featuredImage, int hasOnlineDelivery, int isDeliveringNow, boolean includeBogoOffers, String deeplink, int isTableReservationSupported, int hasTableBooking, String eventsUrl, List<String> establishmentTypes, String orderUrl, String orderDeeplink) {
        super();
        this.r = r;
        this.apikey = apikey;
        this.id = id;
        this.name = name;
        this.url = url;
        this.location = location;
        this.switchToOrderMenu = switchToOrderMenu;
        this.cuisines = cuisines;
        this.averageCostForTwo = averageCostForTwo;
        this.priceRange = priceRange;
        this.currency = currency;
        this.offers = offers;
        this.opentableSupport = opentableSupport;
        this.isZomatoBookRes = isZomatoBookRes;
        this.mezzoProvider = mezzoProvider;
        this.isBookFormWebView = isBookFormWebView;
        this.bookFormWebViewUrl = bookFormWebViewUrl;
        this.bookAgainUrl = bookAgainUrl;
        this.thumb = thumb;
        this.userRating = userRating;
        this.photosUrl = photosUrl;
        this.menuUrl = menuUrl;
        this.featuredImage = featuredImage;
        this.hasOnlineDelivery = hasOnlineDelivery;
        this.isDeliveringNow = isDeliveringNow;
        this.includeBogoOffers = includeBogoOffers;
        this.deeplink = deeplink;
        this.isTableReservationSupported = isTableReservationSupported;
        this.hasTableBooking = hasTableBooking;
        this.eventsUrl = eventsUrl;
        this.establishmentTypes = establishmentTypes;
        this.orderUrl = orderUrl;
        this.orderDeeplink = orderDeeplink;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getSwitchToOrderMenu() {
        return switchToOrderMenu;
    }

    public void setSwitchToOrderMenu(int switchToOrderMenu) {
        this.switchToOrderMenu = switchToOrderMenu;
    }

    public List<String> getCuisines() {
        return Arrays.asList(cuisines.split(", "));
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public boolean containCuisine(String cousine) {
        return getCuisines().contains(cousine);
    }

    public int getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public void setAverageCostForTwo(int averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getOffers() {
        return offers;
    }

    public void setOffers(List<String> offers) {
        this.offers = offers;
    }

    public int getOpentableSupport() {
        return opentableSupport;
    }

    public void setOpentableSupport(int opentableSupport) {
        this.opentableSupport = opentableSupport;
    }

    public int getIsZomatoBookRes() {
        return isZomatoBookRes;
    }

    public void setIsZomatoBookRes(int isZomatoBookRes) {
        this.isZomatoBookRes = isZomatoBookRes;
    }

    public String getMezzoProvider() {
        return mezzoProvider;
    }

    public void setMezzoProvider(String mezzoProvider) {
        this.mezzoProvider = mezzoProvider;
    }

    public int getIsBookFormWebView() {
        return isBookFormWebView;
    }

    public void setIsBookFormWebView(int isBookFormWebView) {
        this.isBookFormWebView = isBookFormWebView;
    }

    public String getBookFormWebViewUrl() {
        return bookFormWebViewUrl;
    }

    public void setBookFormWebViewUrl(String bookFormWebViewUrl) {
        this.bookFormWebViewUrl = bookFormWebViewUrl;
    }

    public String getBookAgainUrl() {
        return bookAgainUrl;
    }

    public void setBookAgainUrl(String bookAgainUrl) {
        this.bookAgainUrl = bookAgainUrl;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    public int getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public void setHasOnlineDelivery(int hasOnlineDelivery) {
        this.hasOnlineDelivery = hasOnlineDelivery;
    }

    public int getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public void setIsDeliveringNow(int isDeliveringNow) {
        this.isDeliveringNow = isDeliveringNow;
    }

    public boolean isIncludeBogoOffers() {
        return includeBogoOffers;
    }

    public void setIncludeBogoOffers(boolean includeBogoOffers) {
        this.includeBogoOffers = includeBogoOffers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public int getIsTableReservationSupported() {
        return isTableReservationSupported;
    }

    public void setIsTableReservationSupported(int isTableReservationSupported) {
        this.isTableReservationSupported = isTableReservationSupported;
    }

    public int getHasTableBooking() {
        return hasTableBooking;
    }

    public void setHasTableBooking(int hasTableBooking) {
        this.hasTableBooking = hasTableBooking;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public List<String> getEstablishmentTypes() {
        return establishmentTypes;
    }

    public void setEstablishmentTypes(List<String> establishmentTypes) {
        this.establishmentTypes = establishmentTypes;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getOrderDeeplink() {
        return orderDeeplink;
    }

    public void setOrderDeeplink(String orderDeeplink) {
        this.orderDeeplink = orderDeeplink;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(r);
        dest.writeValue(apikey);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(url);
        dest.writeValue(location);
        dest.writeValue(switchToOrderMenu);
        dest.writeValue(cuisines);
        dest.writeValue(averageCostForTwo);
        dest.writeValue(priceRange);
        dest.writeValue(currency);
        dest.writeList(offers);
        dest.writeValue(opentableSupport);
        dest.writeValue(isZomatoBookRes);
        dest.writeValue(mezzoProvider);
        dest.writeValue(isBookFormWebView);
        dest.writeValue(bookFormWebViewUrl);
        dest.writeValue(bookAgainUrl);
        dest.writeValue(thumb);
        dest.writeValue(userRating);
        dest.writeValue(photosUrl);
        dest.writeValue(menuUrl);
        dest.writeValue(featuredImage);
        dest.writeValue(hasOnlineDelivery);
        dest.writeValue(isDeliveringNow);
        dest.writeValue(includeBogoOffers);
        dest.writeValue(deeplink);
        dest.writeValue(isTableReservationSupported);
        dest.writeValue(hasTableBooking);
        dest.writeValue(eventsUrl);
        dest.writeList(establishmentTypes);
        dest.writeValue(orderUrl);
        dest.writeValue(orderDeeplink);
    }

    public int describeContents() {
        return 0;
    }

    public static class R implements Parcelable {

        public final static Parcelable.Creator<R> CREATOR = new Creator<R>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public R createFromParcel(Parcel in) {
                return new R(in);
            }

            public R[] newArray(int size) {
                return (new R[size]);
            }

        };
        @SerializedName("res_id")
        @Expose
        private int resId;

        protected R(Parcel in) {
            this.resId = ((int) in.readValue((int.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public R() {
        }

        /**
         * @param resId
         */
        public R(int resId) {
            super();
            this.resId = resId;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(resId);
        }

        public int describeContents() {
            return 0;
        }

    }


    public static class Location implements Parcelable {

        public final static Parcelable.Creator<Location> CREATOR = new Creator<Location>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Location createFromParcel(Parcel in) {
                return new Location(in);
            }

            public Location[] newArray(int size) {
                return (new Location[size]);
            }

        };
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("locality")
        @Expose
        private String locality;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("city_id")
        @Expose
        private int cityId;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("zipcode")
        @Expose
        private String zipcode;
        @SerializedName("country_id")
        @Expose
        private int countryId;
        @SerializedName("locality_verbose")
        @Expose
        private String localityVerbose;

        protected Location(Parcel in) {
            this.address = ((String) in.readValue((String.class.getClassLoader())));
            this.locality = ((String) in.readValue((String.class.getClassLoader())));
            this.city = ((String) in.readValue((String.class.getClassLoader())));
            this.cityId = ((int) in.readValue((int.class.getClassLoader())));
            this.latitude = ((String) in.readValue((String.class.getClassLoader())));
            this.longitude = ((String) in.readValue((String.class.getClassLoader())));
            this.zipcode = ((String) in.readValue((String.class.getClassLoader())));
            this.countryId = ((int) in.readValue((int.class.getClassLoader())));
            this.localityVerbose = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public Location() {
        }

        /**
         * @param countryId
         * @param cityId
         * @param address
         * @param zipcode
         * @param locality
         * @param longitude
         * @param localityVerbose
         * @param latitude
         * @param city
         */
        public Location(String address, String locality, String city, int cityId, String latitude, String longitude, String zipcode, int countryId, String localityVerbose) {
            super();
            this.address = address;
            this.locality = locality;
            this.city = city;
            this.cityId = cityId;
            this.latitude = latitude;
            this.longitude = longitude;
            this.zipcode = zipcode;
            this.countryId = countryId;
            this.localityVerbose = localityVerbose;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLocality() {
            return locality;
        }

        public void setLocality(String locality) {
            this.locality = locality;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public int getCountryId() {
            return countryId;
        }

        public void setCountryId(int countryId) {
            this.countryId = countryId;
        }

        public String getLocalityVerbose() {
            return localityVerbose;
        }

        public void setLocalityVerbose(String localityVerbose) {
            this.localityVerbose = localityVerbose;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(address);
            dest.writeValue(locality);
            dest.writeValue(city);
            dest.writeValue(cityId);
            dest.writeValue(latitude);
            dest.writeValue(longitude);
            dest.writeValue(zipcode);
            dest.writeValue(countryId);
            dest.writeValue(localityVerbose);
        }

        public int describeContents() {
            return 0;
        }

    }

    public static class UserRating implements Parcelable {

        public final static Parcelable.Creator<UserRating> CREATOR = new Creator<UserRating>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public UserRating createFromParcel(Parcel in) {
                return new UserRating(in);
            }

            public UserRating[] newArray(int size) {
                return (new UserRating[size]);
            }

        };
        @SerializedName("aggregate_rating")
        @Expose
        private String aggregateRating;
        @SerializedName("rating_text")
        @Expose
        private String ratingText;
        @SerializedName("rating_color")
        @Expose
        private String ratingColor;
        @SerializedName("votes")
        @Expose
        private String votes;

        protected UserRating(Parcel in) {
            this.aggregateRating = ((String) in.readValue((String.class.getClassLoader())));
            this.ratingText = ((String) in.readValue((String.class.getClassLoader())));
            this.ratingColor = ((String) in.readValue((String.class.getClassLoader())));
            this.votes = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public UserRating() {
        }

        /**
         * @param ratingColor
         * @param votes
         * @param aggregateRating
         * @param ratingText
         */
        public UserRating(String aggregateRating, String ratingText, String ratingColor, String votes) {
            super();
            this.aggregateRating = aggregateRating;
            this.ratingText = ratingText;
            this.ratingColor = ratingColor;
            this.votes = votes;
        }

        public String getAggregateRating() {
            return aggregateRating;
        }

        public void setAggregateRating(String aggregateRating) {
            this.aggregateRating = aggregateRating;
        }

        public String getRatingText() {
            return ratingText;
        }

        public void setRatingText(String ratingText) {
            this.ratingText = ratingText;
        }

        public String getRatingColor() {
            return ratingColor;
        }

        public void setRatingColor(String ratingColor) {
            this.ratingColor = ratingColor;
        }

        public String getVotes() {
            return votes;
        }

        public void setVotes(String votes) {
            this.votes = votes;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(aggregateRating);
            dest.writeValue(ratingText);
            dest.writeValue(ratingColor);
            dest.writeValue(votes);
        }

        public int describeContents() {
            return 0;
        }

    }


}