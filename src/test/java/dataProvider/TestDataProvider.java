package dataProvider;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider
	public static Object[][] dataSuiteA(ITestContext con,Method m) {
		System.out.println("-"+m.getName());
		//	System.out.println(con.getIncludedGroups().length);
	    //	String val = con.getCurrentXmlTest().getParameter("group1");
		//	String browsers[] = con.getCurrentXmlTest().getParameter("browsers").split(",");
			
			Object data[][] = null;
		if(m.getName().toUpperCase().equals("TESTA")) {
			data = new Object[2][2];
			// row 1
		//	data[0][0]=browsers[0]; // xls , json
			data[0][0]="U1";
			data[0][1]="P1";
			//data[0][3]="Y";
			// row 2
			//data[1][0]=browsers[1]; // xls , json
			data[1][0]="U2";
			data[1][1]="P2";
			//data[1][3]="N";
			
		}else if(m.getName().toUpperCase().equals("TESTAA")) {
			data = new Object[2][2];
			// row 1
			//data[0][0]=browsers[0]; // xls , json
			data[0][0]="U1";
			data[0][1]="P1";
			// row 2
			//data[1][0]=browsers[1]; // xls , json
			data[1][0]="U2";
			data[1][1]="P2";
		}
		return data;	}
	
	@DataProvider
	public static Object[][] dataSuiteB(Method m) {
		System.out.println(m.getName());
		Object data[][] =null;
		if(m.getName().toUpperCase().equals("TESTB")) {
			 data = new Object[2][2];
			//row1
			data[0][0]="U1";
			data[0][1]="P1";
			//row2
			data[1][0]="U2";
			data[1][1]="P2";
		}
		else if(m.getName().toUpperCase().equals("TESTBB")) {
			data = new Object[2][2];
			//row1
			data[0][0]="U1";
			data[0][1]="P1";
			//row2
			data[1][0]="U2";
			data[1][1]="P2";
		}
		return data;
	}


}
