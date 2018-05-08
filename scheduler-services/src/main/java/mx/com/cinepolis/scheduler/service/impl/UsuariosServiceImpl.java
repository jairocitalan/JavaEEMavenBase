package mx.com.cinepolis.scheduler.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import mx.com.arquitectura.base.model.UsuariosDO;
import mx.com.cinepolis.scheduler.commons.to.ResponseTO;
import mx.com.cinepolis.scheduler.commons.to.UsuariosTO;
import mx.com.cinepolis.scheduler.data.persistence.dao.UsuariosDAO;
import mx.com.cinepolis.scheduler.service.UsuariosService;

public class UsuariosServiceImpl implements UsuariosService {
    
	@Inject 
	UsuariosDAO usuariosDAO;
	
	@Override
	public ResponseTO login(String user, String pass) {
	    ResponseTO response = new ResponseTO();
	    response.setTypeResponse("SUCCESS");
	    response.setDetail("SUCCESS");
	    
	    try {
	       usuariosDAO.getByColumn("usuario", UsuariosDO.class, user);
		   usuariosDAO.getByColumn("password", UsuariosDO.class, pass);
	    }catch(Exception e) {
	    	response.setTypeResponse("FAIL");
		    response.setDetail(e.getMessage());
	    }
		
		return response;
	}

	@Override
	public ResponseTO registraUsuario(UsuariosTO usuarioTO) {
		UsuariosDO usuariosDO = new UsuariosDO();
		usuariosDO.setId_user(usuarioTO.getId_user());
        usuariosDO.setUsuario(usuarioTO.getUsuario());
        usuariosDO.setNombre(usuarioTO.getNombre());
        usuariosDO.setPassword(usuarioTO.getPassword());
		usuariosDO.setId_permiso(usuarioTO.getId_permiso());
		
		ResponseTO response = new ResponseTO();
        response.setTypeResponse("SUCCESS");
        response.setDetail("SUCCESS");
        
        try {
        	usuariosDAO.create(usuariosDO);
        }catch(Exception e) {
        	response.setDetail(e.getMessage());
            response.setTypeResponse("FAIL");
        }
		
		return response;
	
	}

	@Override
	public List<UsuariosTO> getAllUsuarios() {
		List<UsuariosDO> usuarioTOList = usuariosDAO.findAll();
		
		return usuarioTOList.stream().map(x -> new UsuariosTO() {{ 
		    setId_user(x.getId_user());
		    setNombre(x.getNombre());
		    setUsuario(x.getUsuario());
		    setPassword(x.getPassword());
		    setId_permiso(x.getId_permiso());
		}}).collect(Collectors.toList());
		
	}

	@Override
	public ResponseTO actualizaUsuarios(UsuariosTO usuariosTO) {
        UsuariosDO usuarioDO = new UsuariosDO();
        usuarioDO.setId_user(usuariosTO.getId_user());
        usuarioDO.setUsuario(usuariosTO.getUsuario());
        usuarioDO.setNombre(usuariosTO.getNombre());
        usuarioDO.setPassword(usuariosTO.getPassword());
        usuarioDO.setId_permiso(usuariosTO.getId_permiso());
        
        ResponseTO response = new ResponseTO();
        response.setTypeResponse("SUCCESS");
        response.setDetail("SUCCESS");
        
        try {
        	usuariosDAO.update(usuarioDO);
        }catch(Exception e) {
        	response.setDetail(e.getMessage());
            response.setTypeResponse("FAIL");
        }
        
		return response;
	}

	@Override
	public ResponseTO eliminaUsuarios(Long id) {
		ResponseTO response = new ResponseTO();
		response.setTypeResponse("SUCCESS");
	    response.setDetail("SUCCESS");
	    
	    try {
	    	usuariosDAO.delete(id);
	    }catch(Exception e){
	    	response.setDetail(e.getMessage());
            response.setTypeResponse("FAIL");
	    }
		return response;
	}
	
	
	
	
	
	
	
	
	
	

}
