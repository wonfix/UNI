#include <iostream>
#include <cstdlib>
#include <cstring> //strlen, strcpy
#include <iomanip> //std::setprecision
#include "Contrato.h"
#include "ContratoMovil.h"

ContratoMovil::ContratoMovil(long int dni, Fecha f, float p, int m, char *nac): Contrato(dni, f) {
  this->precioMinuto=p;
  this->minutosHablados=m;
  //this->nacionalidad=nac;  //MAL!!!!
  this->nacionalidad=new char [strlen(nac)+1];
  strcpy(this->nacionalidad, nac);
}

ContratoMovil::~ContratoMovil() {
  //implementarlo...
  //Destruimos la nacionalidad
  delete[] nacionalidad;
}

//ContratoMovil::ContratoMovil(const ContratoMovil& c):Contrato(c) { //IMPORTANTE: SI PONGO ESTA CABECERA y no implemento un constructor de copia en CONTRATO
                                                                     //NO DA ERROR AL COMPILAR PORQUE EL COMPILADOR GENERA UN CONSTRUCTOR COPIA POR SU CUENTA...
                                                                     //...EL PROBLEMA ES QUE EL QUE GENERA EL COMPILADOR NO INCREMENTA contador
                                                                     //Y ASIGNARIA EL MISMO CODIGO A AMBOS CONTRATOS
                                                                     //solucion: implementar constructor copia en CONTRATO y usar esta cabecera...
ContratoMovil::ContratoMovil(const ContratoMovil& c):Contrato(c.getDniContrato(), c.getFechaContrato()) { //... o usar esta otra cabecera
  this->precioMinuto=c.precioMinuto;
  //terminar de implementarlo...
  this->minutosHablados = c.minutosHablados;
  this->nacionalidad = new char[strlen(c.nacionalidad) + 1];
  strcpy(this->nacionalidad, c.nacionalidad);
}

void ContratoMovil::ver() const {
  Contrato::ver(); //IMPORTANTE: llamamos al ver que heredo de mi padre PARA QUE MUESTRE LO DEL PADRE
                   //... y a continuacion solo "me preocupo" de mostrar lo que es exclusivo del hijo
  cout << " " << this->minutosHablados << "m, " << this->nacionalidad << " " << this->precioMinuto;
}

float ContratoMovil::factura() const {
    float factura = precioMinuto * minutosHablados;
    return factura;
}


void ContratoMovil::setNacionalidad(const char* nac) {
    delete [] this->nacionalidad; // Seguro¿?
    this->nacionalidad = new char[strlen(nac) + 1];
    strcpy(this->nacionalidad, nac);
}



ostream& operator<<(ostream &s, const ContratoMovil &c) {
  s << (Contrato &)c; //IMPORTANTE: convierto el objeto c (ContratoMovil &) a objeto Contrato &
                      // de esta forma se cree que es un objeto Contrato y muestra lo que indica el operator<< de Contrato
                      //... y a continuacion solo "me preocupo" de mostrar lo que es exclusivo del hijo
  s << " " << c.getMinutosHablados() << "m, " << c.getNacionalidad() << " " << c.getPrecioMinuto() << " - ";
  s << c.factura() << "";
  return s;
}
