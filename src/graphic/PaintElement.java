package graphic;

import configuration.GameConfig;
import data_base.elements.Agent;
import data_base.elements.Danger;
import data_base.elements.Goal;
import data_base.environment.Environment;
import data_base.environment.Grill;

import java.awt.*;

public class PaintElement {

    public void paint(Environment environment , Graphics graphics){
        int grillSize = GameConfig.GRILL_SIZE;
        Grill [] [] map = environment.getEnvironment () ;

        for (int line = 0; line < environment.getLineNumber () ; line++) {
            for (int column = 0; column < environment.getColumnNumber(); column++) {
                Grill grill = map[line][column];
                if ((line + column) % 2 == 0) {
                    graphics.setColor(Color.LIGHT_GRAY);
                    graphics.fillRect(grill.getColumn() * grillSize, grill.getLine() * grillSize, grillSize, grillSize);
                }
            }
        }
    }
    public void paint(Agent agent , Graphics graphics) {
        Grill position = agent.getPosition();
        int grillSize = GameConfig.GRILL_SIZE;
        int x = position.getLine();
        int y = position.getColumn();

        graphics.setColor(Color.BLACK);
        graphics.drawLine(x * grillSize + grillSize / 2, y * grillSize, x * grillSize, (y + 1) * grillSize);
        graphics.drawLine(x * grillSize + grillSize / 2, y * grillSize, (x + 1) * grillSize, (y + 1) * grillSize);
        graphics.drawLine(x * grillSize + grillSize / 2, y * grillSize, x * grillSize + grillSize / 2, (y + 1) * grillSize);
    }

    public void paint(Danger danger , Graphics graphic){
        Grill position = danger.getPosition () ;
        int grillSize = GameConfig.GRILL_SIZE ;
        int x = position.getLine () ;
        int y = position.getColumn () ;

        graphic.setColor (Color.RED) ;
        graphic.fillRect(x * grillSize + grillSize / 3, y * grillSize, grillSize / 3, grillSize);
    }
    public void paint(Goal goal , Graphics graphic) {
        Grill position = goal.getPosition();
        int grillSize = GameConfig.GRILL_SIZE;
        int x = position.getLine();
        int y = position.getColumn();

        graphic.setColor(Color.BLUE);
        graphic.fillRect(x * grillSize + grillSize / 3, y * grillSize, grillSize / 3, grillSize);
    }

}

