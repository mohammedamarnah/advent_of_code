(ns advent-of-code.2021.01-test
  (:require [clojure.test :as t]
            [advent-of-code.2021.01 :as sol]))

(def data [199 200 208 210 200 207 240 269 260 263])

(t/deftest part-1
  (t/is (= 7 (sol/count-increasing data))))

(t/deftest part-2
  (t/is (= 5 (sol/count-increasing-3 data))))

