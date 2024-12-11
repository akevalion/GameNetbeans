/*
 */
package game.server;

/**
 *
 * @author milton
 */
public class TableUser {
    private Integer [] points;
    public TableUser(){
        points = new Integer[Play.values().length];
    }

    public Integer[] getPoints() {
        return points;
    }

    public void setPoints(Integer[] points) {
        this.points = points;
    }
    
    public boolean canPlay(Play play){
        return this.get(play) == null;
    }
    
    public void set(Play play, int value){
        points[play.getIndex()] = value;
    }
    
    public int totalPoints(){
        int sum = 0;
        for(Play x : Play.values()){
            Integer value = this.get(x);
            if(value != null)
                sum += value;
        }
        return sum;
    }
    
    @Override
    public String toString(){
        return TableUtils.print(this);
    }

    public Integer get(Play play) {
        return points[play.getIndex()];
    }
}
