package test;

import configuration.GameConfig;
import data_base.environment.Environment;
import data_base.environment.Grill;
import graphic.MainGraphic ;
import process.Action;
import process.BuildEnvironment;
import process.BuildGame;
import process.Qlearning;

public class Launch {

    public static void main (String[] args) {
	// write your code here
        MainGraphic window = new MainGraphic ("QLearning Algorithm") ;
        Thread gameThread = new Thread(window) ;
        gameThread.start()  ;


    }
}
