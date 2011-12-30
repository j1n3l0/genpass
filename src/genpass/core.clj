(ns genpass.core
  (:gen-class))

(defn- chars-for
  [start end]
  (map char (range start end)))

(def caps (chars-for 65 91))
(def lows (chars-for 97 123))
(def numbers (range 10))
(def symbols (chars-for 33 47))

(defn password
  "Generate a random password - default length = 8"
  ([] (password 8))
  ([length]
     (apply str
            (loop [n length pass []]
              (if (>= 0 n)
                pass
                (recur (dec n) (conj pass (rand-nth (concat caps lows numbers symbols)))))))))

(defn -main
  ([]  (println (password)))
  ([n] (println (password (Integer. n)))))
