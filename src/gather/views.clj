(ns gather.views
  (:use hiccup.core)
  (:require [hiccup.page :as page]
            [hiccup.element :as element]
            [clojure.string :refer [capitalize]]))

(defn common [title & body]
  (html
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "X-UA-Compatible" :content "IE-Edge"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]
     [:meta {:name "description" :content "make a page for your event"}]
     [:meta {:name "author" :content "Bryan Garza"}]
     [:title title]
     (page/include-css "packages/bootstrap/dist/css/bootstrap.min.css"
                       "packages/fontawesome/css/font-awesome.min.css"
                       "fonts/lora.css"
                       "fonts/montserrat.css"
                       "css/gather.css")]
    [:div.container
     [:body#page-top {:data-spy "scroll" :data-target ".navbar-custom"} body]]
    (page/include-js "packages/jquery/dist/jquery.min.js"
                     "packages/bootstrap/dist/js/bootstrap.min.js"
                     "packages/jquery-easing-original/jquery.easing.1.3.min.js"
                     "js/gather.js")))

(defn index []
  (common
    "Home"
    [:nav.navbar.navbar-custom.navbar-fixed-top {:role "navigation"}
     [:div.container

      [:div.navbar-header.page-scroll
       [:button.navbar-toggle {:type "button"
                               :data-toggle "collapse"
                               :data-target ".navbar-main-collapse"}
        [:i.fa.fa-bars]]
       [:a.navbar-brand {:href "#page-top"}
        [:i.fa.fa-paper-plane] [:span.light "Let's"] "Gather"]]

      ; Collect the nav links, forms, and other content for toggling
      [:div.collapse.navbar-collapse.navbar-right.navbar-main-collapse
       [:ul.nav.navbar-nav
        ; Hidden li included to remove active class from about link when
        ; scrolled up past section
        [:li.hidden (element/link-to "#page-top")]
        [:li.page-scroll (element/link-to "#create" "Create")]
        [:li.page-scroll (element/link-to "#events" "Events")]
        [:li.page-scroll (element/link-to "#contact" "Contact")]]]]]

    [:section.intro
     [:div.intro-body
      [:div.container
       [:div.row
        [:div.col-md-8.col-md-offset-2
         [:h1.brand-heading "Gather"]
         [:p.intro-text "Make a page for your event."]
         [:div.page-scroll
          [:div.btn-group
          [:a.btn.btn-primary.btn-lg {:href "#create"} "Get Started"]]]]]]]]

    [:section#create.container.content-section.text-center
     [:div.row
      [:div.col-lg-8.col-lg-offset-2
       [:h2 "Your Event"]
       (map (fn [w]
              [:div.input-group.input-group-lg.form-group
               [:input.form-control {:type w :placeholder (capitalize w)}]])
            ["title" "location" "date" "time"])
       [:textarea.form-control.input-lg {:rows "5" :placeholder "Description"}]
       [:button.btn.btn-primary {:type "submit"} "Submit"]]]]

    [:section#events.content-section.text-center
     [:div:events-section
      [:div.container
       [:div.col-lg-8.col-lg-offset-2
        [:h2 "Events"]
        [:p "Here's a list of all events"]]]]]


    ))
