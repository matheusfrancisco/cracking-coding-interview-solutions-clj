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
