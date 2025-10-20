#ifndef CLIENTE_H
#define CLIENTE_H

#include <iostream>
#include "Fecha.h"

using namespace std;

class Cliente {
  long int dni;
  char *nombre;
  Fecha fechaAlta;
public:
  Cliente(long int d, char *nom, Fecha f);

  virtual ~Cliente();
  Cliente& operator=(const Cliente& c);

  long int getDni() const { return this->dni; }
  const char* getNombre() const { return nombre; } //VIP devolver un puntero constante para evitar que desde el main() se puede modificar el nombre
  Fecha getFecha() const { return fechaAlta; }

  void setNombre(char *nom);
  void setFecha(Fecha f);

  bool operator==(Cliente c) const; // if (c1 ===c2)
  Cliente(const Cliente &c);
  friend ostream& operator<<(ostream &s, const Cliente &c);
};


#endif
