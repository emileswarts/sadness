(ns sadness.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [sadness.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[sadness started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[sadness has shut down successfully]=-"))
   :middleware wrap-dev})
