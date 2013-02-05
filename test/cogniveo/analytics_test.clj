(ns cogniveo.analytics-test
  (:use midje.sweet
        cogniveo.analytics))

(fact
	"we can list users' experiments"
	(count (get-experiments state "tillda")) => 1

	(provided
		(state) => [
			{:user {:id "tillda"}},
			{:user {:id "jirka"}},
		])

)

