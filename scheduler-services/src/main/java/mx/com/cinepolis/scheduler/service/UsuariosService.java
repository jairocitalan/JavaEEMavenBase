package mx.com.cinepolis.scheduler.service;

import java.util.List;

import mx.com.cinepolis.scheduler.commons.to.ResponseTO;
import mx.com.cinepolis.scheduler.commons.to.UsuariosTO;

public interface UsuariosService {

	public ResponseTO login(String usuario,String password);
	
	public ResponseTO registraUsuario(UsuariosTO usuarioTO);

	public List<UsuariosTO> getAllUsuarios();
	
	public ResponseTO actualizaUsuarios(UsuariosTO usuariosTO);

    public ResponseTO eliminaUsuarios(Long id);	

}