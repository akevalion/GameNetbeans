
package game.server.calc;

/**
 *
 * @author pi
 */
public class NumberCalculator implements Calculator{
    private int value;
    
    public NumberCalculator(int value){
        this.value=value;
    }
    @Override
    public int firstShoot(int[] dice) {
        int result = 0;
        for(int x : dice)
            if (x==value)
                result += x;
        return result;
    }

    @Override
    public int secondShoot(int[] dice) {
        int result = 0;
        int turns = 0;
        for(int x : dice)
            if (x==value)
                result += value;
            else if (x == (7 - value)){
                result += value;
                turns ++;
            }
        int diff = 0;
        if (turns > 2)
            diff = turns - 2;
        else if(turns == 0 && result == (value * dice.length))
            diff = 1;
        return result - value * diff;
    }
}
