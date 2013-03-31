package com.vikrant.google.setA;

import java.io.File;

import com.vikrant.google.generalUtility.ReadTestFile;

/**
 * 
 * @author Vikranth
 * Given a list of space separated words, reverse the order of the words. 
 * Each line of text contains L letters and W words. A line will only consist of letters and space characters. 
 * There will be exactly one space character between each pair of consecutive words.
 */

public class ReverseWords {
	public static void main (String args[]) {
		File input1 = new File ("input/B-large-practice.in");
		//File input = new File ("inout/A-small-practice.in");
		String inputString = (new ReadTestFile()).readDoc(input1);
		String[] myArray = inputString.split("\n");
		String s;
		for (int i = 1 ; i < myArray.length ; i ++) {
			s = myArray[i];
			// revers the string = ekoj a si siht
			String ss = reverseMystring(s);
			// call the same function for each substring
			String[] stringArray = ss.split(" ");
			StringBuilder finalString = new StringBuilder();
			for (int j =0 ; j < stringArray.length ; j++) {
			//System.out.println("... " + stringArray[i]);
			finalString.append(reverseMystring(stringArray[j]));
			finalString.append(" ");
			}
			System.out.println("Case " + i + ": "  + finalString.toString());
		}
		//joke a is this
	}
	
	public static String reverseMystring(String s) {
		//logic 
		char [] stringArray = s.toCharArray();
		StringBuilder resultString = new StringBuilder();
		int k =0;
		for(int i=s.length()-1 ; i>=0; i--) {
			resultString.append(stringArray[i]);
			k++;
		}
		return resultString.toString();
	}

}
