
package game.server.calc;

import java.util.HashMap;

public interface Calculator {

    public static int[] map(int[] dice) {
        int[] map = new int[7];
        for(int x:dice)
            map[x]++;
        return map;
    }
    public static HashMap<Integer, Integer> groups(int[] dice){
        HashMap<Integer, Integer> map = new HashMap();
        for(int x: dice)
            map.put(x, map.getOrDefault(x, 0)+1);
        return map;
    }
    
    int firstShoot(int[] dice);
    int secondShoot(int[] dice);
    
}
