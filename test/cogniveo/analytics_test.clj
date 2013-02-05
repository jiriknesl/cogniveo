(ns cogniveo.analytics-test
  (:use midje.sweet
        cogniveo.analytics))

(defn state [] [
			{:user {:id "tillda"} :experiment {:name "Glog"}}
			{:user {:id "jirka"} :experiment {:name "Abc"}}
      {:user {:id "jirka"} :experiment {:name "Def"}}
      {:user {:id "jirka"} :experiment {:name "Def"}}
		])

(fact
	"we can list users' experiments"
	(count (get-experiments (state) {:user "tillda"})) => 1
  (count (get-experiments (state) {:user "jirka" :name "Def"})) => 2)

