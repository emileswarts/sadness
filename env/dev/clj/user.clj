(ns user
  (:require [mount.core :as mount]
            sadness.core))

(defn start []
  (mount/start-without #'sadness.core/http-server
                       #'sadness.core/repl-server))

(defn stop []
  (mount/stop-except #'sadness.core/http-server
                     #'sadness.core/repl-server))

(defn restart []
  (stop)
  (start))


