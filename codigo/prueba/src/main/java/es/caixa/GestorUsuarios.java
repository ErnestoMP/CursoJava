package es.caixa;

import java.util.Map;
import java.util.HashMap;

public class GestorUsuarios{
    
    private Map<String,Usuario> tablaUsuarios = new HashMap<String,Usuario>();
    
    public Usuario getUsuario(String email){
        return tablaUsuarios.get(email);
    }
    
    public Usuario newUsuario(String email){
        Usuario nuevoUsuario=new Usuario(email);
        //nuevoUsuario.setEmail(email);
        tablaUsuarios.put(email,nuevoUsuario);
        return nuevoUsuario;
    }
}