package saggi.deepak.com.zomatodummyapp.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import saggi.deepak.com.zomatodummyapp.R;
import saggi.deepak.com.zomatodummyapp.models.RestaurantData;

public class RestaurantListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> mHeaderList;
    private HashMap<String, List<RestaurantData>> mChildList;

    public RestaurantListAdapter(Context context, HashMap<String, List<RestaurantData>> listChildData) {
        this._context = context;
        this.mChildList = listChildData;
        this.mHeaderList = new ArrayList<>(mChildList.keySet());

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.mChildList.get(this.mHeaderList.get(groupPosition))
                .get(childPosititon);
    }


    public void addData(HashMap<String, List<RestaurantData>> data) {
        Iterator<String> iterator = data.keySet().iterator();
        String cuisine;

        while (iterator.hasNext()) {
            cuisine = iterator.next();
            if (mChildList.get(cuisine) == null) {
                mChildList.put(cuisine, new ArrayList<>());
            }
            mChildList.get(cuisine).addAll(data.get(cuisine));
        }


        this.mHeaderList = new ArrayList<>(mChildList.keySet());
        notifyDataSetChanged();
    }

    public long getCount() {
        return mHeaderList.size();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final RestaurantData restaurantData = (RestaurantData) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        AppCompatImageView thumbImgView = convertView.findViewById(R.id.thumbnail);
        AppCompatTextView titleTxtView = convertView.findViewById(R.id.title);
        AppCompatTextView addressTxtView = convertView.findViewById(R.id.address);
        AppCompatTextView costTxtView = convertView.findViewById(R.id.cost);
        AppCompatRatingBar ratingBar = convertView.findViewById(R.id.rating);

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.default_img)
                .error(R.drawable.default_img)
                .priority(Priority.HIGH);
        Glide.with(_context).load(restaurantData.getThumb())
                .thumbnail(0.5f)
                .apply(options)
                .into(thumbImgView);

        titleTxtView.setText(restaurantData.getName());
        addressTxtView.setText(restaurantData.getLocation().getAddress());
        String cost = String.format("Avg. cost for two : %s %s", restaurantData.getCurrency(), restaurantData.getAverageCostForTwo());
        costTxtView.setText(cost);
        ratingBar.setRating(Float.parseFloat(restaurantData.getUserRating().getAggregateRating()));


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.mChildList.get(this.mHeaderList.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.mHeaderList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.mHeaderList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (infalInflater != null) {
                convertView = infalInflater.inflate(R.layout.list_group, null);
            }
        }
        TextView lblListHeader = convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class ViewHolder {

    }
}