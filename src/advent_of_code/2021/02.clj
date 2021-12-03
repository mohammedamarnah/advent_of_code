(ns advent-of-code.2021.02
  (:require [advent-of-code.io :as io]
            [clojure.string :refer [split]]))

;; https://adventofcode.com/2021/day/2

(defonce data (io/read-data 2021 2))

(defn forward
  [pos value]
  (if (> (count pos) 2)
    (mapv + pos [0 value (* (first pos) value)])
    (mapv + pos [value 0])))

(defn up
  [pos value]
  (if (> (count pos) 2)
    (mapv - pos [value 0 0])
    (mapv - pos [0 value])))

(defn down
  [pos value]
  (if (> (count pos) 2)
    (mapv + pos [value 0 0])
    (mapv + pos [0 value])))

(defn apply-action
  [pos action]
  (let [formatted-action (split action #" ")
        action (first formatted-action)
        value (Integer/parseInt (last formatted-action))]
    (case action
      "forward" (forward pos value)
      "down"  (down pos value)
      "up" (up pos value))))

(defn part-1
  [data]
  (->> data
       (reduce apply-action [0 0])
       (reduce *)))

(defn part-2
  [data]
  (->> data
       (reduce apply-action [0 0 0])
       (rest)
       (reduce *)))

(defn solve []
  {:part_1 (part-1 data)
   :part_2 (part-2 data)})

