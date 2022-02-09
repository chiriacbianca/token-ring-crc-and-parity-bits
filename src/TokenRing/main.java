package TokenRing;

import TokenRing.CircularNetwork;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner readData=new Scanner(System.in);

        System.out.println("How many computers does your network  have? ");
        int numberOfComputers=readData.nextInt();
        Token messageToken=new Token();
        CircularNetwork tokenRing=new CircularNetwork(messageToken);
        for (int i=1;i<=numberOfComputers;i++){
            tokenRing.addComputer(i);
        }

        char option='y';
        while (option=='y'){

            System.out.println("TokenRing.Computer sending the message: ");
            int sender=readData.nextInt();
            System.out.println("TokenRing.Computer receiving the message: ");
            int receiver=readData.nextInt();
            if ((sender < 1) || (receiver < 1) || (sender > numberOfComputers) ||(receiver>numberOfComputers)){
                System.out.println("The numbers you introduced are out of range!");
                break;
            }

            System.out.println("Choose the direction: 0 for clockwise, anything else for opposite direction");
            char directionOfMoving=readData.next().charAt(0);
            System.out.println("Write the message you want to pass:");
            readData.nextLine();
            String message= readData.nextLine();

            tokenRing.passToken(directionOfMoving,sender,receiver, message);
            System.out.println("Do you want to pass another message? (y for yes, anything else for no)");
            option=readData.next().charAt(0);
        }
        System.out.println("Thank you for using this program!");
    }
}
