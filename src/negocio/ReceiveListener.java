package negocio;




import java.util.EventListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author uagrm
 */
public interface ReceiveListener extends EventListener{
   public void OnReceive(ReceiveEvent e); 
}
 