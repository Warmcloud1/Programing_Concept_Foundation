public class IneerClassMain {
    public class InnerTest{

        //TestAndInner.InnerTestNonStatic aaaa1=new TestAndInner().InnerTestNonStatic; //報錯 因為要先有外部實體才能創建內部類別
        TestA.InnerTestNonStatic aa1=new TestA().new InnerTestNonStatic(); //正確
        TestA.InnerTestStatic aa2=new TestA.InnerTestStatic(); //enum跟Interface為靜態 同理也可這樣提取

    }
}
//___________________________________________________________________________________________________________________

public class TestA { //外部類別本來就為靜態不用加static
    private int a1;
    public TestA(){
        this.a1=10;
    }

    public class InnerTestNonStatic { //非靜態內部類別
        private int c1; //用private外部類別也拿的到
        public InnerTestNonStatic() {
            a1 = 3; //可以拿到外部類別的東西
            c1=3;
            TestA.this.a1=100; //等同a1=100 Test.this指的是Test的實體
            this.c1=300; //等同c1=300 this只當前操作物體的實體

        }

    }

    public static class InnerTestStatic { //enum跟interface也類似靜態同理  //靜態內部類別

        private int aa=9;

        public InnerTestStatic() {
            TestA V=new TestA(); //用new方法存取外部類別的內容
            V.a1 = 1;
        }

    }
    public void funcA(){
        InnerTestNonStatic C=new InnerTestNonStatic();
        C.c1=30; //建立物件，存取到內部類別，可直接存取private資料
        InnerTestStatic V=new InnerTestStatic();
        V.aa=90;//建立物件，存取到內部類別
    }


    public interface Comparator{//要為public 因為Main要可以提取 才能用new物件 //靜態類別
        public boolean compare(int a,int b);
    }
}
