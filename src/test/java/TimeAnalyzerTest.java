import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import timeanalizer.TimeAnalyzer;

import java.net.Authenticator;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeAnalyzerTest {
    private TimeAnalyzer timeAnalyzer;
    private static final org.apache.log4j.Logger logger = Logger.getLogger(HelloWorldTalkerTest.class);

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