List<int> winningNumbers = [12, 6, 34, 22, 41, 9];


void main() {
  
  	List<int> ticket1 = [45, 2, 9, 18, 12, 33];
  	List<int> ticket2 = [41, 17, 26, 32, 7, 35];
  
  
    checkNumbers(ticket1);

}

// List<int> myNumbers

void checkNumbers(List<int> myNum) {
  int matchingNum = 0;
  for (int theNum in winningNumbers) {
    for (int num in myNum) {
      if (num == theNum) {
        matchingNum++;
      }
    } 
  }
  print('You have $matchingNum matching number!');
  
    
  }
  
