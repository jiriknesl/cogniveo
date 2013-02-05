(ns cogniveo.analytics)

(defn get-experiments [state user-id]
  (filter (fn [row] (= user-id ((row :user) :id))) state))