import org.junit.Test;

public class ContactServiceT {
    ContactService service = new ContactService();

    // =========== Ajout =========== //
    // Test si null
    @Test(expected = ContactException.class)
    public void testCreerContactNull() throws ContactException{
        service.add(null);
    }

    // Test si <3
    @Test(expected = ContactException.class)
    public void testCreerContactInf3() throws ContactException{
        ContactService service = new ContactService();
        service.add("a");
    }

    // Test si >40
    @Test(expected = ContactException.class)
    public void testCreerContactSup40() throws ContactException{
        ContactService service = new ContactService();
        service.add("zekefzjhfoziovboevbmpeohvpqejvbpqbvpabevpeqbvpourebvpruaeobvpaeruibvpaeruibvpaerubvpaerbvporubvpaerbvpeaorubvpaeorubvpaerobvpoeraubvopeur");
    }

    // Test si OK
    @Test
    public void testCreerContactOK() throws ContactException{
        ContactService service = new ContactService();
        service.add("Cookies-2");
    }

    // Test si déjà utilisé
    @Test(expected = ContactException.class)
    public void testCreerContactAlreadyUse() throws ContactException{
        ContactService service = new ContactService();
        service.add("Cookies");
        service.add("Cookies");
    }

    // =========== Suppression =========== //

    // Tests si null
    @Test(expected = ContactNotFoundException.class)
    public void testSuppContactNull() throws ContactNotFoundException{
        service.del(null);
    }

    // Tests si non existant
    @Test(expected = ContactNotFoundException.class)
    public void testSuppContactNotExist() throws ContactNotFoundException{
        service.del("Jean");
    }

    // Tests si OK
    @Test
    public void testSuppContactOK() throws ContactException, ContactNotFoundException{
        service.add("Cookies");
        service.del("Cookies");
    }

}
