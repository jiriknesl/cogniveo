(ns cogniveo.analytics)

(defn has-user-id [user-id row] (= user-id ((row :user) :id)))

(defn has-experiment-name [value row]
  (= value ((row :experiment) :name))) 

(defn get-experiments
  ([state user-id] (get-experiments state user-id {}))
  ([state user-id params] (let [user-matcher (partial has-user-id user-id)
                                experiment-name-matcher (partial has-experiment-name (params :name))] 
                            (filter (fn [row] 
                                      (every? true? ((juxt [user-matcher experiment-name-matcher]) row))) 
                                  state))))