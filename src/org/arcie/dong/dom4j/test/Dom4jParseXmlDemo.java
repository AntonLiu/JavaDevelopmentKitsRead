package org.arcie.dong.dom4j.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author ������
 * @version 0.1
 * @time 2014��4��8������8:26:11
 * ʹ��dom4j����xml�ĵ�
 *
 */
public class Dom4jParseXmlDemo {
	
	public void parseXml01(){
		try{
			//��src�����xmlת��Ϊ������
			//InputStream inputStream = new FileInputStream(new File("C:/Users/Anton/git/JavaDevelopmentKitsRead/res/Test1.xml")); 
			//InputStream inputStream = this.getClass().getResourceAsStream("/module01.xml");//Ҳ���Ը�����ı����ļ����·��ȥ��xml
			//����SAXReader��ȡ����ר�����ڶ�ȡxml
            SAXReader saxReader = new SAXReader();
            //����saxReader��read��д������֪���ȿ���ͨ��inputStream����������ȡ��Ҳ����ͨ��file��������ȡ 
            //Document document = saxReader.read(inputStream);  
            Document document = saxReader.read(new File("C:/Users/Anton/git/JavaDevelopmentKitsRead/res/Test1.xml"));//����ָ���ļ��ľ���·��
            //���⻹����ʹ��DocumentHelper�ṩ��xmlת����Ҳ�ǿ��Եġ�
            //Document document = DocumentHelper.parseText("<?xml version=\"1.0\" encoding=\"UTF-8\"?><modules id=\"123\"><module> �����module��ǩ���ı���Ϣ</module></modules>");
            
            //��ȡ���ڵ����
            Element rootElement = document.getRootElement();  
            System.out.println("���ڵ����ƣ�" + rootElement.getName());//��ȡ�ڵ������
            System.out.println("���ڵ��ж������ԣ�" + rootElement.attributeCount());//��ȡ�ڵ�������Ŀ
            System.out.println("���ڵ�id���Ե�ֵ��" + rootElement.attributeValue("id"));//��ȡ�ڵ������id��ֵ
            System.out.println("���ڵ����ı���" + rootElement.getText());//���Ԫ�����ӽڵ��򷵻ؿ��ַ��������򷵻ؽڵ��ڵ��ı�
            //rootElement.getText() ֮���Իỻ������Ϊ ��ǩ���ǩ֮��ʹ����tab���ͻ��з����֣����Ҳ�����ı�������ʾ�������е�Ч����
            System.out.println("���ڵ����ı�(1)��" + rootElement.getTextTrim());//ȥ�����Ǳ�ǩ���ǩ֮���tab���ͻ��з��ȵȣ���������ǰ��Ŀո�
            System.out.println("���ڵ��ӽڵ��ı����ݣ�" + rootElement.getStringValue()); //���ص�ǰ�ڵ�ݹ������ӽڵ���ı���Ϣ��
            
            //��ȡ�ӽڵ�
            Element element = rootElement.element("module");
            if(element != null){
            	System.out.println("�ӽڵ���ı���" + element.getText());//��Ϊ�ӽڵ�͸��ڵ㶼��Element�����������ǵĲ�����ʽ������ͬ��
            }
            //������Щ���xml�Ƚϸ��ӣ��淶��ͳһ��ĳ���ڵ㲻����ֱ��java.lang.NullPointerException�����Ի�ȡ��element����֮��Ҫ���ж�һ���Ƿ�Ϊ��
            
            rootElement.setName("root");//֧���޸Ľڵ�����
            System.out.println("���ڵ��޸�֮������ƣ�" + rootElement.getName());
            rootElement.setText("text"); //ͬ���޸ı�ǩ�ڵ��ı�Ҳһ��
            System.out.println("���ڵ��޸�֮����ı���" + rootElement.getText());
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	
	public void parseXml02(){
		try{
			//��src�����xmlת��Ϊ������
			InputStream inputStream = new FileInputStream("C:/Users/Anton/git/JavaDevelopmentKitsRead/res/Test2.xml");
			//����SAXReader��ȡ����ר�����ڶ�ȡxml
            SAXReader saxReader = new SAXReader();
            //����saxReader��read��д������֪���ȿ���ͨ��inputStream����������ȡ��Ҳ����ͨ��file��������ȡ
            Document document = saxReader.read(inputStream);
            
            Element rootElement = document.getRootElement();
	        @SuppressWarnings("unchecked")
			Iterator<Element> modulesIterator = rootElement.elements("module").iterator();
	        //rootElement.element("name");��ȡĳһ����Ԫ��
	        //rootElement.elements("name");��ȡ���ڵ�����Ԫ��moudule�ڵ�ļ��ϣ�����List��������
	        //rootElement.elements("module").iterator();�ѷ��ص�list��������ÿһ��Ԫ�ص����ӽڵ㣬ȫ�����ص�һ��Iterator������
	        while(modulesIterator.hasNext()){
	            Element moduleElement = modulesIterator.next();
	            Element nameElement = moduleElement.element("name");
	            System.out.println(nameElement.getName() + ":" + nameElement.getText());
	            Element valueElement = moduleElement.element("value");
	            System.out.println(valueElement.getName() + ":" + valueElement.getText());
	            Element descriptElement = moduleElement.element("descript");
	            System.out.println(descriptElement.getName() + ":" + descriptElement.getText());
	        }   
	    } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}	
	public void parseXml03(){
		try{
			//��src�����xmlת��Ϊ������
			InputStream inputStream =  new FileInputStream("C:/Users/Anton/git/JavaDevelopmentKitsRead/res/Test3.xml");
			//����SAXReader��ȡ����ר�����ڶ�ȡxml
            SAXReader saxReader = new SAXReader();
            //����saxReader��read��д������֪���ȿ���ͨ��inputStream����������ȡ��Ҳ����ͨ��file��������ȡ
            Document document = saxReader.read(inputStream);
            
            Element rootElement = document.getRootElement();
            if(rootElement.elements("module") != null ){
            	//��Ϊ��һ��module��ǩֻ������û���ӽڵ㣬ֱ��.iterator()��java.lang.NullPointerException��, ������Ҫ�ֿ�ʵ��
            	@SuppressWarnings("unchecked")
				List<Element> elementList = rootElement.elements("module");
            	for (Element element : elementList) {
            		if(!element.getTextTrim().equals("")){
            			System.out.println("��1��" + element.getTextTrim());
            		}else{
			            Element nameElement = element.element("name");
			            System.out.println("     ��2��" + nameElement.getName() + ":" + nameElement.getText());
			            Element valueElement = element.element("value");
			            System.out.println("     ��2��" + valueElement.getName() + ":" + valueElement.getText());
			            Element descriptElement = element.element("descript");
			            System.out.println("     ��2��" + descriptElement.getName() + ":" + descriptElement.getText());
            			
            			@SuppressWarnings("unchecked")
						List<Element> subElementList = element.elements("module");
                    	for (Element subElement : subElementList) {
                    		if(!subElement.getTextTrim().equals("")){
                    			System.out.println("         ��3��" + subElement.getTextTrim());
                    		}else{
        			            Element subnameElement = subElement.element("name");
        			            System.out.println("         ��3��" + subnameElement.getName() + ":" + subnameElement.getText());
        			            Element subvalueElement = subElement.element("value");
        			            System.out.println("         ��3��" + subvalueElement.getName() + ":" + subvalueElement.getText());
        			            Element subdescriptElement = subElement.element("descript");
        			            System.out.println("         ��3��" + subdescriptElement.getName() + ":" + subdescriptElement.getText());
                    		}
                    	}
            		}
				}
            }
	    } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
	
	public void parseXml04(){
		try{
			//��src�����xmlת��Ϊ������
			InputStream inputStream =  new FileInputStream("C:/Users/Anton/git/JavaDevelopmentKitsRead/res/RW.xml");
			//����SAXReader��ȡ����ר�����ڶ�ȡxml
            SAXReader saxReader = new SAXReader();
            //����saxReader��read��д������֪���ȿ���ͨ��inputStream����������ȡ��Ҳ����ͨ��file��������ȡ
            Document document = saxReader.read(inputStream);
            
            Element rootElement = document.getRootElement();
            if(rootElement.elements("module") != null ){
            	//��Ϊ��һ��module��ǩֻ������û���ӽڵ㣬ֱ��.iterator()��java.lang.NullPointerException��, ������Ҫ�ֿ�ʵ��
            	@SuppressWarnings("unchecked")
				List<Element> elementList = rootElement.elements("module");
            	for (Element element : elementList) {
            		if(!element.getTextTrim().equals("")){
            			System.out.println("��1��" + element.getTextTrim());
            		}else{
			            Element nameElement = element.element("name");
			            System.out.println("��2��" + nameElement.getName() + ":" + nameElement.getText());
			            Element valueElement = element.element("value");
			            System.out.println("��2��" + valueElement.getName() + ":" + valueElement.getText());
			            Element descriptElement = element.element("descript");
			            System.out.println("��2��" + descriptElement.getName() + ":" + descriptElement.getText());
            		}
            	}
            	@SuppressWarnings("unchecked")
				Iterator<Element> modulesIterator = rootElement.elements("module").iterator();
            	 while(modulesIterator.hasNext()){
     	            Element moduleElement = modulesIterator.next();
     	            Element nameElement = moduleElement.element("name");
     	            System.out.println("��3��"+ nameElement.getName() + ":" + nameElement.getText());
     	            Element valueElement = moduleElement.element("value");
     	            System.out.println("��3��"+ valueElement.getName() + ":" + valueElement.getText());
     	            Element descriptElement = moduleElement.element("descript");
     	            System.out.println("��3��"+ descriptElement.getName() + ":" + descriptElement.getText());
				}
            }
	    } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}

	public static void main(String[] args) {
		Dom4jParseXmlDemo demo = new Dom4jParseXmlDemo();
		System.out.println("-------------����1------------");
		demo.parseXml01();
		System.out.println("-------------����2------------");
		demo.parseXml02();
		System.out.println("-------------����3------------");
		demo.parseXml03();
		System.out.println("-------------����4------------");
		demo.parseXml04();
	}
}