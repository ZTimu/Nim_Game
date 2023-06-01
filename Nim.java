import java.util.Scanner;
public class Nim extends Parent {  // Nim inherited Parent

    public static void main(String[] args){// main start

        Nim nim = new Nim(); //object created

        nim.func();

    }// main end

    @override             ///pollymorphism

    public static int func(){// func start
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tW E L C O M E");
        System.out.println("1. Start game");
        System.out.println("2. Quit game");
        System.out.println("3. Instruction");
        System.out.println();
        System.out.println("Enter choice:");

        Encap encap = new Encap();
        encap.setOption(scanner.nextInt());

        int choice = encap.getOption();
        if(choice!=1&&choice!=2&&choice!=3){
            System.out.println("Invalid Move, Try Again");
            func();
        }
        if(choice==3){
            //set instruction
            int x=scanner.nextInt();
            if(x==1){
                func();
            }
        }
        else if(choice==2){
            return 1;
        }
        else if(choice==1) {
            int RETURNVALUE=choice1();
            if(RETURNVALUE==4){
                func();
            }
        }
        return  1;
    }


}