package it.epicode.week3.progetto.dao;

import it.epicode.week3.progetto.entities.Rivenditore;
import jakarta.persistence.*;

public class EmittenteDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EmittenteDao (){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em= emf.createEntityManager();


    }}
