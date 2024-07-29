import java.util.Scanner;
class Innings{
	
	static final int OVERS = 3;
    static final int PLAYERS = 5;
    static final int BALLS_IN_OVER = 6;
    static final int WICKETS = 5;
    static final int MAX_RUN = 6;
	static int target ;

	
	static void batting(String[] battingTeam, String[] bowlingTeam,boolean firstInn) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nLet's start the innings!");
		
		int batsman=0,bowler=2,individualRun = 0,totalScore = 0,indBallfaced = 0,wickets = 0,overs = 0,balls = 0;

        while (overs < OVERS && wickets < WICKETS){
            System.out.print("Press Enter to bat...");
            scanner.nextLine();
            int runsScored = (int) (Math.random() * (BALLS_IN_OVER + 1));
            if (runsScored == 5) {
				System.out.println("-----------------------------------");
				System.out.println("Runs scored : W");
                System.out.println(battingTeam[batsman]+" Out!");
                wickets++;
				batsman++;
				if(batsman==5 && firstInn){
					target = totalScore;
					break;
				}else if(batsman==5){
					System.out.println("you loss by "+(target-totalScore)+" Runs");
					break;
				}
				individualRun = 0;
				indBallfaced = 0;
            } else {
				System.out.println("-----------------------------------");
				System.out.println("Runs scored : " + runsScored);
                totalScore += runsScored;
				individualRun +=runsScored;
				indBallfaced++;
            }
			System.out.println("-----------------------------------");
			System.out.print(battingTeam[batsman]+" : "+individualRun);
			System.out.print("("+ indBallfaced +")");
            System.out.println(" Total Score: " + totalScore + "/" + wickets);
            System.out.print("Bowler : " +bowlingTeam[bowler]);
			System.out.println(" Over " + overs  + " : " + ++balls);
			System.out.println("-----------------------------------");
			if(!firstInn && target<=totalScore){
				System.out.println("YOU Won by "+(WICKETS-batsman)+"wickets");
				break;
			}
            if (balls == BALLS_IN_OVER || wickets == WICKETS) {
				if(overs!=2){
					bowler++;
				}
                balls = 0;
                overs++;
            }
		}
		if(firstInn){
			target = totalScore+1;
			System.out.println("\n~~~~~~~~~~~~");
			System.out.println(" TARGET "+target);
			System.out.println("~~~~~~~~~~~~");
		}else if(target>totalScore){
			System.out.println("you loss by "+(target-totalScore)+" Runs");
		}
	}
	
	static void bowling(String[] bowlingTeam,String[] battingTeam,boolean firstInn) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nLet's start the innings!");
		
		int batsman=0,bowler=2,individualRun = 0,totalScore = 0,indBallfaced = 0,wickets = 0,overs = 0,balls = 0;

        while (overs < OVERS && wickets < WICKETS) {
	
            System.out.print("Press Enter to bowl...");
            scanner.nextLine();
            int runsScored = (int) (Math.random() * (BALLS_IN_OVER + 1));
            if (runsScored == 5) {
				System.out.println("-----------------------------------");
				System.out.println("Runs scored : W");
                System.out.println(battingTeam[batsman]+" Out!");
                wickets++;
				batsman++;
				if(batsman==5 && firstInn){
					target = totalScore;
					break;
				}else if(batsman==5){
					System.out.println("you loss by "+(target-totalScore)+" Runs");
					break;
				}
				individualRun = 0;
				indBallfaced = 0;
            } else {
				System.out.println("-----------------------------------");
				System.out.println("Runs scored : " + runsScored);
                totalScore += runsScored;
				individualRun +=runsScored;
				indBallfaced++;
            }
			System.out.println("-----------------------------------");
			System.out.print(battingTeam[batsman]+" : "+individualRun);
			System.out.print("("+ indBallfaced +")");
            System.out.println(" Total Score: " + totalScore + "/" + wickets);
			System.out.print("Bowler : " +bowlingTeam[bowler]);
			System.out.println(" Over " + overs + " : " + ++balls);
			System.out.println("-----------------------------------");
			if(!firstInn && target<=totalScore){
				System.out.println("Opponent Won by "+(WICKETS-batsman)+"wickets");
				break;
			}
            if (balls == BALLS_IN_OVER || wickets == WICKETS) {
				if(overs!=2){
					bowler++;
				}
                balls = 0;
                overs++;
            }
		}
		if(firstInn){
			target = totalScore+1;
			System.out.println("\n~~~~~~~~~~~~");
			System.out.println(" TARGET "+target);
			System.out.println("~~~~~~~~~~~~");
		}else if(target>totalScore){
			System.out.println("you won by "+(target-totalScore)+" Runs");
		}
	}
}