(ns sadness.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [sadness.layout :refer [error-page]]
            [sadness.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [sadness.env :refer [defaults]]
            [mount.core :as mount]
            [sadness.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes)
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
