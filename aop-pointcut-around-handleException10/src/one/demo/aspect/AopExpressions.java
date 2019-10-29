package one.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	//this class to be shared by other aspect classes

	@Pointcut("execution(* one.demo.dao.*.*(..))")
	public void forDaoPackage() {};
 
	//createa pointcut for getter methos
	@Pointcut("execution(* one.demo.dao.*.get*(..))")
	public void getterMethod() {}
	//create a poincutfor setter methods
	@Pointcut("execution(* one.demo.dao.*.set*(..))")
	public void setterMethod() {}
	
	//create pointcut include package and exclude the getter/setter
	@Pointcut("forDaoPackage() && !(getterMethod() || setterMethod())")
	public void forDaoPackNoGetterSetter() {}


}
