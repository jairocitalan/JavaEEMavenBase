package mx.com.cinepolis.scheduler.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import mx.com.cinepolis.scheduler.commons.to.ResponseTO;
import mx.com.cinepolis.scheduler.commons.to.UsuariosTO;
import mx.com.cinepolis.scheduler.service.UsuariosService;

@Stateless
@LocalBean
public class UsuariosFacadeEJB {

	@Inject
	UsuariosService usuarioService;
	
	public ResponseTO login(String user,String password) {
		return usuarioService.login(user, password);
	}   
	
	public ResponseTO ragistrarUsuario(UsuariosTO usuarioTO) {
		return usuarioService.registraUsuario(usuarioTO);	
	}
	
	public List<UsuariosTO> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	public ResponseTO actualizaUsuarios(UsuariosTO usuariosTO) {
		return usuarioService.actualizaUsuarios(usuariosTO);
	}
	
	public ResponseTO eliminaUsuarios(Long id) {
		return usuarioService.eliminaUsuarios(id);
	}
	
	
}
