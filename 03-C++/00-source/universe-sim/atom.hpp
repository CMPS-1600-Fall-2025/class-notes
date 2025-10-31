// Header file for our Atom class
#include <iostream>
using namespace std;

namespace universe {
    typedef struct point3D {
        int x;
        int y;
        int z;
    } point3D;

    class Atom {
        string symbol;
        int number;
        point3D coords;

        public:
        Atom(string symbol, int number, point3D coords);
        void print();
    };
}