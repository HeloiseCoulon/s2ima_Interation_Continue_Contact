public interface IContactService {

    /**
     * Méthode qui permet de créer un contact
     *
     * @param nom nom du contact a créer
     * @return Contact créé
     * @throws ContactException exception lorsque le contact ne peut être créé
     */
    Contact creerContact(String nom) throws ContactException;

    Contact supprimerContact(String nom) throws ContactNotFoundException;
}
