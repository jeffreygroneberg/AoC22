package util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {

    public File getFile(String fileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }


    public static List<String> getStacksInLine(String stringToSearch) {

        Pattern integerPattern = Pattern.compile("\\[(\\S+)\\]|\\s\\s\\s\\s?");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> buckets = new ArrayList<>();
        while (matcher.find()) {
            buckets.add(matcher.group());
        }

        return buckets;

    }

    public static List<Integer> findIntegers(String stringToSearch) {

        Pattern integerPattern = Pattern.compile("-?\\d+");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }

        return integerList.stream().map(Integer::parseInt).collect(Collectors.toList());

    }

    public static String stampStringOver(String stamp, String target) {

        String newString = "";

        for (int i = 0; i < stamp.length(); i++) {

            if (i < target.length() && !(target.charAt(i) == ' '))
                newString = newString.concat(String.valueOf(target.charAt(i)));

            else
                newString = newString.concat(String.valueOf(stamp.charAt(i)));
        }

        return newString;

    }


}


