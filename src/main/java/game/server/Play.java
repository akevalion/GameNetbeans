/*
 */
package game.server;

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
    ESCALERA(6),
    FULL(7),
    POKER(8),
    GRANDE1(9),
    GRANDE2(10),
    DORMIDA(11);
    private int index;
    Play(int index){
        this.index = index;
    }
    public int getIndex(){
        return index;
    }
}
