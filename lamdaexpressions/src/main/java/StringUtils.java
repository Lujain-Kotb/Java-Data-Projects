
import java.util.function.BiPredicate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lujain
 */
public class StringUtils {
    public static String betterString(String s1, String s2, BiPredicate<String,String> p){
      return p.test(s1, s2)? s1 : s2;
    }
}
