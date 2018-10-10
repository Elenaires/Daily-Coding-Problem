/* daily coding problem #97 */

/* Write a map implementation with a get function that lets
* you retrieve the value of a key at a particular time.
*
* It should contain the following methods:
*
* set(key, value, time): sets key to value for t = time.
* get(key, time): gets the key at t = time.
*/

/* https://stackoverflow.com/questions/1314650/using-java-map-for-range-searches*/

import java.util.*;

public class MapWithKeyAndTime
{
	HashMap<Integer, NavigableMap<Integer, Integer>> map = new HashMap<>();

	public void set(int key, int value, int time)
	{
		NavigableMap<Integer, Integer> navMap;

		if(map.containsKey(key))
		{
			navMap = map.get(key);
		}
		else
		{
			navMap = new TreeMap<>();
			map.put(key, navMap);
		}

		navMap.put(time, value); 
	}

	public Integer get(int key, int time)
	{
		Integer value = null;

		NavigableMap<Integer, Integer> navMap;

		if(map.containsKey(key))
		{
			navMap = map.get(key);
			
			Integer timeKey = navMap.floorKey(time);
			if(timeKey != null)
			{
				value = navMap.get(timeKey);
			}
		} 

		return value;
	}

	public static void main(String[] args)
	{
		MapWithKeyAndTime myMap = new MapWithKeyAndTime();
		myMap.set(1,1,0);
		myMap.set(1,2,0);
		System.out.println(myMap.get(1,0));
		//System.out.println(myMap.get(1,10));		
	}
} 
