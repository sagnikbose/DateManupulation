package com.fujitsu.task.util;

import com.fujitsu.task.app.AppConst;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Validator {


	private Date inputDate;
	private final List<String> validationErrorMessage = new ArrayList<>();

	private static boolean dateValidation(String date)
	{
		boolean status = false;
		if (checkDate(date)) {
			DateFormat dateFormat = new SimpleDateFormat(AppConst.inputDateFormat);
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(date);
				status = true;
			} catch (Exception e) {
				status = false;
			}
		}
		return !status;
	}

	static boolean checkDate(String date) {
		String pattern = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/([0-9]{4})";
		boolean flag = false;
		if (date.matches(pattern)) {
			flag = true;
		}
		return flag;
	}


	
	public  Validator( String DateStr, String operation) throws ParseException {

		if((dateValidation(DateStr) && operation.charAt(0)>'6')){
				validationErrorMessage.add("Operation choice  is wrong!! , must be between ( 1 to 6 )");
			validationErrorMessage.add("Date format is wrong!! , must be entered in dd/mm/yyyy format.");
		}
		else if (operation.charAt(0)>'6'){
			validationErrorMessage.add("Operation choice  is wrong!! , must be between ( 1 to 6 )");

			}
		else if(dateValidation(DateStr)){
			validationErrorMessage.add("Date format is wrong!! , must be entered in dd/mm/yyyy format.");
		}
		else {
			SimpleDateFormat format = new SimpleDateFormat(AppConst.inputDateFormat);
			this.inputDate = format.parse(DateStr);
		}

		// Convert the date String to the required format
		// Use AppConst.inputDateFormat
		// First convert String to date then if exception occurred store the validation message
		// Second check if user input choice is between ( 1 to 6 ) 
		// if user input suppose 8 then just you have to add below message in validatonErrorMessage list
		// See Sample User Input and Results sheet for more detail
		
	}
	
	public Date getInputDate() {

		return this.inputDate;
	}

	public List<String> getValidatonErrorMessage() {
		return validationErrorMessage;
	}
}
