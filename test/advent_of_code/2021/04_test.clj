(ns advent-of-code.2021.04-test
  (:require [clojure.test :as t]
            [advent-of-code.io :as io]
            [advent-of-code.2021.04 :as sol]))

(t/deftest solution
  (t/is (= {:part_1 54275
            :part_2 13158} (sol/solve))))

