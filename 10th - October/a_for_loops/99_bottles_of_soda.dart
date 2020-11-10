void main() {
  printing(99);
  }



void printing(var numberOfSodas) {
 for (var i = numberOfSodas; i > -1; i--) {
   
 
 
  if (numberOfSodas == 0) {
    print('No more bottles of soda on the wall, no more bottles of soda,');
print('Go to the store and buy some more, 99 bottles of soda on the wall!');
  } else {
    if (i == 1) {
      print('$i bottle of soda on the wall, $i bottle of soda,');
    print('Take one down and pass it around, no more bottles of soda on the wall');
      numberOfSodas--;
    } else {
    print('$i bottles of soda on the wall, $i bottles of soda,');
    print('Take one down and pass it around, ${i-1} bottles of soda on the wall');
    numberOfSodas--;
    }
  }
  }
}
