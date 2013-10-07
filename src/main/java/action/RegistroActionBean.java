package action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;

import repos.MundoFactory;
import mundo.Jugador;

@UrlBinding("/logeo.htm")
public class RegistroActionBean extends BaseActionBean{

	// **********************************************
	// * VARIABLES
	// **********************************************
	
	@Validate(required = true, minlength = 3, maxlength=15) private String nombre;	
	
	// **********************************************
	// * ACCESSORS
	// **********************************************
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// **********************************************
	// * METODOS
	// **********************************************
	
	@HandlesEvent("registrar")
	public Resolution registrar() {		
		if(this.elUsuarioExiste()){
			throw new RuntimeException("El usuario ya existe");
		}else{
			Jugador nuevo = new Jugador(this.getNombre()); 
			MundoFactory.getInstance().agregarJugador(nuevo); 
			MundoFactory.getInstance().setJugadorSeleccionado(nuevo);
			return this.abrirEditor();
		}		
	}
	
	@DefaultHandler
	public Resolution abrirEditor(){
		return new ForwardResolution("/editor.jsp");
	}
	
	public Boolean elUsuarioExiste(){
		return this.buscarUsuario();
	}

	private Boolean buscarUsuario() {
		return MundoFactory.getInstance().buscarUsuario(this.getNombre());
	}

	@HandlesEvent("logear")
	public Resolution logear(){
		if(this.elUsuarioExiste()){
			MundoFactory.getInstance().setJugadorSeleccionado(this.jugadorSeleccionado());
			return this.abrirEditor();
		}else{
			throw new RuntimeException("El usuario no existe");
		}
	}
	
	private Jugador jugadorSeleccionado() {
		return MundoFactory.getInstance().retJugador(this.getNombre());
	}
	
	
}