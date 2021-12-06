(ns advent-of-code.helpers)

(defn transpose [v]
  (map
   (fn [index] (map #(get % index) v))
   (->> (map count v)
        (apply max)
        (range))))

