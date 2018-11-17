import org.junit.Assert;
import org.junit.Test;
import talker.HelloWorldTalker;
import talker.Talker;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorldTalkerTest {
    private static final String MESSAGE_EN_PATTERN="^[a-zA-Z].+$";
    private static final String MESSAGE_RU_PATTERN="^[Р-пр-џ].+$";
    private Pattern pattern;
    private Matcher matcher;

    @Test
    public void LocaleTestMustReturnTrueWhenLangEqualsEn(){
        //GIVEN
        Locale.setDefault(new Locale("en","EN"));
        HelloWorldTalker talker = new HelloWorldTalker();
        //WHEN
        talker.say();
        pattern = Pattern.compile(MESSAGE_EN_PATTERN);
        matcher = pattern.matcher(talker.getMessage());
        //THEN
        Assert.assertTrue(matcher.matches());
    }
    @Test
    public void LocaleTestMustReturnTrueWhenLangEqualsRu(){
        //GIVEN
        Locale.setDefault(new Locale("ru","UA"));
        HelloWorldTalker talker = new HelloWorldTalker();
        //WHEN
        talker.say();
        pattern = Pattern.compile(MESSAGE_RU_PATTERN);
        matcher = pattern.matcher(talker.getMessage());
        //THEN
        Assert.assertTrue(matcher.matches());
    }
}
