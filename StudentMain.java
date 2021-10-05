package com.hibernate.jpa;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char exit='N';
		while(exit!='Y') {
		System.out.println("Press 1. select all data from table");
		System.out.println("Press 2. update all data from table");
		System.out.println("Press 3. delete all data from table");
		System.out.println("Press 4. insert all data from table");
		int choice = scanner.nextInt();
		Studentdynamically studentdynamically = new Studentdynamically();
		switch (choice) {
		case 1: {

			studentdynamically.selectData();
		}

			break;
		case 2: {
			studentdynamically.update();

		}
			break;

		case 3: {
			studentdynamically.delete();
		}
			break;
		case 4: {
			studentdynamically.insert();
		}
			break;
		default:{
			System.out.println("do you wnat to exit: Press 'Y' ");
			exit=scanner.next().charAt(0);
		}
			break;
		}
		}
	}

}
