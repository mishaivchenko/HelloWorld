package talker;


import timeanalizer.TimeAnalyzer;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelloWorldTalker implements Talker {
    private TimeAnalyzer timeAnalyzer;
    private Locale locale;
    private String message;


    public HelloWorldTalker(){
    timeAnalyzer = new TimeAnalyzer();
    locale = Locale.getDefault();
    }


    @Override
    public void say() {
        getMessageByLocale(timeAnalyzer.getNameOfThePartOfTheDay());
        System.out.println(message);
    }

    private void getMessageByLocale(String partOfTheDay){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n.messages", locale);
        message =  resourceBundle.getString(partOfTheDay);
    }

    public String getMessage(){
        return this.message;
    }
}
