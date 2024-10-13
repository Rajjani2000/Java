import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;

public class InClassExercise {

	public static void main(String[] args) 
	{
		
		//Ans 1 use index and for loop to print element		

		ArrayList<String>  stringArrayList= new ArrayList<String>();
		
		
		stringArrayList.add("one");
		stringArrayList.add("two");
		stringArrayList.add("three");
		stringArrayList.add("four");
		stringArrayList.add("five");
		System.out.println("Printing using Index");
		
		
		
		
	for(int i=0;i< stringArrayList.size();i++)
		{
				System.out.println("Element at index "+ i + " " +stringArrayList.get(i));			
				
		}
	
		
	
	
		
		//Ans 1- 2 use iterator  and for loop to print element		
		Iterator<String> iterator = stringArrayList.iterator();
		System.out.println("Printing using  iterator");
		
		while(iterator.hasNext())
		{
			String element = iterator.next();
			System.out.println(element);
		}
	
		
		
		//Ans 1-3 using treeset  to print element
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("one");
		treeSet.add("two");
		treeSet.add("three");
		treeSet.add("four");
		treeSet.add("five");
		
		Iterator<String> iterator_new = treeSet.iterator();
		System.out.println("Printing using TreeSet iterator");
		
		while(iterator_new.hasNext())
		{
			String element_2 =iterator_new.next();
			System.out.println(element_2);
		}
		
		
		
		
		
		
		
		
		
	}

}
