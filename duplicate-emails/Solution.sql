select distinct P1.Email
from Person as P1 
inner join Person as P2
on P1.Email = P2.Email
and P1.Id <> P2.Id;
