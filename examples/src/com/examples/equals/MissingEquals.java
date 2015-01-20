package com.examples.equals;

import static java.lang.System.out;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Illustrates the significance that equals/hashcode plays when we are using the 
 * Collections API. 
 * 
 * @author taitn
 *
 */
public class MissingEquals {
	
	/* test */
	
	/* Our 'people' identified by their SS ID (parameter 3) */
	PersonDTO personOne = new PersonDTO("blogs", "fred", "0001");
	PersonDTO personTwo = new PersonDTO("blogs", "joe", "0002");
	PersonDTO personThree = new PersonDTO("blogs", "fred", "0003");
	PersonDTO personFour = new PersonDTO("blogs", "Jeff", "0004");
	
	/* This record is a duplicate of personOne (from a data point of view)*/
	PersonDTO duplicateOne = new PersonDTO("blogs", "fred", "0001");

	
	
	

	
	public static void main(String[] args) {
		
		MissingEquals application = new MissingEquals();
		
		/* We declare a reference variable of the generic base type 'Set' */
		Set<PersonDTO> setToProcess;
		
		
		/* Now we assign one of it's implementation and sent this to our checking service */
		setToProcess = new HashSet<PersonDTO>();
		application.checkSet(setToProcess);
		
		/* Assign a different implementation and sent this to our checking service */
		setToProcess = new TreeSet<PersonDTO>();
		application.checkSet(setToProcess);
				
		setToProcess = new LinkedHashSet<PersonDTO>();
		application.checkSet(setToProcess);
		
		/* As an exercise, please test another Set implementation from the 'All Known Implementing Classes' list on the API docs:
		 * 
		 * http://docs.oracle.com/javase/7/docs/api/java/util/Set.html
		 * 
		 * */
	
	}

	/**
	 * Note this method/service declares that you can send ANY of the Set implementations in for checking 
	 */
	void checkSet(Set<PersonDTO> set){
		
		out.println("Testing type: " + set.getClass().getName());
		
		set.add(personOne);
		set.add(personTwo);
		set.add(personThree);
		set.add(personFour);
		
		/* Since the SS ID of this record is identical to 'personOne' we'd expect this to
		 * be treated as a duplicate... */
		set.add(duplicateOne);		
		
		out.println("hash set size (should be 4)" + set.size());		
		
		
	}
	
}
