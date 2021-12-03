(ns advent-of-code.io
  (:require [clojure.string :refer [split]]))

(defn- file-url
  [year day]
  (let [day (if (< day 10)
              (str "0" day)
              day)]
    (str "resources/" year "/" day)))

(defn read-data
  [year day]
  (-> (file-url year day)
      (slurp)
      (split #"\n")))

(defn read-data-int
  [year day]
  (->> (read-data year day)
       (map #(Integer/parseInt %))))

