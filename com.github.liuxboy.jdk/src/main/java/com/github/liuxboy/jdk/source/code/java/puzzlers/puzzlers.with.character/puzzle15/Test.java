package com.github.liuxboy.jdk.source.code.java.puzzlers.puzzlers.with.character.puzzle15;

/**
 * Generated by the IBM IDL-to-Java compiler, version 1.0
 * from F:\TestRoot\apps\a1\units\include\PolicyHome.idl
 * Wednesday, June puzzle17, 1998 6:44:40 o'clock AM GMT+00:00
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 问题出在"from F:\TestRoot\apps\a1\units\include\PolicyHome.idl"中
         * 有\units，出现"\u"，编译器以为是一个Unicode字符，结果后面又不是正常的4字节十六进制字符，所以认为该
         * Unicode字符非法而拒绝编译。这说明编译器在词法分析生成AST(抽象语法树的时候)，会对注释块也进行分析，这一点
         * 在Javadoc中遇到比较多，这里应该用HTML实体转义符来代替
         */
        System.out.print("Hell");
        System.out.println("o world");
    }
}