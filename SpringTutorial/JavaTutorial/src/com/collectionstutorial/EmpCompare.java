package com.collectionstutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpCompare {

	public static void main(String[] args) {

		EmpCompare empCompare = new EmpCompare();
		empCompare.sortEmp();
	}
	
	public void sortEmp(){
		Emp emp1 = new Emp(1, 2, "Madhukar");
		Emp emp2 = new Emp(21, 31, "Madhukar");
		Emp emp3 = new Emp(8676, 31, "Madhukar");
		List<Emp> listEmp = new ArrayList<Emp>();
		listEmp.add(emp1);
		listEmp.add(emp2);
		listEmp.add(emp3);
		listEmp.add(new Emp(434, 28, "Sri"));
		listEmp.add(new Emp(4, 1, "Gayathri"));
		listEmp.add(new Emp(4341, 2, "Naragam"));
		listEmp.add(new Emp(4342, 28, "Srikar"));
		listEmp.add(new Emp(4343, 28, "Ravi"));
		listEmp.add(new Emp(434, 28, "Sai"));
		Collections.sort(listEmp, new EmpComparator());
		System.out.println(listEmp);
	}

}
