// Header file for our Atom class
#include <iostream>
using namespace std;

namespace universe {
    class Point3D {
        public:
        int x;
        int y;
        int z;

        Point3D(int x, int y, int z);
        string toString();
    };

    class Atom {
        public:
        string symbol;
        int number;
        Point3D *coords;

        Atom(string symbol, int number, int x, int y, int z);
        Atom(const Atom& other);
        ~Atom();
        void print();

    };
}