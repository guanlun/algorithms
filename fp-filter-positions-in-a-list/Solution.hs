f :: [Int] -> [Int]
f lst = go 1 lst where
    go _ [] = []
    go n lst
        | (n `mod` 2) == 0 = (head lst) : rem
        | otherwise = rem
        where rem = go (n + 1) (tail lst)

-- This part deals with the Input and Output and can be used as it is. Do not modify it.
main = do
   inputdata <- getContents
   mapM_ (putStrLn. show). f. map read. lines $ inputdata
