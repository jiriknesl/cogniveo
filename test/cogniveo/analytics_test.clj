(ns cogniveo.analytics-test
  (:use midje.sweet
        cogniveo.analytics))

(defn state [] [
		{:user {:id "tillda"} :experiment {:name "Glog" :params {}}}		
		{:user {:id "jirka"} :experiment {:name "Abc" :params {}}}
		{:user {:id "jirka"} :experiment {:name "Def" :params {:foo "bar"}}}
		{:user {:id "jirka"} :experiment {:name "Def" :params {}}}
	])

(fact
	"we can list users' experiments"
	(count (get-experiments (state) "jirka")) => 3
	(count (get-experiments (state) "jirka" "Def")) => 2
	(count (get-experiments (state) "jirka" "" {:foo "bar"})) => 1)