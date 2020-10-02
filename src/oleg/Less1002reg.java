package oleg;
// https://regex101.com/

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Less1002reg {
    public static void main(String[] args) {
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s " +
                "standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently " +
                "with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        //        "abcabcabc"
        String myPattern= "[A-Z]{1}[a-z]{4,}";
//         myPattern = "(.(.(.)))";

        Pattern pattern = Pattern.compile(myPattern);
        Matcher matcher = pattern.matcher("Vaska");
        List<String> years = new ArrayList<>();
        String m = (matcher.matches())?matcher.group() : "Don't";
        System.out.println(m);
//        System.out.println(matcher.group(0));
        while (matcher.find()) {
            years.add(matcher.group());
        }
        System.out.println(years.toString());
    }
}
