(ns midje.comparisons.f-atoms
  (:use midje.sweet)
  (:require [midje.comparisons.atoms :as subject]
            [midje.comparisons.reasons :refer :all]))

(facts "about checking for differences" 
  (fact "most numbers are compared using Clojures rules for equality"
    (subject/differences 1 1) => []
    (subject/differences 1 2) => [(->DifferentAtoms 1 2)])

  (fact "However, big decimal ignore additional 0 in fraction"
    (subject/differences 1M 1M) => []
    ;; These compare false in Clojure 1.4
    (subject/differences 1M 1.0M) => []
    (subject/differences 1.0M 1M) => []
    (subject/differences 1M 1.0) => [(->DifferentAtoms 1M 1.0)])

  (fact "regexps are equal if their string values are equal"
    (subject/differences #"a*b+" #"a*b+") => []
    (let [[{:keys [actual expected]}] (subject/differences #"a*b+" #"a*b")]
      (str actual) => "a*b+"
      (str expected) => "a*b")))
