package Int.InterfaceMehtod;

/**
 * Main
 */
public class Main {public static void main(String[] args) {
    
AndroidDev o1=new AndroidDev();
o1.devlop();o1.init();
WebDev o2=new WebDev();
o2.devlop();
o2.init();


//static//method hiding hoga bs
//ab agar hu, chahte hai parent ke pass body bhhi ho aur koi baccha usse overrrode na kr paye then use static
AndroidDev o3=new AndroidDev();
// o3.staticfun();//WRONG HAI 
Developer o4=new AndroidDev();
// o4.staticfun()WRONG HAI BETAAAAAAA
Developer.staticfun();//YE SHI HAI NO NEED TO CREATE OBJECT


}
    


}