
package game.server.calc;

import java.util.Arrays;

public class StairsCalculator implements Calculator{

    public static int [][] VALID_ANSWERS = {
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 6},
            {1, 3, 4, 5, 6}
        };
    @Override
    public int firstShoot(int[] dice) {
        Arrays.sort(dice);
        for (int [] answer: VALID_ANSWERS)
            if(Arrays.equals(answer, dice))
                return 25;
        return 0;
    }

    @Override
    public int secondShoot(int[] dice){
        int[] n = Calculator.map(dice);
        if(n[3]+n[4]>2)
            return 0;
        return n[2]==1 && n[5]==0?0:20;
    }
    
}
