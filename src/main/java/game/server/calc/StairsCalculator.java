
package game.server.calc;

import java.util.Arrays;

public class StairsCalculator implements Calculator{

    @Override
    public int firstShoot(int[] dice) {
        Arrays.sort(dice);
        int [][] validAnswers = {
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 6},
            {1, 3, 4, 5, 6}
        };
        for (int [] answer: validAnswers)
            if(Arrays.equals(answer, dice))
                return 25;
        return 0;
    }

    @Override
    public int secondShoot(int[] dice) {
        return 20;
    }
    
}
