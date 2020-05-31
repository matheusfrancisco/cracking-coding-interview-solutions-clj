(ns ckci.array-and-strings
  (:require [clojure.string :refer :all]))


;; O(N)
(defn is-unique [s]
  "Time complexity O(N)"
  (= (count (set s)) (count s)))

;; See the test file to read more and understand
;; how distinct? works
(defn is-unique-new-ds
  "Time complexity N O(log N)"
  [s]
  (if (blank? s)
    true
    (apply distinct? (sort s))))

;; O(N)
(defn check-permutations [s1 s2]
  """
    Time complexity: O(N)
  """
  (= (frequencies s1) (frequencies s2)))


(defn compression [s1]
  """
    Time complexity: O(N^2)
  """
  (let [parts (partition-by identity s1)
        compressed (clojure.string/join (reduce #(conj % (first %2) (count %2)) [] parts))]
    (if (<= (count s1) (count compressed))
      s1
      compressed)))


(defn one-away?
  [s1 s2]
  (let [alphabet ('clojure.set/union (set s1) (set s2))
        shared-map (zipmap alphabet (repeat 0))
        frequencie-s1 (merge shared-map (frequencies s1))
        frequencie-s2 (merge shared-map (frequencies s2))
        diff-deltas (->> (merge-with - frequencie-s1 frequencie-s2)
                          vals
                          (remove zero?))]
    (and (-> diff-deltas count (<= 2))
         (->> diff-deltas (apply +) (contains? #{-1 0 1})))))
