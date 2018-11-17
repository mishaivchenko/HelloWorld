package timeanalizer;

import org.apache.log4j.Logger;
import talker.HelloWorldTalker;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeAnalyzer {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
    private Date date;
    private final org.apache.log4j.Logger logger = Logger.getLogger(TimeAnalyzer.class);

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameOfThePartOfTheDay() {
        logger.info("Get part of the day");
        if (date == null) {
            date = new Date();
        }
        String dateInString = simpleDateFormat.format(date);
        int time = Integer.parseInt(dateInString);
        String partOfTheDay = analyze(time);
        logger.info("The part of the day is " + partOfTheDay);
        logger.debug("WHAT IS IT");
        return partOfTheDay;
    }

    private String analyze(int time) {
        if (time < 9 && time > 6) {
            return "morning";
        } else if (time > 9 && time < 19) {
            return "day";
        } else if (time > 19 && time < 23) {
            return "evening";
        } else {
            return "night";
        }
    }

}
