package com.HM.SortNumbers;

import java.util.Arrays;
import java.util.Date;

public class DateUtil {

	
	public static void main(String[] args){
		DateUtil d1 = new DateUtil();
		String str = d1.selectionSort(new int[] {1,32,23,2,5,54});
		
	}
	
	public String selectionSort(int[] arrayToSort){
		int swapCount = 0;
		
		for (int i = 0; i < arrayToSort.length - 1; i++)
		{
			int index = i;
			for (int j = i + 1; j < arrayToSort.length; j++)
				if (arrayToSort[j] < arrayToSort[index]) 
					index = j;
			swapNumbers(i,index,arrayToSort);
			swapCount++;
		}
		String str =  Arrays.toString(arrayToSort)+"~"+swapCount;
		return str;
	}
	
	private static void swapNumbers(int i, int j, int[] arrayToSort){
		int tempVar = arrayToSort[i];
		arrayToSort[i] = arrayToSort[j];
		arrayToSort[j] = tempVar;
	}
	
}
