package mx.com.cinepolis.scheduler.data.persistence.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import mx.com.arquitectura.arquitectura.persistence.impl.BaseDAOImpl;
import mx.com.arquitectura.base.model.UsuariosDO;
import mx.com.cinepolis.scheduler.data.persistence.dao.UsuariosDAO;

public class UsuariosDAOImpl extends BaseDAOImpl<UsuariosDO, Long> implements UsuariosDAO {

	
	 @Override
	    @PersistenceContext
	    public void setEntityManager(EntityManager entityManager) {
	        super.setEntityManager(entityManager);
	    }

	
}
