
import java.util.*;

public class Move {

    private String moveType;

    public Move() {
        String[] moves = {"R", "P", "S"};
        int pos = (int) (Math.random() * 3);
        moveType = moves[pos];
    }

    public Move(String uMv) {
        uMv = uMv.substring(0, 1).toUpperCase();
        // .toUpperCase() - refered StackOverflow
        moveType = uMv;
    }

    public String toString() {
        return moveType;
    }
}
