(ns advent-of-code.io
  (:require [clojure.string :refer [split]]))

(defn- file-url
  [year day & [test?]]
  (let [day (if (< day 10)
              (str "0" day)
              day)]
    (str "resources/" year "/" day (if test? "_test" ""))))

(defn read-data
  [year day & [test?]]
  (-> (file-url year day test?)
      (slurp)
      (split #"\n")))

(defn read-data-int
  [year day & [test?]]
  (->> (read-data year day test?)
       (map #(Integer/parseInt %))))

