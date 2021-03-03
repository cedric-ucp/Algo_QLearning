package graphic;

import data_base.elements.Agent;
import data_base.elements.Danger;
import data_base.elements.Goal;
import data_base.environment.Environment;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

import process.BuildEnvironment;
import process.Action;

public class Display extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L ;

    private final PaintElement paintElement = new PaintElement () ;
    private final BuildEnvironment environment ;
    private final Action action;
    private final Environment map ;

    public Display (BuildEnvironment environment){
        this.environment = environment ;
        this.action = new Action(environment) ;
        this.map = environment.getMap () ;

    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent (g) ;
        paintElement.paint(map, g) ;

        Agent agent = this.action.getAgent () ;
        paintElement.paint(agent , g) ;

        Danger danger = environment.getDanger () ;
        paintElement.paint(danger , g);

        Goal goal = environment.getGoal () ;
        paintElement.paint(goal , g) ;

    }
}
