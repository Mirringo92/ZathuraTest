package com.IngeSoft3.demo.dataaccess.dao;

import com.IngeSoft3.demo.dataaccess.api.JpaDaoImpl;
import com.IngeSoft3.demo.modelo.TblLibros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * TblLibros entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.TblLibros
 */
@Scope("singleton")
@Repository("TblLibrosDAO")
public class TblLibrosDAO extends JpaDaoImpl<TblLibros, Long>
    implements ITblLibrosDAO {
    private static final Logger log = LoggerFactory.getLogger(TblLibrosDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ITblLibrosDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ITblLibrosDAO) ctx.getBean("TblLibrosDAO");
    }
}
