package game.server.calc;

/**
 *
 * @author pi
 */
public class FullCalculator implements Calculator {

    @Override
    public int firstShoot(int[] dice) {
        int[] groups = Calculator.groups(dice);
        return groups.length == 2 && (groups[0] == 2 || groups[0] == 3) ? 35 : 0;
    }

    @Override
    public int secondShoot(int[] dice) {
        int result = firstShoot(Calculator.transform(dice));
        return result == 0? 0: 30;
    }

}
