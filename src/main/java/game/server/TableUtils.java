/*
 */
package game.server;

/**
 *
 * @author milton
 */
public class TableUtils {

    public static String print(TableUser aTable) {
        StringBuilder b = new StringBuilder();
        
        b.append("┌────┬────┬────┐").append(System.lineSeparator());
        print(b, aTable, Play.BALAS, Play.ESCALERA, Play.CUADRAS);
        b.append("├────┼────┼────┤").append(System.lineSeparator());
        print(b, aTable, Play.TONTOS, Play.FULL, Play.QUINAS);
        b.append("├────┼────┼────┤").append(System.lineSeparator());
        print(b, aTable, Play.TRENES, Play.POKER, Play.SENAS);
        b.append("└────┼────┼────┘").append(System.lineSeparator());
        printGrande(b, aTable, Play.GRANDE1);
        b.append("     ├────┤").append(System.lineSeparator());
        printGrande(b, aTable, Play.GRANDE2);
        b.append("     └────┘");
        
        return b.toString();
    }

    private static void print(StringBuilder b, TableUser aTable, Play play0, Play play1, Play play2) {
        b.append("│ ");
        print(b, aTable, play0);
        b.append(" │ ");
        print(b, aTable, play1);
        b.append(" │ ");
        print(b, aTable, play2);
        b.append(" │");
        b.append(System.lineSeparator());
    }

    private static void print(StringBuilder b, TableUser aTable, Play play) {
        Integer value = aTable.get(play);
        if(value == null)
            b.append("  ");
        else if(value < 10){
            b.append(" ");
            b.append(value);
        }else
            b.append(value);
    }

    private static void printGrande(StringBuilder b, TableUser aTable, Play play) {
        b.append("     │ ");
        print(b, aTable, play);
        b.append(" │");
        b.append(System.lineSeparator());
    }
    
}
