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
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author Usuario
 */
public class Practica1 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Scanner sc = new Scanner(System.in);
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
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1: {
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();

                    try {
                        //Muestra todos los campos de todos los socios en HQL
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
                pausar(sc);
                break;
                case 2: {
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();

                    try {
                        //Muestra todos los campos de todos los socios en SQL Nativo
                        //en HQL tiene que poner el nombre de la entidad no de la tabla SOCIO 
                        Query consulta = sesion.createNativeQuery("Select * From SOCIO S", Socio.class);
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
                pausar(sc);
                break;

                case 3: {
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();

                    try {
                        //Mirar Mejor
                        //Muestra todos los campos de todos los socios en SQL NativoIgual que las opciones 1 y 2 usando una consulta nombrada
                        //en HQL tiene que poner el nombre de la entidad no de la tabla SOCIO 
                        Query consulta = sesion.createNamedQuery("Socio.findAll", Socio.class);
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
                pausar(sc);
                break;

                case 4: {
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();

                    try {
                        /*Muestra el nombre y el teléfono de todos los socios
                          (la consulta debe recuperar sólo estos dos campos de la base de datos) HECHO EN SQL NATIVO*/
                        Query consulta = sesion.createNativeQuery("SELECT s.nombre, s.telefono FROM SOCIO s", Object[].class);
                        List<Object[]> socios = consulta.getResultList();
                        for (Object[] socio : socios) {
                            System.out.println("Nombre: " + socio[0] + " | Telefono: " + socio[1]);
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
                pausar(sc);
                break;

                case 5: {
                    /*Muestra el nombre y la categoría de los socios que
                      pertenecen a una determinada categoría. El programa solicitará la categoría por teclado HECHO EN HQL*/
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();
                    System.out.print("Dime una categoria(A,B,C,D,E): ");
                    char categoria = sc.nextLine().charAt(0);
                    //Si nos pone a b c d e lo pasamos a MAYUSCULAS
                    categoria = Character.toUpperCase(categoria);
                    
                    //Recuerda para char son '' y para string ""
                    if (categoria != 'A' && categoria != 'B' && categoria != 'C' && categoria != 'D' && categoria != 'E') {
                        System.out.println("Recurda tiene que ser A, B , C, D, E");
                    } else {
                        try {
                            Query consulta = sesion.createQuery("FROM Socio s WHERE s.categoria=:categoria", Socio.class).setParameter("categoria", categoria);
                            List<Socio> socios = consulta.getResultList();
                            for (Socio socio : socios) {
                                System.out.println("Nombre: " + socio.getNombre() + " | Categoria: " + socio.getCategoria());
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
                }
                pausar(sc);
                break;

            }

        } while (opc != 0);

        sc.close();

    }

    private static void pausar(Scanner sc) {
        System.out.println("\nPulsa Enter para continuar...");
        sc.nextLine();
    }

}
