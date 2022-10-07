package domain;
import java.util.HashMap;
import java.awt.Color;
import java.util.Random;
/**
 * Write a description of class crazyCell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Constructor for objects of class crazyCell
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
    private void fullerColor(){
        Color[] col1 = {Color.blue,Color.red,Color.yellow,Color.gray,Color.pink,Color.yellow,Color.cyan,Color.magenta};
        for(int i  =  0; i < col1.length;++i){
            colors.put(i,col1[i]);
        }
    }
    public void decide(){
        int randomized = random.nextInt(8);
        nextState = (getSteps() % 2 ==0 ? Artefact.ACTIVE:Artefact.INACTIVE);
        this.color = colors.get(randomized);
    }
}
