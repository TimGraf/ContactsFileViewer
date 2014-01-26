package com.grafcode.contactsfileviewer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContactsFileReader {
	BufferedReader fileReader;

	private void readFile(String fileName) throws FileNotFoundException {
		fileReader = new BufferedReader(new FileReader(fileName));
	}
	
	private void parseFile() throws IllegalStateException, IOException {
		
		if (fileReader == null) {
			throw new IllegalStateException("");
		}
		
		String nextLine;
        
		while ((nextLine = fileReader.readLine()) != null) {
            String[] tokens = nextLine.split(",");
            
            // XXX
        }
	}
}
