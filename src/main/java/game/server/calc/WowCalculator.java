/*
 */
package game.server.calc;

/**
 *
 * @author milton
 */
public class WowCalculator implements Calculator {

    @Override
    public int firstShoot(int[] dice) {
        return Calculator.sum(dice) == dice[0]* dice.length? Integer.MAX_VALUE: 0;
    }

    @Override
    public int secondShoot(int[] dice) {
        return 0;
    }
    
}
