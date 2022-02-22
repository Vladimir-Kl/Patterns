package VKpackage;


public class FactoryTest {

    public static void main(String[] args) {
	
//	KotlinCoder kc = new KotlinCoder();
//	System.out.println(kc.getClass());
//	RubyCoder rc = new RubyCoder();
//	System.out.println(rc.getClass());
	
	Coder cwj = new ItCompany("Java").getCoder();
	cwj.writeCode();
	
	Coder cwcpp = new ItCompany("C++").getCoder();
	cwcpp.writeCode();
	
	Coder cw1 = new ItCompany("Ruby").getCoder();
	cw1.writeCode();
	
	Coder cw2 = new ItCompany("Kotlin").getCoder();
	cw2.writeCode();
	
	Coder cw3 = new ItCompany("NonExistentLang").getCoder();
	cw3.writeCode();
	
//	try {
//	    Class clazz = Class.forName("check_statement." + "Kotlin" + "Coder");
//	    Coder coder = null;
//	    try {
//		coder = (Coder) clazz.newInstance();
//	    } catch (InstantiationException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	    } catch (IllegalAccessException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	    }
//	    coder.writeCode();
//	} catch (ClassNotFoundException e) {
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	}
    }
}

interface Coder {
    
    public void writeCode();
}

class JavaCoder implements Coder {

    @Override
    public void writeCode() {
	System.out.println("Write code by java");
    }
}


class CppCoder implements Coder {
    
    @Override
    public void writeCode() {
	System.out.println("Write code by C++");
    }
}

class CshCoder implements Coder {
    
    @Override
    public void writeCode() {
	System.out.println("Write code by C#");
    }
}

class RubyCoder implements Coder {
    
    @Override
    public void writeCode() {
	System.out.println("Write code by Ruby");
    }
}

class ItCompany {
    
    Coder coder;
    
    public ItCompany(String prgLang) {
//	this.prgLang = prgLang;
	switch(prgLang.toLowerCase()){
	case "java" :
	    coder = new JavaCoder();
	    return;
//	case "C#" , "Csh", "Csharp" :
	case "c#" :
	case "csh" :
	case "csharp" :
	    coder = new CshCoder();
	    return;
//	case "Cpp", "C++" :
	case "cpp" :
	case "c++" :
	    coder = new CppCoder();
	    return;
	default :
	    try {
		Class clazz = Class.forName("VKpackage." +
	    prgLang.substring(0, 1).toUpperCase() + 
	    prgLang.substring(1).toLowerCase() + "Coder");
		try {
		    coder = (Coder) clazz.newInstance();
		} catch (InstantiationException e) {
		    e.printStackTrace();
		} catch (IllegalAccessException e) {
		    e.printStackTrace();
		}
	    } catch (ClassNotFoundException e) {
		throw new RuntimeException("We have not any " + prgLang + " developers");
	    }
	}
    }
    
    public Coder getCoder() {
	return coder;
    }
}


