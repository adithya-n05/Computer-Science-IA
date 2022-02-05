public class Class {
    private String classname;
    private Teacher teacher;
    private Subject subject;
    private int classid;


    public Class(){

    }

    public Class(String classname, Teacher teacher, Boolean HL) {
        this.classname = classname;
        this.teacher=teacher;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
