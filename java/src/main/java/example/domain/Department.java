package example.domain;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="departments")
public class Department {
  @Id @GeneratedValue
  @Column(name="id")
  private long id;
  @Column(name="name")
  private String name;

  @OneToMany
  private List<Course> courses;

  @OneToMany
  private List<Student> students;

  @OneToMany
  private List<Professor> professors;
  
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

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public List<Course> getCourses() {
    return this.courses;
  }

  public void setStudents(List<Student> students) {
    this.students = students;
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void setProfessors(List<Professor> professors) {
    this.professors = professors;
  }

  public List<Professor> getProfessors() {
    return this.professors;
  }
  
  
};
