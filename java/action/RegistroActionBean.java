package action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import repos.MundoFactory;
import mundo.Jugador;

@UrlBinding("/home.htm")
public class RegistroActionBean extends BaseActionBean{

	protected String nombre;

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
	
	@DefaultHandler
	public Resolution registrar() {
		
		if(this.elUsuarioExiste()){
			//mensage de error (El ususario ya existe)
		}else{
			Jugador nuevo = new Jugador(this.getNombre());
			MundoFactory.getInstance().agregarJugador(nuevo);
			MundoFactory.getInstance().setJugadorSeleccionado(nuevo);
			return new ForwardResolution("/editor.jsp");
		}
		
		return new ForwardResolution("/editor.jsp");
	}

	public Boolean elUsuarioExiste(){
		return MundoFactory.getInstance().buscarUsuario(this.getNombre());
	}

	@DefaultHandler
	public Resolution logear(){
		if(this.elUsuarioExiste()){
			MundoFactory.getInstance().setJugadorSeleccionado(this.jugadorSeleccionado());
			return new ForwardResolution("/editor.jsp");
		}else{
			//mensage de error (El usuario no existe)
		}
		return new ForwardResolution("/editor.jsp");
	}
	
	private Jugador jugadorSeleccionado() {
		return MundoFactory.getInstance().retJugador(this.getNombre());
	}
	
	
}
