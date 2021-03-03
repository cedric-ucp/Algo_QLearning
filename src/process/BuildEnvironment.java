package process;

import configuration.GameConfig;
import data_base.elements.Agent;
import data_base.elements.Danger;
import data_base.elements.Goal;
import data_base.environment.Environment;
import data_base.environment.Grill;

public class BuildEnvironment {
    private final Environment map ;
    private final Agent agent ;
    private final Danger danger ;
    private final Goal goal ;


    public BuildEnvironment (int lineNumber , int columnNumber , int states){
        this.map = new Environment (lineNumber , columnNumber , states) ;


        Grill agentPosition = map.getGrill (0 , 0) ;
        this.agent = new Agent (agentPosition) ;

        int line = map.getLineNumber () ;
        int column = map.getColumnNumber () ;

        Grill dangerPosition = map.getGrill (line/2 , column/2) ;
        this.danger = new Danger (dangerPosition) ;

        Grill goalPosition = map.getGrill (line - 1 , column -1) ;
        this.goal = new Goal (goalPosition) ;

        this.fillReward () ;
    }
    public void fillReward (){

        for (int i = 0 ; i < getMap().getLineNumber() ; i++){
            for (int j = 0 ; j < getMap().getColumnNumber() ; j++){
                if ((!(this.danger.isDanger(this.getMap ().getGrill (i , j))) || !(this.goal.isGoal (this.getMap ().getGrill (i , j))))){
                    this.getMap().getGrill(i , j).setReward(0);
                }
            }
        }
        this.danger.getPosition().setReward (-10) ;
        this.goal.getPosition ().setReward (100) ;

    }

    public Environment getMap() {
        return this.map ;
    }

    public Agent getAgent (){
        return this.agent ;
    }

    public Danger getDanger () {
        return this.danger ;
    }
    public Goal getGoal (){
        return this.goal ;
    }
}
