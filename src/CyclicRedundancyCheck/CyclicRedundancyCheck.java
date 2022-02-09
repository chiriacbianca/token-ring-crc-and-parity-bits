package CyclicRedundancyCheck;

import com.sun.tools.corba.se.idl.constExpr.Xor;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class CyclicRedundancyCheck {
    public String sourceMessage;
    public String generatorCode;
    public String extendedPolynomial;

    public CyclicRedundancyCheck(Scanner scanner) {
        sourceMessage=scanner.nextLine();
        generatorCode=scanner.nextLine();
        for (int i = 0; i < sourceMessage.length(); i++) {
            if ((sourceMessage.charAt(i) != '1') && (sourceMessage.charAt(i) != '0')) {
                System.out.println("Message must be a sequence of 1 and 0");
                sourceMessage = null;
            }
        }
        for (int i = 0; i < generatorCode.length(); i++) {
            if ((generatorCode.charAt(i) != '0') && (generatorCode.charAt(i) != '1')) {
                System.out.println("Generator code must be a sequence of 1 and 0");
                generatorCode = null;
            }
        }
        if ((generatorCode.charAt(0) != '1') && (generatorCode.charAt(generatorCode.length() - 1) != '1')) {
            System.out.println("Generator code must start with 1 and end with 1!");
            generatorCode = null;
        }
        if ((sourceMessage != null) && (generatorCode != null)) {
            extendedPolynomial = sourceMessage;
            for (int i = 0; i < generatorCode.length() - 1; i++) {
                extendedPolynomial = extendedPolynomial + '0';
            }
        }
        System.out.println("Source message is: "+sourceMessage);
        System.out.println("Generator code is: "+generatorCode);
        System.out.println("Extended polynomial is: "+ extendedPolynomial);
    }

    public char XOR(char a, char b){
        if (a == b) {
            return '0';
        }
        return '1';
    }

    public String remainingXOR(String message){
        System.out.println(message);;
        System.out.println(generatorCode);
        String remainder = message;
        System.out.println("Remainder: "+ remainder);
        while (generatorCode.length() <= remainder.length()) {
            for (int i = 0; i < generatorCode.length(); i++) {

                //remainder=remainder.replace(remainder.charAt(i), XOR(remainder.charAt(i) ,generatorCode.charAt(i)));
                remainder=remainder.substring(0,i)+XOR(remainder.charAt(i) ,generatorCode.charAt(i))+remainder.substring(i+1);
            }
            if (remainder.indexOf('1')!=-1) {
                remainder = remainder.substring(remainder.indexOf('1'));
                System.out.println("Remainder: " + remainder);
                System.out.println("Code: " + generatorCode);
            }
            else remainder="";
        }
        System.out.println("Reminder is: "+remainder);
        return remainder;
    }

    public String transmittedMessage(){
        String remainder = remainingXOR(extendedPolynomial);
        String transmittedMessage = extendedPolynomial;
        int length=transmittedMessage.length()-1;
        for (int i = 0; i < remainder.length(); i++) {
            transmittedMessage = transmittedMessage.substring(0, length - i) + XOR(remainder.charAt(remainder.length()-1 - i), transmittedMessage.charAt(length-i)) + transmittedMessage.substring(length +1- i );
            System.out.println("Message transmitted: "+transmittedMessage);
        }
        return transmittedMessage;
    }

    public String sendMessageWithError(){
        String messageWithError=transmittedMessage();
        Random rand = new Random(System.currentTimeMillis());
        int position=rand.nextInt(messageWithError.length());
        char changed='0';
        if(messageWithError.charAt(position)=='0')
            changed='1';
        messageWithError=messageWithError.substring(0,position)+changed+messageWithError.substring(position+1);
        System.out.println("Message with error:"+messageWithError);
        return messageWithError;
    }

    public void verifyMessage(char option){
        String finalMessage;
        if (option=='n')
            finalMessage=transmittedMessage();
        else
            finalMessage=sendMessageWithError();
        if (remainingXOR(finalMessage)=="")
            System.out.println("Message transmitted correctly");
        else
            System.out.println("Message transmitted with errors");
    }
}
