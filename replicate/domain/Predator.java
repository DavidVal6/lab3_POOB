package domain;

import java.awt.Color;
import java.util.ArrayList;


/**
 * Write a description of class Predator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Predator extends Artefact implements Thing {
    // instance variables - replace the example below with your own
    protected char nextState;
    protected Color color;
    private AManufacturing aManufactuing;
    private int row,column;

    /**
     * Constructor for objects of class Kriptonita
     */
    public Predator(AManufacturing am,int row, int column, boolean active){
        aManufactuing=am;
        this.row=row;
        this.column=column;
        state=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        nextState=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        aManufactuing.setThing(row,column,(Thing)this);
        color=Color.gray;
        //positions = new ArrayList();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public int getRow() {
        return row;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public int getColumn() {
        return column;
    }

    public final Color getColor(){
        return color;
    }
    
    public void change() {
        step();
        for(int dr = -1; dr<2; dr++) {
            for(int dc = -1; dc<2; dc++) {
                if(neighborIsOccupied(dr,dc)){
                    int[] pos = {row+dr, column+dc};
                    aManufactuing.addPositions(pos, 1);
                    //positions.add(pos);
                }
            }
        }
        state=nextState;
    }

    public void decide() {
        nextState=(neighborsActive()>0 ? Artefact.ACTIVE:Artefact.INACTIVE);
    }

    public int neighborsActive(){
        return aManufactuing.neighborsActive(row,column);
    }

    public boolean neighborIsEmpty(int dr,int dc){
        return aManufactuing.isEmpty(row+dr,column+dc);
    }
    
    public boolean neighborIsOccupied(int dr,int dc){
        return aManufactuing.isOccupied(row+dr,column+dc);
    }
    
    public int shape() {
        return ROUND;
    }

    public char getState(){
        return state;
    }
}

