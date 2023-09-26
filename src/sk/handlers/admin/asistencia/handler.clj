(ns sk.handlers.admin.asistencia.handler
  (:require [sk.models.crud :refer [build-form-row build-form-save build-form-delete]]
            [sk.models.grid :refer [build-grid]]
            [sk.layout :refer [application]]
            [sk.models.util :refer [get-session-id user-level]]
            [sk.handlers.admin.asistencia.view :refer [asistencia-view asistencia-scripts]]))

(defn asistencia [_]
  (let [title "Asistencia"
        ok (get-session-id)
        js (asistencia-scripts)
        content (asistencia-view title)]
    (if
     (or
      (= (user-level) "A")
      (= (user-level) "S"))
      (application title ok js content)
      (application title ok nil "solo <strong>los administradores </strong> pueden accessar esta opción!!!"))))

(defn asistencia-grid
  "builds grid. parameters: params table & args args: {:join 'other-table' :search-extra name='pedro' :sort-extra 'name,lastname'}"
  [{params :params}]
  (let [table "asistencia"
        args {:sort-extra "id"}]
    (build-grid params table args)))

(defn asistencia-form [id]
  (let [table "asistencia"]
    (build-form-row table id)))

(defn asistencia-save [{params :params}]
  (let [table "asistencia"]
    (build-form-save params table)))

(defn asistencia-delete [{params :params}]
  (let [table "asistencia"]
    (build-form-delete params table)))
