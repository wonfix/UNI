/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Socio;
import Modelo.SocioDAO;
import Vista.VistaSocio;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author wonfix
 */
public class ControladorSocio {
    Scanner sc = new Scanner(System.in);
    private final SessionFactory sessionFactory;
    
    public ControladorSocio(SessionFactory sessionFactory) throws Exception{
        this.sessionFactory = sessionFactory;
        menuS();
    }
    
    public void altaSocio() throws Exception{
        
        VistaSocio vistaMenu = new VistaSocio();
        String[] datosUsuario = vistaMenu.pedirDatosSocio();
        String nSocio = datosUsuario[0];
        String dni = datosUsuario[2];
        Socio socio = new Socio(
                datosUsuario[0], //NSocio
                datosUsuario[1], //Nombre
                datosUsuario[2], //DNI
                datosUsuario[3], //FechaEntr
                datosUsuario[4].charAt(0)
        );
        
        socio.setFechaNacimiento(datosUsuario[5]);
        socio.setTelefono(datosUsuario[6]);
        socio.setCorreo(datosUsuario[7]);
        
        Session sesion = null;
        Transaction tr = null;
        
        try {
            sesion = sessionFactory.openSession();
            tr = sesion.beginTransaction();
            //Peticion de datos del socio
            SocioDAO socioDAO = new SocioDAO();
            if((!socioDAO.existeDniSocio(sesion, dni)) && (!socioDAO.existeNSocio(sesion, nSocio))){
              socioDAO.insertaSocio(sesion, socio);
              tr.commit();  
                System.out.println("Socio Insertado correctamente...");  
            } else {
                System.out.println("Ya existe un socio con ese nSocio o DNI");
                tr.rollback();
            }
            
        } catch(HibernateException e){
            if(tr != null && tr.isActive()){
                tr.rollback();
            }
        }finally {
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public void menuS() throws Exception{
        VistaSocio vistaMenu = new VistaSocio();
        int opc = 0;
        
        while(opc != 2){
            opc = vistaMenu.menuSocio();
            
            switch (opc){
                case 1:
                    altaSocio();
                    break;
                case 2:
                    System.out.println("saliendo...");
                    break;
                default:
                throw new AssertionError();
            }
        }
    }
    
   
}
