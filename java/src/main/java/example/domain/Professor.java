package example.domain;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Professors")
public class Professor {
  @Id @GeneratedValue
  @Column(name="id")
  private long id;
  @Column(name="name")
  private String name;

  @ManyToOne
  @JoinColumn(name="department_id")
  private Department department;
  
  @OneToMany
  private List<Course> courses;
  
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

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public List<Course> getCourses() {
    return this.courses;
  }
  
};
