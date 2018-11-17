package talker;


import org.apache.log4j.Logger;
import timeanalizer.TimeAnalyzer;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloWorldTalker implements Talker {
    private final Logger logger = Logger.getLogger(HelloWorldTalker.class);
    private TimeAnalyzer timeAnalyzer;
    private Locale locale;
    private String message;


    public HelloWorldTalker() {
        timeAnalyzer = new TimeAnalyzer();
        locale = Locale.getDefault();
    }


    @Override
    public void say() {
        logger.info("application running");
        System.out.println(getMessage());
        logger.info("application completed");
    }

    private void getMessageByLocale(String partOfTheDay) {
        logger.info("Try to get message by locale. Locale is " + Locale.getDefault());
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.messages", locale);
        message = resourceBundle.getString(partOfTheDay);
        logger.info("message is " + message);
    }

    public String getMessage() {
        getMessageByLocale(timeAnalyzer.getNameOfThePartOfTheDay());
        return this.message;
    }
}
