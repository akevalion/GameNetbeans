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
        return check(groups)?45:0;
    }
    private boolean check(int[] groups){
        return groups.length == 2 && (groups[0] == 1 || groups[0] == 4);
    }

    @Override
    public int secondShoot(int[] dice) {
        int[] transformedDice = Calculator.transform(dice);
        int[] groups = Calculator.groups(transformedDice);
        return (groups.length == 1 || this.check(groups))?40:0;
    }
}
