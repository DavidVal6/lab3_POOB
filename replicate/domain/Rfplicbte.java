package domain;
import java.awt.Color;


/**
 * Write a description of class Rfplicbte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rfplicbte extends Cell {
    private AManufacturing aManufactuing;
    private int row,column;

    /**
     * Create a new Rfplicbte cell (<b>row,column</b>) in the aManufactuing <b>ac</b>..
     * @param am
     * @param row
     * @param column
     * @param active
     */
    public Rfplicbte(AManufacturing am,int row, int column, boolean active)
    {
        super(am,row,column,active);
        aManufactuing = am;
        this.color = Color.blue;
        this.row = row;
        this.column = column;
    }
    
    /**
     * set the next state, if has a odd number of neighours plus himself (if is active), then set active
     *                      else if has number even set inactive
     */
    public void decide() {
        int neighbours = neighborsActive();
        if(getState() == 'a') {
            neighbours++;
        }
        nextState = (neighbours%2 == 0 ? Artefact.INACTIVE:Artefact.ACTIVE);
    }
}
