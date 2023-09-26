(ns sk.handlers.admin.mision.view
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
    {:id "empresa"
     :name "empresa"
     :class "easyui-textbox"
     :prompt "Nombre de la empresa..."
     :data-options "label:'Empresa:',
        labelPosition:'top',
        required:true,
        width:'100%'"})
   (build-field
    {:id "meta"
     :name "meta"
     :class "easyui-textbox"
     :prompt "Misión de la empresa..."
     :data-options "label:'Misión:',
        labelPosition:'top',
        required:true,
        multiline:true,
        height:120,
        width:'100%'"})))

(defn mision-view [title]
  (list
   (anti-forgery-field)
   (build-table
    title
    "/admin/mision"
    (list
     [:th {:data-options "field:'empresa',sortable:true,width:100"} "EMPRESA"]
     [:th {:data-options "field:'meta',sortable:true,width:100"} "META"]))
   (build-toolbar)
   (build-dialog title (dialog-fields))
   (build-dialog-buttons)))

(defn mision-scripts []
  (include-js "/js/grid.js"))
