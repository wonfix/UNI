/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Aplicacion;

import Modelo.Socio;
import Modelo.Monitor;
import Modelo.Actividad;
import config.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
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

    /*
    SessionFactory sessionFactory
    String tipoConsulta -> sera si queremos hacer un HQL,  SQL o NAMED
    String ConsultaStr -> sera para pasarle la consulta a ejecutar
    Class<T> tipoEntidad -> sera para pasarle si es Monitor, Socio o Actividad
    Consumer<List<T>> accion -> sera para ejecutar los resultado, Imprimir, filtrar o lo que sea
     */
 /*private static <T> void ejecutarConsulta(SessionFactory sessionFactory, String tipoConsulta, String consulta, Class<T> tipoClase, Consumer<List<T>> accion) {

        Session sesion = sessionFactory.openSession();
        Transaction tr = sesion.beginTransaction();

        try {
            Query<T> query = null;
            switch (tipoConsulta.toUpperCase()) {
                case "HQL":
                    query = sesion.createQuery(consulta, tipoClase);
                    break;
                case "SQL":
                    query = sesion.createNativeQuery(consulta, tipoClase);
                    break;
                case "NAMED":
                    query = sesion.createNamedQuery(consulta, tipoClase);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de consulta no valido");
            }
            List<T> resultados = query.getResultList();
            //ESTO SERIA  List<Socio> socios = consulta.getResultList(); Socio se cambiaria por Monitor Socio o Actividad
            accion.accept(resultados);
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
    
    ASI SE LLAMARIA //Muestra todos los campos de todos los socios en HQL
                    //en HQL tiene que poner el nombre de la entidad no de la tabla SOCIO 
                    ejecutarConsulta(sessionFactory, "HQL", "FROM Socio s", Socio.class, socios -> {
                        for (Socio socio : socios) {
                            System.out.println(socio.getNombre());
                        }
                    });
     */
 /*
    SessionFactory sessionFactory
    String tipoConsulta -> sera si queremos hacer un HQL,  SQL o NAMED
    String ConsultaStr -> sera para pasarle la consulta a ejecutar
    Class<T> tipoEntidad -> sera para pasarle si es Monitor, Socio o Actividad
     */
    private static void pausar(Scanner sc) {
        System.out.println("\nPulsa Enter para continuar...");
        sc.nextLine();
    }

    private static <T> List<T> ejecutarConsulta(SessionFactory sessionFactory, String tipoConsulta, String consulta, Class<T> tipoClase, String parametroNombre, Object parametroValor) {
        Session sesion = sessionFactory.openSession();
        Transaction tr = sesion.beginTransaction();
        List<T> resultados = null;

        try {
            Query<T> query = null;
            switch (tipoConsulta.toUpperCase()) {
                case "HQL":
                    query = sesion.createQuery(consulta, tipoClase);
                    break;
                case "SQL":
                    query = sesion.createNativeQuery(consulta, tipoClase);
                    break;
                case "NAMED":
                    query = sesion.createNamedQuery(consulta, tipoClase);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de consulta no válido");
            };

            if (parametroNombre != null && parametroValor != null) {
                query.setParameter(parametroNombre, parametroValor);
            }

            resultados = query.getResultList();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Error en la recuperación " + e.getMessage());
        } finally {
            sesion.close();
        }

        return resultados;
    }

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
            System.out.println("11. Inserción de socio.");
            System.out.println("12. Borrado de socio por DNI.");
            System.out.println("13. Información de la actividad de la que es responsable un monitor por DNI.");
            System.out.println("14. Información de las actividades en las que está inscrito un socio por DNI.");
            System.out.println("15. Información de los socios inscritos en una actividad por nombre de la actividad.");
            System.out.println("16. Inscripción de un socio en una actividad");
            System.out.println("17. Baja de un socio de una actividad");
            System.out.println("18. Mostrar el horario de un monitor por el DNI");
            System.out.println("19. Mostrar la cuota que paga un socio.");
            System.out.println("20. Mostrar los socios que sean mayores a una edad.");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1: {
                    //Muestra todos los campos de todos los socios en HQL
                    //en HQL tiene que poner el nombre de la entidad no de la tabla SOCIO 
                    List<Socio> socios = ejecutarConsulta(sessionFactory, "HQL", "FROM Socio s", Socio.class, null, null);
                    for (Socio socio : socios) {
                        //Devuelve entidades por eso socio.getN
                        System.out.println("Numero de Socio: " + socio.getNumeroSocio() + " | Nombre: " + socio.getNombre() + " | Dni: " + socio.getDni() + " | Fecha de Nacimiento: " + socio.getFechaNacimiento() + " | Telefono: " + socio.getTelefono() + " | Correo: " + socio.getCorreo() + " | Fecha de Entrada: " + socio.getFechaEntrada() + " | Categoria: " + socio.getCategoria());
                    }
                }
                pausar(sc);
                break;

                case 2: {
                    //Muestra todos los campos de todos los socios en SQL
                    //en SQL tiene que poner el nombre de la entidad no de la tabla SOCIO 
                    List<Object[]> socios = ejecutarConsulta(sessionFactory, "SQL", "SELECT * FROM SOCIO ", Object[].class, null, null);
                    for (Object[] socio : socios) {
                        //Devuelve un array(filas sin mapear) por eso socio[n], preguntar por que si en vez de List<Object[]> y Object.class utiliar socio puedes utilizar gets y sets
                        System.out.println("Numero de Socio: " + socio[0] + " | Nombre: " + socio[1] + " | Dni: " + socio[2] + " | Fecha de Nacimiento: " + socio[3] + " | Telefono: " + socio[4] + " | Correo: " + socio[5] + " | Fecha de Entrada: " + socio[6] + " | Categoria: " + socio[7]);
                    }
                }
                pausar(sc);
                break;

                case 3: {
                    //Mirar Mejor
                    //Muestra todos los campos de todos los socios en SQL NativoIgual que las opciones 1 y 2 usando una consulta nombrada
                    //en HQL tiene que poner el nombre de la entidad no de la tabla SOCIO
                    List<Socio> socios = ejecutarConsulta(sessionFactory, "NAMED", "Socio.findAll", Socio.class, null, null);
                    for (Socio socio : socios) {
                        //Devuelve entidades completas por eso socio.getN(podemos utilizar gets y sets)
                        System.out.println("Numero de Socio: " + socio.getNumeroSocio() + " | Nombre: " + socio.getNombre() + " | Dni: " + socio.getDni() + " | Fecha de Nacimiento: " + socio.getFechaNacimiento() + " | Telefono: " + socio.getTelefono() + " | Correo: " + socio.getCorreo() + " | Fecha de Entrada: " + socio.getFechaEntrada() + " | Categoria: " + socio.getCategoria());
                    }
                }
                pausar(sc);
                break;

                case 4: {
                    //Muestra el nombre y el teléfono de todos los socios
                    //(la consulta debe recuperar sólo estos dos campos de la base de datos) HECHO EN SQL NATIVO

                    List<Object[]> socios = ejecutarConsulta(sessionFactory, "SQL", "SELECT nombre, telefono FROM SOCIO ", Object[].class, null, null);
                    for (Object[] socio : socios) {
                        System.out.println("Nombre: " + socio[0] + " | Telefono: " + socio[1]);
                    }
                }
                pausar(sc);
                break;

                case 5: {
                    //Muestra el nombre y la categoría de los socios que
                    //pertenecen a una determinada categoría. El programa solicitará la categoría por teclado HECHO EN HQL

                    System.out.print("Dime una categoria(A,B,C,D,E): ");
                    char categoria = sc.nextLine().charAt(0);
                    //Si nos pone a b c d e lo pasamos a MAYUSCULAS
                    categoria = Character.toUpperCase(categoria);
                    //Recuerda para char son '' y para string ""
                    if (categoria != 'A' && categoria != 'B' && categoria != 'C' && categoria != 'D' && categoria != 'E') {
                        System.out.println("Recurda tiene que ser A, B , C, D, E");
                    } else {
                        List<Socio> socios = ejecutarConsulta(sessionFactory, "HQL", "FROM Socio s WHERE s.categoria=:categoria", Socio.class, "categoria", categoria);
                        for (Socio socio : socios) {
                            System.out.println("Nombre: " + socio.getNombre() + " | Categoria: " + socio.getCategoria());
                        }
                    }
                }

                pausar(sc);
                break;

                case 6: {
                    //Nombre de monitor por nick. Dado un nick solicitado por teclado, muestra el nombre
                    //del monitor al que le corresponde HECHO EN SQL NATIVO

                    System.out.print("Dime un Nick: ");
                    String NickName = sc.nextLine();

                    List<String> monitores = ejecutarConsulta(sessionFactory, "SQL", "SELECT nombre FROM MONITOR WHERE nick=:NickName", String.class, "NickName", NickName);
                    for (String nombre : monitores) {
                        System.out.println("Nombre: " + nombre);
                    }
                }
                pausar(sc);
                break;

                case 7: {
                    //Información de socio por nombre. Dado un nombre de socio solicitado por teclado,
                    //muestra su información hecho en HQL*/
                    System.out.print("Dime un nombre: ");
                    String Name = sc.nextLine();
                    //Query consulta = sesion.createQuery("FROM Socio s WHERE s.nombre LIKE :Name", Socio.class).setParameter("Name", "%" + Name + "%"); !!!!xk no funciona con LIKE%NAME%
                    List<Socio> socios = ejecutarConsulta(sessionFactory, "HQL", "From Socio s WHERE s.nombre=:Name", Socio.class, "Name", Name);
                    for (Socio socio : socios) {
                        System.out.println("Nombre: " + socio.getNombre() + " | Numero de socio: " + socio.getNumeroSocio() + " | Dni: " + socio.getDni() + " | Fecha de Nacimiento: " + socio.getFechaNacimiento() + " | Telefono: " + socio.getTelefono() + " | Correo: " + socio.getCorreo() + " | Fecha Entrada: " + socio.getFechaEntrada() + " | Categoria: " + socio.getCategoria());
                    }
                }
                pausar(sc);
                break;

                case 8: {
                    //Información de actividades por día y cuota. Mostrar la información de las actividades
                    //que se imparten en un determinado día y que tengan una cuota mayor que un
                    //determinado precio. Ambas informaciones se solicitarán desde teclado

                    //SELECT * FROM ACTIVIDAD a WHERE a.dia = "Martes" AND a.precioBaseMes > 20;
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();
                    int precio;
                    System.out.println("Dime un dia(Lunes, Martes...): ");
                    String dia = sc.nextLine();
                    System.out.println("Dime un precio base: ");
                    precio = Integer.parseInt(sc.nextLine());

                    try {
                        Query consulta = sesion.createQuery("From Actividad a WHERE a.dia =:dia AND a.precioBaseMes>:precio").setParameter("dia", dia).setParameter("precio", precio);
                        List<Actividad> actividades = consulta.getResultList();
                        for (Actividad actividad : actividades) {
                            System.out.println("Id Actividad: " + actividad.getIdActividad() + " | Nombre: " + actividad.getNombre() + " | Dia: " + actividad.getDia() + " | Horario: " + actividad.getHora() + " | Descripcion: " + actividad.getDescripcion() + " | Precio: " + actividad.getPrecioBaseMes() + " | Monitor: " + actividad.getMonitorResponsable());
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

                case 9: {
                    System.out.println("soy el 9");
                }

                pausar(sc);
                break;

                case 10: {
                    System.out.println("Soy e 10");
                }
                pausar(sc);
                break;

                case 11: {
                    /* Inserción de socio. Se le pedirá al usuario los datos correspondientes al nuevo socio y se
                        insertará en la BD teniendo en cuenta la unicidad de la clave primaria y el DNI*/
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();
                    try {
                        String numSocio, nombre, dni, fechaNac, numTelefono, correo, fechaEnt;
                        char categoria;
                        System.out.println("Dime el numero de Socio: ");
                        numSocio = sc.nextLine();
                        System.out.println("Dime el nombre del Socio: ");
                        nombre = sc.nextLine();
                        System.out.println("Dime el DNI del Socio: ");
                        dni = sc.nextLine();
                        System.out.println("Dime el numero de Telefono: ");
                        numTelefono = sc.nextLine();
                        System.out.println("Dime la Fecha de Nacimiento del Socio: ");
                        fechaNac = sc.nextLine();
                        System.out.println("Dime el correo del Socio: ");
                        correo = sc.nextLine();
                        System.out.println("Dime la Fecha de Entrada del Socio: ");
                        fechaEnt = sc.nextLine();
                        System.out.println("Dime la Categoria del Socio: ");
                        categoria = sc.nextLine().charAt(0);

                        Socio nuevoSocio = new Socio(numSocio, nombre, dni, fechaEnt, categoria);

                        //Añadir campos opcionales Correo, telefono y fechaNac
                        nuevoSocio.setCorreo(correo);
                        nuevoSocio.setTelefono(numTelefono);
                        nuevoSocio.setFechaNacimiento(fechaEnt);

                        //Preguntar es mejor que Hibernate lance la excepcion o tengo que hacer una consulta antes y comprobar que no exista el dni y el numSocio antes de insertar
                        sesion.persist(nuevoSocio);
                        tr.commit();
                        System.out.println("Socio Insertado correctamente...");
                    } catch (Exception ex) {
                        tr.rollback();
                        System.out.println("Error al insertar Socio. Tal vez ya exista...");
                    } finally {
                        if (sesion != null && sesion.isOpen()) {
                            sesion.close();
                        }
                    }

                }
                pausar(sc);
                break;
                //PREGUNTAR XK AUNQUE NO EXISTA EL NUMSOCIO SIGUE DICIENDO SOCIO BORRADO CORRECTAMENTE
                case 12: {
                    /*Borrado de socio por DNI. Se le pedirá al usuario el DNI del socio a eliminar y se procederá a
                        su borrado*/
                    Session sesion = sessionFactory.openSession();
                    Transaction tr = sesion.beginTransaction();
                    
                    try {
                        System.out.println("Introduzca el DNI del Socio: ");
                        String dni = sc.nextLine();
                        
                        Query consulta = sesion.createNativeQuery("SELECT numeroSocio FROM SOCIO WHERE dni = :dni", String.class).setParameter("dni", dni);
                        List<String> eliminarSocio = consulta.getResultList();
                        for(String numeroSocio : eliminarSocio){
                            System.out.println("Numero de socio a eliminar: " + numeroSocio);
                            Socio socio = sesion.find(Socio.class, numeroSocio);
                            sesion.remove(socio);
                        }                 
                        tr.commit();
                        System.out.println("Socio borrado correctamente...");
                    } catch (Exception ex){
                        System.out.println("No se encontro el dni del socio. Tal vez no exista...");
                        tr.rollback();
                    } finally {
                        if( sesion != null && sesion.isOpen()){
                            sesion.close();
                        }
                    }

                }
                pausar(sc);
                break;

                case 13: {
                    System.out.println("Soy el 13");
                }
                pausar(sc);
                break;

                case 14: {
                    System.out.println("Soy el 14");
                }
                pausar(sc);
                break;

                case 15: {
                    System.out.println("Soy el 15");
                }
                pausar(sc);
                break;

                case 16: {
                    System.out.println("Soy el 16");
                }
                pausar(sc);
                break;

                case 17: {
                    System.out.println("Soy el 17");
                }
                pausar(sc);
                break;

                case 18: {
                    System.out.println("Soy el 18");
                }
                pausar(sc);
                break;

                case 19: {
                    System.out.println("Soy el 19");
                }
                pausar(sc);
                break;

                case 20: {
                    System.out.println("Soy el 20");
                }
                pausar(sc);
                break;

            }

        } while (opc != 0);
    }
}
