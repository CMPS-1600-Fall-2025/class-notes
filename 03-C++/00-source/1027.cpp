// 1. First program -- Hello World / Running

#include <iostream>
using namespace std;

int main() {
    cout << "Hello, World!";
    return 0;
};


// 2. Intro to Classes with an example

#include <iostream>
using namespace std;

class Restaurant {
public:
    void SetRating(int r);
private:
    int rating;
};

void Restaurant::SetRating(int r) {
    rating = r;
}

int main() {
    Restaurant favLunchPlace;
    favLunchPlace.SetRating(4);
    return 0;
}

// 3. Using "this" pointer

#include <iostream>
using namespace std;

class Restaurant {
public:
    void SetRating(int rating) {
        this->rating = rating;
    }
    int GetRating() const { return rating; }
private:
    int rating;
};

int main() {
    Restaurant r1, r2;
    r1.SetRating(3);
    r2.SetRating(5);
    cout << "r1 rating: " << r1.GetRating() << endl;
    cout << "r2 rating: " << r2.GetRating() << endl;
    return 0;
}

// 4. Why namespaces are important

#include <iostream>
using namespace std;

namespace Auditorium {
    class Seat {
    public:
        void Print() { cout << "Auditorium Seat\n"; }
    };
}

namespace Airplane {
    class Seat {
    public:
        void Print() { cout << "Airplane Seat\n"; }
    };
}

int main() {
    Auditorium::Seat concertSeat;
    Airplane::Seat flightSeat;
    concertSeat.Print();
    flightSeat.Print();
    return 0;
}

// 5. What is namespace std

#include <iostream>
using namespace std;

int main() {
    std::cout << "Printing using std::cout" << std::endl;
    cout << "Printing by using namespace std...much easier" << endl;
    return 0;
}