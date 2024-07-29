import java.util.Scanner;
import java.util.Random;

public class Main{
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIPL 2024!!");
		Players.showTeams();
		
		System.out.print("Enter Your Team : ");
        String choice1 = scanner.next().toUpperCase();
        if (!Players.teams.containsKey(choice1)) {
            System.out.println("Team not found!");
            return;
        }
		System.out.print("Enter Opponent Team : ");
        String choice2 = scanner.next().toUpperCase();
		if (!Players.teams.containsKey(choice2)) {
            System.out.println("Team not found!");
            return;
        }

		
        String[] user = Players.teams.get(choice1);

        String[] computer = Players.teams.get(choice2);

	
        System.out.println("\nToss time!");
        System.out.print("Enter H/T : ");
        char toss = scanner.next().toUpperCase().charAt(0);
		boolean isHead = new Random().nextBoolean();
		char res = isHead ?'H':'T';

        boolean BatFirst = false;
        if (toss == res) {
            System.out.println("You won the toss!");
            System.out.print("Choose 'bat' or 'bowl' : ");
            String Decision = scanner.next();
            if (Decision.equalsIgnoreCase("bat")) {
                BatFirst = true;
				System.out.println(choice1+" Selected To Bat First");
            }else{
				System.out.println(choice1 +" Selected To Bowl First");
			}
        } else {
            System.out.println("You lost the toss!");
			System.out.println(choice2 + " Selected To Bat First");
        }

        if(BatFirst) {
            Innings.batting(user,computer,true);
            Innings.bowling(user,computer,false);
        } else {
            Innings.bowling(user,computer,true);
            Innings.batting(user,computer,false);
        }
    }
}
