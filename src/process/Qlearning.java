package process;

import configuration.GameConfig;
import data_base.environment.Environment;
import data_base.environment.Grill;

import java.util.Random;

public class Qlearning {
    private double learningRate = GameConfig.learningRate ;
    private double discountFactor = GameConfig.discountFactor ;
    private double exploration = GameConfig.explorationGreedy ;

    private final double[][] qTable;
    private final int states ;
    private final int actions ;

    private final BuildEnvironment environment;
    private final Environment map ;
    private final Action action ;

    public Qlearning(BuildEnvironment environment , Action action) {
        this.environment = environment ;
        this.map = environment.getMap () ;
        this.action = action ;
        this.states = GameConfig.states ;
        this.actions = 4 ;

        this.qTable = new double[this.states][];
        for (int s = 0; s < this.states; s++) {
            this.qTable[s] = new double[actions];
        }

    }

    public double [][] getQtable() {
        return this.qTable;
    }

    public void initQtable() {
        for (int i = 0; i < this.states; i++) {
            for (int j = 0; j < this.actions; j++) {
                this.qTable[i][j] = 0 ;
            }
        }
    }

    public void updateQtable (){
       this.initQtable () ;
        for (int i = 0 ; i < GameConfig.roundCount ; i++) {
            int state = this.action.getAgent ().getPosition ().getState () ;
            while (BuildGame.endGame (this.action.getAgent ())) {

                int action = takeAction (state, this.qTable, this.exploration) ;
                Grill newGrill = this.action.makeStep (action) ;

                int nextState = newGrill.getState () ;
                double newReward = newGrill.getReward () ;
                int nextAction = takeAction (nextState, getQtable(), 0.0) ;
                this.updateReward (state, action, newReward, nextState, nextAction) ;
                state = nextState ;
            }
        }
    }
    public void updateReward (int state , int action , double reward , int nextState , int nextAction){
        this.qTable [state][action] = this.qTable [state][action] + this.learningRate * (reward + this.discountFactor * this.qTable[nextState][nextAction] - this.qTable[state][action]) ;
    }

     public int takeAction (int state , double [][] qtable , double greedy){
        Random random = new Random () ;
         if (Math.random () < greedy){
            return random.nextInt (4) ;
         }
         else
             return getActionMax (state) ;
     }

    public void printQtable () {
        System.out.println("\n[Qtable]");
        for (int i = 0; i < this.qTable.length; i++) {
            System.out.print("From state " + i + ":  ");
            for (int j = 0; j < this.qTable[i].length; j++) {
                System.out.printf("%6.2f ", (qTable[i][j]));
            }
            System.out.println();
        }
    }
    public int getActionMax (int state){
        double rewardMax = 0.0 ;
        int actionMax = 0 ;
        for (int i = 0 ; i < this.actions ; i++ ){
            if (this.qTable [state] [i] > rewardMax) {
                rewardMax = this.qTable[state][i];
                actionMax = i ;
            }
        }
        System.out.println (actionMax) ;
            return actionMax ;
    }
}



