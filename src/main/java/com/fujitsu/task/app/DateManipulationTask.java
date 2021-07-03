package com.fujitsu.task.app;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fujitsu.task.util.MyDateUtil;
import com.fujitsu.task.util.Validator;

public class DateManipulationTask {
	private static String dateInputStr;
	public static void main(String[] args) throws ParseException {

		System.out.println("++[ Date Manipulation Task: Emp ID: XXXXX. Name: < Your name>  ]++");
		String results = null;
		
		// Take user input ( date and choice )
		Scanner input = new Scanner(System.in);

		System.out.println("Enter check-in date :");
		 dateInputStr = input.nextLine();


		// Initialize Validator class to perform input validation
		System.out.println("1: Press 1 to change the format to YYYY-MM-DD");
		System.out.println("2: Press 2 to get the Day");
		System.out.println("3: Press 3 to add & subtract number of Day");
		System.out.println("4: Press 4 to add & subtract number of Months");
		System.out.println("5: Press 5 to to get the difference in year Month And Days form today");
		System.out.println("6: Press 6 to compare with today");
		String choiceStr=input.nextLine();

		
		Validator validator = new Validator(dateInputStr, choiceStr);


		// if the errorMessage List size if emprt means no input error
		if ( validator.getValidatonErrorMessage().size() > 0 ) {
			showValidationErrors(validator.getValidatonErrorMessage());
			// Exit from the program
			System.exit(0);
		}


		
		// Get the converted ( String to Date ) date from the Validator class through a public method 
		Date inputDate  = validator.getInputDate();
//
		// Initialize the dateUtil class
		MyDateUtil myDateUtil = new MyDateUtil();
		//Change the date format
		switch (choiceStr) {
			case "1" -> results = myDateUtil.changeDateFormat(inputDate, AppConst.inputDateFormat, AppConst.toDateFormat);
			case "2" -> results = myDateUtil.getDay(inputDate);
			case "3" -> results = myDateUtil.addSubtractDays(inputDate, AppConst.addSubtractDaysOffset);
			case "4" -> results = myDateUtil.addSubtractMonths(inputDate, AppConst.addSubtractMonthsOffset);
			case "5" -> results = myDateUtil.getDateDifference(inputDate);
			case "6" -> results = myDateUtil.compare(inputDate);
		}
		showResults(choiceStr,results);
	}
	
	private static void showValidationErrors( List<String> validationError ) {
		try {
			System.out.println(validationError.get(0));
			System.out.println(validationError.get(1));
		} catch (IndexOutOfBoundsException e) {
			System.exit(0);

		}


	}
	
	private static void showResults(String  choiceStr, String results) {
	if (choiceStr.charAt(0)=='1'){
		System.out.println("Converted date format( YYYY-MM-DD): "+ results);
	}
	else if(choiceStr.charAt(0)=='2'){
		System.out.println(dateInputStr + " : " + results);
	}
	else if(choiceStr.charAt(0)=='3'){
		System.out.println(dateInputStr + " \n " + results);
	}else if(choiceStr.charAt(0)=='4'){
		System.out.println(dateInputStr + "\n" + results);
	}else if(choiceStr.charAt(0)=='5'){
		System.out.println(dateInputStr + " \n " + results);
	}else if(choiceStr.charAt(0)=='6'){
		System.out.println( results);
	}
}}
