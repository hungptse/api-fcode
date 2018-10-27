/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungpt.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author THANH HUNG
 */
@javax.ws.rs.ApplicationPath("hungpt")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(hungpt.service.AccountEventFacadeREST.class); 
        resources.add(hungpt.service.AccountFacadeREST.class);
        resources.add(hungpt.service.AttendanceFacadeREST.class);
        resources.add(hungpt.service.CourseFacadeREST.class);
        resources.add(hungpt.service.EventDetailFacadeREST.class);
        resources.add(hungpt.service.EventFacadeREST.class);
        resources.add(hungpt.service.EventStatusFacadeREST.class);
        resources.add(hungpt.service.EventTypeFacadeREST.class);
        resources.add(hungpt.service.MajorFacadeREST.class);
        resources.add(hungpt.service.RoleFacadeREST.class);
    }
    
}
