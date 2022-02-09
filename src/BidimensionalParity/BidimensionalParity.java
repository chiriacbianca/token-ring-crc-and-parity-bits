package BidimensionalParity;

import java.util.Scanner;

public class BidimensionalParity {
    public String sourceMessage;
    private int numberOfRows;
    private char[][] matrix;


    public BidimensionalParity(Scanner scanner) {
        sourceMessage = scanner.nextLine();
        if (sourceMessage.length() % 7 != 0) {
            System.out.println("Message length must be a multiple of 7!");
            sourceMessage = null;
        } else {
            for (int i = 0; i < sourceMessage.length(); i++) {
                if ((sourceMessage.charAt(i) != '1') && (sourceMessage.charAt(i) != '0')) {
                    System.out.println("Message must be a sequence of 1 and 0");
                    sourceMessage = null;
                }
            }
            if (sourceMessage!=null){
                numberOfRows=sourceMessage.length()/7+1;
                System.out.println("Original message: "+sourceMessage);
            }
        }
    }

    public void creatingMatrix(){
        matrix=new char[numberOfRows][8];
        int line = 0;
        int i = 0;
        while (i < sourceMessage.length()) {
            for (int column = 0; column < 7; column++)
            {
                matrix[line][column] = sourceMessage.charAt(i);
                i++;
            }
            line++;
        }
    }

    public void completingMatrix(){
        creatingMatrix();
        for (int line = 0; line < numberOfRows-1; line++)
        {
            int counterOfOnes = 0;
            for (int column = 0; column < 7; column++)
            {
                if (matrix[line][column] == '1')
                {
                    counterOfOnes++;
                }
            }
            if (counterOfOnes % 2 == 0)
            {
                matrix[line][7] = '0';
            }
            else
            {
                matrix[line][7] = '1';
            }

        }
        for (int column = 0; column < 7; column++) {
            int counterOfOnes = 0;
            for (int line = 0; line < numberOfRows - 1; line++) {
                if (matrix[line][column] == '1')
                {
                    counterOfOnes++;
                }
            }
            if (counterOfOnes % 2 == 0)
            {
                matrix[numberOfRows-1][column] = '0';
            }
            else
            {
                matrix[numberOfRows-1][column] = '1';
            }
        }
    }

    public void displayMatrix(){
        completingMatrix();
        for (int line = 0; line < numberOfRows; line++) {
            for (int column = 0; column < 8; column++) {
                System.out.print(matrix[line][column]+" ");
            }
            System.out.println();
        }
    }

    public String finalMessage(){
        displayMatrix();
        String messageReceived="";
        for (int line = 0; line < numberOfRows; line++) {
            for (int column = 0; column < 8; column++) {
                messageReceived =messageReceived+ matrix[line][column];
            }
        }
        return messageReceived;
    }
}
