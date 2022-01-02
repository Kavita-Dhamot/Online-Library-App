package kavs.myappcompany.onlinelibrary;

public class User {

    public String fullName, age, email;

    //so that we can call this info later
    public User(){

    }

    public User(String fullName, String age, String email){

        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }
}
