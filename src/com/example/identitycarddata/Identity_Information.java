package com.example.identitycarddata;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;
public class Identity_Information extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_identity__information);
		
		
	}
	public void set(View view){
		TextView number=(TextView)findViewById(R.id.id_no);
		TextView birthDay=(TextView)findViewById(R.id.bday);
		TextView sex =(TextView)findViewById(R.id.sex);
	    TextView weekday=(TextView)findViewById(R.id.day);
		
		String person="Male";
		String id=""+number.getText().toString();
		String birthYear="19"+id.substring(0, 2);
        String dates=id.substring(2, 5);
        int year=Integer.parseInt(birthYear);
        int no=Integer.parseInt(dates);
        
        if(no>500){no-=500;person="Female";}
        no--;
        if(year%100==0){
             if(!(year%400==0))
                no--;
             }
        else
             if(!(year%4==0))
                 no--;
        if(no<60) no++;

        Calendar cal=Calendar.getInstance();    //use the calendar functions
        cal.set(year,0,1);
        cal.add(cal.DATE,no);
        sex.setText(person);
        weekday.setText("Born on "+cal.getDisplayName(cal.DAY_OF_WEEK,cal.LONG, Locale.UK));
        birthDay.setText(cal.get(cal.DATE)+" - "+cal.getDisplayName(cal.MONTH, cal.LONG, Locale.ENGLISH)+" - "+cal.get(cal.YEAR));
     //   System.out.println(cal.get(cal.DATE));
       // System.out.println(cal.getDisplayName(cal.MONTH, cal.LONG, Locale.ENGLISH));
        //System.out.println(cal.get(cal.YEAR));
        //System.out.println(cal.getDisplayName(cal.DAY_OF_WEEK,cal.LONG, Locale.UK));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_identity__information, menu);
		return true;
	}

}
