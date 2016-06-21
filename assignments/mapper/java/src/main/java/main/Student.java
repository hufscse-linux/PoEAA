package main;

public class Student {
    private String name;
    private String department;
    private long id;

    public Student(long id, String name, String department){
        this.name = name;
        this.department = department;
    }

    public String getName(){
        return this.name;
    }

    public long getId(){
        return this.id;
    }

    public String getDepartment(){
        return this.department;
    }
}
