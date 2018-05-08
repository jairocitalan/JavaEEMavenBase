package mx.com.cinepolis.scheduler.commons.to;



public class UsuariosTO {

    private Long id_user;	
	
	private String usuario;
	
	
	private String nombre;
	
	
	private String password;
	
	
	private int id_permiso;


	public Long getId_user() {
		return id_user;
	}


	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId_permiso() {
		return id_permiso;
	}


	public void setId_permiso(int id_permiso) {
		this.id_permiso = id_permiso;
	}
	
	
	
}
