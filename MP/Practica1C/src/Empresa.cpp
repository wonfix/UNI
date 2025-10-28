#include "Empresa.h"
#include <typeinfo>

//el constructor de la clase empresa debe crear un array dinámico de tamaño inicial 10
//debe inicializar a 0 los contadores de clientes (ncli) y contratos (ncon)
//y debe inicializar la constante nmaxcli a 100 y la variable nmaxcon a 10
Empresa::Empresa(): nmaxcli(100)
{
    this->ncli = 0;
    this->ncon = 0;
    this->contratos = new Contrato *[10];//Inicialmente capacidad para 10 contratos;
    this->nmaxcon = 10;
}

//el destructor debe, además de eliminar el array dinámico creado en el constructor,
//eliminar los objetos clientes y contratos apuntados por ambos arrays
Empresa::~Empresa()
{
    for(int i=0; i<this->ncon; i++)   //primero elimino los objetos contratos
    {
        delete this->contratos[i];
    }
    delete [] this->contratos; //luego elimino el array de punteros
    for(int i=0; i<this->ncli; i++)   //primero elimino los objetos contratos
    {
        delete this->clientes[i];
    }
//delete [] this->clientes; //ERROR el array clientes no es dinámico
}
//método auxiliar usado por el método crearContrato
int Empresa::altaCliente(Cliente *c)   //añade cliente apuntado por c al array clientes
{
    int pos=-1; //devuelve -1 si no cabe y la posición donde
    if (this->ncli<nmaxcli)   //donde lo he metido si cabe
    {
        this->clientes[this->ncli]=c;
        pos=this->ncli;
        this->ncli++;
    }
    else
    {
        cout << "Lo siento, el cupo de clientes esta lleno";
        pos=-1;
    }
    return pos;
}

//método auxiliar usado por el método crearContrato
//si no existe devuelve -1 y si existe devuelve la posición del cliente
int Empresa::buscarCliente(long int dni) const
{
//A IMPLEMENTAR POR EL ALUMNO... //con ese dni en el array clientes
    for(int i = 0; i < ncli; i++){
        if(clientes[i]->getDni() == dni){
            return i;
        }
    }
    return -1;
}

void Empresa::crearContrato()   //EL ALUMNO DEBE TERMINAR DE IMPLEMENTAR ESTE METODO
{
    long int dni;
    int pos;
    cout << "Introduce DNI: ";
    cin >> dni;
    //supongo que hay un metodo buscarCliente(dni) que devuelve -1 si no existe y si
    //existe devuelve la posicion del cliente en el array this->cli
    pos=this->buscarCliente(dni); //OJO ESTE METODO HAY QUE IMPLEMENTARLO
    if (pos==-1)   //el cliente no existe y hay que darlo de alta
    {
        int dia, mes, anio;
        char nombre[100];
        Cliente *c; //NO CREO NINGUN CLIENTE SINO SOLO UN PUNTERO A CLIENTE
        cout << "Introduce Nombre: ";
        cin >> nombre;
        cout << "Introduce Fecha (dd mm aaaa): ";
        cin >> dia >> mes >> anio;
        c=new Cliente(dni, nombre, Fecha(dia, mes, anio));
        pos=this->altaCliente(c); //OJO HAY QUE IMPLEMENTARLO
    }
    //viendo cuanto vale la variable pos sé si el cliente se ha dado de alta o no
    if (pos!=-1)   //el cliente existe o se ha dado de alta
    {
        //PREGUNTAR QUE TIPO DE CONTRATO QUIERE Y LOS DATOS NECESARIOS
        //CREAR EL OBJETO CONTRATO CORRESPONDIENTE Y AÑADIR AL ARRAY
        //contratos UN PUNTERO A DICHO OBJETO
        int tipo = 0;
        cout << "Tipo de Contrato a abrir (1.-Tarifa Plana, 2.-Movil): ";
        cin >> tipo;

        int dia, mes, anio;
        cout << "Fecha del contrato: " << endl;
        cout << "Dia: ";
        cin >> dia;
        cout << "Mes: ";
        cin >> mes;
        cout << "Anio: ";
        cin >> anio;
        Fecha fechaContrato(dia, mes, anio);

        Contrato *nuevo;

        if(tipo == 1){
            //ContratoTP
            int minutos;
            cout << "Minutos Hablados: ";
            cin >> minutos;

            nuevo = new ContratoTP(dni, fechaContrato, minutos);
        } else if(tipo == 2){
            int minutos;
            float precio;
            char nacionalidad[50];
            cout << "Minutos Hablados: ";
            cin >> minutos;
            cout << "Precio Minutos: ";
            cin >> precio;
            cout << "Nacionalidad: ";
            cin >> nacionalidad;

            nuevo = new ContratoMovil(dni, fechaContrato, precio, minutos, nacionalidad);
        } else {
            cout << "Tipo de contrato no valido." << endl;
        }

        //Tenemos que aÑadir el contrato al array dinamico !!IMPORTANTE!!
        if(ncon >= nmaxcon){
            //Hemos llegado al limite hay que agrandar el array dinamico
            int nuevaCapacidad = nmaxcon * 2; //Por ejemplo el doble puede ser mas
            Contrato **aux = new Contrato*[nuevaCapacidad];
            for (int i = 0; i < ncon; i++){
                aux[i] = contratos[i];
            }
            delete [] contratos;
            contratos = aux;
            nmaxcon = nuevaCapacidad;
        }

        //Todavia hay espacio
        contratos[ncon] = nuevo;
        ncon++;

        cout << "Contrato creado correctamente con ID: " << nuevo->getIdContrato() << endl;
    }
}

