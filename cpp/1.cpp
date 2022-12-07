#include <bits/stdc++.h>
#include <iostream>
using namespace std;

typedef long long ll;
typedef unsigned long long ull;

#define CHECK_BIT(var,pos) ((var) & (1<<(pos)))
#define DEBUG_PRINT_ARR(arr) for(auto x : arr) cout << x << " "; cout << endl;
#define MOD (1e9)+7

int main() {
#ifndef ONLINE_JUDGE
  freopen("input/1.in", "r", stdin);
#endif
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
