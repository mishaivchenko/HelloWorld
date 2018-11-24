package timeanalizer;

import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class TimeAnalyzer {
    private final org.apache.log4j.Logger logger = Logger.getLogger(TimeAnalyzer.class);
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameOfThePartOfTheDay() {
        logger.info("Get part of the day");
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        String partOfTheDay = analyze(hours, minutes, seconds);
        logger.info("The part of the day is " + partOfTheDay);
        return partOfTheDay;
    }

    private String analyze(int hours, int minutes, int seconds) {

        if ((hours >= 6 && minutes >= 0 && seconds >= 0) && (hours <= 8 && minutes <= 59 && seconds <= 59)) {
            return "morning";
        } else if ((hours >= 9 && minutes >= 0 && seconds >= 0) && (hours <= 18 && minutes <= 59 && seconds <= 59)) {
            return "day";
        } else if ((hours >= 19 && minutes >= 0 && seconds >= 0) && (hours <= 22 && minutes <= 59 && seconds <= 59)) {
            return "evening";
        } else {
            return "night";
        }
    }

}
