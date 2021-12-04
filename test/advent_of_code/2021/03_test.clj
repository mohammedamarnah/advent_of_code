(ns advent-of-code.2021.03-test
  (:require [clojure.test :as t]
            [advent-of-code.2021.03 :as sol]))

(def data ["00100" "11110" "10110" "10111" "10101"
           "01111" "00111" "11100" "10000" "11001"
           "00010" "01010"])

(t/deftest part-1
  (t/is (= 198 (sol/part-1 data))))

(t/deftest part-2
  (t/is (= 230 (sol/part-2 data))))

(t/deftest solution
  (t/is (= {:part_1 2250414
            :part_2 6085575} (sol/solve))))

