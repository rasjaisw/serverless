package com.cg.framework.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains utility methods for date functionality
 * 
 * @author satispati
 *
 */
public class DateUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	private static final String EST_TIME_ZONE_ID = "America/New_York";

	private DateUtil() {

	}

	public static long getUTCTimeinMillis() {
		LOGGER.info("ENTER::DateUtil::getUTCTimeinMillis () ");
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		LOGGER.info("EXIT::DateUtil::getUTCTimeinMillis () ");
		return cal.getTimeInMillis();
	}

	/**
	 * This method converts the given string to the given date format
	 * 
	 * @param dateString
	 *            the string to convert into Date
	 * @param dateFormat
	 *            the date format
	 * @return Date in the given Date format
	 * 
	 */
	public static Date convertStringToDate(String dateString, String dateFormat) {
		LOGGER.info("ENTER::DateUtil::convertStringToDate () ");
		DateFormat df = new SimpleDateFormat(dateFormat);
		Date ds = null;
		try {
			ds = df.parse(dateString);
		} catch (ParseException e) {
			return ds;
		}
		LOGGER.info("EXIT::DateUtil::convertStringToDate () ");
		return ds;
	}

	/**
	 * This method converts the string to timestamp.
	 * 
	 * @param dateTime
	 * @param format
	 * @return Timestamp
	 */
	public static Timestamp convertStringToTimestamp(String dateTime, String format) {
		LOGGER.info("ENTER::DateUtil::convertStringToTimestamp () ");
		DateFormat formatter = new SimpleDateFormat(format);
		Timestamp timeStampDateTime = null;
		try {
			Date date = formatter.parse(dateTime);
			timeStampDateTime = new Timestamp(date.getTime());
		} catch (ParseException e) {
			return timeStampDateTime;
		}
		LOGGER.info("EXIT::DateUtil::convertStringToTimestamp () ");
		return timeStampDateTime;
	}

	/**
	 * returns the current timestamp value.
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimestamp() {
		LOGGER.info("ENTER::DateUtil::getCurrentTimestamp () ");
		LOGGER.info("EXIT::DateUtil::getCurrentTimestamp () ");
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * returns the current EST date in a specific format.
	 * 
	 * @param format
	 * @return
	 */
	public static Date getFormattedCurrentDate(String format) {
		LOGGER.info("ENTER::DateUtil::getFormattedCurrentDate () ");
		String currentDate = getEstFormattedCurrentDate(format);
		LOGGER.info("EXIT::DateUtil::getFormattedCurrentDate () ");
		return convertStringToDate(currentDate, format);
	}

	/**
	 * takes a timestamp and returns a date in the specified format.
	 * 
	 * @param timestamp
	 * @param format
	 * @return
	 */
	public static String getFormattedTimestamp(Timestamp timestamp, String format) {
		LOGGER.info("ENTER::DateUtil::getFormattedTimestamp () ");
		DateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date(timestamp.getTime());
		String formattedDateString = formatter.format(date);
		LOGGER.info("EXIT::DateUtil::getFormattedTimestamp () ");
		return formattedDateString;

	}

	/**
	 * takes a string in mm/dd/yy format and converts it to the Date in the provided
	 * format
	 * 
	 * @param dateString
	 *            string to be converted into Date
	 * @param dateFormat
	 *            date format
	 * @param startAndEndDateFormat
	 *            required date format
	 * @return the date in provided format
	 */
	public static Date convertStringToDate(String dateString, String dateFormat, String startAndEndDateFormat) {
		LOGGER.info("ENTER::DateUtil::convertStringToDate () ");
		DateFormat formatter = new SimpleDateFormat(startAndEndDateFormat);
		Date date = null;
		try {
			date = formatter.parse(dateString);
			formatter = new SimpleDateFormat(dateFormat);
			String converteddate = formatter.format(date);
			return formatter.parse(converteddate);
		} catch (ParseException e) {
			LOGGER.info("EXIT::DateUtil::convertStringToDate () ");
			return date;
		}
	}

	/**
	 * converts string from one format to the other format
	 * 
	 * @param dateString
	 *            string to be converted from one format to the other format
	 * @param inDateFormat
	 *            input date format
	 * @param outDateFormat
	 *            output date format
	 * 
	 *
	 * @return the string in provided output format
	 */
	public static String formatDate(String inDate, String inDateFormat, String outDateFormat) {
		LOGGER.info("ENTER::DateUtil::formatDate () ");
		SimpleDateFormat inSDF = new SimpleDateFormat(inDateFormat);
		SimpleDateFormat outSDF = new SimpleDateFormat(outDateFormat);
		String outDateString = null;
		if (inDate != null) {
			try {
				Date date = inSDF.parse(inDate);
				outDateString = outSDF.format(date);
			} catch (ParseException ex) {
				return outDateString;
			}
		}
		LOGGER.info("EXIT::DateUtil::formatDate () ");
		return outDateString;
	}

	/**
	 * This method converts the input string date to EST date
	 * 
	 * @param dateString
	 * @param sourceFormat
	 * @param destFormat
	 * @return
	 */
	public static String convertToEST(String dateString, String sourceFormat, String destFormat) {
		LOGGER.info("ENTER::DateUtil::convertToEST () ");
		SimpleDateFormat sourceFormatter = new SimpleDateFormat(sourceFormat);
		SimpleDateFormat finalFormatter = new SimpleDateFormat(destFormat);

		Date parsedOktaDate = null;
		String convertedDateString = null;

		try {
			parsedOktaDate = sourceFormatter.parse(dateString);
			finalFormatter.setTimeZone(TimeZone.getTimeZone(EST_TIME_ZONE_ID));
			convertedDateString = finalFormatter.format(parsedOktaDate);
			LOGGER.info(convertedDateString);
			return convertedDateString;
		} catch (ParseException e) {
			LOGGER.info("EXIT::DateUtil::convertToEST () ");
			return convertedDateString;
		}
	}

	/**
	 * get current EST date in provided format
	 * 
	 * @param format
	 *            the required format
	 * @return current EST date in provided format
	 */
	public static String getEstFormattedCurrentDate(String format) {
		LOGGER.info("ENTER::DateUtil::getEstFormattedDate () ");
		DateFormat formatter = new SimpleDateFormat(format);
		// Set the formatter to use a EST timezone
		formatter.setTimeZone(TimeZone.getTimeZone(EST_TIME_ZONE_ID));
		LOGGER.info("EXIT::DateUtil::getEstFormattedDate () ");
		return formatter.format(new Date());
	}

}
