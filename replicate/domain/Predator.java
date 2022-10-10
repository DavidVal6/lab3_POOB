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
    protected char nextState;
    protected Color color;
    private AManufacturing aManufactuing;
    private int row,column;

    /**
     * Create a new Predator (<b>row,column</b>) in the aManufactuing <b>ac</b>..
     * @param am
     * @param row
     * @param column
     * @param active
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
     * return row
     */
    public int getRow() {
        return row;
    }

    /**
     * return column
     */
    public int getColumn() {
        return column;
    }

    public final Color getColor(){
        return color;
    }
    
    /**
     * change the state to the next state and incrase the steps
     */
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
    
    /**
     * decide the next state, if has neighbours actives then the next state is active, else inactive.
     */
    public void decide() {
        nextState=(neighborsActive()>0 ? Artefact.ACTIVE:Artefact.INACTIVE);
    }

    public int neighborsActive(){
        return aManufactuing.neighborsActive(row,column);
    }

    public boolean neighborIsEmpty(int dr,int dc){
        return aManufactuing.isEmpty(row+dr,column+dc);
    }
    
    /**
     * return if a neighbor exist in aManufacturing
     */
    public boolean neighborIsOccupied(int dr,int dc){
        return aManufactuing.isOccupied(row+dr,column+dc);
    }
    
    /**
     * set the shape as round 
     */
    public int shape() {
        return ROUND;
    }

    public char getState(){
        return state;
    }
}

