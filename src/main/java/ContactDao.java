import java.util.ArrayList;

public class ContactDao implements IContactDao {

    private ArrayList<Contact> contacts;

    public ContactDao(){
        contacts = new ArrayList<>();
    }

    @Override
    public ArrayList<Contact> readAll(){
        return contacts;
    }

    @Override
    public Contact findByName(String nom){
        for (Contact contact : this.contacts){
            if(contact.getNom().equals(nom)){
                return contact;
            }
        }
        return null;
    }

    @Override
    public void add(Contact contact) throws ContactException{
        boolean in = false;
        for(Contact contactGens : this.contacts){
            if(contact.getNom().equals(contactGens.getNom())) {
                in = true;
                break;
            }
        }

        if(in){
            System.err.println("Le nom est déjà utilisé");
            throw new ContactException();
        }
        else{
            this.contacts.add(contact);
        }

    }

    @Override
    public void del(Contact contact) throws ContactNotFoundException {
        boolean in = false;
        for(Contact contactGens : this.contacts){
            if(contact.getNom().equals(contactGens.getNom())) {
                in = true;
                break;
            }
        }

        if(in){
            this.contacts.remove(contact);
        }
        else{
            System.err.println("La suppression ne peut pas se faire car le contact n'existe pas.");
            throw new ContactNotFoundException();
        }
    }

}
