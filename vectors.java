package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/**
 * Compare to ArrayList, Vector is a thread safe Data Structure
 */
public class Main{
	public static void main(String[] args)
	{
		List<Employee> aList=new Vector<>();
		aList.add(new Employee("Xin","Wang",25));
		aList.add(new Employee("Han","Weng",24));
		aList.get(0).print();
		System.out.println(aList.get(1));
		aList.set(1,new Employee("Hao","Dong",23));
		aList.add(0,new Employee("Niu","Bi",30));
		aList.forEach(eachEmp->System.out.println(eachEmp));
		aList.remove(0);

		System.out.println("-------");
		Employee[] empArray=aList.toArray(new Employee[aList.size()]);

		for(Employee emp:empArray)
		{
			System.out.println(emp);
		}

		//Require to override equals method
		System.out.println(aList.contains(new Employee("Hao","Dong",23)));
		System.out.println(aList.indexOf(new Employee("Hao","Dong",23)));

	}
}

class Employee
{
	private String firstName;
	private String lastName;
	private int age;

	Employee(String fName,String lName,int age)
	{
		this.firstName=fName;
		this.lastName=lName;
		this.age=age;
	}

	public void print()
	{
		System.out.println("Employee Name is: "+firstName+" "+lastName+", Age is: "+age);
	}

	public String toString()
	{
		return "Employee Name is: "+firstName+" "+lastName+", Age is: "+age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee)) return false;
		Employee employee = (Employee) o;
		return age == employee.age &&
				Objects.equals(firstName, employee.firstName) &&
				Objects.equals(lastName, employee.lastName);
	}
}
