(ns advent-of-code.2021.02-test
  (:require [clojure.test :as t]
            [advent-of-code.2021.02 :as sol]))

(def data ["forward 5"
           "down 5"
           "forward 8"
           "up 3"
           "down 8"
           "forward 2"])

(t/deftest part-1
  (t/is (= 150 (sol/part-1 data))))

(t/deftest part-2
  (t/is (= 900 (sol/part-2 data))))

