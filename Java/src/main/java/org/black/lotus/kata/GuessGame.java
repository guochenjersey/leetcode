package org.black.lotus.kata;

public class GuessGame extends GuessGameTester {
  public int guessNumber(int n) {
    long start = 1;
    long end = n;
    while (start + 1 < end) {
      long mid = (start + end) / 2;
      if (guess((int) mid) == 0) {
        return (int) mid;
      }
      if (guess((int) mid) == -1) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (guess((int) start) == 0) {
      return (int) start;
    }

    if (guess((int) end) == 0) {
      return (int) end;
    }

    return -1;
  }
}

class GuessGameTester {

  int guess(int num) {
    int magicNum = 8;
    if (num == magicNum) {
      return 0;
    } else if (num > magicNum) {
      return 1;
    } else {
      return -1;
    }
  }
}
