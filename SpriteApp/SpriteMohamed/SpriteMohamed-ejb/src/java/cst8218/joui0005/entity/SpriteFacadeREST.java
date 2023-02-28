/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.joui0005.entity;

import cst8218.joui0005.entity.Sprite;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
import javax.ws.rs.core.Response;

/**
 * Purpose : Contains the necessary restAPI functions to make crud operations : get , put, post, delete
 * 
 * @author Mohamed Jouini
 * 
 * Student Id : 040994664
 * 
 * 
 * 
 *      
 */
@Stateless
@Path("cst8218.joui0005.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "SpriteMohamed-warPU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sprite entity) {
        super.create(entity);
    }
    
    /**
     * POST on a specific id 
     * @param id -- the param id
     * @param entity --  body of the request
     * @return the response generated
     */
    @POST
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateSprite(@PathParam("id") Long id, Sprite entity){
        Sprite s = super.find(id);
        if(s==null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Cannot process request").build();
        }
        else{
            s.updateSprite(entity, s);
            return Response.status(Response.Status.CREATED).entity(s).build();
            
        }
    }

    
    public void edit(@PathParam("id") Long id, Sprite entity) {        
        super.edit(entity);
    }

    /**
     * PUT on a specific id:- as it will replace the specific entity with the mentioned body of the request
     * @param id -- the param id
     * @param entity --  body of the request
     * @return the response generated
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response replaceSprite(@PathParam("id") Long id, Sprite entity){
        Sprite s = super.find(id);
        if(s==null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Cannot process request").build();
                    
        }
        else{
            s.replaceSprite(entity, s);
            return Response.ok("Entity created").build(); 
        }
       
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sprite find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
