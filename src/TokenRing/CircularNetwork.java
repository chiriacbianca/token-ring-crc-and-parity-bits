package TokenRing;

import java.util.ArrayList;
import java.util.List;

public class CircularNetwork {
    public Computer first;
    public Token token;


    public CircularNetwork(Token token) {
        first=null;
        this.token=token;
    }

    public void addComputer(int number){
        Computer current=new Computer(number);
        if (first==null){
            first=current;
            first.previous=current;
            first.next=current;
        }
        else {
            Computer iterator=first;
            while (iterator.next!=first)
                iterator=iterator.next;
            iterator.next=current;
            current.previous=iterator;
            current.next=first;
            first.previous=current;
        }
    }

    public Computer searchComputer(int number){
        Computer iterator=first;
        do {
            if( iterator.getNumber()==number) {
                return iterator;
            }
            else {
                iterator=iterator.next;
            }
        } while (iterator!=first);
        return null;
    }

    public void passToken(char direction, int startComputer, int endComputer, String message){
        System.out.println("Initial token"+token.toString());
        Computer start=searchComputer(startComputer);
        Computer end=searchComputer(endComputer);
        if (start!=end){
            Computer iterator = start;
            System.out.println(iterator);
            List<Integer> localHistory=new ArrayList<Integer>();
            token.setReachedDestination(false);
            token.setFreeForUse(false);
            token.setMessage(message);
            token.setSourceIp(start.getIP());
            token.setDestinationIp(end.getIP());
            do{
                localHistory.add(iterator.getNumber());
                token.setHistory(localHistory);
                if (iterator==end){
                    System.out.println("Message received: "+token.getMessage());
                    token.setMessage(null);
                    token.setReachedDestination(true);
                }
                System.out.println("TokenRing.Computer: "+iterator.getNumber()+" "+token);
                iterator=iterator.directionOfIteration(direction);
            } while (iterator!=start);
            token.setSourceIp(null);
            token.setDestinationIp(null);
            token.setFreeForUse(true);
            localHistory.add(start.getNumber());
            token.setHistory(localHistory);
            System.out.println("TokenRing.Computer: "+start.getNumber()+" "+token);
        }
    }
}
