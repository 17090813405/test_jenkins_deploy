//package com.example.demo.security;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * @author daizhichao
// * @date 2019/3/5
// */
//public class CustomPasswordEncoder implements PasswordEncoder {
//    @Override
//    public String encode(CharSequence charSequence) {
//        return charSequence.toString();
//    }
//
//    @Override
//    public boolean matches(CharSequence charSequence, String s) {
//        return s.equals(charSequence.toString());
//    }
//}
