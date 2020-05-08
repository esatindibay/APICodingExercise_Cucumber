package pojo;
//  this pojo class is not for validate values but for validate structure of response json
// for example: in json format, id should be integer, i do not focus what value the id is
// i will check only if it is integer or not.

public class PersonDataType
{
    Person person;
    private String idType;
    private String nameType;
    private String lastType;
    private String genderType;
    private String ageType;

    public PersonDataType(String idType,String nameType, String lastType, String genderType, String ageType ) {
        this.idType = idType;
        this.ageType = ageType;
        this.nameType = nameType;
        this.lastType = lastType;
        this.genderType = genderType;
    }
    public PersonDataType(){

    }

    public PersonDataType(Person person){
        this.person = person;
        getLastType();
        getIdType();
        getAgeType();
        getNameType();
        getGenderType();
    }
    public String getAgeType() {

        ageType= ((Object)(person.getAge())).getClass().getTypeName();
        return ageType;
    }

    public String getNameType() {
        nameType=((Object)(person.getName())).getClass().getTypeName();
        this.nameType=nameType;
        return nameType;
    }

    public String getLastType() {
        lastType=((Object)(person.getLast())).getClass().getTypeName();
        this.lastType=lastType;
        return lastType;
    }

    public String getGenderType() {
        genderType=((Object)(person.getGender())).getClass().getTypeName();
        this.genderType=genderType;
        return genderType;
    }

    public String getIdType() {
        idType=((Object)(person.getId())).getClass().getTypeName();
        this.idType=idType;
        return idType;
    }


    @Override
    public String toString() {
        return  "{" +
                "id=" + idType + " " +
                "name='" + nameType +'\'' +
                "last='" + lastType +'\'' +
                "age="+ageType  + " " +
                "gender='" + genderType + '\''+
                "}";
    }
}