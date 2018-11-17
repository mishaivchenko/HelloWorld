import org.junit.Assert;
import org.junit.Test;
import timeanalizer.TimeAnalyzer;

import java.net.Authenticator;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeAnalyzerTest {
    private TimeAnalyzer timeAnalyzer;

    @Test
    public void testMustReturnMorning() {
        //Given
        String expected = "morning";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1970, Calendar.AUGUST, 21, 7, 0, 0);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMustReturnEvening() {
        //Given
        String expected = "evening";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1970, Calendar.AUGUST, 21, 20, 0, 0);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }
    @Test
    public void testMustReturnNight() {
        //Given
        String expected = "night";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1970, Calendar.AUGUST, 21, 24, 0, 0);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }
}