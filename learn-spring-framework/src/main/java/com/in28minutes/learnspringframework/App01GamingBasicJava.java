package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PackManGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {
/*
        var game =  new MarioGame();
        var game =  new SuperContraGame();
*/
//        01. Object Creation
        var game = new PackManGame();
//      02. Dependency Injection (DI) + Wring of Dependency's
        var gameRunner = new GameRunner(game);

        gameRunner.run();
    }



}
