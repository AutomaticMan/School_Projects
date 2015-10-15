#lang racket
;Programmer: John Gardiner
;Date: Mar 9, 2015
;Assigment: Lab 4 Recursion in Racket

;Question 5- Compute powers including non-positive exponents
(define (power-any n k)
  (cond
    ((> k 0) 
      (* n (power-any n (- k 1)))
    )
    ((< k 0) 
      (/ 1 (* n (power-any n (- (* k -1) 1))))
    )
    (else 
      1
    )
  )
)

;Question 6- Countdown from some number to 1
(define (countdown num)
  (cond
    ((< num 0)
      #f
    )
    ((= num 0)
      '()
    )
    (else
      (cons num (countdown (- num 1)))
    )
  )
)

;Question 7- Return a list with count number of elements consisting of items
(define (repeat count item)
  (cond
    ((< count 0)
      (repeat (* count -1) item)
    )
    ((= count 0)
      '()
    )
    (else
      (cons item (repeat (- count 1) item))
    )
  )
)

;Question 8- Return a list of numbers which are each double the number at the same index in the input list
(define (double-each-element list)
  (if (null? list) '()
    ;else
    (cons (* (car list) 2) (double-each-element (cdr list)))
  )
)

;Question 9- Return a list of integers from 0 to the input number
(define (iota num)
  (if (< num 0) (iota (* num -1)) (iota_act 0 num))
)

(define (iota_act count num)
  (if (= count num) '()
    (cons count (iota_act (+ count 1) num))
  )
)
