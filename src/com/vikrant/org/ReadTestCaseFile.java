package com.vikrant.org;

import java.io.File;

public class ReadTestCaseFile {
	
	public static void main(String args[]) {
		try {
			File file = new File("A-small.practice.in.txt"); 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
