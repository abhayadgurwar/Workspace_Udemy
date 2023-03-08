package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PackManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PackManGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }


    /*
            var game =  new MarioGame();
            var game =  new SuperContraGame();
    */
//        01. Object Creation
  /*  var game = new PackManGame();
    //      02. Dependency Injection (DI) + Wring of Dependency's
    var gameRunner = new GameRunner(game);

        gameRunner.run();*/
}
