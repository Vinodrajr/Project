package com.hibernate.jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Studentdynamically {

//	Select Data from Table
	// start
	public boolean selectData() {
		EntityManager manager = null;
		EntityManagerFactory factory = null;
		Query query = null;
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			String select = " from Student";
			query = manager.createQuery(select);
			List<Student> list = query.getResultList();
			for (Student student : list) {
				System.out.println(student);
			}

		} catch (IdNotFound e) {
			throw new IdNotFound("Id not present in Table");

		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		if (query != null) {
			return true;
		}
		return false;
	}

	// end

//Update data into table
	// START
	public boolean update() {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Query query = null;

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			System.out.println("ENTER THE ROLLNO FOR WHICH UPDATE TO BE DONE");
			int rollno = scanner.nextInt();
			System.out.println("Do you want update name: Press (Y/N)");
			char choice1 = scanner.next().charAt(0);
			String name = null;

			if (choice1 == 'y') {
				System.out.println("Enter the name to Updated");
				name = scanner.next();
				String update = "update Student set name=:name where rollno=:rollno";
				query = manager.createQuery(update);
				query.setParameter("name", name);
				query.setParameter("rollno", rollno);
				int result = query.executeUpdate();
			} else {
				System.out.println("Name not Updated");
			}
			System.out.println("Do you want update phone number: Press (Y/N)");
			char choice2 = scanner.next().charAt(0);
			String phno = null;

			if (choice2 == 'y') {
				System.out.println("Enter the phone to Updated");
				phno = scanner.next();
				String update = "update Student set name=:name where phno=:phno";
				query = manager.createQuery(update);
				query.setParameter("name", name);
				query.setParameter("phno", phno);
				int result = query.executeUpdate();
			} else {
				System.out.println("Phno not Updated");
			}
			System.out.println("Do you want update standard: Press (Y/N)");
			char choice3 = scanner.next().charAt(0);
			String standrad = null;

			if (choice3 == 'y') {
				System.out.println("Enter the standrad to Updated");
				standrad = scanner.next();
				String update = "update Student set standrad=:standrad where rollno=:rollno";
				query = manager.createQuery(update);
				query.setParameter("standrad", standrad);
				query.setParameter("rollno", rollno);
				int result = query.executeUpdate();
			} else {
				System.out.println("Standrad not Updated");
			}

			transaction.commit();

		} catch (IdNotFound e) {
			throw new IdNotFound("Id not present in Table");

		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		if (query != null)
			return true;
		else
			return false;
	}

	// END

	// Delete data from Database using rollno
	// start
	public boolean delete() {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Query query = null;

		System.out.println("Enter the rollno to Delete the Data");
		int rollno = scanner.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String update = "delete from Student where rollno=:rollno";
			query = manager.createQuery(update);

			query.setParameter("rollno", rollno);
			int result = query.executeUpdate();
			transaction.commit();

		} catch (IdNotFound e) {
			throw new IdNotFound("Id not present in Table");

		} finally {
			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		if (query != null)
			return true;
		else
			return false;
	}
	// end

	public void insert() {
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();
		System.out.println("Enter the RollNO");
		int rollno = scanner.nextInt();
		System.out.println("Enter the Name of Student");
		String name = scanner.next();

		System.out.println("Enter the Phone number of Student");
		String phno = scanner.next();

		System.out.println("Enter the Standrad of Student");
		String standrad = scanner.next();

		student.setRollno(rollno);
		student.setName(name);
		student.setPhno(phno);
		student.setStandrad(standrad);

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(student);
			transaction.commit();
		}
			catch (IdNotFound e) {
			throw new IdNotFound("Id not present in Table");
		} finally {
			if (factory != null) {
				factory.close();

			}
			if (manager != null) {
				manager.close();
			}
		}
	}
}