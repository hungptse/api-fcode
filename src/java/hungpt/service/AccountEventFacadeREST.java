/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.service;

import hungpt.entites.Account;
import hungpt.entites.AccountEvent;
import hungpt.entites.AccountEventPK;
import hungpt.entites.Event;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author THANH HUNG
 */
@Path("accountEvent")
public class AccountEventFacadeREST extends AbstractFacade<AccountEvent> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FcodePU");
    private EntityManager em = emf.createEntityManager();

    private AccountEventPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;eventId=eventIdValue;studentID=studentIDValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        AccountEventPK key = new AccountEventPK();
        MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        List<String> eventId = map.get("eventId");
        if (eventId != null && !eventId.isEmpty()) {
            key.setEventId(new java.lang.Integer(eventId.get(0)));
        }
        List<String> studentID = map.get("studentID");
        if (studentID != null && !studentID.isEmpty()) {
            key.setStudentID(studentID.get(0));
        }
        return key;
    }

    public AccountEventFacadeREST() {
        super(AccountEvent.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(List<AccountEvent> list) {
        getEntityManager().getTransaction().begin();
        List<Account> listA = new ArrayList<>();
        List<AccountEvent> ae = new ArrayList<>();
        for (AccountEvent accountEvent : list) {
            listA.add(accountEvent.getAccount());
        }
        Event e = list.get(0).getEvent();
        getEntityManager().persist(e);
        getEntityManager().flush();
        for (Account account : listA) {
            AccountEventPK aePk = new AccountEventPK(e.getEventId(),account.getStudentID());
            ae.add(new AccountEvent(aePk,true));
        }
        for (AccountEvent accountEvent : ae) {              
            getEntityManager().persist(accountEvent);
        }
        getEntityManager().getTransaction().commit();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, AccountEvent entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        AccountEventPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AccountEvent find(@PathParam("id") PathSegment id) {
        AccountEventPK key = getPrimaryKey(id);
        return super.find(key);
    }
    
    public List<AccountEvent> getAllAccountByEventID(int id)
    {
        return getEntityManager().createNamedQuery("AccountEvent.findByEventId").setParameter("eventId", id).getResultList();
    }
    

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<AccountEvent> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AccountEvent> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
