#include <bits/stdc++.h>
#include <iostream>
#include "1.cpp"
#include "2.cpp"

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef void (*FnPtr)();

#define CHECK_BIT(var,pos) ((var) & (1<<(pos)))
#define DEBUG_PRINT_ARR(arr) for(auto x : arr) cout << x << " "; cout << endl;
#define MOD (1e9)+7

int main(int argc, char** argv) {
#ifndef ONLINE_JUDGE
  string test = argc > 2 && (string)argv[2] == "test" ? "_test" : "";
  string input = "input/" + (string)argv[1] + test + ".in";
  cout << "loading: " << input << endl;
  freopen(input.c_str(), "r", stdin);
#endif
  map<string, FnPtr> funcs = {
    {"1", day1::main},
    {"2", day2::main}
  };
  funcs[argv[1]]();
}