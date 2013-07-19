package negocio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import com.dao.Conectados;
//import com.dao.LugarPunto;
//import com.dao.LugaresDAO;
//import com.dao.Puntos;
//import com.dao.PuntosDAO;
//import com.dao.UsuLatLong;
//import com.dao.Usuario;
//import com.dao.UsuarioDAO;
//import com.dao.UsuarioPunto;
//import com.dao.UsuarioPuntoDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import datos.Persona;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uagrm
 */
public class Controlador implements ReceiveListener {

    private Servidor server;
    private Gson gson = new Gson();
//    ArrayList<Conectados> c = new ArrayList<Conectados>();

    public Controlador(Servidor server) {
        this.server = server;
    }

    public synchronized void recivir(String e) {
//        Type typePuntos = new TypeToken<UsuLatLong>() {
//        }.getType();
//        UsuLatLong u = gson.fromJson(e, typePuntos);
//            UsuarioDAO k= new UsuarioDAO();
//            Usuario j= new Usuario();
//            
//            if (!k.existe(u.getIMEI())) {
//                j.setIMEI(u.getIMEI());
//                j.setNombre(u.getNombre());
//                j.setFoto(null);
//                j.setFecha_Actualizacion(null);
//                j.setNum(u.getNum());
//                j.setEstado("true");
//                k.Guardar(j);
//            }else{
//                j.setIMEI(u.getIMEI());
//                //j.setEstado("true");
//                k.GuardarA(j);
//            }
//            
//            Puntos pu = new Puntos();
//            pu.setLatitud(u.getLatitud());
//            pu.setLongitud(u.getLongitud());
//            pu.setFechaActualizacion(null);
//            PuntosDAO pDAO = new PuntosDAO();
//            int r = pDAO.guardar(pu);
//
//            UsuarioPunto up = new UsuarioPunto();
//            up.setIMEI(u.getIMEI());
//            up.setIdPunto(r);
//            up.setFechaActualizacion(null);
//            UsuarioPuntoDAO ud = new UsuarioPuntoDAO();
//            ud.guardar(up);
//
//
//            u.setEstado("true");
//            String ul = gson.toJson(u);
//
//            try {
//                server.enviarTodos(ul);
//
//
//            } catch (IOException ex) {
//                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            System.out.println(u.getNombre());
//            System.out.print("  " + u.getLatitud());
//            System.out.print("  " + u.getLongitud());

        // REcibir GSON
        Type typePuntos = new TypeToken<Persona>() {
        }.getType();
        Persona u = gson.fromJson(e, typePuntos);
        //ENVIAR GSON
        System.out.println(u.toString());
        
     
        String Mensaje="Nuevo USUARIO INSERTADO...";
        String ul = gson.toJson(Mensaje);
        
        try {
            server.enviarTodos(ul);

        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public synchronized void OnReceive(ReceiveEvent e) {

        // if (e.Dato.getDato().length() > 20) {
        recivir(e.Dato.getDato());
        System.out.println("es:" + e.Dato.getIP());
        
        
        /* }/*else{
         try {
         server.enviarTodos(e.Dato.getDato());
         } catch (IOException ex) {
         Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         }*/

    }
}
