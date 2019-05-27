package com.generator.fastxml;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Created by iMouseWu on 2019-05-27.
 */
public class FastXML {

    public static <T> T parseObject(String url, Class<T> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            field.getName();
            field.getType();
        }





        T object = (T)clazz.newInstance();
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        Element element = document.getRootElement();
        System.out.println(element.getName());

        System.out.println(element.getNodeTypeName());
        List<Attribute> attributes = element.attributes();
        attributes.forEach((attribute)->{
            //System.out.println(attribute.getName());
            //System.out.println(attribute.getNodeTypeName());
            //System.out.println(attribute.getValue());
        });
        element.elements().forEach((elementSigle)->{
            System.out.println(elementSigle.getName());
            System.out.println(elementSigle.getStringValue());
        });

        return object;
    }

    public static void main(String[] args) throws Exception {
        File path = new File(FastXML.class.getResource("/").getPath());
        //parseObject(path.getAbsolutePath() + "/config.xml", FastXML.class);
    }
}
