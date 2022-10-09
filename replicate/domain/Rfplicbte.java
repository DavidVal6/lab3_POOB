package domain;
import java.awt.Color;


/**
 * Write a description of class Rfplicbte here.
 * 
 * @author (Olaya - Valencia) 
 *  
*/
public class Rfplicbte extends Cell
{   
    private char nextState;
    private Color color;
    private AManufacturing aManufactuing;
    private int row,column;
    private int[][] innerMatrix;
    /**
     * Constructor for objects of class Rfplicbte
     */
    public Rfplicbte(AManufacturing am,int row, int column, boolean active)
    {
        super(am,row,column,active);
        aManufactuing = am;
        color = Color.blue;
        this.row = row;
        this.column = column;
        innerMatrix = new int[3][3];
        fuller();
    }
    private void fuller(){
        
    }
    /**
     * This method should made the decision between steps in the final step
     */
    public void decide(){
        
    }
    
    
}
