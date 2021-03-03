package process;

import data_base.elements.Agent;
import data_base.elements.Danger;
import data_base.elements.Goal;
import data_base.environment.Environment;
import data_base.environment.Grill;

public class Action {
    private Environment map ;
    private Agent agent ;

    public Action(BuildEnvironment environment){
        this.map = environment.getMap () ;
        this.agent = environment.getAgent () ;
    }

    public void goUp (){
        Grill position = agent.getPosition () ;
        if (map.CanGoUp (position)){
            Grill updatePosition = map.getGrill (position.getLine () , position.getColumn () - 1) ;
            this.agent.setPosition (updatePosition) ;
        }
        else
            this.agent.setPosition (agent.getPosition()) ;

    }
    public void goDown (){
        Grill position = this.agent.getPosition () ;
        if (map.CanGoDown (position)){
            Grill updatePosition = map.getGrill (position.getLine () , position.getColumn () + 1) ;
            this.agent.setPosition (updatePosition) ;
        }
        else
            this.agent.setPosition (position) ;

    }
    public void goLeft (){
        Grill position = this.agent.getPosition () ;
        if (map.CanGoLeft (position)){
            Grill updatePosition = map.getGrill (position.getLine () - 1 , position.getColumn ()) ;
            this.agent.setPosition (updatePosition) ;
        }
        else
            this.agent.setPosition (position) ;
    }
    public void goRight (){
        Grill position = this.agent.getPosition () ;
        if (map.CanGoRight (position)){
            Grill updatePosition = map.getGrill (position.getLine () + 1  , position.getColumn ()) ;
            this.agent.setPosition (updatePosition) ;
        }
        else
            this.agent.setPosition (position) ;

    }
    public Agent getAgent (){
        return this.agent ;
    }
    public Grill makeStep (int action){
        switch (action){
            case 0 :
                this.goLeft () ;
                break ;
            case 1 :
                this.goRight () ;
                break ;
            case 2 :
                this.goUp () ;
                break ;
            case 3 :
                this.goDown () ;
                break ;
            default :
                break ;
        }
        return this.agent.getPosition () ;
    }

}
