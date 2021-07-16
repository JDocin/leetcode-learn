
![截屏2021-07-10 下午6.06.26.png](https://pic.leetcode-cn.com/1625911773-eNwdhj-%E6%88%AA%E5%B1%8F2021-07-10%20%E4%B8%8B%E5%8D%886.06.26.png)


```Swift
class Solution {
    func exist(_ board: [[Character]], _ word: String) -> Bool {
        let maxY = board.count
        let chars: [Character] = Array(word)
        
        guard let maxX = board.first?.count, maxY > 0, maxX > 0 else {
            return false
        }
        
        var visited: [[Bool]] = Array(repeating: Array(repeating: false, count: maxX), count: maxY)
        
        var pathLength = 0
        
        for y in 0..<maxY {
            for x in 0..<maxX {
                if hasPathCore(board, chars, maxX: maxX, maxY: maxY, pathLength: &pathLength, x: x, y: y, visted: &visited) {
                    return true
                }
            }
        }
        
        return false
    }

    func hasPathCore(_ board: [[Character]], _ chars: [Character], maxX: Int, maxY: Int, pathLength: inout Int, x: Int, y: Int, visted: inout [[Bool]]) -> Bool {
        if pathLength == chars.count {
            return true
        }
        
        var result = false
        if x >= 0, y >= 0,
            x < maxX, y < maxY,
            visted[y][x] == false,
            board[y][x] == chars[pathLength]
        {
            pathLength += 1
            visted[y][x] = true
            
            result =
                hasPathCore(board, chars, maxX: maxX, maxY: maxY, pathLength: &pathLength, x: x - 1, y: y, visted: &visted) ||
                hasPathCore(board, chars, maxX: maxX, maxY: maxY, pathLength: &pathLength, x: x + 1, y: y, visted: &visted) ||
                hasPathCore(board, chars, maxX: maxX, maxY: maxY, pathLength: &pathLength, x: x, y: y - 1, visted: &visted) ||
                hasPathCore(board, chars, maxX: maxX, maxY: maxY, pathLength: &pathLength, x: x, y: y + 1, visted: &visted)
            
            if result == false {
                pathLength -= 1
                visted[y][x] = false
            }
        }
        
        return result
    }

}
```
