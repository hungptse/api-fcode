/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.service;

import hungpt.entites.Account;
import hungpt.entites.AccountEvent;
import hungpt.entites.AccountEventPK;
import hungpt.entites.Attendance;
import hungpt.entites.EventDetail;
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

/**
 *
 * @author THANH HUNG
 */
@Path("eventDetail")
public class EventDetailFacadeREST extends AbstractFacade<EventDetail> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FcodePU");
    private EntityManager em = emf.createEntityManager();

    public EventDetailFacadeREST() {
        super(EventDetail.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public void create(EventDetail entity) {
        getEntityManager().getTransaction().begin();
        int id = entity.getAccountEvent().getEvent().getEventId();
        List<AccountEvent> accountEvent = new AccountEventFacadeREST().getAllAccountByEventID(id);

        EventDetail ed = new EventDetail();
        ed.setAccountEvent(accountEvent.get(0));
        ed.setDateEvent(entity.getDateEvent());
        ed.setDetailName(entity.getDetailName());
        getEntityManager().persist(ed);
        getEntityManager().flush();
        for (AccountEvent ae : accountEvent) {
            Attendance a = new Attendance();
            a.setEventDetail(ed);
            a.setIsUsed(false);
            a.setIsPresent(false);
            a.setNote("");
            a.setStudentID(ae.getAccount());
            getEntityManager().persist(a);
        }

        getEntityManager().getTransaction().commit();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, EventDetail entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventDetail find(@PathParam("id") Integer id) {
//        return super.find(id);
        return (EventDetail) getEntityManager().createNamedQuery("EventDetail.findByEventDetail").setParameter("eventDetail", id).getSingleResult();
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventDetail> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EventDetail> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
