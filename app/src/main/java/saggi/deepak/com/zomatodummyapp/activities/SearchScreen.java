package saggi.deepak.com.zomatodummyapp.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.HashMap;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import saggi.deepak.com.zomatodummyapp.R;
import saggi.deepak.com.zomatodummyapp.adapters.RestaurantListAdapter;
import saggi.deepak.com.zomatodummyapp.api.SearchResturant;
import saggi.deepak.com.zomatodummyapp.base.BaseActivity;
import saggi.deepak.com.zomatodummyapp.commons.NetworkUtil;
import saggi.deepak.com.zomatodummyapp.models.CuisineData;

public class SearchScreen extends BaseActivity implements SearchView.OnQueryTextListener {

    private long start = 0;
    private String query = "";
    private ExpandableListView expandableListView;
    private RestaurantListAdapter adapter;

    public SearchScreen() {
        mLayoutId = R.layout.search_screen;
    }

    @Override
    protected void setUpUi(Bundle savedInstanceState) {
        expandableListView = findViewById(R.id.exListview);
        expandableListView.setSmoothScrollbarEnabled(true);

    }


    @Override
    protected void loadData(Bundle savedInstanceState) {
        adapter = new RestaurantListAdapter(this, new HashMap<>());
        expandableListView.setAdapter(adapter);
        expandableListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (!query.isEmpty() && ((firstVisibleItem + visibleItemCount + 1) > totalItemCount) && start != 0) {
                    searchResurants(false);
                    expandableListView.smoothScrollToPosition(firstVisibleItem);

                }
            }
        });
    }


    private void searchResurants(Boolean isNewSearch) {
        if (isNewSearch) {
            start = 0;
        }

        if (!NetworkUtil.newInstance().hasInternetConnection(SearchScreen.this)) {
            showSnackbar("No Internet Connection", false);
            return;
        }
        if (isNewSearch) {
            showpDialog(getString(R.string.getting_data));
        }
        new SearchResturant(SearchScreen.this, query, (int) start, 20, "cost", "asc")
                .request()
                .subscribe(new SingleObserver<CuisineData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(CuisineData cuisineData) {
                        hidepDialog();

                        if (cuisineData.getResultsStart() < cuisineData.getResultsFound()) {
                            if (cuisineData.getRestaurants().size() > 0) {

                                adapter.addData(cuisineData.getRestaurants());
                                adapter.notifyDataSetChanged();
                                start = cuisineData.getResultsStart() + cuisineData.getResultsShown();
                            } else {
                                start = 0;
                            }
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        hidepDialog();
                        showSnackbar(e.getMessage(), false);
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String text) {
        query = text;
        searchResurants(true);
        return false;
    }

    protected void showSnackbar(String msg, boolean success) {
        View container = findViewById(R.id.search_container);
        if (container != null) {
            Snackbar snackbar = Snackbar.make(container, msg, Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.text_primary_light));
            View sbView = snackbar.getView();
            if (success) {
                sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.green_active));
            } else {
                sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.card_red));
            }
            TextView textView = sbView
                    .findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(ContextCompat.getColor(this, R.color.text_primary_light));
            snackbar.show();
        }
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
