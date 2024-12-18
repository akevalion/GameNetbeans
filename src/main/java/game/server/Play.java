/*
 */
package game.server;

import game.server.calc.Calculator;
import game.server.calc.FullCalculator;
import game.server.calc.NumberCalculator;
import game.server.calc.StairsCalculator;

/**
 *
 * @author milton
 */
public enum Play {
    BALAS(0),
    TONTOS(1),
    TRENES(2),
    CUADRAS(3),
    QUINAS(4),
    SENAS(5),
    ESCALERA(6, new StairsCalculator()),
    FULL(7, new FullCalculator()),
    POKER(8/*, new PokerCalculator()*/),
    GRANDE1(9/*, new BigCalculator()*/),
    GRANDE2(10/*, new BigCalculator()*/),
    DORMIDA(11/*, new WowCalculator()*/);
    private int index;
    private Calculator calc;
    Play(int index){
        this(index, new NumberCalculator(index + 1));
    }
    
    Play(int index, Calculator calc){
        this.index = index;
        this.calc = calc;
    }
    
    public int getIndex(){
        return index;
    }
    
    public int sumFirstShoot(int[] dices){
        return calc.firstShoot(dices);
    }
    
    public int sumSecondShoot(int[] dices){
        return calc.secondShoot(dices);
    }
}
