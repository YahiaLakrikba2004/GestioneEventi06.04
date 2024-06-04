package YahiaLakrikba;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        try {
            EventoDAO eventoDAO = new EventoDAO();

            Evento nuovoEvento = new Evento(
                    "Conferenza 2",
                    new Date(),
                    "Una conferenza sulla vita.",
                    TipoEvento.PUBBLICO,
                    300
            );

            eventoDAO.save(nuovoEvento);
            System.out.println("Nuovo evento salvato: " + nuovoEvento.getId());

            Evento nuovoEventoSalvato = eventoDAO.getById(nuovoEvento.getId());
            if (nuovoEventoSalvato != null) {
                System.out.println("Evento salvato: " + nuovoEventoSalvato.getTitolo());
            } else {
                System.out.println("Errore durante il recupero dell'evento salvato.");
            }

//            eventoDAO.delete(nuovoEventoSalvato.getId());
//            System.out.println("Evento eliminato con successo.");

            eventoDAO.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Si è verificato un errore durante l'esecuzione dell'applicazione.");
        }
    }
}
