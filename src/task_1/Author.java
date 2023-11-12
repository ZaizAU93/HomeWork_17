package task_1;

public class Author {
    private String lastName;
    private String firstName;
    private String nationality;
    private String yearOfBirth;
    private String yearOfDeath;

    public Author(String author, String firstName, String nationality, String yearOfBirth, String yearOfDeath) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.nationality = nationality;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getYearOfDeath() {
        return yearOfDeath;
    }

    public String getNationality() {
        return nationality;
    }


}
