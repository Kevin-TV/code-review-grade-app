package io.kevinlee.tv.ep37;

import java.util.Arrays;
import java.util.List;

/**
 * @since 2016-05-08
 */
public class GradeApp {
    public static void main(String[] args) {
        final Student student1 = new Student(1L, "Tom");
        final Student student2 = new Student(2L, "Kevin");
        final Student student3 = new Student(3L, "John");
        final Student student4 = new Student(3L, "Jon Snow");
        final Student student5 = new Student(3L, "Jane");
        final List<Score> scores = Arrays.asList(
                new Score(1L, 49, student1),
                new Score(1L, 55, student2),
                new Score(1L, 68, student3),
                new Score(1L, 78, student4),
                new Score(1L, 88, student5)
        );

        for (final Score score : scores) {
            // Student: Student(id=1, name=Tom)
            System.out.println("Student: " + score.getStudent());

            //   Score: 49
            System.out.println("  Score: " + score.getScore());

            //   Grade: Fail
            System.out.println("  Grade: " + score.getGrade());
        }

    }
}

class GradeUtil {
    public static String grade(double score) {

    /*
     * score < 50: Fail
     * 50 <= score < 65: Pass
     * 65 <= score < 75: Credit
     * 75 <= score < 85: Distinct
     * 85 < score: High Distinction
     */
        String retGrade;

        if(score < 50){
            retGrade = "Fail";
        }
        else if(50 <= score && score < 65) {
            retGrade = "Pass";
        }
        else if(65 <= score && score < 75){
            retGrade = "Credit";
        }
        else if(75 <= score && score < 85){
            retGrade = "Distinct";
        }
        else if(85 <= score){
            retGrade = "High Distinction";
        }
        else
            throw new UnsupportedOperationException("Please implement it");

        return retGrade;
    }
}

class Student {

    private Long id;

    private String name;

    public Student(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();

        s.append("Student(");
        s.append("id=$ID".replace("$ID", this.id+""));
        s.append(", ");
        s.append("name=$NAME".replace("$NAME", this.name));
        s.append(")");

        return s.toString();
    }
}

class Score {

    private Long id;

    private double value;

    private Student student;

    public Score(final Long id, final double value, final Student student) {
        this.id = id;
        this.value = value;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public double getScore() {
        return value;
    }

    public String getGrade() {
        return GradeUtil.grade(value);
    }
}