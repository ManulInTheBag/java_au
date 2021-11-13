+ [String Compression](#string-compression)
+ [String Compression](#string-compression)
+ [String Compression](#string-compression)
<!-----solution----->
##String Compression
https://leetcode.com/problems/string-compression/
```java
class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }

        StringBuilder s = new StringBuilder();
        int count = 1;
        for(int i = 0; i < chars.length; i++) {
            if(i == chars.length-1) {
                 if(count > 1) {
                   s.append(chars[i]);
                   s.append(count);
               } else {
                   s.append(chars[i]);
               }
            } else if (chars[i] == chars[i+1]) {
               count++;
            } else {
               if(count > 1) {
                   s.append(chars[i]);
                   s.append(count);
               } else {
                   s.append(chars[i]);
               }
               count = 1;
           }

        }

        char[] c = s.toString().toCharArray();
        System.arraycopy(c, 0, chars, 0, c.length);
        return s.length();
    }
}
```
##String Compression
https://leetcode.com/problems/string-compression/
```java
class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }

        StringBuilder s = new StringBuilder();
        int count = 1;
        for(int i = 0; i < chars.length; i++) {
            if(i == chars.length-1) {
                 if(count > 1) {
                   s.append(chars[i]);
                   s.append(count);
               } else {
                   s.append(chars[i]);
               }
            } else if (chars[i] == chars[i+1]) {
               count++;
            } else {
               if(count > 1) {
                   s.append(chars[i]);
                   s.append(count);
               } else {
                   s.append(chars[i]);
               }
               count = 1;
           }

        }

        char[] c = s.toString().toCharArray();
        System.arraycopy(c, 0, chars, 0, c.length);
        return s.length();
    }
}
```
##String Compression
https://leetcode.com/problems/string-compression/
```java
class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) {
            return 1;
        }

        StringBuilder s = new StringBuilder();
        int count = 1;
        for(int i = 0; i < chars.length; i++) {
            if(i == chars.length-1) {
                 if(count > 1) {
                   s.append(chars[i]);
                   s.append(count);
               } else {
                   s.append(chars[i]);
               }
            } else if (chars[i] == chars[i+1]) {
               count++;
            } else {
               if(count > 1) {
                   s.append(chars[i]);
                   s.append(count);
               } else {
                   s.append(chars[i]);
               }
               count = 1;
           }

        }

        char[] c = s.toString().toCharArray();
        System.arraycopy(c, 0, chars, 0, c.length);
        return s.length();
    }
}
```