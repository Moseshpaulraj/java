import java.util.*;
public class Players {
	static Map<String, String[]> teams = new HashMap<>();
	
	public static void showTeams(){
		
		String[] csk = {"RUTURAJ","DHONI","DUBE","JADEJA","PATHIRANA"};
		String[] rcb = {"FAF","KOHLI","MAXWEL","GREEN","JOSEPH"};
		String[] mi = {"ROHIT","SURYA","HARDIK","BUMRAH","COETZEE"};
		String[] srh = {"HEAD","KLAASEN","CUMMINS","BUVI","NATTU"};
		String[] lsg = {"KLRAHUL","DECOCK","STOINIS","BISHNOI","NAVEEN"};
		String[] kkr = {"NARINE","SHREYAS","RUSSELL","STARC","VARUN"};

        teams.put("CSK",csk );
        teams.put("RCB",rcb);
        teams.put("MI",mi);
        teams.put("SRH",srh);
        teams.put("LSG",lsg);
        teams.put("KKR",kkr);
		
		System.out.println("\nTOTAL TEAMS");
		System.out.println("==============================================");
        for (Map.Entry<String, String[]> entry : teams.entrySet()) {
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        }
		System.out.println("==============================================");
	}
}