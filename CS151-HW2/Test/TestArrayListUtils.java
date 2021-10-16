import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class TestArrayListUtils {
    @Test public void testSum()
    {
        int sum = 6;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int sum2 = ArrayListUtils.sum(arr);
        assertTrue(sum == sum2);
    }
}
