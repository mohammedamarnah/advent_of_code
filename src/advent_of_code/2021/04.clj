(ns advent-of-code.2021.04
  (:require [advent-of-code.io :as io]
            [clojure.string :refer [split trim]]
            [advent-of-code.helpers :refer [transpose]]))

;; https://adventofcode.com/2021/day/4

(defonce data (io/read-data 2021 4))

(defn format-row [row]
  (->> (split (trim row) #" ")
       (filterv seq)
       (mapv #(Integer/parseInt %))))

(defonce queries (map #(Integer/parseInt %) (split (first data) #",")))

(defonce boards (->> data
                     (rest)
                     (filter seq)
                     (partition 5)
                     (mapv #(mapv format-row %))))

(defn mapped-indices [boards]
  (mapv (fn [board]
          (reduce-kv (fn [board-map idx row]
                       (merge board-map
                              (reduce-kv (fn [h index v]
                                           (assoc h v [idx index])) {} row)))
                     {} board)) boards))

(defn won? [board]
  (let [check-fn (partial reduce (fn [flag row]
                                   (or flag (every? #(= -1 %) row))) false)]
    (or (check-fn board)
        (check-fn (transpose board)))))

(defn assoc-query [boards index board value]
  (let [[r c] (get ((mapped-indices boards) index) value)]
    (if (and r c)
      (assoc-in board [r c] -1)
      board)))

(defn calc-score
  ([board]
   (calc-score (first board) (second board)))
  ([board query]
   (* (reduce + (filter #(not= -1 %) (flatten board)))
      query)))

(defn part-1 [queries boards]
  (if (empty? queries)
    boards
    (let [new-boards (map-indexed (fn [index board]
                                    (assoc-query boards index board (first queries))) boards)
          won-boards (first (filter won? new-boards))]
      (if won-boards
        (calc-score won-boards (first queries))
        (recur (rest queries) new-boards)))))

(defn part-2 [queries boards winning-board]
  (if (or (empty? queries) (empty? boards))
    (calc-score winning-board)
    (let [new-boards (map-indexed (fn [index board]
                                    (assoc-query boards index board (first queries))) boards)
          not-won-boards (filter #(not (won? %)) new-boards)
          last-winning (last (filter won? new-boards))]
      (recur (rest queries) not-won-boards (if last-winning
                                             [last-winning (first queries)]
                                             winning-board)))))

(defn solve []
  {:part_1 (part-1 queries boards)
   :part_2 (part-2 queries boards [])})

