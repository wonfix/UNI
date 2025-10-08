/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Aplicacion;

import Modelo.Socio;
import config.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Usuario
 */
public class Practica1 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Scanner scanner = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\n--- MENU DE OPCIONES ---");
            System.out.println("1. Informacion de socios (HQL)");
            System.out.println("2. Informacion de socios (SQL Nativo)");
            System.out.println("3. Informacion de socios (Consulta nombrada)");
            System.out.println("4. Nombre y telefono de los socios");
            System.out.println("5. Nombre y categoria de los socios por categoria");
            System.out.println("6. Nombre de monitor por nick");
            System.out.println("7. Informacion de socio por nombre");
            System.out.println("8. Informacion de actividades por dia y cuota");
            System.out.println("9. Informacion de socios por categoria (HQL nombrada)");
            System.out.println("10. Informacion de socios por categoria (SQL nombrada)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1: {
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();

                    try {
                        //en HQL tiene que poner el nombre de la entidad no de la tabla SOCIO 
                        Query consulta = sesion.createQuery("FROM Socio s", Socio.class);
                        List<Socio> socios = consulta.getResultList();
                        for (Socio socio : socios) {
                            System.out.println(socio.getNombre());
                        }
                        tr.commit();
                    } catch (Exception e) {
                        tr.rollback();
                        System.out.println("Error en la recuperación "
                                + e.getMessage());
                    } finally {
                        if (sesion != null && sesion.isOpen()) {
                            sesion.close();
                        }
                    }
                    
                }
                break;
                case 2:{
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();

                    try {
                        //en HQL tiene que poner el nombre de la entidad no de la tabla SOCIO 
                        Query consulta = sesion.createQuery("FROM Socio s", Socio.class);
                        List<Socio> socios = consulta.getResultList();
                        for (Socio socio : socios) {
                            System.out.println(socio.getNombre());
                        }
                        tr.commit();
                    } catch (Exception e) {
                        tr.rollback();
                        System.out.println("Error en la recuperación "
                                + e.getMessage());
                    } finally {
                        if (sesion != null && sesion.isOpen()) {
                            sesion.close();
                        }
                    }
                }
                 
                 break;
                 
            }
        } while (opc != 0);

    }

}
