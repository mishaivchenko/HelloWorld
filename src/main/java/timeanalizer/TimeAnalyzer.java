package timeanalizer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAnalyzer {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameOfThePartOfTheDay() {
        if (date == null) {
            date = new Date();
        }
        String dateInString = simpleDateFormat.format(date);
        int time = Integer.parseInt(dateInString);
        return analyze(time);
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
