package Lab4;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int [] u = {4, 3, 9, 5, 1, 6, 2, 7, 8};
 
        boolean isSorted = false;
        int b;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < u.length-1; i++) {
                if(u[i] > u[i+1]){
                    isSorted = false;
 
                    b = u[i];
                    u[i] = u[i+1];
                    u[i+1] = b;
                }
            }
        }
        System.out.println(Arrays.toString(u));
    }
}

