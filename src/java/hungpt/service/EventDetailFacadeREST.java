/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.service;

import hungpt.entites.Attendance;
import hungpt.entites.EventDetail;
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
    public void create(List<EventDetail> list) {
        getEntityManager().getTransaction().begin();
        for (EventDetail entity : list) {
            getEntityManager().persist(entity);
            Attendance a = new Attendance();
            a.setIsPresent(false);
            a.setNote("");
            a.setStudentID(entity.getStudentID().getStudentID());
            a.setEventDetail(entity);
            a.setIsUsed(false);
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
    @Produces({MediaType.APPLICATION_JSON})
    public EventDetail find(@PathParam("id") Integer id) {
        return super.find(id);
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
