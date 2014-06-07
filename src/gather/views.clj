(ns gather.views
  (:use hiccup.core)
  (:require [hiccup.page :as page]
            [hiccup.element :as element]
            [clojure.string :as string]))

(defn app [title & body]
  (html
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE-Edge"}]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
      [:title title]
      (page/include-css "css/bootstrap.min.css")
      (page/include-js "js/bootstrap.min.js")]
    [:body body]))

(defn index []
  (app
    "Home"
    [:h1 "Gather"]
    [:h2 "Create an information page for your event, no signup required."]
    (map (fn [w]
           [:div.input-group.input-group-lg
           [:input.form-control {:type w :placeholder (string/capitalize w)}]])
         ["title" "location" "date" "time"])
    [:button.btn.btn-default {:type "submit"} "Submit"]))
