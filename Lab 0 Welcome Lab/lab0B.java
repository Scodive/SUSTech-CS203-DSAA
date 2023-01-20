import java.util.Scanner;
public class pokergame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String dealer = input.next();
        String card1 = input.next();
        String card2 = input.next();
        String card3 = input.next();
        String card4 = input.next();
        String card5 = input.next();
        if(dealer.substring(0,1).equals(card1.substring(0,1))||dealer.substring(0,1).equals(card2.substring(0,1))||
                dealer.substring(0,1).equals(card3.substring(0,1))||dealer.substring(0,1).equals(card4.substring(0,1))||
                dealer.substring(0,1).equals(card5.substring(0,1))||dealer.substring(1).equals(card1.substring(1))||dealer.substring(1).equals(card2.substring(1))||
                dealer.substring(1).equals(card3.substring(1))||dealer.substring(1).equals(card4.substring(1))||
                dealer.substring(1).equals(card5.substring(1))){System.out.println("All in");}
        else System.out.println("Fold");
    }
}
