package edu.unc.comp301.a03connectcarolina;

import java.util.HashMap;
import java.util.Map;

public class Apprentice {

    private static final Map<String, Double> GRADE_MAP = new HashMap<>();
    static {
        GRADE_MAP.put("A", 4.0);
        GRADE_MAP.put("A-", 3.7);
        GRADE_MAP.put("B+", 3.3);
        GRADE_MAP.put("B", 3.0);
        GRADE_MAP.put("B-", 2.7);
        GRADE_MAP.put("C+", 2.3);
        GRADE_MAP.put("C", 2.0);
        GRADE_MAP.put("C-", 1.7);
        GRADE_MAP.put("D+", 1.3);
        GRADE_MAP.put("D", 1.0);
        GRADE_MAP.put("F", 0.0);
    }

    public static double charToGrade(String grade) {
        if (grade == null) {
            return -1;
        }
        Double value = GRADE_MAP.get(grade.toUpperCase());
        return (value == null) ? -1 : value;
    }

    public static String calculateGPA(int num_classes, String[] grades){
        if (grades == null) {
            throw new IllegalArgumentException("Grades array cannot be null!");
        }

        double sum = 0;
        int i = 0;
        if (num_classes > 0 && num_classes == grades.length){
            for (String grade: grades){
                if(charToGrade(grade) == -1){
                    throw new IllegalArgumentException("Invalid grade!");
                }

                else{
                    sum += charToGrade(grade);
                }
            }

        }
        else{
            throw new IllegalArgumentException("Mismatch! Make sure number of classes and the grades are correct!");
        }

        return ("Your calculated GPA is: " + sum/num_classes);
    }
}
