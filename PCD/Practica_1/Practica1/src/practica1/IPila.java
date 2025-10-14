/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package practica1;

/**
 *
 * @author wonfix
 */
public interface IPila {
    int GetNum();
    void Apila(Object elemento) throws Exception;
    Object Desacola() throws Exception;
    Object Primero() throws Exception;
}
