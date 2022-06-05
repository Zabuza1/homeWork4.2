package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(loginCheck("AlexSuper]", "pg_qHcC", "pg_qHcC"));
        //System.out.println(loginCheck("Alex.Super1@yandex.ru", "W2jQq_1", "W2jQq_1")); //Логин длинный
        System.out.println(loginCheck("Alex", "ycBz6up_U*", "ycBz6up_U*"));
        System.out.println(loginCheck("Super", "ZHUzftgaIv", "ZHUzftgaIv"));
        //System.out.println(loginCheck("Alex_Martinez", "1N1CxaBLkgDO}Gi3Ho60Aa", "1N1CxaBLkgDO}Gi3Ho60Aa")); //пароль длинный

    }


    public static boolean loginCheck(String login, String password,String confirmPassword){

        try {
            passwordCheck(password, confirmPassword);
            nameCheck(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean nameCheck(String login){
        if(login.length() > 20){
            try {
                throw new WrongLoginException("User name have limits 20 symbols");
            } catch (WrongLoginException e) {
                e.printStackTrace();
            }
        }
        return isStringContainsRightSymbols(login);
    }
    public static boolean passwordCheck(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("Passwords do not match");
            } catch (WrongPasswordException e) {
                e.printStackTrace();
            }
        }
        if (password.length() >= 20){
            try {
                throw new WrongPasswordException(password);
            } catch (WrongPasswordException e) {
                e.printStackTrace();
            }
        }
        return isStringContainsRightSymbols(password);
    }
    public static boolean isStringContainsRightSymbols(String s){
        boolean correct = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch<= 'Z' || ch >= '0' && ch <= '9' || ch == '_')){
                correct = false;
                break;
            }
        }
        return correct;
    }
}
