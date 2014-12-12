(ns chat.server
  (:use (compojure handler [core :only (GET POST defroutes)]))
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :as resources]
            [ring.util.response :as response])
  (:gen-class))

(defn render-app []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body
   (str "<!DOCTYPE html>"
        "<html>"
        "<head>"
        "<link rel=\"stylesheet\" href=\"css/page.css\" />"
        "</head>"
        "<body>"
        "<div>"
        "<p id=\"clickable\">Click me!</p>"
        "</div>"
        "<script src=\"js/cljs.js\"></script>"
        "</body>"
        "</html>")})

(defn get-all-messages []
  "<p>Returning all messages</p>")

(defn post-message []
  "<p>Posting message</p>")

(defroutes app
  (GET "/" request "Hello")
  (GET "/message" request (get-all-messages))
  (POST "/message" request (post-message)))

(defn -main [& args]
  (jetty/run-jetty app {:port 3000}))
