package TokenRing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Token {
    private String sourceIp;
    private String destinationIp;
    private String message;
    private boolean reachedDestination;
    private boolean freeForUse;
    private List<Integer> history;

    public Token() {

        freeForUse=true;
        history=new ArrayList<Integer>();
    }

    public String getSourceIp() { return sourceIp; }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getDestinationIp() {
        return destinationIp;
    }

    public void setDestinationIp(String destinationIp) {
        this.destinationIp = destinationIp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isReachedDestination() {
        return reachedDestination;
    }

    public void setReachedDestination(boolean reachedDestination) {
        this.reachedDestination = reachedDestination;
    }

    public boolean isFreeForUse() {
        return freeForUse;
    }

    public void setFreeForUse(boolean freeForUse) {
        this.freeForUse = freeForUse;
    }

    public List<Integer> getHistory() {
        return history;
    }

    public void setHistory(List<Integer> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "TokenRing.Token{" +
                "sourceIp='" + sourceIp + '\'' +
                ", destinationIp='" + destinationIp + '\'' +
                ", message='" + message + '\'' +
                ", reachedDestination=" + reachedDestination +
                ", freeForUse=" + freeForUse +
                ", history=" + history +
                '}';
    }
}
