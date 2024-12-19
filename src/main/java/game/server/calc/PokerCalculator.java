/*
 */
package game.server.calc;

/**
 *
 * @author milton
 */
public class PokerCalculator implements Calculator{

    @Override
    public int firstShoot(int[] dice) {
        int[] groups = Calculator.groups(dice);
        return groups.length == 2 && (groups[0] == 1 || groups[0] == 4) ? 45 : 0;
    }

    @Override
    public int secondShoot(int[] dice) {
        int result = firstShoot(Calculator.transform(dice));
        return result == 0? 0: 40;
    }
}
