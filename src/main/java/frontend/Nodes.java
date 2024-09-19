/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frontend;
import Backend.*;
/**
 *
 * @author zedan.net
 */
public interface Nodes {
 //  public  AdminRole a= new AdminRole() ;
    public void setParentNode (Nodes node);
    public Nodes getParentNode ();
    
}
