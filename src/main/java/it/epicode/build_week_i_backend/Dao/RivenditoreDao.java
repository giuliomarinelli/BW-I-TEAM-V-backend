package it.epicode.build_week_i_backend.Dao;

import jakarta.persistence.*;

public class RivenditoreDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public RivenditoreDao (){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em= emf.createEntityManager();


        }

    }

