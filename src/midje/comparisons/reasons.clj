(ns midje.comparisons.reasons)

(defrecord DifferentAtoms [actual expected])

(defrecord FalseFunction [actual function function-name])
