package main;

public class Student {
    private String name;
    private String department;
    private int id;

    public Student(int id, String name, String department){
        this.id = id;
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
