package jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

	public static void main(String[] args) {

		/*
		 * 反射机制
		 * Java在运行期间可以动态的加载、解析和使用一些在编译器不能确定
		 * 其类型的对象。
		 * 最重要：动态
		 *
		 * 每个Java程序执行前必须经过四个阶段
		 * 1.编译
		 * 2.加载，将编译后的字节码文件(.class)中的二进制的数据读入到内存中
		 *   在堆内存中创建一个java.lang.Class的对象
		 * 3.连接：验证确保被加载类的正确性，准备为类的静态变量分配内存，解析
		 * 4.初始化：为类的静态变量赋于初始值
		 *
		 * Class对象中记录着该类各种信息
		 */
		//获取一个类的Class对象
//		Person p = new Person("张三",23);
		try {
//			Class c = p.getClass();
//
//			Class c2 = Person.class;

			String className = "day01.Person";
			Class c3 = Class.forName(className);

			//获取该类全类名
			System.out.println("类名：" + c3.getName());
			//获取该类的全部构造方法的对象数组
			Constructor[] cs = c3.getDeclaredConstructors();
			for (Constructor con : cs) {
				System.out.println("构造方法：" + con.toGenericString());
			}
			//获取该类的全部属性的对象数组
			Field[] fs = c3.getDeclaredFields();
			for (Field f : fs) {
				System.out.println("属性：" + f.getName());
			}
			//获取该的全部方法的对象数组
			Method[] ms = c3.getDeclaredMethods();
			for (Method m : ms) {
				System.out.println("方法：" + m.toGenericString());
			}

			//动态实例化
			Object obj = c3.newInstance();

			Method setName = c3.getMethod("setName", String.class);

			//执行setName该方法
			setName.invoke(obj, "小明");

			Method getName = c3.getMethod("getName");

			//执行getName方法
			Object returnValue = getName.invoke(obj);
			System.out.println("getName方法的返回值：" + returnValue);

		} catch (ClassNotFoundException | InstantiationException | SecurityException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
