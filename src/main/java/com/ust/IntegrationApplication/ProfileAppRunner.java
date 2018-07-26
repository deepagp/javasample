package com.ust.IntegrationApplication;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.ust.vo.Employee;
import com.ust.vo.Salary;

public class ProfileAppRunner {

	public static void main(String arhs[]) {

		try {
			List<String> userDetails = fileReading();
			saveEmployee(userDetails);
		} catch (Exception ex) {
			System.out.println("******* The error " + ex);
		}

	}
	
	public static String getUID(){
		return UUID.randomUUID().toString();
	}

	public static MongoOperations getMongoOperation() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				MongoDBConfig.class);
		MongoOperations mongo = (MongoOperations) ctx.getBean("mongoTemplate");
		return mongo;
	}

	public static void saveEmployee(List<String> employeeList) {
		MongoOperations mongo = getMongoOperation();
		for (String s : employeeList) {
			String userDetails[] = s.split("\\s+");
			Employee emp = new Employee(getUID(), userDetails[0], getSalary(), userDetails[1]);
			mongo.save(emp);
		}

	}

	public static int getSalary(){
		int random = (int)(Math.random()*1000);
		return random;
	}
	
	public static void saveSalary() {
		MongoOperations mongo = getMongoOperation();
		Salary sal = new Salary(1010, 200, 111);
		mongo.save(sal);
	}

	public static List<String> fileReading() {
		List<String> UserList = null;
		try {
			String fileName = "employee.dat";
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File file = new File(classLoader.getResource(fileName).getFile());
			UserList = Files.readAllLines(file.toPath());
		} catch (Exception ex) {
			System.out.println();
			ex.getMessage();
		}
		return UserList;
	}

}
