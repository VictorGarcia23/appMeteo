import com.tecnara.weather.server.domain.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Coordinates_Test {
    @Test
    public void test_of_coordinates(){
        Coordinates coor = new Coordinates();
        float lonTest = 5.25f;
        float latTest = 6.25f;
        coor.setLon(5.25f);
        coor.setLat(6.25f);
        Assertions.assertEquals(lonTest,coor.getLon());
        Assertions.assertEquals(latTest, coor.getLat());
    }
}
