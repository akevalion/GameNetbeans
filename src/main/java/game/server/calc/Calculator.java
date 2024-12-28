
package game.server.calc;

import java.util.Arrays;

public interface Calculator {

    public static int[] map(int[] dice) {
        int[] map = new int[7];
        for(int x:dice)
            map[x]++;
        return map;
    }
    
    public static int[] groups(int[] dice){
        int[] map = new int[groupSize(dice)];
        int index = -1;
        int n = -1;
        for(int die: dice){
            if(die != n){
                index ++;
                n = die;
            }
            map[index]++;
        }
            
        return map;
    }

    public static int groupSize(int[] dice){
        Arrays.sort(dice);
        int n = -1;
        int counter = 0;
        for (int x : dice) {
            if (n != x) {
                n = x;
                counter++;
            }
        }
        return counter;
    }

    public static int[] transform(int[] dice){
        int[] transformed = new int[5];
        for(int k=0; k < dice.length; k++){
            int n = dice[k];
            if(n>3)
                n = 7-n;
            transformed[k] = n;
        }
        return transformed;
    }

    public static int sum(int[] dice){
        int sum = 0;
        for(int k : dice)
            sum += k;
        return sum;
    }
    
    int firstShoot(int[] dice);
    int secondShoot(int[] dice);
    
}