void Empresa::ver() const
{
    // ver de cliente, recuerda cliente no tinee metodo ver si no que tiene una
    // sobrecarga del operando <<
    cout << "La Empresa tiene: " << ncli << " Clientes y " << ncon << " Contratos" << endl;
    cout << "Clientes: " << endl;
    for (int i = 0; i < this->ncli; i++)
    {
        cout << *this->clientes[i] << endl;
    }
    cout << "Contratos: " << endl;
    //ver contratos
    for(int i = 0; i < this->ncon; i++)
    {
        this->contratos[i]->ver();
        cout << " - " << contratos[i]->factura() << "€" << endl;
    }
}

void Empresa::cargarDatos()
{
    Fecha f1(29,2,2001), f2(31,1,2002), f3(1,2,2002);
    this->clientes[0] = new Cliente(75547001, "Peter Lee", f1);
    this->clientes[1] = new Cliente(45999000, "Juan Perez", Fecha(29,2,2000));
    this->clientes[2] = new Cliente(37000017, "Luis Bono", f2);
    this->ncli=3;
    this->contratos[0] = new ContratoMovil(75547001, f1, 0.12, 110, "DANES"); //habla 110m a 0.12€/m
    this->contratos[1] = new ContratoMovil(75547001, f2, 0.09, 170, "DANES"); //habla 170m a 0.09€/m
    this->contratos[2] = new ContratoTP(37000017, f3, 250); //habla 250m (300m a 10€, exceso 0.15€/m)
    this->contratos[3] = new ContratoTP(75547001, f1, 312); //habla 312m (300m a 10€, exceso 0.15€/m)
    this->contratos[4] = new ContratoMovil(45999000, f2, 0.10, 202, "ESPAÑOL"); //habla 202m a 0.10/m
    this->contratos[5] = new ContratoMovil(75547001, f2, 0.15, 80, "DANES"); //habla 80m a 0.15€/m
    this->contratos[6] = new ContratoTP(45999000, f3, 400); //habla 400m (300m a 10€, exceso 0.15€/m)
    this->ncon=7;
}

bool Empresa::cancelarContrato(int idContrato)
{
    for (int i = 0; i < ncon; i++)
    {
        if(contratos[i]->getIdContrato() == idContrato)
        {
            //cout << "El contrato: " << idContrato << " ha sido cancelado" << endl;
            delete contratos[i]; //Liberamos la memoria del objeto apuntado por contrato[i]

            for(int j = i; j < ncon - 1 ; j++)
            {
                //contratos[i] recibe lo que habia en contratos[i+1]
                //Ejemplo c0 c1 c2 eliminamos c1, con lo hecho en el for copiamos en el actual(c1 el que quermos eliminar)
                // lo que habia  en el siguiente para que c1 se convierta en c2
                contratos[j] = contratos[j+1];
            }
            ncon--;
            return true;
        }
    }
    //cout << "El contrato: " << idContrato << " no existe" << endl;
    return false;
}

bool Empresa::bajaCliente(long int dni)
{
    //Eliminamos todos los contratos del cliente
    for (int i = 0; i < ncon;)
    {
        if(contratos[i]->getDniContrato() == dni)
        {
            delete contratos[i];

            for(int j = i; j < ncon - 1; j++)
            {
                contratos[j] = contratos[j+1];
            }
            ncon--;
        }
        else
        {
            i++;
        }
    }
    //Eliminamos el cliente
    for(int i = 0; i < ncli; i++)
    {
        if(clientes[i]->getDni() == dni)
        {
            //cout << "El Cliente con dni: " << dni << " ha sido dado de baja" << endl;

            delete clientes[i];

            for(int j = i; j < ncli - 1; j++)
            {
                clientes[j] = clientes[j+1];
            }
            ncli--;
            return true;
        }
    }
    //cout << "El cliente con dni: " << dni << " No existe" << endl;
    return false;
}


int Empresa::descuento(float porcentaje) const
{
    int contador = 0;

    for(int i = 0; i < ncon; i++)
    {
        ContratoMovil *cm = dynamic_cast<ContratoMovil*>(contratos[i]);

        if (cm != nullptr)
        {
            float precioActual = cm->getPrecioMinuto();
            float nuevoPrecio = precioActual * (1 - porcentaje / 100.0);
            cm->setPrecioMinuto(nuevoPrecio);
            contador++;
        }
    }
    return contador;
}

//Contar cuántos contratos son de tipo ContratoTP
int Empresa::nContratosTP() const
{
    int contador = 0;

    for (int i = 0; i < ncon; i++)
    {
        // typeid(*contratos[i]) obtiene el tipo dinámico del objeto
        if (typeid(*contratos[i]) == typeid(ContratoTP))
        {
            contador++;
        }
    }

    return contador;
}
