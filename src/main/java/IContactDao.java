import java.util.ArrayList;

public interface IContactDao {
    ArrayList<Contact> readAll();

    Contact findByName(String nom);

    void add(Contact contact) throws ContactException;

    void del(Contact contact) throws ContactNotFoundException;
}
