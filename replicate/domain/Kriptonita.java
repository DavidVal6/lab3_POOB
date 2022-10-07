package domain;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Kriptonita is an artefact that implements Thing with the follow rules:
 * - Is round 
 * - Is green
 * - Only is active if has neighbours
 * - Reproduces new Kriptonites in the emptys neighbours
 * 
 * @author OlayaValencia 
 * @version 07/10/2022
 */
public class Kriptonita extends Artefact implements Thing {
    //private ArrayList<int[]> positions;      // Store the positions for the new Kriptonites neighbours 
    protected char nextState;
    protected Color color;
    private AManufacturing aManufactuing;
    private int row,column;

    /**
     * Constructor for objects of class Kriptonita
     */
    public Kriptonita(AManufacturing am,int row, int column, boolean active){
        aManufactuing=am;
        this.row=row;
        this.column=column;
        state=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        nextState=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        aManufactuing.setThing(row,column,(Thing)this);    
        color=Color.green;
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
    
    // public void reproduce() {
        // for(int i = 0 ; i < positions.size(); i++){
            // new Kriptonita(aManufactuing,positions.get(i)[0],positions.get(i)[1],true);
        // }
        // positions.clear();
    // }
    
    public void change() {
        step();
        for(int dr = -1; dr<2; dr++) {
            for(int dc = -1; dc<2; dc++) {
                if(neighborIsEmpty(dr,dc)){
                    int[] pos = {row+dr, column+dc};
                    aManufactuing.addPositions(pos);
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
    
    public int shape() { 
        return ROUND;   
    }
    
    public char getState(){
        return state;
    }
}
