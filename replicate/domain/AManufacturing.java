package domain;
import java.util.*;


/**Information about a AManufacturing<br>
<b>(size,lattice,newKriptonites,newPredators,newRfplicbte)</b><br>
<br>
 */
public class AManufacturing{
    static private int SIZE=50;
    private Thing[][] lattice;
    private ArrayList<int[]> newKriptonites;
    private ArrayList<int[]> newPredators;
    private ArrayList<int[]> newRfplicbte;
    boolean thereAreRep;
    
    /**Create a new AManufacturing
     */
    public AManufacturing() {
        lattice=new Thing[SIZE][SIZE];
        newKriptonites = new ArrayList();
        newPredators = new ArrayList();
        newRfplicbte = new ArrayList();
        thereAreRep = false;
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                lattice[r][c]=null;
            }
        }
        someThings();
    }
    
    /**
     * return the size of the board
     */
    public int  getSize(){
        return SIZE;
    }
    
    /**
     * return the Thing in the positions r,c in lattice
     * @param r,c are int, and are positions in lattice 
     */
    public Thing getThing(int r,int c){
        return lattice[r][c];
    }
    
    /**
     * set a thing in a especific position of lattice
     * @param r,c are int
     * @param e is Thing
     */
    public void setThing(int r, int c, Thing e){
        lattice[r][c]=e;
    }
    
    /**
     * create new Things
     */
    public void someThings(){
        // Cell simba = new Cell(this,1,1,true);
        // Cell dala = new Cell(this,2,2,true);
        // Kriptonita uone = new Kriptonita(this, 0,0,true);
        // Kriptonita two = new Kriptonita(this, 49,0,true);
        // Kriptonita three = new Kriptonita(this, 0,49,true);
        // Kriptonita four = new Kriptonita(this, 49,49,true);
        // Mimo mufasa = new Mimo(this,2,3,true);
        // Mimo scar = new Mimo(this,2,4,true);
        // Mimo rafiki = new Mimo(this,2,5,true);

        // // Ciclo 4
        // crazyCell asmodeo = new crazyCell(this,25,25,true);
        // crazyCell mateo = new crazyCell(this,26,26,true);
        
        // // Ciclo 5
        // Predator predAlien = new Predator(this, 3,3, true);
        // Predator feralPredator = new Predator(this, 12, 13, true);
        
        // Rfplicbte
        Rfplicbte auto1 = new Rfplicbte(this,25,24,true);
        Rfplicbte auto2 = new Rfplicbte(this,25,25,true);
        Rfplicbte auto3 = new Rfplicbte(this,24,25,true);
        thereAreRep = true;
    }

    /**
     * This method search if i have activecell as a neighbor in some exact point in the table(matrix)
     * @param r
     * @param c
     * @return
     */
    public int neighborsActive(int r, int c){
        int num=0;
        for(int dr=-1; dr<2;dr++){
            for (int dc=-1; dc<2;dc++){
                if ((dr!=0 || dc!=0) && inLatice(r+dr,c+dc) &&
                    (lattice[r+dr][c+dc]!=null) &&  (lattice[r+dr][c+dc].isActive())) num++;
            }
        }
        return (inLatice(r,c) ? num : 0);
    }
    
    /**
     * This method should help us to see if in a exact point in the table(matrix) we not got a cell
     * @param r
     * @param c
     * @return
     */
    public boolean isEmpty(int r, int c){
        return (inLatice(r,c) && lattice[r][c]==null);
    }
    
    /**
     * This method should help us to see if in a exact point in the table(matrix) we got a cell
     * @param r
     * @param c
     * @return
     */
    public boolean isOccupied(int r, int c){
        return (inLatice(r,c) && lattice[r][c]!=null);
    }
    
    /**
     *     This method should confirm if the cells that we wanna check is inside the geme table or not
     * @param r
     * @param c
     * @return
     */
    private boolean inLatice(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }
    
    /**
     * This method just search inside the matriz of lattice and make the tic tac for this case that every 3 times the pair of cells will appear and desapper
     */
    public void ticTac(){
        if(thereAreRep){
            for(int i = 0; i < lattice.length;++i){
                for(int j = 0 ; j < lattice[i].length;++j){
                    if(isEmpty(i,j)){
                        if(neighborsActive(i, j)%2 == 1){
                            int[] pos = {i,j};
                            addPositions(pos, 2);
                        }
                    }
                }
            }
        }
        for(int i = 0; i < lattice.length;++i){
            for(int j = 0 ; j < lattice[i].length;++j){
                if(!isEmpty(i,j)){
                    lattice[i][j].decide();
                }
            }
        }
        for(int i = 0; i < lattice.length;++i){
            for(int j = 0 ; j < lattice[i].length;++j){
                if(!isEmpty(i,j)){
                    lattice[i][j].change();
                }
            }
        }
        reproduce();
        eat();
        replicate();
    }
    
    /**
     * this method help us to create new kriptonites when the old kriptonites reproduces themselves
     */
    public void reproduce() {
        for(int i = 0 ; i < newKriptonites.size(); i++){
            new Kriptonita(this,newKriptonites.get(i)[0],newKriptonites.get(i)[1],true);
        }
        newKriptonites.clear();
    }
    
    /**
     * This method help us to replace the Things for predators when they eats
     */
    public void eat() {
        for(int i = 0 ; i < newPredators.size(); i++){
            new Predator(this,newPredators.get(i)[0],newPredators.get(i)[1],true);
        }
        newPredators.clear();
    }
    
    /**
     * This method help us to create new Rfplicbte when success the conditions
     */
    public void replicate() {
        for(int i = 0 ; i < newRfplicbte.size(); i++){
            new Rfplicbte(this,newRfplicbte.get(i)[0],newRfplicbte.get(i)[1],true);
        }
        newRfplicbte.clear();
    }
    
    /**
     * this method help us to store de positions of new Kriptonites, Predators or Rfplicbtes
     */
    public void addPositions(int[] pair, int w) {
        if(w == 0){
            newKriptonites.add(pair);    
        } else if(w == 1) {
            newPredators.add(pair);
        } else if(w == 2) {
            newRfplicbte.add(pair);
        }
    }
    
    /**
     * return the lattice
     */
    public Thing[][] getLattice(){
        return lattice;
    }
}
