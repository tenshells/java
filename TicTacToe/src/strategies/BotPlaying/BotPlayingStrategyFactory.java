package TicTacToe.src.strategies.BotPlaying;

import TicTacToe.src.models.BotDifficulty;
import TicTacToe.src.strategies.BotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyForDifficulty(BotDifficulty bd){
        if(bd.equals(BotDifficulty.EASY))
            return new EasyBotPlayer();
        else if(bd.equals(BotDifficulty.MEDIUM))
            return new MediumBotPlayer();
        else
            return new HardBotPlayer();
    }
}
