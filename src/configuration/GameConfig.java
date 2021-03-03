package configuration;

public class GameConfig {
    /**
     * Hauteur et largeur de la fenêtre codées en dur.
     */
    public static final int WINDOW_WIDTH = 300 ; // On définit la largeur de la fenêtre
    public static final int WINDOW_HEIGHT = 300 ;//On définit la hauteur de notre fenêtre
    /**
     * taille d'un block codé en dur.
     */
    public static final int GRILL_SIZE = 100 ;

    public static final int LINE_COUNT = (WINDOW_HEIGHT / GRILL_SIZE) ; // hauteur de la fenêtre divisée la taille d'un block.
    public static final int COLUMN_COUNT = (WINDOW_WIDTH / GRILL_SIZE); // largeur de la fenêtre divisée par la taille d'un block.

    public static final int GAME_SPEED = 1000;

    public static final int reward = 100 ;
    public static final int danger = -10 ;
    public static final int states = LINE_COUNT * COLUMN_COUNT ;
    public static final double learningRate = 0.25 ;
    public static final double discountFactor = 0.95 ;
    public static final double explorationGreedy = 0.1 ;
    public static final int roundCount = 1000 ;



}
