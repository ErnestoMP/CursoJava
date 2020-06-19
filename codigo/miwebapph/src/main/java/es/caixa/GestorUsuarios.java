package es.caixa;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GestorUsuarios{
    
//    private Map<String,Usuario> tablaUsuarios = new HashMap<String,Usuario>();
    
    public Usuario getUsuario(Integer id){
        //return tablaUsuarios.get(email);
        try{
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            Usuario usuario=session.get(Usuario.class, id);
            tx.commit();
            session.close();
            return usuario;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
    
    public Usuario newUsuario(String nombre,String apellidos, Integer edad, String email){
        try{
            Usuario usuario=new Usuario();
            usuario.setEmail(email);
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setEdad(edad);

            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(usuario);
            tx.commit();
            session.close();

            return usuario;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void datosUsuarioModificados(Usuario usuario){
        try{

            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.update(usuario);
            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void borrarUsuario(Usuario usuario){
        try{
            
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.delete(usuario);
            tx.commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}