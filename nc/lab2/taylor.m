function t = taylor(n, x)
    t = 0;
    for k = 0 : n
      t += (x .^ k) / factorial(k) 
    end
endfunction
