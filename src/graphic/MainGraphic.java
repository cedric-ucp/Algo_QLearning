package graphic;

import configuration.GameConfig;
import process.*;
import process.Action;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serial;
import java.util.Random;

public class MainGraphic extends JFrame implements Runnable{

    @Serial
    private static final long serialVersionUID = 1L;

    private final static Dimension preferredSize = new Dimension(GameConfig.WINDOW_WIDTH, GameConfig.WINDOW_HEIGHT);

    private Display dashboard ;
    private BuildEnvironment environment ;
    private Action action ;
    private Qlearning q ;


    public MainGraphic(String title) {
        super(title);
        this.startGame ();
    }

    private void startGame() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        KeyControls keyControls = new KeyControls();
        JTextField textField = new JTextField();
        textField.addKeyListener (keyControls) ;
        contentPane.add (textField , BorderLayout.SOUTH) ;

        this.environment = BuildGame.initEnvironment () ;
        this.action = BuildGame.initAction () ;
        q =  new Qlearning (environment , action) ;
        q.printQtable () ;

        this.dashboard = new Display (environment) ;

        this.dashboard.setPreferredSize(preferredSize);

        contentPane.add(this.dashboard);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setPreferredSize(preferredSize);
        setResizable(false);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(GameConfig.GAME_SPEED);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            q.updateQtable();
            q.printQtable () ;
            dashboard.repaint () ;
        }
    }

    public class KeyControls implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            char keyChar = e.getKeyChar () ;
            switch (keyChar){
                case 'q' :
                    action.goLeft() ;
                    break ;
                case 'd' :
                    action.goRight () ;
                    break ;
                case 'z' :
                    action.goUp ();
                    break ;
                case 's' :
                    action.goDown () ;
                    break ;
                default :
                    break ;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyReleased (KeyEvent e){

        }
    }

}
