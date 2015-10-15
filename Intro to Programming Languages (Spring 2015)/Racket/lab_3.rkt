#lang racket
;***************************************************************************************************
; Programmer: John Gardiner
; Date: Mar 5, 2015
; Assignment: Lab 3- Racket Worksheet
;***************************************************************************************************


;***************************************************************************************************
; Write a function, c->f, that will convert celsius to fahrenheit. F = (9/5) * C + 32
;***************************************************************************************************
(define (c->f c) 
  (+ (* (/ 9 5) c) 32)
  )
;***************************************************************************************************

;***************************************************************************************************
; Write a function, solutions, with 3 parameters: a, b and c that represent 
; the coefficients of a quadratic equation. Evaluate the discriminant, 
; b 2 -4ac.
;***************************************************************************************************
(define (solutions a b c) 
  (cond
    ((= (determinant_eval a b c) 0) (print "one solution"))
    ((< (determinant_eval a b c) 0) (print "two imaginary solutions"))
    ;else if determinant_eval > 0
    (else (print "two real solutions"))
    )
  )
;***************************************************************************************************

;***************************************************************************************************
; Modify the discriminant function to determine if the “two real solutions” are rational 
; or irrational solutions.
;***************************************************************************************************
(define (solutions_plus a b c) 
  (cond
    ((= (determinant_eval a b c) 0) (print "one solution"))
    ((< (determinant_eval a b c) 0) (print "two imaginary solutions"))
    ;else if determinant_eval > 0
    ((integer? (sqrt (determinant_eval a b c))) (print "two real rational solutions"))
    (else (print "two real irrational solutions"))
    )
  )
;helper function calculates determinant
(define (determinant_eval a b c) 
  (- (* b b) (* 4 a c))
  )
;***************************************************************************************************

;***************************************************************************************************
; Write a function, quadrant, with 2 parameters: x and y that represent coordinates of a point 
; in a Cartesian coordinate system. Determine which quadrant the point is located in and return 
; one of the following: I, II, III, IV, x-axis, y-axis or origin.
;***************************************************************************************************
(define (quadrant x y) 
  (cond
    ((= y 0) (if (= x 0) (print "At orgin") (print "On x-axis")))
    ((< x 0) (if (< y 0) (print "In quadrant III") (print "In quadrant II")))
    ((> x 0) (if (< y 0) (print "In quadrant IV") (print "In quadrant I")))
    ;else if x = 0 and y /= 0
    (else (print "On y-axis"))    
    )
  )
;***************************************************************************************************