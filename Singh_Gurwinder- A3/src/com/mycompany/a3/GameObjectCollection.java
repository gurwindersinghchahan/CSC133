
package com.mycompany.a3;
import java.util.ArrayList; 

public class GameObjectCollection implements ICollection
{
	private ArrayList<GameObject> list2  = new ArrayList<GameObject>(); // Array gameObjectList to store Game Object 
	public class Iterator implements IIterator // Iterator class implemets interface IIterator.
	{
	  private int currElementIndex;
		
		public Iterator() 
		{
			currElementIndex = -1;
		}
		public boolean hasNext() // Code has been provided by the teacher on Design Patterns notes
		{
			if (list2.size ( ) <= 0) 
				return false;
			if (currElementIndex == list2.size() - 1 )
			{
				return false;
			}
			return true;
		}
	
		public Object getNext ( ) 
		{
			currElementIndex ++ ;
			return list2.get(currElementIndex);
		}
	}// end iterator class
		public void add(Object object)
		{
			list2.add((GameObject)object);
		}
		
		public IIterator getIterator()
		{
			return new Iterator();
		}
			
}
