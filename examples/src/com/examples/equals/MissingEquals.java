package com.examples.equals;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.Set;

public class MissingEquals {
	
	/* Our 'people' identified by their SS ID (parameter 3) */
	PersonDTO personOne = new PersonDTO("blogs", "fred", "0001");
	PersonDTO personTwo = new PersonDTO("blogs", "joe", "0002");
	PersonDTO personThree = new PersonDTO("blogs", "fred", "0003");
	
	/* This record is a duplicate of personOne (from a data point of view)*/
	PersonDTO duplicateOne = new PersonDTO("blogs", "fred", "0001");
	
	public static void main(String[] args) {
		
		MissingEquals application = new MissingEquals();
			
		application.checkHashSet();
	}

	/**
	 * This illustrates the issue we discussed (albiet in a different collection!)...
	 * Since it is a SET, which guarantees we will have no duplicates, see:
	 * 
	 * http://docs.oracle.com/javase/7/docs/api/java/util/Set.html
	 * 
	 * 
	 * 
	 */
	void checkHashSet(){
		
		Set<PersonDTO> hashSet = new HashSet<PersonDTO>(); 
		
		hashSet.add(personOne);
		hashSet.add(personTwo);
		hashSet.add(personThree);
		
		/* Since the SS ID of this record is identical to 'personOne' we'd expect this to
		 * be treated as a duplicate... */
		hashSet.add(duplicateOne);		
		
		out.println("hash set size (should be 3)" + hashSet.size());		
	}
	
}
