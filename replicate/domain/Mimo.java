package domain;
import java.awt.Color;
import java.util.HashMap;


/**
 * A Mimo Cell copy the state of his neighbours in a clock sequence
 * 
 * @author (Mateo Olaya - David Valencia) 
 * @version 1.0
 */
public class Mimo extends Cell
{
    // instance variables - replace the example below with your own
    private AManufacturing aManufacturing;
    private int row,column;
    private int cicles;
    private HashMap<Integer,int[]> positions;
    
    /**Create a new Mimo cell (<b>row,column</b>) in the aManufactuing <b>ac</b>..
     * @param am
     * @param row
     * @param column
     * @param active
     */
    public Mimo(AManufacturing am,int row, int column, boolean active)
    {
        super(am,row,column,active);
        aManufacturing = am;
        color = Color.orange;
        this.row = row;
        this.column = column;
        positions = new HashMap();
        cicles = 0;
        fuller();
    }
    
    /**
     * This method inititalize the positions of the clock sequence in a HashMap
     */
    private void fuller(){
        int touple[] = {-1,0};
        positions.put(0,touple);
        int touple1[] = {-1,1};
        positions.put(1, touple1);
        int touple2[] = {0,1};
        positions.put(2,touple2);
        int touple3[] = {1,1};
        positions.put(3,touple3);
        int touple4[] = {1,0};
        positions.put(4,touple4);
        int touple5[] = {1,-1};
        positions.put(5,touple5);
        int touple6[] = {0,-1};
        positions.put(6,touple6);
        int touple7[] = {-1,-1};
        positions.put(7,touple7);
    }
    
    /**
     * set the nextState using the clock sequence
     */
    public void decide(){
        int c = getSteps()- 8 * cicles;
        int x = positions.get(c)[0];
        int y = positions.get(c)[1];
        int op1 = this.row + x;
        int op2 = this.column + y;
        if(!neighborIsEmpty(x, y)){
            if(aManufacturing.getThing(op1, op2) instanceof Cell){
                nextState = aManufacturing.getThing(op1, op2).getState();
            }
        }else{
            nextState = this.state;
        }
        if(c == 7){
            cicles++;
        }
    }
    
    public int neighborsActive(){
        return aManufacturing.neighborsActive(row,column);
    }
    
    public boolean neighborIsEmpty (int dr,int dc){
        return aManufacturing.isEmpty(row+dr,column+dc);
    }
}
