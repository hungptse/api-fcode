/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.service;

import hungpt.entites.Account;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("account")
public class AccountFacadeREST extends AbstractFacade<Account> {

//    @PersistenceContext(unitName = "FcodePU")
//    private EntityManager em;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("FcodePU");
    private EntityManager em = emf.createEntityManager();

    public AccountFacadeREST() {
        super(Account.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Account entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Account entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> findAll() {
        System.out.println("A");
        Query q = getEntityManager().createQuery("SELECT a FROM Account a");
        List<Account> list = q.getResultList();
        return list;
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("authencation/{stuId}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRoleOfAcc(@PathParam("stuId") String stuId, @PathParam("password") String password) {
        Query q = getEntityManager().createQuery("SELECT a.roleId.roleName FROM Account a WHERE a.studentID = :studentID AND a.password = :password AND a.isActive = 1");
        q.setParameter("studentID", stuId);
        q.setParameter("password", password);
        return q.getSingleResult().toString();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
