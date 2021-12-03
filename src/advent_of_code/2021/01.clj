(ns advent-of-code.2021.01
  (:require [advent-of-code.io :as io]))

(defonce data (io/read-data-int 2021 1))

(defn count-increasing
  [data]
  (->> data
       (partition 2 1)
       (map #(reduce < %))
       (filter true?)
       count))

(defn count-increasing-3
  [data]
  (->> data
       (partition 3 1)
       (map #(reduce + %))
       (count-increasing)))

