package org.arcie.dong.reader;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import org.omg.CORBA.DataInputStream;
import org.omg.CORBA.DataOutputStream;
/**
 * 
 * @author chundong.liu
 * @version JDK7.0
 * @since 2013.12.10
 *
 */
public class CommonClassSrcCode {
	//�Ķ�JDK�г�����Դ��
	//System ClassLoader
	//������
	String str;
	StringBuffer strbf;
	System sys;
	Object o;
	Class<?> c;
	
	/**
	 * �������Ͱ�װ��
	 */
	//0������
	Number nb;
	//1������
	Byte byt;
	Short sht;
	Integer inte;
	Long lg;
	
	//2��������
	Float fl;
	Double db;
	
	//3���߼���
	Boolean bl;
	//4���ַ���
	Character chat;
	
	/**
	 * IO��
	 */
	DataInput dt;
	DataInputStream dis;
	java.io.DataInputStream jioDis;
	DataOutput dot;
	DataOutputStream dos;
	java.io.DataOutputStream jioDos;
	
	//1�������ֽڵ�IO
	InputStream is;
	InputStreamReader isr;
 
	OutputStream os;
	OutputStreamWriter osw;
	
	//2�������ַ���IO
	Reader rd;
	Writer wr;
	
	//3�����ڴ��̵�IO
	File file;
	//4�����������IO
	Socket sckt;
	
	/**
	 * ������ 
	 * java.util.concurrent
	 * java.util.concurrent.comic
	 * java.util.concurrent.locks
	 **/
	
	Lock lk;
	Condition cd;
	ConcurrentHashMap<?, ?> chm;
	
	public static void main(String[] args) {
		System.out.println("Today is new day!");
	}
}
