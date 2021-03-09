function L = LAGRANGE3(x,y,xx)
  x = 0:0.5:10;
  y = [];
  xx = x;
  
f = @(v) (1 + cos(pi*v)) ./ (1 + v);
for i = 1:21
  y(i) = f(x(i));
endfor  

v = 0:0.01:10;
hold on;
plot(v, f(v));
  
m = length(x);
P = zeros(1,m);
N = length(xx);
L = zeros(1,N);
for j = 1:N
  s1 = 0;
  s2 = 0;
  for i = 1:m
    P(i) = Ai_test(i,x);
  s1 = s1 + P(i)*y(i)/(xx(j)-x(i));
  s2 = s2 + P(i)/(xx(j)-x(i));
endfor
L(j) = s1/s2;
end

t = 1:1:20;
plot(t, L(t));
endfunction