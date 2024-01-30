package it.epicode.build_week_i_backend;


import it.epicode.build_week_i_backend.Dao.EmittenteDao;
import it.epicode.build_week_i_backend.Dao.TesseraDao;
import it.epicode.build_week_i_backend.Dao.TitoloDiViaggioDAO;
import it.epicode.build_week_i_backend.Dao.ViaggioDao;
import it.epicode.build_week_i_backend.entities.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TitoloDiViaggioDAO titoloDiViaggioDAO = new TitoloDiViaggioDAO();

        ViaggioDao.open();
        Viaggio v = ViaggioDao.findOne(1);
        ViaggioDao.close();

        titoloDiViaggioDAO.vidimaTitolo(1, v);
    }
}
