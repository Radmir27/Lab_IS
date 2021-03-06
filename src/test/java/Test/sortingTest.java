package Test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class sortingTest {

    private int az;

    @BeforeClass
    public static void prisvoenieTest() {
    int az = (int) (Math.random()*70 +20);
    }

    @Test
    public void sortingTest() {
        int[] a = new int[9];
        for (int i = 0; i < 9; i++) {
            prisvoenieTest();
            a[i] = az;
        }
        boolean isSorted = false;
        int b;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < (a.length -1) ; i++) {
                if(a[i] > a[i+1]){
                    isSorted = false;
 
                    b = a[i];
                    a[i] = a[i+1];
                    a[i+1] = b;
                }
            }
        }
        for (int i = 0; i<8; i++) {
            assertTrue(a[i] <= a[i+1]);
        }

    }

    @AfterClass
    public static void vivodTest() {
            System.out.print("Проверка прошла успешно");

    }

}