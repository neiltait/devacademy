package com.examples.equals;

public class PersonDTO implements Comparable<PersonDTO>{
	public String surname;
	public String forename;
	public String socialSecurityNumber;

	public PersonDTO(String surname, String forename, String socialSecurityNumber) {
		super();
		this.surname = surname;
		this.forename = forename;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((socialSecurityNumber == null) ? 0 : socialSecurityNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDTO other = (PersonDTO) obj;
		if (socialSecurityNumber == null) {
			if (other.socialSecurityNumber != null)
				return false;
		} else if (!socialSecurityNumber.equals(other.socialSecurityNumber))
			return false;
		return true;
	}

	@Override
	public int compareTo(PersonDTO o) {
		// TODO - future lesson on Comparators
		return 0;
	}


	
}