(ns cogniveo.analytics)
(use 'clojure.data)

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