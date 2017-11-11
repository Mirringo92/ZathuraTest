package com.IngeSoft3.demo.presentation.businessDelegate;

import com.IngeSoft3.demo.modelo.TblDetallePrestamo;
import com.IngeSoft3.demo.modelo.TblLibros;
import com.IngeSoft3.demo.modelo.TblPrestamo;
import com.IngeSoft3.demo.modelo.TblSanciones;
import com.IngeSoft3.demo.modelo.control.ITblDetallePrestamoLogic;
import com.IngeSoft3.demo.modelo.control.ITblLibrosLogic;
import com.IngeSoft3.demo.modelo.control.ITblPrestamoLogic;
import com.IngeSoft3.demo.modelo.control.ITblSancionesLogic;
import com.IngeSoft3.demo.modelo.control.TblDetallePrestamoLogic;
import com.IngeSoft3.demo.modelo.control.TblLibrosLogic;
import com.IngeSoft3.demo.modelo.control.TblPrestamoLogic;
import com.IngeSoft3.demo.modelo.control.TblSancionesLogic;
import com.IngeSoft3.demo.modelo.dto.TblDetallePrestamoDTO;
import com.IngeSoft3.demo.modelo.dto.TblLibrosDTO;
import com.IngeSoft3.demo.modelo.dto.TblPrestamoDTO;
import com.IngeSoft3.demo.modelo.dto.TblSancionesDTO;
import com.IngeSoft3.demo.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private ITblDetallePrestamoLogic tblDetallePrestamoLogic;
    @Autowired
    private ITblLibrosLogic tblLibrosLogic;
    @Autowired
    private ITblPrestamoLogic tblPrestamoLogic;
    @Autowired
    private ITblSancionesLogic tblSancionesLogic;

    public List<TblDetallePrestamo> getTblDetallePrestamo()
        throws Exception {
        return tblDetallePrestamoLogic.getTblDetallePrestamo();
    }

    public void saveTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception {
        tblDetallePrestamoLogic.saveTblDetallePrestamo(entity);
    }

    public void deleteTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception {
        tblDetallePrestamoLogic.deleteTblDetallePrestamo(entity);
    }

    public void updateTblDetallePrestamo(TblDetallePrestamo entity)
        throws Exception {
        tblDetallePrestamoLogic.updateTblDetallePrestamo(entity);
    }

    public TblDetallePrestamo getTblDetallePrestamo(Long idDetalle)
        throws Exception {
        TblDetallePrestamo tblDetallePrestamo = null;

        try {
            tblDetallePrestamo = tblDetallePrestamoLogic.getTblDetallePrestamo(idDetalle);
        } catch (Exception e) {
            throw e;
        }

        return tblDetallePrestamo;
    }

    public List<TblDetallePrestamo> findByCriteriaInTblDetallePrestamo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tblDetallePrestamoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<TblDetallePrestamo> findPageTblDetallePrestamo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tblDetallePrestamoLogic.findPageTblDetallePrestamo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTblDetallePrestamo() throws Exception {
        return tblDetallePrestamoLogic.findTotalNumberTblDetallePrestamo();
    }

    public List<TblDetallePrestamoDTO> getDataTblDetallePrestamo()
        throws Exception {
        return tblDetallePrestamoLogic.getDataTblDetallePrestamo();
    }

    public void validateTblDetallePrestamo(
        TblDetallePrestamo tblDetallePrestamo) throws Exception {
        tblDetallePrestamoLogic.validateTblDetallePrestamo(tblDetallePrestamo);
    }

    public List<TblLibros> getTblLibros() throws Exception {
        return tblLibrosLogic.getTblLibros();
    }

    public void saveTblLibros(TblLibros entity) throws Exception {
        tblLibrosLogic.saveTblLibros(entity);
    }

    public void deleteTblLibros(TblLibros entity) throws Exception {
        tblLibrosLogic.deleteTblLibros(entity);
    }

    public void updateTblLibros(TblLibros entity) throws Exception {
        tblLibrosLogic.updateTblLibros(entity);
    }

    public TblLibros getTblLibros(Long idLibro) throws Exception {
        TblLibros tblLibros = null;

        try {
            tblLibros = tblLibrosLogic.getTblLibros(idLibro);
        } catch (Exception e) {
            throw e;
        }

        return tblLibros;
    }

    public List<TblLibros> findByCriteriaInTblLibros(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tblLibrosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TblLibros> findPageTblLibros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tblLibrosLogic.findPageTblLibros(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberTblLibros() throws Exception {
        return tblLibrosLogic.findTotalNumberTblLibros();
    }

    public List<TblLibrosDTO> getDataTblLibros() throws Exception {
        return tblLibrosLogic.getDataTblLibros();
    }

    public void validateTblLibros(TblLibros tblLibros)
        throws Exception {
        tblLibrosLogic.validateTblLibros(tblLibros);
    }

    public List<TblPrestamo> getTblPrestamo() throws Exception {
        return tblPrestamoLogic.getTblPrestamo();
    }

    public void saveTblPrestamo(TblPrestamo entity) throws Exception {
        tblPrestamoLogic.saveTblPrestamo(entity);
    }

    public void deleteTblPrestamo(TblPrestamo entity) throws Exception {
        tblPrestamoLogic.deleteTblPrestamo(entity);
    }

    public void updateTblPrestamo(TblPrestamo entity) throws Exception {
        tblPrestamoLogic.updateTblPrestamo(entity);
    }

    public TblPrestamo getTblPrestamo(Long idPrestamo)
        throws Exception {
        TblPrestamo tblPrestamo = null;

        try {
            tblPrestamo = tblPrestamoLogic.getTblPrestamo(idPrestamo);
        } catch (Exception e) {
            throw e;
        }

        return tblPrestamo;
    }

    public List<TblPrestamo> findByCriteriaInTblPrestamo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tblPrestamoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TblPrestamo> findPageTblPrestamo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tblPrestamoLogic.findPageTblPrestamo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTblPrestamo() throws Exception {
        return tblPrestamoLogic.findTotalNumberTblPrestamo();
    }

    public List<TblPrestamoDTO> getDataTblPrestamo() throws Exception {
        return tblPrestamoLogic.getDataTblPrestamo();
    }

    public void validateTblPrestamo(TblPrestamo tblPrestamo)
        throws Exception {
        tblPrestamoLogic.validateTblPrestamo(tblPrestamo);
    }

    public List<TblSanciones> getTblSanciones() throws Exception {
        return tblSancionesLogic.getTblSanciones();
    }

    public void saveTblSanciones(TblSanciones entity) throws Exception {
        tblSancionesLogic.saveTblSanciones(entity);
    }

    public void deleteTblSanciones(TblSanciones entity)
        throws Exception {
        tblSancionesLogic.deleteTblSanciones(entity);
    }

    public void updateTblSanciones(TblSanciones entity)
        throws Exception {
        tblSancionesLogic.updateTblSanciones(entity);
    }

    public TblSanciones getTblSanciones(Long idSancion)
        throws Exception {
        TblSanciones tblSanciones = null;

        try {
            tblSanciones = tblSancionesLogic.getTblSanciones(idSancion);
        } catch (Exception e) {
            throw e;
        }

        return tblSanciones;
    }

    public List<TblSanciones> findByCriteriaInTblSanciones(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tblSancionesLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TblSanciones> findPageTblSanciones(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tblSancionesLogic.findPageTblSanciones(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTblSanciones() throws Exception {
        return tblSancionesLogic.findTotalNumberTblSanciones();
    }

    public List<TblSancionesDTO> getDataTblSanciones()
        throws Exception {
        return tblSancionesLogic.getDataTblSanciones();
    }

    public void validateTblSanciones(TblSanciones tblSanciones)
        throws Exception {
        tblSancionesLogic.validateTblSanciones(tblSanciones);
    }
}
