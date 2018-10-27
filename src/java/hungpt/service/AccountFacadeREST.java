/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.service;

import hungpt.entites.Account;
import java.nio.charset.StandardCharsets;
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
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Account entity) {
        super.create(entity);
    }

    @PUT
    @Path("profile/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") String id, Account entity) {
        getEntityManager().getTransaction().begin();
        Account existed = find(id);
        existed.setEmail(entity.getEmail());
        existed.setLinkFB(entity.getLinkFB());
        existed.setName(new String(entity.getName().getBytes(),StandardCharsets.UTF_8));    
        existed.setPhone(entity.getPhone());
        existed.setGender(entity.getGender());
        existed.setAddress(entity.getAddress());
        existed.setDayOfBirth(entity.getDayOfBirth());
        existed.setAboutMe(new String(entity.getAboutMe().getBytes(),StandardCharsets.UTF_8));
        getEntityManager().getTransaction().commit();
    }
    
    @PUT
    @Path("isActive/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editIsActive(@PathParam("id") String id, Account entity) {
        getEntityManager().getTransaction().begin();
        Account existed = find(id);
        existed.setIsActive(entity.getIsActive());
        getEntityManager().getTransaction().commit();
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
        return (Account) getEntityManager().createNamedQuery("Account.findByStudentID").setParameter("studentID", id).getSingleResult();
    }
    
    @GET
    @Path("notNew")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> findMemberNotNew() {
        return getEntityManager().createQuery("SELECT a FROM Account a WHERE a.roleId.roleId <> 5").getResultList();
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> findAll() {
       return super.findAll();
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
        Query q = getEntityManager().createQuery("SELECT a.roleId.roleName FROM Account a WHERE a.studentID = :studentID AND a.password = :password");
        q.setParameter("studentID", stuId);
        q.setParameter("password", password);
        return q.getSingleResult().toString();
    }

    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
