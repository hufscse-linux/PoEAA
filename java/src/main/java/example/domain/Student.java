package example.domain;

import java.util.List;
import javax.persistence.*;

import org.apache.ibatis.annotations.*;

@Entity
@Table(name="students")
public class Student {
  @Id @GeneratedValue
  @Column(name="id")
  private long id;
  @Column(name="name")
  private String name;

  @ManyToOne
  @JoinColumn(name="department_id")
  private Department department;

  @ManyToMany
  @JoinTable(
      name="course_registrations",
      joinColumns={@JoinColumn(name="student_id")},
      inverseJoinColumns={@JoinColumn(name="course_id")})
  private List<Course> courses;

  public static interface Mapper {
    @Select("select * from students")
    @Results({
        @Result(property="id", column="id", id=true),
        @Result(property="name", column="name"),
        @Result(property="department", column="departmentId",
                javaType=Department.class,
                one=@One(select="example.domain.Department.Mapper.selectOne"))
      })
    List<Student> listAll();
  };
  
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
