import java.util.ArrayList;
public class User {

    private String username;
    private String password;
    //private ArrayList<Book> booksResponsibleFor;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        //this.booksResponsibleFor = booksResponsibleFor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   // public ArrayList<Book> getBooksResponsibleFor() {
        return booksResponsibleFor;
    }

   // public void setBooksResponsibleFor(ArrayList<Book> booksResponsibleFor) {
      //  this.booksResponsibleFor = booksResponsibleFor;
    //}
}git 