#include <iostream>
using namespace std;
int main() {
int a = 10, b = 20, c = 0, d = 5;
double x = 10.5, y = 3.2;

a++; 
b--; 
--c; 
!a; 
~b; 

c = a + b; 
c -= d;
c *= 2; 
c /= 5; 
c = a % b; 
c = a > b; 
c = a < b; 
c = a == b; 
c = a != b; 
c = a && b; 
c = a || b; 
c = a << 2; 
c = b >> 1; 

c += 5; 
c *= 3; 
c -= 10; 
c /= 7; 
c <<= 1; 
c >>= 2; 
c &= 3; 
c |= 1; 
c ^= 4; 

c = (a > b) ? a : b; 
c = (x > y) ? (a + b) : (a - b);
c = (a == b) ? 100 : 200; 

if (a == 10 || b != 19) {
c += 5; 
}

cout << "a = " << a << endl;
cout << "b = " << b << endl;
cout << "c = " << c << endl;
cout << "x = " << x << endl;
cout << "y = " << y << endl;
return 0;
}