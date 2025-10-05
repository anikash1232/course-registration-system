package edu.unc.comp301.a03connectcarolina;

import java.util.ArrayList;
import java.util.List;

public class AuthenticatorSimulation {
    public static void main(String[] args) {
        Student student1 = new Student("Ani", 730761368, 0);

        Enchanter enchanter = new Enchanter();
        enchanter.initCalendar();

        student1.getScannedCLEEvents().add("Leadership Summit");
        enchanter.getCLECredits("Leadership Summit", student1.getScannedCLEEvents());

        List<Student> students = new ArrayList<>();
        students.add(student1);
        Sorcerer.initStudents(students);

        boolean authentication_window = false;

        try {
            String currDay = Sorcerer.calculateValidDay(student1.getCredits());
            authentication_window = Sorcerer.duoAuthenticate(student1, currDay);
        }
        catch (DuoAuthenticationFailedException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid credit count - " + e.getMessage());
        }

        System.out.println("\nThank you for visiting ConnectCarolina.");
        if (authentication_window) {
            System.out.println("You are authenticated for the next 10 minutes.");
        } else {
            System.out.println("You will have to authenticate again.");
        }
    }
}