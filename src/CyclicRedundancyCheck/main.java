package CyclicRedundancyCheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\bianca info\\IdeaProjects\\com.teme.retele\\src\\CyclicRedundancyCheck\\entryData.txt"));
        CyclicRedundancyCheck crc=new CyclicRedundancyCheck(input);
        Scanner consoleData=new Scanner(System.in);
        System.out.println("Do you want to send the message correctly? type n for no, anything else for yes");
        char option=consoleData.next().charAt(0);
        crc.verifyMessage(option);
    }
}
