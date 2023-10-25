package com.decoder135.cruddemo;

import com.decoder135.cruddemo.dao.StudentDAO;
import com.decoder135.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//			System.out.println("Command Line Application Using SpringBoot.");
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudents(studentDAO);
        };

    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting All Students");
        int numRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting students with id: " + studentId);

        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student....");

        // change first name to DevD
        myStudent.setFirstName("Devu");
        studentDAO.update(myStudent);

        // display updated student details
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Shukla");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }


    }

    private void queryForStudents(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@email.com");

        // save the student
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + tempStudent.getId());
        Student myStudent = studentDAO.findById(tempStudent.getId());

        // display student
        System.out.println("Fount the student: " + myStudent);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students

        System.out.println("Creating 3 student objects...");
        Student tempStudent1 = new Student("Dev", "Shukla", "dev@email.com");
        Student tempStudent2 = new Student("Devu", "Shukla", "devu@email.com");
        Student tempStudent3 = new Student("Omi", "Shukla", "omi@email.com");

        // save the student objects
        System.out.println("Saving the students....");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);


    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Devansh", "Shukla", "devansh@email.com");


        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Student details saved. Generated id: " + tempStudent.getId());
    }
}
