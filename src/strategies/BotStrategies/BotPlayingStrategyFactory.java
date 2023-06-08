package strategies.BotStrategies;

import models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDiffuciltyLevel( BotDifficultyLevel difficultyLevel) {
        return new EasyBotPlayingStrategy();
//        return switch (difficultyLevel) {
//            case EASY -> new EasyBotPlayingStrategy();
//            Case HARD -> new HardBotPlayingStrategy();
//        };
    }
}
