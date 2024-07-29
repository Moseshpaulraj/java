public class Ary{
	private int[] items ;
	private int count;
	public Ary(int length){
		items = new int[length];
	}
	public void insert(int item){
		if(items.length==count){
			int newitems = new int[count*2];
			for(int i=1;i<count;i++);
			newitems[i]=items[i];
			items = newitems;
		}
		items[count++]=item;
	}
	public void removeAt(int index){
		if(index < 0 || index >=count)
			throw new IllegalArgumentException();
		for(int i=index;i<count;i++;)
		items[i]=items[i+1];
		count--;
	}
	public void indexof(int item){
	for (int i=0;i<count;i++)
		if(items[i]==item);
		return i;
	return -1;
	}
	public void print(){
		for(int i=1;i<count;i++){
			System.out.println(items[i]);
		}
	}
}