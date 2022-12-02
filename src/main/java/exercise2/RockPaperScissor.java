package exercise2;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RockPaperScissor {

    public Map<String, Integer> firstGames = Map.ofEntries(

            new AbstractMap.SimpleEntry<>("A X", 4),
            new AbstractMap.SimpleEntry<>("A Y", 8),
            new AbstractMap.SimpleEntry<>("A Z", 3),
            new AbstractMap.SimpleEntry<>("B X", 1),
            new AbstractMap.SimpleEntry<>("B Y", 5),
            new AbstractMap.SimpleEntry<>("B Z", 9),
            new AbstractMap.SimpleEntry<>("C X", 7),
            new AbstractMap.SimpleEntry<>("C Y", 2),
            new AbstractMap.SimpleEntry<>("C Z", 6)
    );

    public Map<String, String> secondGames = Map.ofEntries(

            new AbstractMap.SimpleEntry<>("A X", "A Z"),
            new AbstractMap.SimpleEntry<>("A Y", "A X"),
            new AbstractMap.SimpleEntry<>("A Z", "A Y"),
            new AbstractMap.SimpleEntry<>("B X", "B X"),
            new AbstractMap.SimpleEntry<>("B Y", "B Y"),
            new AbstractMap.SimpleEntry<>("B Z", "B Z"),
            new AbstractMap.SimpleEntry<>("C X", "C Y"),
            new AbstractMap.SimpleEntry<>("C Y", "C Z"),
            new AbstractMap.SimpleEntry<>("C Z", "C X")
    );

    public int calculateScoreFirstExercise(List<String> games) {
        return games.stream().map(s -> firstGames.get(s)).collect(Collectors.summingInt(Integer::intValue));
    }

    public int calculateScoreSecondExercise(List<String> results) {

        // transform expected results to games
        List<String> gamesToBePlayed = results.stream().map(s -> secondGames.get(s)).collect(Collectors.toList());

        // now play the games
        return gamesToBePlayed.stream().map(s -> firstGames.get(s)).collect(Collectors.summingInt(Integer::intValue));

    }
}

