package com.adv.qa.selenium.helpers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;






public class MyAnnotationTransformer implements IAnnotationTransformer {	
	@Override
	
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)

	{IRetryAnalyzer retry = annotation.getRetryAnalyzer();
	
	if (retry == null)
	
			{
				annotation.setRetryAnalyzer(Retry.class);
			}
	}
}
