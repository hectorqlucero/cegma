(ns sk.handlers.admin.ventas.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.ventas.view :refer [ventas-view ventas-scripts]]))

(defn ventas [_]
  (let [title "Ventas"
        ok (get-session-id)
        js (ventas-scripts)
        content (ventas-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn ventas-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "ventas"
        args {:sort-extra "id"}]
    (build-grid params table args)))

(defn ventas-form [id]
  (let [table "ventas"]
    (build-form-row table id)))

(defn ventas-save [{params :params}]
  (let [table "ventas"]
    (build-form-save params table)))

(defn ventas-delete [{params :params}]
  (let [table "ventas"]
    (build-form-delete params table)))
