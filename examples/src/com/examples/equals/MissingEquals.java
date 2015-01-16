package com.examples.equals;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		
		application.checkHashMap();
				
		application.checkArrayList();
		
		application.checkHashSet();
	}

	/**
	 * ArrayList actually behaves okay!! Since it is just a sequential list, it's happy to 
	 * launch things in and out without consulting Equals and Hashcode. Event the 'contains' API
	 * works okay because it only agrees to find 'one or more' (it would be knackered if it was supposed
	 * to return a count).
	 */
	void checkArrayList(){
		List<PersonDTO> arrayList = new ArrayList<PersonDTO>(); 
		arrayList.add(personOne);
		arrayList.add(personTwo);
		arrayList.add(personThree);
		arrayList.add(duplicateOne);		
		out.println("array list size: " + arrayList.size());
		out.println("contains personOne : " + arrayList.contains(personOne));
		
	}
	
	/**
	 * This one IS knackered though (thankfully!), because it is a SET, which guarantees we will have
	 * no duplicates, see:
	 * 
	 * http://docs.oracle.com/javase/7/docs/api/java/util/Set.html
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
	
	void checkHashMap(){
		
		Map<PersonDTO, String> hashMap = new HashMap<PersonDTO, String>();
		
		hashMap.put(this.personOne, "PERSON-ONE");
		hashMap.put(this.personTwo, "PERSON-TWO");
		hashMap.put(this.personThree, "PERSON-THREE");
		hashMap.put(this.duplicateOne, "PERSON-FOUR");
		
		out.println("person one?" + hashMap.get(duplicateOne));
	}
}
