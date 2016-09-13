package edu.softserveinc.healthbody.webclient.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomDateFormater {
	/**
	 * dateInString format: "2016-08-25"
	 **/
	public static Long getDateInMilliseconds(String dateInString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		Date date;
		try {
			date = sdf.parse(dateInString);
			log.info("Time in milliseconds for  " + dateInString + " : " + date.getTime());
			return date.getTime();
		} catch (ParseException e) {
			log.error("Coldnt parse date", e);
			return System.currentTimeMillis();
		}
	}
}
