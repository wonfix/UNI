#include "ContratoTP.h"

int ContratoTP::minutosTP=300;
float ContratoTP::precioTP=10;
const float ContratoTP::precioExcesoMinutos=0.15;


//static se pone en el .h (no se pone en el .cpp)
void ContratoTP::setTarifaPlana(int m, float p) {
  ContratoTP::minutosTP=m; //puedo poner minutosTP=m ...pongo ContratoTP::minutosTP para recordar que es estatico
  ContratoTP::precioTP=p;  //puedo poner precioTP=p  ...pongo ContratoTP::precioTP para recordar que es estatico
}

//RESTO DE METODOS Y FUNCIONES A RELLENAR POR EL ALUMNO...

ContratoTP::ContratoTP(long int dni, Fecha f, int m) : Contrato(dni, f){
    minutosHablados = m;
}

float ContratoTP::factura() const{
    float factura = precioTP;
    if(minutosHablados > minutosTP){
        int exceso = minutosHablados - minutosTP;
        factura += precioExcesoMinutos * exceso;
    }
    return factura;
}

ostream &operator<<(ostream &s, const ContratoTP &c){

    s << (const Contrato &)c; //Mostrar dni y fecha
    s << " " << c.getMinutosHablados() << "m, " << ContratoTP::getLimiteMinutos() << "(" << ContratoTP::getPrecio() << ") -" << c.factura();
    return s;
}
