#include "headers.h"
#include "1.cpp"
#include "2.cpp"

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