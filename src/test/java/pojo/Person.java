package pojo;

public class Person {
    private int id;
    private String name;
    private  String last;
    private int age;
    private String gender;

    public Person(int id, String name, String last, int age, String gender) {
        this.id = id;
        this.name = name;
        this.last = last;
        this.age = age;
        this.gender = gender;
    }
    public Person() {

    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String  gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id + " " +
                "name='" + name +'\'' +
                "last='" + last +'\'' +
                "age="+age  + " " +
                "gender='"+gender +'\'' +
                "}";
    }
}
