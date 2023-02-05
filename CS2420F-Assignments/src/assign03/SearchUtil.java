package assign03;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
 * @author Daniel Kopta and William Dreyer and Brayden Neal
 * A utility class for searching, containing just one method (see below).
 *
 */
public class SearchUtil {

	//in order to call the binary search method,
	//you have to use the address: SearchUtil.binarySearch...
	
	/**
	 * 
	 * @param <T>	The type of elements contained in the list
	 * @param list	An ArrayList to search through. 
	 * 				This ArrayList is assumed to be sorted according 
	 * 				to the supplied comparator. This method has
	 * 				undefined behavior if the list is not sorted. 
	 * @param item	The item to search for
	 * @param cmp	Comparator for comparing Ts or a super class of T
	 * @return		true if the item exists in the list, false otherwise
	 */
	public static <T> boolean binarySearch(ArrayList<T> list, T item, Comparator<? super T> cmp)
	{
		ArrayCollection<T> arr = new ArrayCollection<T>();
		arr.addAll(list);
		arr.toSortedList(cmp);
		//Object[] arrayForBinary = arr.toArray();
		//int n = arrayForBinary.length;
		
		int left = 0;
		int right = list.size() - 1;
		int mid;
		
		while(left <= right) {
			mid = left + ((right - left)/2);
			if(cmp.compare(list.get(mid), item) == 0)
			{
				return true;
			}
			if(cmp.compare(list.get(mid), item) < 0)
			{
				right = mid - 1;
			}
			if(cmp.compare(list.get(mid), item) > 0)
			{
				left = mid + 1;
			}
			
		}
		return false;
//		int result = helper(arrayForBinary, 0, n - 1, item, cmp);
//		if(result == -1)
//			return false;
//		else
//			return true;
//		
//		
//		
//		
		
		}

//	private static <T> int helper(Object[] arrayForBinary, int l, int r,
//			T item, Comparator<? super T> cmp)
//	{
//		if(r >= l) {
//					int mid = l + (r - 1) / 2;
//					
//					if(arrayForBinary[mid].equals(item))
//						return mid;
//					
//					if(cmp.compare((T) arrayForBinary[mid], item) > 0)
//						return helper(arrayForBinary, l, mid - 1, item, cmp);
//					
//					return helper(arrayForBinary, mid + 1, r, item, cmp);
//				}
//				return -1;		
//	}

}
