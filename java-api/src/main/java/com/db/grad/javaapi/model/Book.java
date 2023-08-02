import java.util.ArrayList;
public class Book {

    private ArrayList<Bond> bonds;
    private ArrayList<User> usersWithAccess;

    public Book(ArrayList<Bond> bonds, ArrayList<User> usersWithAccess) {
        this.bonds = new ArrayList<Bond>();
        this.usersWithAccess = new ArrayList<User>();
    }

    public ArrayList<Bond> getBonds() {
        return bonds;
    }

    public void setBonds(ArrayList<Bond> bonds) {
        this.bonds = bonds;
    }

    public ArrayList<User> getUsersWithAccess() {
        return usersWithAccess;
    }

    public void setUsersWithAccess(ArrayList<User> usersWithAccess) {
        this.usersWithAccess = usersWithAccess;
    }
}