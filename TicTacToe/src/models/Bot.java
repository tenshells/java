package TicTacToe.src.models;

import TicTacToe.src.strategies.BotPlayingStrategy;
import TicTacToe.src.strategies.BotPlaying.BotPlayingStrategyFactory;


public class Bot extends Player{
    BotDifficulty botDifficulty;
    BotPlayingStrategy botStrategy;

    Bot(int id, String name, char Symbol, BotDifficulty bd){
        super(id, name, Symbol);
        this.botDifficulty=bd;
        this.botStrategy=BotPlayingStrategyFactory.getBotPlayingStrategyForDifficulty(botDifficulty);
    }

    @Override
    Move makeMove(Board b){
        System.out.println("Autoplaying "+this.getName()+"'s move : ");
        Move m =  botStrategy.makeMove(b);
        if(m!=null){
            Move chosenMove = new Move(m.getCell(), this);
            return chosenMove;
        }
        return m;
    }
}
