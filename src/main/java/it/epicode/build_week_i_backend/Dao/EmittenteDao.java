package it.epicode.build_week_i_backend.Dao;

import jakarta.persistence.*;

public class EmittenteDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EmittenteDao (){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em= emf.createEntityManager();


    }}
