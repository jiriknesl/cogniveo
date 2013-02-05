(ns cogniveo.analytics-test
  (:use midje.sweet
        cogniveo.analytics))

(defn state [] [
			{:user {:id "tillda"}},
			{:user {:id "jirka"}},
		])

(fact
	"we can list users' experiments"
	(count (get-experiments (state) "tillda")) => 1)

