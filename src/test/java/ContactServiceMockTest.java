import org.easymock.*;
import org.junit.Rule;
import org.junit.Test;

public class ContactServiceMockTest extends EasyMockSupport{

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @TestSubject
    private ContactService service = new ContactService();

    @Mock
    private IContactDao contactDao;

    @Test(expected = ContactException.class)
    public void testAddContact() throws ContactException {
        // 1 - Enregistrement des comportement de mocks
        EasyMock.expect(contactDao.findByName("Cookies")).andReturn(new Contact());
        // 2 - Fin d'nregistrement
        replayAll();
        // 3 - Test
        service.add("Cookies");
    }

//    @Test(expected = ContactNotFoundException.class)
//    public void testDelContactNonExist() throws ContactNotFoundException {
//        // 1 - Enregistrement des comportement de mocks
//        EasyMock.expect(contactDao.findByName("ContactPasExistant")).andReturn(null);
//        // 2 - Fin d'nregistrement
//        replayAll();
//        // 3 - Test
//        service.del("ContactPasExistant");
//    }

    @Test
    public void testDelContactExist() throws ContactNotFoundException {
        // 1 - Enregistrement des comportement de mocks
        Contact contact = new Contact();
        contact.setNom("Contact");
        EasyMock.expect(contactDao.findByName(contact.getNom())).andReturn(contact);
        contactDao.del(contact);
        // 2 - Fin d'nregistrement
        replayAll();
        // 3 - Test
        service.del(contact.getNom());
    }
}
