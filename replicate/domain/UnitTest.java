package domain;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class UnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest
{
    @Test
    public void shouldCreateANewCell(){
        AManufacturing am1 = new AManufacturing();
        boolean flag = false;
        Thing[][] lattice = am1.getLattice(); 
        for(Thing[] b :lattice){
            for(Thing a : b){
                if(b != null){
                    flag = true;
                }
            }
        }
        assertTrue(flag);
    }
    @Test
    public void shouldAppearAndDessapear(){
        AManufacturing am1 = new AManufacturing();
        am1.ticTac();
        am1.ticTac();
        am1.ticTac();
        am1.ticTac();
        assertTrue(am1.getThing(2,2).isActive());
    }
    @Test
    public void shouldStayAlive(){
        AManufacturing am1 = new AManufacturing();
        am1.ticTac();
        am1.ticTac();
        am1.ticTac();
        am1.ticTac();
        assertTrue(am1.getThing(2,3).isActive());
    }
    
}
