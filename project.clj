(defproject midje/midje-comparisons "0.1.0"
  :description "Comparisons as used by Midje."
  :url "https://github.com/marick/Midje"
  :pedantic? :warn
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/mit-license.php"
            :distribution :repo}
  :mailing-list {:name "Midje"
                 :subscribe "https://groups.google.com/forum/?fromgroups#!forum/midje"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [marick/clojure-commons "0.4.0" :exclusions [org.clojure/clojure]]]
  :profiles {:dev {:dependencies [[midje "2.0.0-SNAPSHOT" :exclusions [org.clojure/clojure]]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5.0 {:dependencies [[org.clojure/clojure "1.5.0"]]}
             :1.5.1 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0-beta1"]]}
             }

  :aliases {"compatibility" ["with-profile" "+1.4:+1.5.0:+1.5.1:+1.6:+1.7" "midje" ":config" ".compatibility-test-config"]
            "travis" ["with-profile" "+1.4:+1.5.0:+1.5.1:+1.6:+1.7" "midje"]}


  ;; For Clojure snapshots
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
)
