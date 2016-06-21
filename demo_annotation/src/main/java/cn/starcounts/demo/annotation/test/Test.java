package cn.starcounts.demo.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cn.starcounts.demo.annotation.Column;
import cn.starcounts.demo.annotation.Description;
import cn.starcounts.demo.annotation.Table;

public class Test {
	public static void main(String[] args) {
		Class clazz = UserTable.class;
		if (clazz.isAnnotationPresent(Table.class)) {
			Table table =(Table) clazz.getAnnotation(Table.class);
			System.out.println(clazz.getName()+"----"+table.value());
			
			Field[] fields = clazz.getFields();
			for(Field f:fields){
				if(f.isAnnotationPresent(Column.class)){
					Column column = f.getAnnotation(Column.class);
					System.out.println(f.getName()+" ----"+column.name());
					
				}
			}
			
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m:methods){
				if(m.isAnnotationPresent(Description.class)){
					Description description = m.getAnnotation(Description.class);
					System.out.println(m.getName()+"----"+description.val());
				}
			}
			
			//getAnnotations 获得该类(属性/方法)上的所有注解			
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation a:annotations){
				if (a instanceof Table) {
					System.out.println(((Table)a).value());
				}
				
				if(a instanceof Column){
					System.out.println(((Column)a).name());
				}
				
				if(a instanceof Description){
					System.out.println(((Description)a).val());
				}
			}
			
		}
	}

}
