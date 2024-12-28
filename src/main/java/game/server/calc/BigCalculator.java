/*
 */
package game.server.calc;

import game.server.calc.Calculator;

/**
 *
 * @author milton
 */
public class BigCalculator implements Calculator {

    @Override
    public int firstShoot(int[] dice) {
        return 0;
    }

    @Override
    public int secondShoot(int[] dice) {
        if (Calculator.sum(dice) == dice[0]*dice.length)
            return 0;
        return Calculator.groupSize(Calculator.transform(dice)) == 1? 50: 0;
    }
    
}
