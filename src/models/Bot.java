package models;

import strategies.BotStrategies.BotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Bot(Symbol symbol, String name,BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botDifficultyLevel = ;
    }

    private BotPlayingStrategy botPlayingStrategy;

    public Cell makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }

}
