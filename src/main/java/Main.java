

import talker.HelloWorldTalker;
import talker.Talker;

public class Main {
    public static void main(String[] args) {
        Talker talker = new HelloWorldTalker();
        talker.say();
    }
}
