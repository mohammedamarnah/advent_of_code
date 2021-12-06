(ns advent-of-code.2021.03
  (:require [advent-of-code.io :as io]
            [advent-of-code.helpers :refer [transpose]]))

;; https://adventofcode.com/2021/day/3

(defonce data (io/read-data 2021 3))

(defn compute-gamma-epsilon [current entry]
  (let [ones (or (get entry \1) 0)
        zeros (or (get entry \0) 0)
        most-common-bit (if (> ones zeros) 1 0)
        lowest-common-bit (bit-xor most-common-bit 1)]
    [(str (first current) (str most-common-bit))
     (str (last current) (str lowest-common-bit))]))

(defn part-1 [data]
  (->> data
       (transpose)
       (map frequencies)
       (reduce compute-gamma-epsilon ["" ""])
       (map #(Integer/parseInt % 2))
       (reduce *)))

(defn calculate-rating [data [a b]]
  (let [rng (range (count (first data)))]
    (reduce (fn [numbers-left index]
              (if (= 1 (count numbers-left))
                (reduced numbers-left)
                (let [nth-bit (map #(get % index) numbers-left)
                      freqs (frequencies nth-bit)
                      ones (or (get freqs \1) 0)
                      zeros (or (get freqs \0) 0)
                      mcb (if (>= ones zeros) a b)]
                  (filterv #(= (get % index) mcb) numbers-left))))
            data rng)))

(defn part-2 [data]
  (let [oxygen-generator-rating (calculate-rating data [\1 \0])
        co2-scrubber-rating (calculate-rating data [\0 \1])]
    (->> [oxygen-generator-rating co2-scrubber-rating]
         (map #(apply str %))
         (map #(Integer/parseInt % 2))
         (reduce *))))

(defn solve []
  {:part_1 (part-1 data)
   :part_2 (part-2 data)})

