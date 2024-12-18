package game.server.calc;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author pi
 */
public class FullCalculator implements Calculator {

    @Override
    public int firstShoot(int[] dice) {
        Arrays.sort(dice);
        int n = -1;
        int counter = 0;
        for (int x : dice) {
            if (n != x) {
                n = x;
                counter++;
            }
        }
        return counter == 2 ? 35 : 0;
    }

    @Override
    public int secondShoot(int[] dice) {
        int[] transformed = new int[6];
        for(int k=0; k < dice.length; k++){
            int n = dice[k];
            if(n>3)
                n = 7-n;
            transformed[k] = n;
        }
        return firstShoot(transformed);
    }

}
