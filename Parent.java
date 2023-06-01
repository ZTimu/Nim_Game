import java.util.Scanner;
class Parent{
    static String[] player=new  String[2];
    static char[][] pile=new char[5][5];

    static Scanner scanner = new Scanner(System.in);
    public static void fillzero(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++) {
                pile[i][j] = '.';
            }
        }
    }
    public static void reshape(int reshapepileno ,int reshapemove){// reshape function start
        int count=0;

        for(int j=0;j<5;j++){//for start
            if(pile[j][reshapepileno]=='O'){
                count++;
                pile[j][reshapepileno]='.';
                if(count==reshapemove){
                    break;
                }
            }
        }// end for
    }// reshape function end
    public static boolean moveapply(int pileno,int blocks){// moveapply start
        boolean checklastpile=false;
        int countblock=0;
        for(int j=0;j<5;j++){//for start
            if(pile[j][pileno]=='O'){
                countblock++;
            }
        }//for end
        if(countblock<blocks&& countblock!=0){
            return false;
        }

        reshape(pileno,blocks);
        return  true;
    }// moveapply end
    public static int show(){
        int x=0;
        for(int i=0;i<5;i++){
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
            for(int j=0;j<5;j++){
                if(pile[i][j]=='O')x++;
                System.out.print(pile[i][j]+ " ");
            }
            System.out.println();
        }
        return x;
    }
    public static void fill(int i,int x){

        for(int k=5-(x);k<5;k++){
            pile[k][i]='O';
        }
    }

    public static  int choice1(){
        int choice=0;
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("4. Back");
        choice = scanner.nextInt();scanner.nextLine();
        if (choice == 2 || choice == 3) {
            System.out.println("Sorry, Level is under development.");
            choice1();
        }
        else if(choice==4){
            return 4;
        }
        else if(choice==1){
            fillzero();
            // game start
            System.out.println("Enter first player name:\n");
            player[0]=scanner.nextLine();
            System.out.println("Enter second player name:\n");
            player[1]=scanner.nextLine();
            System.out.println(""+player[0]+" enter block of each piles\n");
            for(int i=0;i<5;i++){
                int x=0;
                System.out.print(i+1 +":");
                x=scanner.nextInt();
                fill(i,x);
            }
            int sum=show();
            int playerturn=1;
            while(sum!=0){
                System.out.println(""+player[playerturn%2]+ "'s move:\n");
                System.out.print("Pile no: ");

                int pileno=0;
                pileno=scanner.nextInt();
                System.out.print("No of Blocks: ");
                int blocks=0;
                blocks=scanner.nextInt();
                System.out.println();
                boolean checkifvalid=moveapply(pileno-1,blocks);
                if(!checkifvalid){
                    System.out.println("Invalid Move! Please try again.");
                    System.out.println();
                    playerturn--;
                }
                sum=show();
                playerturn++;
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+player[(playerturn+1)%2]+" Won!");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+player[(playerturn)%2]+" Lost!");
            System.out.println("\n\n\n");

        }
        return 4;
    }

    public static int func() {
        return 0;
    }
}
