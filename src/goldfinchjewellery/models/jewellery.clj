(ns goldfinchjewellery.models.jewellery
  (:require [clojure.java.jdbc :as sql]))

(def db {:classname "org.sqlite.JDBC"
         :subprotocol "sqlite"
         :subname "db.sq3"})

(def galleries
  ["Peace Doves" "Weather" "Birds" "Commissions" "Branches" "Woodlands"])

(defn create-jewellery-table []
  (sql/with-connection
    db
    (sql/create-table
      :jewellery
      [:id "INTEGER PRIMARY KEY AUTOINCREMENT"]
      [:name "STRING NOT NULL"]
      [:created_at "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"]
      [:gallery "TEXT NOT NULL"]
      [:description "TEXT NOT NULL"]
      [:image_path "STRING NOT NULL"])))

(defn all []
  (sql/with-connection
    db
    (sql/with-query-results res
      ["SELECT * FROM jewellery"]
      (doall res))))

(defn delete [id]
  (sql/with-connection
    db
    (sql/do-prepared "DELETE FROM jewellery WHERE id = ?" [id])))

(defn create [name gallery description image-path]
  (sql/with-connection
    db
    (sql/insert-values
      :jewellery
      [:name :gallery :description :image_path]
      [name   gallery  description  image-path])))