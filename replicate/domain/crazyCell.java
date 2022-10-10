package domain;
import java.util.HashMap;
import java.awt.Color;
import java.util.Random;
/**
 * A crazy cell success the next conditions:
 * - change his color to a random color 
 * - tic tac then dissappear(if is active)
 * - tic tac then appear(if is inactive)
 * 
 * @author OlayaValencia
 * @version 1.0
*/
public class crazyCell extends Cell
{
    // instance variables - replace the example below with your own
    private AManufacturing aManufacturing;
    private int row,column;
    private int cicles;
    private HashMap<Integer,Color> colors;
    private Random random; 
    /**
     * Create a new crazy cell (<b>row,column</b>) in the aManufactuing <b>ac</b>..
     * @param am
     * @param row
     * @param column
     * @param active
     */
    public crazyCell(AManufacturing am,int row, int column, boolean active)
    {
        super(am,row,column,active);
        aManufacturing = am;
        color = Color.blue;
        this.row = row;
        this.column = column;
        colors = new HashMap();
        random = new Random();
        fullerColor();
    }
    
    /**
     * initialize the random colors in a hashmap
     */
    private void fullerColor(){
        Color[] col1 = {Color.blue,Color.red,Color.yellow,Color.gray,Color.pink,Color.yellow,Color.cyan,Color.magenta};
        for(int i  =  0; i < col1.length;++i){
            colors.put(i,col1[i]);
        }
    }
    
    /**
     * decide the next state with the conditions of color and state
     */
    public void decide(){
        int randomized = random.nextInt(8);
        nextState = (getSteps() % 2 ==0 ? Artefact.ACTIVE:Artefact.INACTIVE);
        this.color = colors.get(randomized);
    }
}
