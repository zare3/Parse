package com.example.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.classes.DataEntry;
import com.example.parse.R;


public class DataListAdapter extends ArrayAdapter<DataEntry> {

	private final Context context;
	private final ArrayList<DataEntry> dataObjects;
	LayoutInflater inflater;
	View rowView;
	TextView textViewNumber, textViewAmount, textViewApproval, textViewDate;
	
	public DataListAdapter(Context context, ArrayList<DataEntry> dataObjects) {
	    super(context,R.layout.row_layout_data, dataObjects);
	    this.context = context;
	    this.dataObjects = dataObjects;
	   
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		initIalizeView(parent);
	    setRowComponents(position);   
	    return rowView;
	  }
	
	
	private void initIalizeView(ViewGroup parent)
	{
		initializeInflater();
	    initializeRowView(parent);
	    matchRowComponentsWithIDS();
	}
	
	private void matchRowComponentsWithIDS()
	{
		textViewNumber = (TextView) rowView.findViewById(R.id.number);
	     textViewAmount = (TextView) rowView.findViewById(R.id.amount);
	     textViewApproval= (TextView) rowView.findViewById(R.id.approval);
	     textViewDate = (TextView) rowView.findViewById(R.id.date);
	}
	
	private void setRowComponents(int position)
	{
		DataEntry temp = dataObjects.get(position);
		textViewNumber.setText(temp.getPhoneNumber());
	    textViewAmount.setText(temp.getAmount());
	    textViewApproval.setText(temp.getApprovalNumber());
	    textViewDate.setText(temp.getDate());
	}
	
	private void initializeRowView(ViewGroup parent)
	{
		rowView = inflater.inflate(R.layout.row_layout_data, parent, false);
	}
	
	private void initializeInflater()
	{
		inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
}


/*

public class PendingArrayAdapter extends ArrayAdapter<PendingArrayAdapterObject> {
	
	private final Context context;
	private final ArrayList<PendingArrayAdapterObject> pendingObjects;
	LayoutInflater inflater;
	View rowView;
	TextView textViewNumber, textViewAmount, textViewApproval, textViewDate;
	ActionBarActivity activity;
	
	public PendingArrayAdapter(Context context, ArrayList<PendingArrayAdapterObject> pendingObjects, ActionBarActivity activity) {
	    super(context, R.layout.row_layout_pending, pendingObjects);
	    this.context = context;
	    this.pendingObjects = pendingObjects;
	    this.activity = activity;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
	     initIalizeView(parent);
	    setRowComponents(position);   
	    return rowView;
	  }
	

	private void initIalizeView(ViewGroup parent)
	{
		initializeInflater();
	    initializeRowView(parent);
	    matchRowComponentsWithIDS();
	    setFonts();
	    setBoldFonts();
	}

	private void initializeInflater()
	{
		inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	private void initializeRowView(ViewGroup parent)
	{
		rowView = inflater.inflate(R.layout.row_layout_pending, parent, false);
	}
	

	private void matchRowComponentsWithIDS()
	{
		textViewNumber = (TextView) rowView.findViewById(R.id.contact_name);
	     textViewAmount = (TextView) rowView.findViewById(R.id.last_message);
	     textViewApproval= (TextView) rowView.findViewById(R.id.transfer_amount);
	     textViewDate = (TextView) rowView.findViewById(R.id.time);
	}
	
	private void setFonts()
	{
		try
		{
			Font helvetica = initializeFont(FontType.HELVETICA);
			setFont(helvetica,textViewAmount,textViewApproval, textViewDate);
		} catch (FontNotFoundException e)
		{
			showErrordialog("Some fonts were not loaded");
		}
	}
	
	
	private void setBoldFonts()
	{
		try
		{
			Font helveticaBold= initializeFont(FontType.HELVETICA_BOLD);
			setFont(helveticaBold, textViewNumber);
		} catch (FontNotFoundException e)
		{
			showErrordialog("Some fonts were not loaded");
		}
	}

	
	private Font initializeFont(FontType type)
			throws FontNotFoundException
	{
		return new Font(type, context);
	}
	
	private void showErrordialog(String errorMessage)
	{
		SingleButtonMessageDialog errorAlert = new SingleButtonMessageDialog();
		errorAlert.SetMessage("", "OK"); 
		errorAlert.show(activity.getSupportFragmentManager(), errorMessage);
	}

	private void setRowComponents(int position)
	{
		PendingArrayAdapterObject temp = pendingObjects.get(position);
		textViewNumber.setText(temp.getContactName());
	    textViewAmount.setText(temp.getMessage());
	    textViewApproval.setText(temp.getAmount());
	    textViewDate.setText(temp.getTime());
	}
	
	private void setFont(Font font, View... view)
	{
		try
		{
			font.setObjectsToFont(view);
		}
		catch(CannotSetFontToThisTypeException e)
		{
			Log.e("Font Error", "CannotSetFontToThisTypeException"); 
		}
		
	}




}*/