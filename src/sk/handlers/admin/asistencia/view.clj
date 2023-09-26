(ns sk.handlers.admin.asistencia.view
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
     :prompt "Encabesado de asistencia..."
     :data-options "label:'Encabesado:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "d2"
     :name "d2"
     :class "easyui-textbox"
     :prompt "Detalle de asistencia..."
     :data-options "label:'Detalle:',
        labelPosition:'top',
        required:true,
        multiline:true,
        height:120,
        width:'100%'"})
   (build-field
    {:id "imagen"
     :name "imagen"
     :class "easyui-textbox"
     :prompt "Imagen deseada..."
     :data-options "label:'Imagen:',
        labelPosition:'top',
        required:false,
        width:'100%'"})))

(defn asistencia-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/asistencia"
    (list
     [:th {:data-options "field:'d1',sortable:true,width:100"} "D1"]
     [:th {:data-options "field:'d2',sortable:true,width:100"} "D2"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn asistencia-scripts []
  (include-js "/js/grid.js"))
