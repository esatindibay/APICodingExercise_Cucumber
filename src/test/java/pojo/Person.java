package pojo;
// this pojo class is created for json --> java object conversion.
// I need to have java object in order to validate values
//this conversion is also known deserialization
public class Person {
    //in class, i define variables as private and later i create getter/setter as public
    // this is one of the 4 basics of OOP concept, encapsulation.
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

    // the empty constructor should be present for getting the process started.
    public Person() {
            //EMPTY CONSTRUCTOR
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

    // overriding toString method from Object class is not mandatory but i would like to print my new created object
    // in order to check whether i am on right track
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
