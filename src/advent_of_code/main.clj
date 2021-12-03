(ns advent-of-code.main
  (:require [clojure.string :refer [join]]
            [advent-of-code.require :refer :all])
  (:gen-class))

(defn evaluate [year day]
  (let [day (if (< (count day) 2) (str "0" day) day)
        formatted-ns (str (join #"." ["advent-of-code" year day]) "/solve")]
    ((resolve (symbol formatted-ns)))))

(defn validate-input [year day]
  (if (nil? year)
    (throw (Exception. "year_cant_be_empty")))
  (if (nil? day)
    (throw (Exception. "day_cant_be_empty"))))

(defn -main [& args]
  (let [year (first args)
        day (second args)]
    (validate-input year day)
    (println (evaluate year day))))

