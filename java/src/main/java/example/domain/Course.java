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

  @ManyToOne
  @JoinColumn(name="department_id")
  private Department department;

  @ManyToOne
  @JoinColumn(name="professor_id")
  private Professor professor;
  
  @ManyToMany
  @JoinTable(name="course_registrations")
  @JoinColumn(name="course_id")
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

  public void setDepartment(Department department) {
    this.department = department;
  }

  public Department getDepartment() {
    return this.department;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public Professor getProfessor() {
    return this.professor;
  }
  
  public void setStudents(List<Student> students) {
    this.students = students;
  }
  public List<Student> getStudents() {
    return this.students;
  }
};
