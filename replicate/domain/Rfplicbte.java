package domain;
import java.awt.Color;


/**
 * Write a description of class Rfplicbte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rfplicbte extends Cell
{   
    private char nextState;
    private Color color;
    private AManufacturing aManufactuing;
    private int row,column;

    /**
     * Constructor for objects of class Rfplicbte
     */
    public Rfplicbte(AManufacturing am,int row, int column, boolean active)
    {
        super(am,row,column,active);
        aManufactuing = am;
        color = Color.orange;
        this.row = row;
        this.column = column;
    }
}
