#include <iostream>
using namespace std;
int main() {
int a = 10, b = 20; 
int c = a + b; 
c++; 
a--; 
!b; 
~c; 
if (a != b) { 
c = (a > b) ? a : b; 
}
c += 5;
 c = a * b; 
 c = a / b; 
 c = a - b; 
 c &= b; 
 c |= b; 
 c ^= b; 
 c <<= 2; 
 c >>= 1; 
 return 0;
}
