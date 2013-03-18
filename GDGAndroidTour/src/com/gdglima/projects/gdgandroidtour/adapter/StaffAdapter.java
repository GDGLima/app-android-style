package com.gdglima.projects.gdgandroidtour.adapter;

import java.util.ArrayList;
import java.util.List;

import com.gdglima.projects.gdgandroidtour.AndroidTourPeruApplication;
import com.gdglima.projects.gdgandroidtour.R;
import com.gdglima.projects.gdgandroidtour.model.Staff;
import com.novoda.imageloader.core.model.ImageTag;
import com.novoda.imageloader.core.model.ImageTagFactory;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StaffAdapter extends ArrayAdapter<Staff>{
	
	private Activity context;
	private int row_layout;
	private ArrayList<Staff> staff_list;
	private ImageTagFactory imageTagFactory;
	
	
	
	private ViewBinder getViewBinder() {
	  return new ViewBinder() {
	    @Override
	    public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
	      // Build image tag with remote image URL
	      return true;
	    }

	  };
	}
	public StaffAdapter(Activity activity, int resourceItemId, ArrayList<Staff> staff) {
		super(activity, resourceItemId, staff);
		context=activity;
		row_layout=resourceItemId;
		setStaff_list(staff);
		imageTagFactory = new ImageTagFactory(context, R.drawable.loading);
		imageTagFactory.setErrorImageId(R.drawable.not_found);
		// TODO Auto-generated constructor stub
	}

	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        StaffHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(row_layout, parent, false);
            
            holder = new StaffHolder();
            holder.proPic = (ImageView)row.findViewById(R.id.profile_pic_iv);
            holder.uname = (TextView)row.findViewById(R.id.username_tv);
            holder.email = (TextView)row.findViewById(R.id.email_tv);
            holder.bio = (TextView)row.findViewById(R.id.bio_tv);
            
            row.setTag(holder);
        }
        else
        {
            holder = (StaffHolder)row.getTag();
        }
        
        Staff staff = getStaff_list().get(position);
        ImageTag tag = imageTagFactory.build(staff.getPlus_image());
        ((ImageView) holder.proPic).setTag(tag);
        ((AndroidTourPeruApplication)context.getApplication()).getImageManager().getLoader().load((ImageView) holder.proPic );
        holder.uname.setText(staff.getPlus_username());
        holder.email.setText(staff.getPlus_email());
        holder.bio.setText(staff.getPlus_bio());
        
        return row;
    }
    
    public ArrayList<Staff> getStaff_list() {
		return staff_list;
	}
	public void setStaff_list(ArrayList<Staff> staff_list) {
		this.staff_list = staff_list;
	}

	static class StaffHolder
    {
        ImageView proPic;
        TextView uname;
        TextView email;
        TextView bio;
    }


}
