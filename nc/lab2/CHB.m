function c = CHB(n, x)
    if n == 0
        c = 1;
    elseif n == 1
        c = x;
    else
        c = 2 * x .* CHB(n - 1, x) - CHB(n - 2, x);
    endif
endfunction
