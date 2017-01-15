f :: Int -> [Int] -> [Int]
f n arr = go n n arr where
    go n _ [] = []
    go n 0 arr = go n n (tail arr)
    go n m arr = (head arr) : go n (m - 1) arr

-- This part handles the Input and Output and can be used as it is. Do not modify this part.
main :: IO ()
main = getContents >>=
       mapM_ print. (\(n:arr) -> f n arr). map read. words
