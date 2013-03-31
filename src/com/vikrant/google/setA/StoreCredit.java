package com.vikrant.google.setA;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.vikrant.google.generalUtility.ReadTestFile;

public class StoreCredit {
	private static int testcaseN;
	private static int credit;
	private static int itemsnumbers;
	private static Integer [] itemspricelist;
	private static Set<Integer> itempriceset;
	
	
	private static void ReadInputAndExecute() {
		File input1 = new File ("input/A-large-practice.in");
		//File input = new File ("inout/A-small-practice.in");
		String inputString = (new ReadTestFile()).readDoc(input1);
		String[] myArray = inputString.split("\n");
		
		testcaseN = Integer.parseInt(myArray[0]);
		int count = 1;
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
		for (int i =1; i< myArray.length-1; i= i+3 ) {
			credit = Integer.parseInt(myArray[i]);
			itemsnumbers = Integer.parseInt(myArray[i+1]);
			itemspricelist = new Integer[myArray[i+2].split(" ").length];
			String itemlistString = myArray[i+2].replaceAll("(\\d+)\\s?", "itemspricelist[i++]=$1;");
			jsEngine.put("itemspricelist", itemspricelist);
			try {
		    jsEngine.eval("var i=0;" +  itemlistString);
			}catch (ScriptException ex) {
				ex.printStackTrace();
			}
			itempriceset = new HashSet<Integer>(Arrays.asList(itemspricelist));
			System.out.println();
			System.out.print("Case[" + count++ + "]:" );
			StoreCreditExecutor(credit,itemsnumbers,itempriceset,itemspricelist);
		}
	}
	private static void StoreCreditExecutor(int C, int I , Set<Integer> P, Integer [] PArray) {
		
		for (Integer price : P ) { //O(N)
		    Integer k = C - price;
		    if (P.contains(k)) {    //O(1)
		    	//run over the array
		    	for(int i = 0; i< PArray.length ; i++) {   //O(n)
		    		if (PArray[i].intValue() == k || PArray[i] == price) {
		    			System.out.print("  " + (i+1));
		    			
		    		}
		    	}
		    	break;
		    }
		}
		
	}
	public static void main(String args[]) {
		ReadInputAndExecute();
	}
}
