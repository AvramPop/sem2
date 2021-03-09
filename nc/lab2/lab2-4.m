## p4
h = 0.25;
f = @(x) sqrt(5*x^2+1);
r = zeros(7, 7);
## above we initialise the parameters
for i = 0:6 ## with this for loop we create the first column of the matrix - the base case of the would be recurrence
   x = 1 + i * h;
   r(i + 1, 1) = f(x);
end
for i = 1:6 ## here we populate all items above the secondary diagonal of the matrix by making use of the preceding column
  for k = 0:6-i
      r(k + 1, i + 1) = r(k + 2, i) - r(k + 1, i);
  end
end
disp(r);
