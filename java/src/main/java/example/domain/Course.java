package example.domain;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Courses")
public class Course {
  @Id @GeneratedValue
  @Column(name="id")
  private long id;
  @Column(name="name")
  private String name;

  @OneToMany
  @JoinTable
  private List<Student> students;
  
  public void setId(long id) {
    this.id = id;
  }
  public long getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }
  public List<Student> getStudents() {
    return this.students;
  }
};
