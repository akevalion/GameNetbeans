/*
 */
package game.server;

/**
 *
 * @author milton
 */
public class Game {
    
    private TableUser[] tables;
    private int index;
    
    public Game(){
        this(1);
    }
    
    public Game(int size){
        this.tables = new TableUser[size];
        while ( size --> 0)
            tables[size] = new TableUser();
        this.index = 0;
    }
    
    public TableUser[] getTables() {
        return tables;
    }

    public void setTables(TableUser[] tables) {
        this.tables = tables;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public TableUser getCurrentTable(){
        return this.tables[index];
    }
    
    public void next(){
        this.index = (this.index + 1) % this.tables.length;
    }
    
    public static int[] getDice(){
        int n = 5;
        int[] dice = new int[n];
        while (n-->0)
            dice[n] = (int)(Math.random()*6)+1;
        return dice;
    }
}
