import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import timeanalizer.TimeAnalyzer;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeAnalyzerTest {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(HelloWorldTalkerTest.class);
    private TimeAnalyzer timeAnalyzer;

    @BeforeClass
    public static void informBefore() {
        logger.info("=====TimeAnalyzerTest.class is running===== ");
    }

    @AfterClass
    public static void informAfter() {
        logger.info("=====TimeAnalyzerTest.class is completed===== ");
    }

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
        calendar.set(1970, Calendar.AUGUST, 21, 20, 1, 0);
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
        calendar.set(1970, Calendar.AUGUST, 21, 27, 0, 0);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void boundaryTestMustReturnMorningWhenTimeIsEqualSixHoursAndOneMinute() {
        //Given
        String expected = "morning";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1999, Calendar.DECEMBER, 21, 6, 1, 1);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void boundaryTestMustReturnNightWhenTimeIsEqualTwentyThreeHoursAndOneMinute() {
        //Given
        String expected = "night";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1999, Calendar.DECEMBER, 21, 23, 1, 1);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void boundaryTestMustReturnEveningWhenTimeIsEqualTwentyTwoHoursAndFiftyNineMinutes() {
        //Given
        String expected = "evening";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1999, Calendar.DECEMBER, 21, 22, 59, 1);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void boundaryTestMustReturnNightWhenTimeIsEqualFiveHoursAndFiftyNineMinutes() {
        //Given
        String expected = "night";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1999, Calendar.DECEMBER, 21, 5, 59, 1);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void boundaryTestMustReturnDayWhenTimeIsEqualNineHoursAndOneMinute() {
        //Given
        String expected = "day";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1999, Calendar.DECEMBER, 21, 9, 1, 0);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void boundaryTestMustReturnEveningWhenTimeIsEqualNineteenHoursAndOneMinute() {
        //Given
        String expected = "evening";
        timeAnalyzer = new TimeAnalyzer();
        //When
        Calendar calendar = new GregorianCalendar();
        calendar.set(1999, Calendar.DECEMBER, 21, 19, 1, 0);
        timeAnalyzer.setDate(calendar.getTime());
        //Then
        String result = timeAnalyzer.getNameOfThePartOfTheDay();
        Assert.assertEquals(expected, result);
    }
}