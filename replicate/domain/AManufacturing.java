package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
public class AManufacturing{
    static private int SIZE=50;
    private Thing[][] lattice;
    
    public AManufacturing() {
        lattice=new Thing[SIZE][SIZE];
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                lattice[r][c]=null;
            }
        }
        someThings();
    }

    public int  getSize(){
        return SIZE;
    }

    public Thing getThing(int r,int c){
        return lattice[r][c];
    }

    public void setThing(int r, int c, Thing e){
        lattice[r][c]=e;
    }
    
    public void someThings(){
        Cell simba = new Cell(this,1,1,true);
        Cell dala = new Cell(this,2,2,true);
        setThing(1,1,simba);
        setThing(2,2,dala);
    }
    /**+
     * This method is the getter for lattice matrix
     * @return
     */
    public Thing[][] getLattice(){
        return lattice;
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
     * This method should help us to see if in a exact point in the table(matrix) we got a cell or not
     * @param r
     * @param c
     * @return
     */
    public boolean isEmpty(int r, int c){
        return (inLatice(r,c) && lattice[r][c]==null);
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
        for(int i = 0; i < lattice.length;++i){
            for(int j = 0 ; j < lattice[i].length;++j){
                if(lattice[i][j] != null){
                    lattice[i][j].decide();
                    lattice[i][j].change();
                }
            }
        }
    }
    
}
