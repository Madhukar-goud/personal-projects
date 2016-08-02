package com.collectionstutorial;

import java.util.Comparator;

public class EmpComparator implements Comparator<Emp> {

	@Override
	public int compare(Emp emp1, Emp emp2) {
		int idCompare = emp1.getId() - emp2.getId();
		if(idCompare != 0)
			return idCompare;
		
		int ageCompare = emp1.getAge() - emp2.getAge();
		if(ageCompare != 0)
			return ageCompare;

		return emp1.getName().compareTo(emp2.getName());
	}

}
