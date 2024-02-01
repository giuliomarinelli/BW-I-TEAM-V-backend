package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtenteDao {


    private EntityManagerFactory emf;
    private EntityManager em;

    public UtenteDao(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void saveUtente(Utente u){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(u);
        et.commit();
    }

    public Utente getbyid(int id){
        return em.find(Utente.class, id);
    }
        public void deleteUtente(int id){
        EntityTransaction et = em.getTransaction();
            et.begin();
            Utente u = getbyid(id);
            em.remove(u);
            et.commit();
        }

}
