package mx.com.cinepolis.scheduler.service;

import mx.com.arquitectura.base.model.UserDO;
import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;

import java.util.List;

/**
 * @author jrodriguez
 */
public interface CatalogService {

    /**
     *
     * @return User
     */
    UserTO getUser();
    
    
    /**
     * Retorna la lista de estado de un pais
     * @param pais acepta un pais como string
     * @return Lista de estados
     */
    List<CatalogsTO> getEstados(String pais);

    
    /**
     * Retorna la lista de los usuarios de bd
     */
 
    List<UserTO> getOutUser();
    
    
    public void registerUser(UserTO userTO);
    
    UserTO findById(Long id);
    
    
    
}
