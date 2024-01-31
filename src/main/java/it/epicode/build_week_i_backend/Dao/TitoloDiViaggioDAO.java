package it.epicode.build_week_i_backend.Dao;

import it.epicode.build_week_i_backend.entities.Abbonamento;
import it.epicode.build_week_i_backend.entities.Tessera;
import it.epicode.build_week_i_backend.entities.TitoloDiViaggio;
import it.epicode.build_week_i_backend.entities.Viaggio;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.size;

public class TitoloDiViaggioDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public TitoloDiViaggioDAO(){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em = emf.createEntityManager();
    }

    public void emettiTitolo(TitoloDiViaggio t){
        if (!t.getEmittente().isActive()) {
            System.out.println("L'emittente non è attivo");
            return;
        }
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(t);
        et.commit();
    }

    public TitoloDiViaggio getById(int id){
        return em.find(TitoloDiViaggio.class, id);
    }

    public void eliminaTitolo(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();
        TitoloDiViaggio t = getById(id);
        em.remove(t);
        et.commit();
    }

    public void vidimaTitolo(int id, Viaggio v){
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

    public int numeroAbbonamentiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        Query q = em.createQuery("SELECT COUNT(a) FROM Abbonamento a WHERE a.dataEmissione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return Integer.parseInt(q.getSingleResult().toString());
    }

    public int numeroAbbonamentiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo, int idEmittente) {
        Query q = em.createQuery("SELECT a FROM Abbonamento a WHERE a.dataEmissione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return ((List<Abbonamento>) q.getResultList()).stream().filter(a -> a.getId() == idEmittente)
                .toList().size();
    }
public int numeroBigliettiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo, int idEmittente) {
        Query q = em.createQuery("SELECT e FROM Biglietto e WHERE e.dataEmissione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return ((List<Abbonamento>) q.getResultList()).stream().filter(a -> a.getId() == idEmittente)
                .toList().size();
    }

    public int numeroBigliettiTotaliEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        Query q = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return Integer.parseInt(q.getSingleResult().toString());
    }

    public int numeroTitoliDiViaggioEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        return numeroBigliettiTotaliEmessi(inizioPeriodo, finePeriodo) +
                numeroAbbonamentiTotaliEmessi(inizioPeriodo, finePeriodo);
    }

    public int numeroTitoliDiViaggioEmessi(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo, int idEmittente) {
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

        return true;

    }

    public int numeroTitoliDiViaggioVidimati(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo) {
        Query q = em.createQuery("SELECT COUNT(t) FROM TitoloDiViaggio t " +
                "WHERE t.dataDiAttivazione IS NOT NULL AND t.dataDiAttivazione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
        return Integer.parseInt(q.getSingleResult().toString());
    }

    public int numeroTitoliDiViaggioVidimatiPerMezzo(LocalDateTime inizioPeriodo, LocalDateTime finePeriodo, int idMezzo) {
        MezzoDao mezzoDao = new MezzoDao();
        Query q = em.createQuery("SELECT t FROM TitoloDiViaggio t " +
                "WHERE t.dataDiAttivazione IS NOT NULL AND t.dataDiAttivazione BETWEEN :inizio AND :fine");
        q.setParameter("inizio", inizioPeriodo);
        q.setParameter("fine", finePeriodo);
//        List<Viaggio> viaggi = mezzoDao.getById(idMezzo).getViaggi();
//        viaggi.stream().filter(v -> v.get)
        return 0;
    }


}
