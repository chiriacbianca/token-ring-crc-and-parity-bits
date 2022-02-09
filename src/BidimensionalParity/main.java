package BidimensionalParity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File ("C:\\Users\\bianca info\\IdeaProjects\\com.teme.retele\\src\\BidimensionalParity\\data.txt"));
        BidimensionalParity bidimensionalParity=new BidimensionalParity(input);
        System.out.println("Final message: "+bidimensionalParity.finalMessage());
    }
}
