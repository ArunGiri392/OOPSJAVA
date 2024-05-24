

public class reversstring{
    public static String reversestringwithstring(String input) {
        String reverseString = "";
        for(int i = input.length()-1; i >= 0; i--){
            reverseString += input.charAt(i);
        }
        return reverseString;
    
    }

    public static String reverseStringwithstringbuilderclass(String input){
        StringBuilder reversestring = new StringBuilder();
        for(int i = input.length()-1; i >= 0; i--){
            reversestring.append(input.charAt(i));
        }
        return reversestring.toString();
        
    }

    public static String reversestringwithlist(String input){
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        char temp;
        while (left < right){
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left += 1;
            right -= 1;
        }
        return new String(chars);

    }

    public static String recursively(String s){
       if (s == null || s.length() <= 1){
        return s;
       }
       return recursively(s.substring(1)) + s.charAt(0);

    }
    
    // nura

    // nur + a

    // nu + R

    // n + u




    // A R U N ---- N U R A 

    // R U N -- > A 
    //  U N --> R + A 
    //  N --> u + R + A 
    //    --. N + U + R + A





    public static void main(String[] args){
        String input = "hello";
        System.out.println(reversestringwithstring(input));
        System.out.println(reverseStringwithstringbuilderclass(input));
        System.err.println(reversestringwithlist(input));
        System.err.println(recursively(input));

        

    }
}
