(ns ckci.core-test
  (:require [clojure.test :refer :all]
            [ckci.core :refer :all]))


(deftest a-test
  (testing "Sum two number"
    (is (= (sum 1 2) 3))))

