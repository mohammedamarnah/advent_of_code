(ns advent-of-code.io-test
  (:require [clojure.test :as t]
            [advent-of-code.io :as io]))

(t/deftest reading-data
  (t/is (= 2000 (count (io/read-data 2021 1)))))

(t/deftest reading-integer-data
  (let [data (io/read-data-int 2021 1)]
    (t/is (= 2000 (count data)))
    (t/is (= java.lang.Integer (type (first data))))))

