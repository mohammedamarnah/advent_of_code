#include <bits/stdc++.h>
#include "headers.h"

namespace day2 {
  map<char, int> SCORE = {
    {'A', 1},
    {'X', 1}, // Rock (beaten by Paper (Y))
    {'B', 2},
    {'Y', 2}, // Paper (beaten by Scissors (Z))
    {'C', 3},
    {'Z', 3} // Scissors (beaten by Rock (X))
  };

  map<char, string> TYPE = {
    {'A', "Rock"},
    {'X', "Rock"},
    {'B', "Paper"},
    {'Y', "Paper"},
    {'C', "Scissors"},
    {'Z', "Scissors"}
  };

  int part1(char opponent, char you) {
    int score = 0;
    if (opponent == 'A') {
      score += SCORE[you] + (TYPE[opponent] == TYPE[you] ? 3 : (TYPE[you] == "Paper" ? 6 : 0));
    } else if (opponent == 'B') {
      score += SCORE[you] + (TYPE[opponent] == TYPE[you] ? 3 : (TYPE[you] == "Scissors" ? 6 : 0));
    } else if (opponent == 'C') {
      score += SCORE[you] + (TYPE[opponent] == TYPE[you] ? 3 : (TYPE[you] == "Rock" ? 6 : 0));
    }
    return score;
  }

  int part2(char opponent, char you) {
    int score = 0;
    if (opponent == 'A') {
      you = you == 'X' ? 'Z' : you == 'Y' ? opponent : 'Y';
      score += SCORE[you] + (TYPE[opponent] == TYPE[you] ? 3 : (TYPE[you] == "Paper" ? 6 : 0));
    } else if (opponent == 'B') {
      you = you == 'X' ? 'X' : you == 'Y' ? opponent : 'Z';
      score += SCORE[you] + (TYPE[opponent] == TYPE[you] ? 3 : (TYPE[you] == "Scissors" ? 6 : 0));
    } else if (opponent == 'C') {
      you = you == 'X' ? 'Y' : you == 'Y' ? opponent : 'X';
      score += SCORE[you] + (TYPE[opponent] == TYPE[you] ? 3 : (TYPE[you] == "Rock" ? 6 : 0));
    }
    return score;
  }

  void main() {
    string line;
    int part1TotalScore = 0;
    int part2TotalScore = 0;
    while (getline(cin, line)) {
      char opponent = line[0];
      char you = line[2];
      part1TotalScore += part1(opponent, you);
      part2TotalScore += part2(opponent, you);
    }
    cout << "1: " << part1TotalScore << endl;
    cout << "2: " << part2TotalScore << endl;
  }
}
