import org.apache.log4j.Logger;
import org.junit.*;
import talker.HelloWorldTalker;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorldTalkerTest {
    private static final String MESSAGE_EN_PATTERN = "^[a-zA-Z].+$";
    private static final String MESSAGE_RU_PATTERN = "^[Р-пр-џ].+$";
    private static final org.apache.log4j.Logger logger = Logger.getLogger(HelloWorldTalkerTest.class);
    private Pattern pattern;
    private Matcher matcher;

    @BeforeClass
    public static void informBefore() {
        logger.info("=====HelloWorldTalkerTest.class is running===== ");
    }

    @AfterClass
    public static void informAfter() {
        logger.info("=====HelloWorldTalkerTest.class is completed===== ");
    }

    @Test
    public void falseLocaleTestMustReturnEnglishWord() {
        //Given
        Locale.setDefault(new Locale("fr", "EN"));
        HelloWorldTalker talker = new HelloWorldTalker();
        //When
        pattern = Pattern.compile(MESSAGE_EN_PATTERN);
        matcher = pattern.matcher(talker.getMessage());
        //THEN
        Assert.assertTrue(matcher.matches());
    }

    @Test
    public void LocaleTestMustReturnTrueWhenLangEqualsEn() {
        //GIVEN
        Locale.setDefault(new Locale("en", "EN"));
        HelloWorldTalker talker = new HelloWorldTalker();
        //WHEN
        talker.say();
        pattern = Pattern.compile(MESSAGE_EN_PATTERN);
        matcher = pattern.matcher(talker.getMessage());
        //THEN
        Assert.assertTrue(matcher.matches());
    }

    @Test
    public void LocaleTestMustReturnFalseWhenLangNotEqualsEn() {
        //GIVEN
        Locale.setDefault(new Locale("ru", "UA"));
        HelloWorldTalker talker = new HelloWorldTalker();
        //WHEN
        talker.say();
        pattern = Pattern.compile(MESSAGE_EN_PATTERN);
        matcher = pattern.matcher(talker.getMessage());
        //THEN
        Assert.assertFalse(matcher.matches());
    }
}
