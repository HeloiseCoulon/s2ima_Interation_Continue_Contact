public class ContactService implements IContactService{

    private IContactDao dao;

    public ContactService(){
        this.dao = new ContactDao();
    }



    public void add(String contactName) throws ContactException {
        dao.add(creerContact(contactName));
    }

    public void del(String contactName) throws ContactNotFoundException {
        dao.del(supprimerContact(contactName));
    }


    @Override
    public Contact creerContact(String nom) throws ContactException {
        Contact c = null;
        if(nom == null) {
            System.err.println("Une erreur de saisie est survenue");
            throw new ContactException();
        }
        if(nom.length() <= 3){
            System.err.println("Veuillez renseigner un nombre plus grand que 3");
            throw new ContactException();
        }
        if( nom.length() >= 40){
            System.err.println("Veuillez renseigner un nombre plus petit que 40");
            throw new ContactException();
        }
        if(dao.findByName(nom) != null){
            throw new ContactException();
        }

        c = new Contact(nom);

        return c;
    }

    @Override
    public Contact supprimerContact(String nom) throws ContactNotFoundException {
        Contact c = null;
        if(nom == null) {
            System.err.println("Suppression : Une erreur de saisie est survenue");
            throw new ContactNotFoundException();
        }

        c = dao.findByName(nom);

        return c;
    }
}