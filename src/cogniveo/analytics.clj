(ns cogniveo.analytics)
(use 'clojure.data)

(defn is-param? [name]
  (.startsWith (name 0) "param."))

(defn get-params [params-kv]
  (apply merge (map (fn [item] {(keyword (subs (item 0) 6)) (item 1)}) (filter is-param? params-kv))))

(defn get-experiments 
	([state user-id] (get-experiments state user-id "" {}))
	([state user-id experiment-name] (get-experiments state user-id experiment-name {}))
	([state user-id experiment-name params] (filter (fn [row] 
		(and
			(= user-id ((row :user) :id))
			(or (= experiment-name "") (= experiment-name ((row :experiment) :name)))
			(= (nth (diff ((row :experiment) :params) params) 1) nil)		 
	)) state)
	)
)