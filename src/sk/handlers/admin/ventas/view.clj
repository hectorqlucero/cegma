(ns sk.handlers.admin.ventas.view
  (:require
   [hiccup.page :refer [include-js]]
   [ring.util.anti-forgery :refer [anti-forgery-field]]
   [sk.models.util :refer
    [build-dialog build-dialog-buttons build-field build-table build-toolbar]]))

(defn dialog-fields []
  (list
   (build-field
    {:id "id"
     :name "id"
     :type "hidden"})
   (build-field
    {:id "d1"
     :name "d1"
     :class "easyui-textbox"
     :prompt "Encavezado..."
     :data-options "label:'Encavezado:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "d2"
     :name "d2"
     :class "easyui-textbox"
     :prompt "Detalles..."
     :data-options "label:'Detalles:',
        labelPosition:'top',
        required:true,
        multiline:true,
        height:120,
        width:'100%'"})))

(defn ventas-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/ventas"
    (list
     [:th {:data-options "field:'d1',sortable:true,width:100"} "D1"]
     [:th {:data-options "field:'d2',sortable:true,width:100"} "D2"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn ventas-scripts []
  (include-js "/js/grid.js"))
