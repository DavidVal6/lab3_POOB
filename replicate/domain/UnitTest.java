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
    public void shouldMakeANewAmanufacturing(){
        AManufacturing a1  = new AManufacturing();
        boolean flag = false;
        Thing[][] lat = a1.getLattice();
        for(Thing[] b : lat){
            for(Thing a : b){
                if(a != null){
                    flag = true;
                }
            }
        }
        assertTrue(flag);
    }
    
    @Test
    public void shouldMakeThreetTicTacs(){
        AManufacturing a1  = new AManufacturing();
        a1.ticTac();
        a1.ticTac();
        a1.ticTac();
        a1.ticTac();
        Thing[][] lat = a1.getLattice();
        assertTrue(lat[1][1].isActive());
    }
}
