package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.size;

public class TitoloDiViaggioDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public TitoloDiViaggioDAO() {
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void emettiTitolo(TitoloDiViaggio t) {
        if (!t.getEmittente().isActive()) {
            System.out.println("L'emittente non è attivo");
            return;
        }
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(t);
        et.commit();
    }

    public TitoloDiViaggio getById(int id) {
        return em.find(TitoloDiViaggio.class, id);
    }

    public void eliminaTitolo(int id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        TitoloDiViaggio t = getById(id);
        em.remove(t);
        et.commit();
    }

    public void vidimaTitolo(int id, Viaggio v) {
        TitoloDiViaggio t = getById(id);
        if (t.getDataAttivazione() != null) {
            System.out.println("Il titolo di viaggio è già stato vidimato");
            return;
        }
        t.setDataAttivazione(LocalDateTime.now());
        EntityTransaction et = em.getTransaction();
        et.begin();
        t.getViaggi().add(v);
        em.persist(t);
        et.commit();
    }

    public long numeroAbbonamentiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        Query q = em.createQuery("SELECT COUNT(a) FROM Abbonamento a WHERE a.dataEmissione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return (Long) q.getSingleResult();
    }

    public long numeroAbbonamentiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo, int idEmittente) {
        EmittenteDao emittenteDao = new EmittenteDao();
        Emittente e = emittenteDao.getById(idEmittente);
        Query q = em.createQuery("SELECT COUNT(a) FROM Abbonamento a WHERE a.dataEmissione BETWEEN :inizio AND :fine AND a.emittente = :e");
        q.setParameter("e", e);
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return (Long) q.getSingleResult();

    }

    public long numeroBigliettiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo, int idEmittente) {
        EmittenteDao emittenteDao = new EmittenteDao();
        Emittente e = emittenteDao.getById(idEmittente);
        Query q = em.createQuery("SELECT COUNT(e) FROM Biglietto e WHERE e.dataEmissione BETWEEN :inizio AND :fine AND e.emittente = :e");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        q.setParameter("e", e);
        return (Long) q.getSingleResult();
    }

    public long numeroBigliettiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        Query q = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return (Long) q.getSingleResult();
    }

    public long numeroTitoliDiViaggioEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        return numeroBigliettiTotaliEmessi(inizioPeriodo, finePeriodo) +
                numeroAbbonamentiTotaliEmessi(inizioPeriodo, finePeriodo);
    }

    public long numeroTitoliDiViaggioEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo, int idEmittente) {
        return numeroBigliettiTotaliEmessi(inizioPeriodo, finePeriodo, idEmittente) +
                numeroAbbonamentiTotaliEmessi(inizioPeriodo, finePeriodo, idEmittente);
    }

    public static boolean verificaValiditaAbbonamento(Abbonamento a, int idTessera) {
        TesseraDao tesseraDao = new TesseraDao();
        Tessera t = tesseraDao.getbyid(idTessera);
        if (t == null) {
            System.out.println("tessera inesistente");
            return false;
        }

        if (!a.getTessera().equals(t)) return false;

        if (a.getDataScadenza().isBefore(LocalDateTime.now())) return false;

        if (a.getDataAttivazione().isAfter(LocalDateTime.now()) || a.getDataAttivazione() == null) return false;

        return true;

    }

    public long numeroTitoliDiViaggioVidimati(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        Query q = em.createQuery("SELECT COUNT(t) FROM TitoloDiViaggio t " +
                "WHERE t.dataAttivazione IS NOT NULL AND t.dataAttivazione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return (Long) q.getSingleResult();
    }


    public int numeroTitoliDiViaggioVidimatiPerMezzo(int idMezzo) {
        MezzoDao mezzoDao = new MezzoDao();
        Mezzo mezzo = mezzoDao.getById(idMezzo);
        int contatore = mezzo.getViaggi().stream().flatMap(v -> v.getTitoliDiViaggio().stream()).toList().size();

        return contatore;
    }
}
