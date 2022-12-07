#include "headers.h"

namespace day1 {
  void main() {
    string calorie;
    ll elfCalories = 0;
    priority_queue<ll> elfsCalories;
    while (getline(cin, calorie)) {
      if (calorie.empty()) {
        elfsCalories.push(elfCalories);
        elfCalories = 0;
      } else {
        elfCalories += stoi(calorie);
      }
    }
    elfsCalories.push(elfCalories);

    cout << "1: " << elfsCalories.top() << endl;

    ll sum = 0;
    int cnt = 3;
    while (cnt--) {
      sum += elfsCalories.top();
      elfsCalories.pop();
    }

    cout << "2: " << sum << endl;
  }
}