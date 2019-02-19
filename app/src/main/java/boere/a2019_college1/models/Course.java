package boere.a2019_college1.models;

import java.io.Serializable;

public class Course  implements Serializable {

    private String period;
    private String name;
    private String ects;
    private String grade;

    public Course(String courseName, String ects, String grade, String period){
        this.name = courseName;
        this.ects = ects;
        this.grade = grade;
        this.period = period;
    }

    public Course(){
    }
}

