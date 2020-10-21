local Hamming = {}

function Hamming.compute(a,b)
  al = string.lower(a)
  bl = string.lower(b)

  hamming = 0

  if al == bl then
    return hamming
  elseif #al ~= #bl then
    return -1
  else
    for i=1, #al do
      if string.sub(al, i, i) ~= string.sub(bl, i, i)  then
        hamming = hamming + 1
      end
    end
  end
  return hamming
end

return Hamming
