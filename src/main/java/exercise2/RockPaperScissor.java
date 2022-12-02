package exercise2;

import java.util.List;
import java.util.stream.Collectors;

public class RockPaperScissor {

    public int playRockAgainst(Character against) {

        switch (against) {

            case 'X':
                return 3;
            case 'Y':
                return 6;
            case 'Z':
                return 0;

        }

        return 0;

    }

    public int playPaperAgainst(Character against) {

        switch (against) {

            case 'X':
                return 0;
            case 'Y':
                return 3;
            case 'Z':
                return 6;

        }

        return 0;

    }

    public int playScissorAgainst(Character against) {

        switch (against) {

            case 'X':
                return 6;
            case 'Y':
                return 0;
            case 'Z':
                return 3;

        }

        return 0;

    }

    public String rockReturnGameForExpectedResult(Character result) {

        switch (result) {

            case 'X':
                return "A Z";
            case 'Y':
                return "A X";
            case 'Z':
                return "A Y";
        }

        return "";
    }

    public String paperReturnGameForExpectedResult(Character result) {

        switch (result) {

            case 'X':
                return "B X";
            case 'Y':
                return "B Y";
            case 'Z':
                return "B Z";
        }

        return "";
    }

    public String scissorReturnGameForExpectedResult(Character result) {

        switch (result) {

            case 'X':
                return "C Y";
            case 'Y':
                return "C Z";
            case 'Z':
                return "C X";
        }

        return "";
    }

    public int valueOf(Character c) {

        switch (c) {

            case 'X':
                return 1;
            case 'Y':
                return 2;
            case 'Z':
                return 3;
        }

        return 0;
    }

    public int playGame(Character opponent, Character you) {

        switch (opponent) {

            case 'A':
                return playRockAgainst(you) + valueOf(you);
            case 'B':
                return playPaperAgainst(you) + valueOf(you);
            case 'C':
                return playScissorAgainst(you) + valueOf(you);


        }

        return 0;

    }

    public String transformResultToGame(String game) {

        switch (game.charAt(0)) {

            case 'A':
                return rockReturnGameForExpectedResult(game.charAt(2));
            case 'B':
                return paperReturnGameForExpectedResult(game.charAt(2));
            case 'C':
                return scissorReturnGameForExpectedResult(game.charAt(2));

        }

        return "";
    }


    public int calculateScoreFirstExercise(List<String> games) {

        return games.stream().map(s -> playGame(s.charAt(0), s.charAt(2))).collect(Collectors.summingInt(Integer::intValue));

    }

    public int calculateScoreSecondExercise(List<String> results) {

        // transform expected results to games
        List<String> gamesToBePlayed = results.stream().map(s -> transformResultToGame(s)).collect(Collectors.toList());

        // now play the games
        return gamesToBePlayed.stream().map(s -> playGame(s.charAt(0), s.charAt(2))).collect(Collectors.summingInt(Integer::intValue));

    }
}

