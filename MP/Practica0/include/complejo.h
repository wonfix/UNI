#ifndef COMPLEJO_H
#define COMPLEJO_H


class complejo
{
    public:

        complejo(int r, int i);
        int getr() {return real;}
        int geti() {return imaginaria;}
        void set();
        void setT(int real, int imaginario);
        void ver();
        virtual ~complejo();

    private:
        int real;
        int imaginaria;

};

#endif // COMPLEJO_H
