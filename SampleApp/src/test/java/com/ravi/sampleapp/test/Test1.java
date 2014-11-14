package com.ravi.sampleapp.test;

import java.util.Calendar;
import java.util.List;

import org.mockito.Mockito;


public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar mockedCalendar = Mockito.mock(Calendar.class);
		Mockito.when(mockedCalendar.get(Calendar.YEAR)).thenReturn(2020);
		
		System.out.println(mockedCalendar.get(Calendar.YEAR));
		

		List myMockedList = Mockito.mock(List.class); 
		Mockito.when(myMockedList .get(Mockito.anyInt())).thenReturn("targetAny");
		Mockito.when(myMockedList .get(0)).thenReturn("target", "1", "2");
		Mockito.when(myMockedList .get(1)).thenReturn("target2");

		
		System.out.println(myMockedList .get(0));		
		System.out.println(myMockedList .get(1));
		System.out.println(myMockedList .get(10));
		System.out.println(myMockedList .get(100));
		System.out.println(myMockedList .get(0));	
		System.out.println(myMockedList .get(0));	
		System.out.println(myMockedList .get(0));	
		
		Mockito.verify(myMockedList, Mockito.times(7)).get(Mockito.anyInt());
	}

}
