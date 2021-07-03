package com.fujitsu.task.util;

import com.fujitsu.task.app.AppConst;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


/**
 * Main date utility class
 * @author < Write Your name here>
 * @EmpId: < Write your emp id here >
 *
 */
public class MyDateUtil {
	SimpleDateFormat sdf = new SimpleDateFormat(AppConst.inputDateFormat);
	Calendar c = Calendar.getInstance();
	Calendar c1 = Calendar.getInstance();

	
	/**
	 * This method will convert a date to different format and return the String value
	 * @para ( user input date )
	 * @param fromFormat ( input date format )
	 * @param toFormat ( output date format )
	 * @return the String value 
	 */
	public String changeDateFormat(Date inputDate, String fromFormat, String toFormat) {
		try {
		SimpleDateFormat formatter = new SimpleDateFormat(fromFormat);
			String startDateString = formatter.format(inputDate);
			SimpleDateFormat sdf2 = new SimpleDateFormat(toFormat);
			return sdf2.format(formatter.parse(startDateString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	/**
	 * This method will return the day text ( Sunday , ---Saturday)
	 * @return Day of the week
	 * @Ref: java.time.LocalDate ( DayOfWeek )
	 */
	public String getDay( Date inputDate) {

		DateFormat formatter = new SimpleDateFormat("EEEE");
		return formatter.format(inputDate);

	}
	
	public String addSubtractDays(Date inputData, int daysOffset) {


		//Given Date in String format
		//Specifying date format that matches the given date

		//Setting the date to the given date
		c.setTime(inputData);
		c1.setTime(inputData);

		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, daysOffset);
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		c.add(Calendar.DAY_OF_MONTH,daysOffset*-1);
		String subDate=sdf.format(c1.getTime());
		//Displaying the new Date after addition of Days
//		System.out.println("Date after Addition: "+newDate);
		String addSubtractDays=(newDate + "\n" + subDate);
		return addSubtractDays;

	}



		public String addSubtractMonths(Date inputData, int monthsOffset){

			Calendar addMonth = Calendar.getInstance();
			addMonth.setTime(inputData);
			addMonth.add(Calendar.MONTH,monthsOffset);
			String addMonths=sdf.format(addMonth.getTime());
			Calendar subMonth =Calendar.getInstance();
			subMonth.setTime(inputData);
			subMonth.add(Calendar.MONTH,monthsOffset*-1);
			String subMonths=sdf.format(subMonth.getTime());
            String addSubtractMonth=(addMonths + "\n" + subMonths);
			return addSubtractMonth;
		}

	
	public String getDateDifference(Date inputDate) {

		Date date = new Date();
		LocalDate today = Instant.ofEpochMilli(date.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		LocalDate fromDay = Instant.ofEpochMilli(inputDate.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
		Period getDateDifference =Period.between(fromDay,today);
		String difference =(getDateDifference.getYears() + " Years " +getDateDifference.getMonths() +" Months " +getDateDifference.getDays() + "Days");

		return difference;
	}
	
	public String compare(Date inputDate) {

		String inputDates=sdf.format(inputDate);
		String answer;
		Date date = new Date();
		String today=sdf.format(date);
		if (inputDate.compareTo(date) > 0) {
			answer=(inputDates +" > "+today);
//			System.out.println("Date1 is after Date2");
		} else if (inputDate.compareTo(date) < 0) {
			answer=(inputDates +" < "+today);
		} else {
			answer=(inputDate +" = "+today);
		}
		return answer;
	}
}
