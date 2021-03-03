package process;

import configuration.GameConfig;
import data_base.elements.Agent;

public class BuildGame {
    private static BuildEnvironment environment ;
    public static BuildEnvironment initEnvironment(){
        environment = new BuildEnvironment (GameConfig.LINE_COUNT , GameConfig.COLUMN_COUNT , GameConfig.states) ;
        return environment ;
    }
    public static Action initAction (){
        return new Action (environment) ;
    }
    public static boolean endGame (Agent agent){
        return agent.getPosition ().getReward () == GameConfig.reward ;
    }
}
