package TokenRing;

import java.util.Random;


public class Computer {
    private int number;
    private String IP;
    public Computer next;
    public Computer previous;

    public Computer(){}

    public Computer(int number) {
        this.number = number;
        this.IP=generateIp();
        next=null;
        previous=null;
    }

    private String generateIp(){
        Random rand = new Random(System.currentTimeMillis());
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }

    public int getNumber() {
        return number;
    }

    public Computer directionOfIteration(char direction){
        if (direction=='0')
            return this.next;
        else return this.previous;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return IP.equals(computer.IP);
    }

    @Override
    public String toString() {
        return "TokenRing.Computer{" +
                "number=" + number +
                ", next=" + next.getNumber() +
                ", previous=" + previous.getNumber() +
                '}';
    }
}
