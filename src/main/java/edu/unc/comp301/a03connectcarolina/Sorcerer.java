package edu.unc.comp301.a03connectcarolina;

import java.util.*;

public class Sorcerer {
  private static Map<String, Set<Student>> enrollment = new HashMap<>();

    public static String calculateValidDay(int credits){
        if(credits < 0){
            throw new IllegalArgumentException();
        }
        else if(credits <= 55){
            return ("Wednesday");
        }
        else if(credits <= 100){
            return ("Tuesday");
        }
        else{
            return ("Monday");

        }

    }

    public static void initStudents(List<Student> students){
        if (students == null){
            return;
        }

        enrollment.put("Monday", new HashSet<Student>());
        enrollment.put("Tuesday", new HashSet<Student>());
        enrollment.put("Wednesday", new HashSet<Student>());
        enrollment.put("Thursday", new HashSet<Student>());
        enrollment.put("Friday", new HashSet<Student>());

        for (Student student: students){
            if(student == null){
                return;
            }
            try{
                String day = calculateValidDay(student.getCredits());
                enrollment.get(day).add(student);
            }

            catch (IllegalArgumentException e){
                System.out.println("Error in credits!");

            }
        }

    }

    public static boolean duoAuthenticate(Student student, String day) throws DuoAuthenticationFailedException {
        boolean auth = false;

        if (student == null){
            return false;
        }

        int studentID = student.getStudentID();



        if (("" + studentID).length() != 9) {
            throw new DuoAuthenticationFailedException("Invalid student ID.");
        }
        else{
            if(!enrollment.get(day).contains(student)){
                throw new DuoAuthenticationFailedException("Error with Authentication");
            }
            else{
                System.out.println("Duo authentication successful! Welcome, " + student.getName() + ":");
                auth = true;
            }

        }
        return auth;
    }
}
