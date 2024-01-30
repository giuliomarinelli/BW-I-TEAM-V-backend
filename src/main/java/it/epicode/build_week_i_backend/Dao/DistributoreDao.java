package it.epicode.build_week_i_backend.Dao;

import jakarta.persistence.*;

public class DistributoreDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DistributoreDao (){
        emf = Persistence.createEntityManagerFactory("trasporto_pubblico_jpa");
        em= emf.createEntityManager();


    }}
