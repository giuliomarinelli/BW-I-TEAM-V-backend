package it.epicode.build_week_i_backend;


import it.epicode.build_week_i_backend.Dao.*;
import it.epicode.build_week_i_backend.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        TitoloDiViaggioDAO titoloDiViaggioDAO = new TitoloDiViaggioDAO();
        UtenteDao utenteDao = new UtenteDao();
        TesseraDao tesseraDao = new TesseraDao();
        MezzoDao mezzoDao = new MezzoDao();
        EmittenteDao emittenteDao = new EmittenteDao();
        ManutenzioneDAO manutenzioneDao = new ManutenzioneDAO();



//
//        Tratta t1 = new Tratta();
//        t1.setZonaPartenza("milano");
//        t1.setZonaArrivo("roma");
//        t1.setTempoMedioPercorrenza(3);
//
//        TrattaDao.open();
//        TrattaDao.save(t1);
//
//        Utente u1 = new Utente();
//        u1.setNome("Mario");
//        u1.setCognome("tommasini");
//        u1.setSesso(Sesso.M);
//        u1.setDataNascita(LocalDate.of(1998, 12,1));
//        u1.setLuogoNascita("messina");
//
//        Utente u2 = new Utente();
//        u2.setNome("Maria");
//        u2.setCognome("tommasini");
//        u2.setSesso(Sesso.F);
//        u2.setDataNascita(LocalDate.of(1990, 12,1));
//        u2.setLuogoNascita("messina");
//
//        utenteDao.saveUtente(u1);
//        utenteDao.saveUtente(u2);
//
//
//        Tessera tessera1 = new Tessera();
//        Tessera tessera2 = new Tessera();
//
//
//
//
//
//        tessera1.setUtente(u1);
//        tessera1.setDataEmissioneORinnovo(LocalDate.of(2024, 06,15));
//
//        tessera2.setUtente(u2);
//        tessera2.setDataEmissioneORinnovo(LocalDate.of(2024,12,23));
//
//        tesseraDao.saveTessera(tessera1);
//        tesseraDao.saveTessera(tessera2);

//        TrattaDao.open();
//        Tratta tratta1=TrattaDao.findOne(2);
//
//        Tram tram1 = new Tram();
//        tram1.setCapienza(90);
//        tram1.setTratta(tratta1);
//
//        Autobus autobus1= new Autobus();
//        autobus1.setCapienza(120);
//        autobus1.setTratta(tratta1);
//
//        mezzoDao.save(autobus1);
//        mezzoDao.save(tram1);
//
//        Distributore distributore = new Distributore();
//        distributore.setAttivo(true);
//        distributore.setLuogo("bologna");
//
//        Rivenditore rivenditore = new Rivenditore();
//        rivenditore.setAperto(true);
//        rivenditore.setLuogo("trieste");
//
//        emittenteDao.save(distributore);
//        emittenteDao.save(rivenditore);
//
//       Biglietto biglietto1 = new Biglietto();
//        Biglietto biglietto2 = new Biglietto();
//
//       biglietto1.setEmittente(rivenditore);
//       biglietto1.setDataEmissione(LocalDateTime.of(LocalDate.of(2024,1,15), LocalTime.of (15,30,50) ));
//
//
//        biglietto2.setEmittente(rivenditore);
//        biglietto2.setDataEmissione(LocalDateTime.of(LocalDate.of(2024,1,15), LocalTime.of (15,30,50) ));
//        titoloDiViaggioDAO.emettiTitolo(biglietto1);
//        titoloDiViaggioDAO.emettiTitolo(biglietto2);
//
//
//        Abbonamento abbonamento1 = new Abbonamento();
//        Abbonamento abbonamento2 = new Abbonamento();
//
//
//
//       abbonamento1.setEmittente(distributore);
//       abbonamento1.setDataEmissione(LocalDateTime.of(LocalDate.of(2024,1,20), LocalTime.of(12,0,20)));
//       abbonamento1.setDurata(DurataAbbonamento.MENSILE);
//
//        abbonamento2.setEmittente(distributore);
//        abbonamento2.setDataEmissione(LocalDateTime.of(LocalDate.of(2024,1,1), LocalTime.of(12,0,20)));
//        abbonamento2.setDurata(DurataAbbonamento.MENSILE);
//
//
//
//         Tessera tessera1 = tesseraDao.getbyid(2);
//         Tessera tessera2 = tesseraDao.getbyid(3);
//
//       abbonamento1.setTessera(tessera1);
//       abbonamento2.setTessera(tessera1);
//
//        titoloDiViaggioDAO.emettiTitolo(abbonamento1);
//        titoloDiViaggioDAO.emettiTitolo(abbonamento2);

//        TrattaDao.open();
//        Tratta tratta1 = TrattaDao.findOne(2);
//
          Mezzo tram1 =  mezzoDao.getById(2);
//       Mezzo autobus1 =mezzoDao.getById(1);
//
//       TitoloDiViaggio abbonamento1 = titoloDiViaggioDAO.getById(3);
//        TitoloDiViaggio abbonamento2 = titoloDiViaggioDAO.getById(4);
//
//        TitoloDiViaggio biglietto1 = titoloDiViaggioDAO.getById(1);
//        TitoloDiViaggio biglietto2 = titoloDiViaggioDAO.getById(2);
//
//
//       Viaggio viaggio1 = new Viaggio();
//
//        viaggio1.setMezzo(tram1);
//        viaggio1.setMezzo(autobus1);
//        viaggio1.setTratta(tratta1);
//
//        ViaggioDao.open();
//        ViaggioDao.save(viaggio1);
//
//        titoloDiViaggioDAO.vidimaTitolo(3, viaggio1);
//
//        titoloDiViaggioDAO.vidimaTitolo(1, viaggio1);

//
        Manutenzione manutenzione = new Manutenzione();
        manutenzione.setMezzo(tram1);
        manutenzione.setDataInizio(LocalDateTime.of(LocalDate.of(2024,1,15), LocalTime.of (15,30,50) ));
        manutenzione.setDatafine(LocalDateTime.of(LocalDate.of(2024,2,15), LocalTime.of (15,30,50) ));

        manutenzioneDao.save(manutenzione);

        System.out.println(manutenzione.getMezzo());

    }
}
