package YahiaLakrikba;

import jakarta.persistence.*;

public class EventoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EventoDAO() {
        emf = Persistence.createEntityManagerFactory("gestioneeventi");
        em = emf.createEntityManager();
    }

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Long id) {
        Evento evento = getById(id);
        if (evento != null) {
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
        }
    }

    public void close() {
        em.close();
        emf.close();
    }
}
