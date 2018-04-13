package com.HM.SortNumbers.dao;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import com.HM.SortNumbers.Model.NumberSortingDetails;

@Repository ("sortNumbersAppDao")
@SpringBootTest
public class SortNumbersAppDaoImpl implements SortNumbersAppDao {

	@PersistenceContext
	private EntityManager entityManager;

	public String sortNumbers(String numberVal) {

		int[] arrayToSort = generateRandomNumbers(Integer.valueOf(numberVal));
		String arrayToSortStr = convertToCommaSeparatedString(arrayToSort);

		String sortedNoStr = selectionSort(arrayToSort);

		String[] strArr = sortedNoStr.split("~");
		String sortedNos = strArr[0];
		String swapCount = strArr[1];
		String timeTakenToSort = strArr[2];


		saveDetails(numberVal,arrayToSortStr,sortedNos,swapCount,timeTakenToSort);

		String outputStr = String.join("~", arrayToSortStr, sortedNoStr, swapCount, timeTakenToSort);
		return outputStr;

	}
	
	@Test
	private int[] generateRandomNumbers(int numberVal) {
		int[] randomNumArr = new int[numberVal];
		Random random = new Random();
		int max = 100;
		int min = 0;
		for(int i=0; i<=numberVal-1; i++){
			randomNumArr[i] = random.nextInt((max - min) + 1) + min;
		}
		return randomNumArr;
	}

	private String selectionSort(int[] arrayToSort){
		int swapCount = 0;

		//LocalDateTime beforeTime = LocalDateTime.now();
		Instant beforeTime = Instant.now();
		
		for (int i = 0; i < arrayToSort.length - 1; i++)
		{
			int index = i;
			for (int j = i + 1; j < arrayToSort.length; j++)
				if (arrayToSort[j] < arrayToSort[index]) 
					index = j;
			swapNumbers(i,index,arrayToSort);
			swapCount++;
		}

		//LocalDateTime afterTime = LocalDateTime.now();
		Instant afterTime = Instant.now();
		Duration duration = Duration.between(beforeTime, afterTime);
		long timeTakenToSort = duration.toNanos();

		return Arrays.toString(arrayToSort)+"~"+swapCount+"~"+timeTakenToSort;
	}

	private static void swapNumbers(int i, int j, int[] arrayToSort){
		int tempVar = arrayToSort[i];
		arrayToSort[i] = arrayToSort[j];
		arrayToSort[j] = tempVar;
	}

	private void saveDetails(String numberVal,String arrayToSortStr, String sortedNos, String swapCount, String timeTakenToSort) {

		NumberSortingDetails pojoObj=null;
		Session session = entityManager.unwrap(Session.class);
		Transaction txn = session.beginTransaction();
		try{

			pojoObj = new NumberSortingDetails();

			pojoObj.setCountOfNumbers(Long.valueOf(numberVal));
			pojoObj.setInputNumbers(arrayToSortStr);
			pojoObj.setSortedNumbers(sortedNos);
			pojoObj.setCountOfChangeValue(swapCount);
			pojoObj.setSortingTime(timeTakenToSort);

			entityManager.unwrap(Session.class).persist(pojoObj);
			txn.commit();
		}catch(Exception e){
			txn.rollback();
		}finally{
			if(session==null)
				session.close();
		}

	}

	public String convertToCommaSeparatedString(int[] arrayToSort) {
		String outputStr = "";
		if (arrayToSort.length > 0){
			StringBuilder sb = new StringBuilder(); 
			for (Integer i : arrayToSort){
				sb.append(String.valueOf(i)).append(","); 
			}
			outputStr = sb.deleteCharAt(sb.length() - 1).toString();
		}

		return outputStr;
	}

}
