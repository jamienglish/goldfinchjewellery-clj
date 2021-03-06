(defproject goldfinchjewellery "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]
                 [markdown-clj "0.9.43"]
                 [lib-noir "0.7.6"]
                 [org.clojure/data.json "0.2.4"]
                 [org.clojure/java.jdbc "0.3.2"]
                 [postgresql "9.1-901.jdbc4"]
                 [ring-server "0.3.0"]
                 [clj-aws-s3 "0.3.9"]
                 [ring/ring-json "0.3.1"]
                 [clj-time "0.7.0"]
                 [clj-http "0.9.1"]]
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler goldfinchjewellery.handler/app
         :init goldfinchjewellery.handler/init
         :destroy goldfinchjewellery.handler/destroy}
  :aot :all
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.2.0"]]}})
