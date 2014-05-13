package org.arcie.dong.reader;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**�ο�Michael Lee from web
 * Java Reflection Cookbook
 * @author Michael Lee
 * @since 2006-8-23
 * @version 0.1a
 */

public class ReflectExample {
	/**
	 * �õ�ĳ������Ĺ�������
	 * 
	 * @param owner, fieldName
	 * @return �����Զ���
	 * @throws Exception
	 * 
	 */
	public Object getProperty(Object owner, String fieldName) throws Exception {
		Class<? extends Object> ownerClass = owner.getClass();

		Field field = ownerClass.getField(fieldName);

		Object property = field.get(owner);

		return property;
	}

	/**
	 * �õ�ĳ��ľ�̬��������
	 * 
	 * @param className ����
	 * @param fieldName ������
	 * @return �����Զ���
	 * @throws Exception
	 */
	public Object getStaticProperty(String className, String fieldName)
			throws Exception {
		Class<?> ownerClass = Class.forName(className);

		Field field = ownerClass.getField(fieldName);

		Object property = field.get(ownerClass);

		return property;
	}

	/**
	 * ִ��ĳ���󷽷�
	 * 
	 * @param owner ����
	 * @param methodName ������
	 * @param args ����
	 * @return ��������ֵ
	 * @throws Exception
	 */
	public Object invokeMethod(Object owner, String methodName, Object[] args)
			throws Exception {

		Class<? extends Object> ownerClass = owner.getClass();

		Class<?>[] argsClass = new Class[args.length];

		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}

		Method method = ownerClass.getMethod(methodName, argsClass);

		return method.invoke(owner, args);
	}

	/**
	 * ִ��ĳ��ľ�̬����
	 * 
	 * @param className ����
	 * @param methodName ������
	 * @param args ��������
	 * @return ִ�з������صĽ��
	 * @throws Exception
	 */
	public Object invokeStaticMethod(String className, String methodName,
			Object[] args) throws Exception {
		Class<?> ownerClass = Class.forName(className);

		Class<?>[] argsClass = new Class[args.length];

		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}

		Method method = ownerClass.getMethod(methodName, argsClass);

		return method.invoke(null, args);
	}

	/**
	 * �½�ʵ��
	 * 
	 * @param className ����
	 * @param args ���캯���Ĳ���
	 * @return �½���ʵ��
	 * @throws Exception
	 */
	public Object newInstance(String className, Object[] args) throws Exception {
		Class<?> newoneClass = Class.forName(className);

		Class<?>[] argsClass = new Class[args.length];

		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}

		Constructor<?> cons = newoneClass.getConstructor(argsClass);

		return cons.newInstance(args);

	}

	/**
	 * �ǲ���ĳ�����ʵ��
	 * 
	 * @param obj ʵ��
	 * @param cls ��
	 * @return ��� obj �Ǵ����ʵ�����򷵻� true
	 */
	public boolean isInstance(Object obj, Class<?> cls) {
		return cls.isInstance(obj);
	}

	/**
	 * �õ������е�ĳ��Ԫ��
	 * 
	 * @param array ����
	 * @param index ����
	 * @return ����ָ��������������������ֵ
	 */
	public Object getByArray(Object array, int index) {
		return Array.get(array, index);
	}
	
	
	public static void main(String[] args) {
		ReflectExample reft = new ReflectExample();
		ReflectClass[] rc = {
								new ReflectClass(23L, "����"), 
								new ReflectClass(12L, "xiaoming"),
								new ReflectClass(9L, "Anton")
							};
		String name;
		for(int i = 0; i < rc.length; i++){
			System.out.println(rc[i].id);
			try {
				Class<?> classType = rc[i].getClass();
				
				Field field = classType.getDeclaredField("name");
				field.setAccessible(true);	//����˽����ɼ�
				System.out.println(field.get(rc[i]));//�ɷ���
				
				Method method = classType.getDeclaredMethod("getInfo",Long.class,String.class);
				method.setAccessible(true);	//����˽����ɼ�
				method.invoke(classType,new Long(25),"zhangshanfeng");//�ɷ���
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(reft.getClass().getSimpleName());	//ֻ������������������
		System.out.println(reft.getClass().getName());			//��������������					
		System.out.println(reft.getClass().getCanonicalName());	//��������������
	}
}

//��ͨ��
class ReflectClass{	
	public Long id;
	private String name;		//˽����
	/**
	 * @param id
	 * @param name
	 */
	public ReflectClass(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * ˽�з���
	 * @param id
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getInfo(Long id, String name){	//˽�з���
		return id+"-"+name;
	}
}