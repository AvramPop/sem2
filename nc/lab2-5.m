## p5
x = [2, 4, 6, 8]
r = zeros(4, 4)
r(1, 1) = 4
r(2, 1) = 8
r(3, 1) = 14
r(4, 1) = 16
## above we initialise the given data
for i = 2:4
  for j = 1:4-i+1
    r(j,i) = (r(j+1, i-1) - r(j,i-1)) / (x(i+j-1)-x(j))
  endfor
endfor
## here we compute the k-th order divided difference by the formula in the lecture