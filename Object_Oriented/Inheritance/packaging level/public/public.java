//比較有無public
//*****************************************************
package second;

public class A{
//方法t()有public
  public void t(){
      A a=new A();
  }
}

//*****************************************************
package second;

public class B {
//方法t()無public
	void t() {  
		
	}
}
//*****************************************************
package first;

import second.A; // 載入package    import package名稱.類別 
import second.B;
public class inher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a.t();//OK
    b.t();//會報錯
	}

}