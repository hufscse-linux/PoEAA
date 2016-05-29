package example.domain;

import javax.persistence.*;

@Entity
@Table(name="Students")
public class Registration {
  @Id @GeneratedValue
  @Column(name="id")
  private long id;
  private Course course;
  private Student student;

  public void setId(long id) {
    this.id = id;
  }
  public long getId() {
    return this.id;
  }

  public void setCourse(Course course) {
    this.course = course;
  }
  public Course getCourse() {
    return this.course;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Student student() {
    return this.student;
  }
};
