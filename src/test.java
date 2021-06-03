
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Scanner;


public class test {
    public static int answer(int k){
        if(k==1){
            return 4;
        }
        else{
            return 4 * answer(k-1);
        }
    }
    static void printString(String str){
        if(str.length() > 0){
            printString(str.substring(1));
            System.out.println(str.substring(0,1));
 
        }
    }
}
   class Exercise3 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter your specialization you are interested in: ");
        String specialization = input.nextLine();

        System.out.println("Hey, my name is " + name + " and my ID number is " + id + ". The Specialization that I am interested in is " + specialization);

    }
}
