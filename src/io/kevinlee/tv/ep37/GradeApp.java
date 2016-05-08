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
    final Student student4 = new Student(4L, "Jon Snow");
    final Student student5 = new Student(5L, "Jane");
    final List<Score> scores = Arrays.asList(
        new Score(1L, 49, student1),
        new Score(2L, 55, student2),
        new Score(3L, 68, student3),
        new Score(4L, 78, student4),
        new Score(5L, 88, student5)
    );

    for (final Score score : scores) {
      // Student: Student(id=1, name=Tom)
      System.out.println("Student: " + score.getStudent());

      //   Score: 49
      System.out.println("  Score: " + score.getValue());

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
    if (score < 50)
      return "Fail";
    if (score < 65)
      return "Pass";
    if (score < 75)
     return "Credit";
    if (score < 85)
     return "Distinct";
    return "High Distinction";
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
    return "Student(id = " + id + ", name = " + name + ")";
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

  public double getValue() {
    return value;
  }

  public Student getStudent() {
    return student;
  }

  public String getGrade() {
    return GradeUtil.grade(this.value);
  }
}
