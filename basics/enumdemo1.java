class enumdemo1{
	public enum levels {EASY , MEDIUM , HARD}
	public static void main(String[] args){
		for( levels l : levels.values())
		System.out.println(l);
		levels yourlevel = levels.HARD;
		switch(yourlevel){
			case EASY :
			System.out.println("your level is "+yourlevel);
			break;
			case MEDIUM :
			System.out.println("your level is "+yourlevel);
			break;
			case HARD :
			System.out.println("your level is "+yourlevel);
			break;
			default :
			System.out.println("select your level ");
			break;
		}
	}
}