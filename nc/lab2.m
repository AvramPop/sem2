## p1
##x = 0:0.01:1;
##subplot(2, 2, 1);
##l1 = @(x) x;
##plot(x, l1(x));
##
##subplot(2, 2, 2);
##l2 = @(x) (3 / 2) * x .^ 2 - (1 / 2);
##plot(x, l2(x));
##
##subplot(2, 2, 3);
##l3 = @(x) (5 / 2) * x .^ 3 - (3 / 2) * x;
##plot(x, l3(x));
##
##subplot(2, 2, 4);
##l4 = @(x) (35 / 8) * x .^ 4 - (15 / 4) * x .^ 2 + (3 / 8);
##plot(x, l4(x));
##x = 0:0.01:1;
##for n = 1 : 4
##  l = LP(n, x);
##  subplot(2, 2, n);
##  plot(x, l); 
##endfor
## p2
##x = -1:0.01:1;
##c1 = @(x) cos(acos(x));
##c2 = @(x) cos(2 .* acos(x));
##c3 = @(x) cos(3 .* acos(x));
##hold on;
##plot(x, c1(x));
##plot(x, c2(x));
##plot(x, c3(x));
##x = -1:0.01:1;
##hold on;
##for n = 1 : 4
##  l = CHB(n, x);
##  plot(x, l);
##endfor
## p3
##x = -1:0.01:3;
##hold on;
##for n = 1 : 6
##  l = taylor(n, x);
##  plot(x, l);
##endfor

