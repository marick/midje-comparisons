(ns midje.comparisons.atoms
  (:require [midje.comparisons.reasons :refer :all]))

;; TODO: Put these in a clojure commons
(defn big-decimal? [x]
  (instance? java.math.BigDecimal x))

(defn regex? [x]
  (instance? java.util.regex.Pattern x))

(defn differences [actual expected]
  ;; BigDecimal check required because = is broken until Clojure 1.6.
  (let [none? (cond (big-decimal? expected)
                    (= (compare actual expected) 0)

                    (every? regex? [actual expected])
                    (= (str actual) (str expected))

                    :else
                    (= actual expected))]

    (if none? [] [(->DifferentAtoms actual expected)])))
