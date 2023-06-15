package controller;


import service.DiscardBooksService;
import service.LoanService;
import service.LoginService;
import service.LogoutService;
import service.ModifyStudentService;
import service.NewBooksService;
import service.RcmdService;
import service.RequestService;
import service.ReturnBooksService;
import service.RsvService;
import service.SelectService;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class Controller {

   public static void main(String[] args) {
      JDBCUtil jdbc = JDBCUtil.getInstance();
      DiscardBooksService dcb = DiscardBooksService.getInstance();   //�������
      LoginService login = LoginService.getInstance();            //�α���
      RcmdService rc1 = RcmdService.getInstance();               //���� ��õ
      RequestService r1 = RequestService.getInstance();            //������û
      NewBooksService newB=NewBooksService.getInstance();            //�������
      MainS m1=MainS.getInstance();                           //�л����θ޴�
      MainM m2 = MainM.getInstance();                           //������ ���θ޴�
      MyPage myp = MyPage.getInstance();                        //����������
      StudentBook stdB=StudentBook.getInstance();                        //����ݳ��������
      SelectService s1=SelectService.getInstance();               //��Ȳ��ȸ(�˻�,����,��ü,��û)
      ReturnBooksService reB = ReturnBooksService.getInstance();
      LoanService ls = LoanService.getInstance();
      StudBook stb = StudBook.getInstance();
      RsvService resvS = RsvService.getInstance();
      ManBook m3=ManBook.getInstance();
      Main ma = Main.getInstance();
      ModifyStudentService modi = ModifyStudentService.getInstance();
      
      
      jdbc.connectConn();
      
     while(true) {
      loop01 : while(true) {
          System.out.println("============�ý��� ȭ��============");
          System.out.println("1. �α���");
          System.out.println("2. �ý��� ����");
          String menu0 = ScanUtil.nextLine();
          switch (menu0) {
          case "1":
             login.loginService();
             break loop01;
          case "2":
             System.out.println("�ý����� �����մϴ�.");
             jdbc.disconnectConn();
             return;
          default:
             System.out.println("�߸��� �Է��Դϴ�.");
             break;
          }
      }
      
      if (JDBCUtil.loginUser.get("STD_CLSCODE").equals("1")) {   //�л��޴�
         int view = View.S_MAIN;
         while (true) {
        	if(JDBCUtil.loginUser==null) break;
            switch (view) {
            case View.MAIN :            //����
                view = ma.main();
                break;
            case View.S_MAIN :            //����
               view = m1.main();
               break;
            case View.S_SRHBOOK :         //�����˻�
               view = s1.selectBookList();
               break;   
            case View.S_RECOBOOK :         //��õ���� �˻�
               view = rc1.rcmdService();
               break;
            case View.S_LENDSTMT :               //������Ȳ��ȸ
               view = s1.selectLendStatement();
               break;
            case View.S_REQBOOK :         //���� ��û
               view = r1.requestService();
               break;
            case View.S_MYPAGE :         //����������
               view = myp.myPage();
               break;
            case View.S_LRMAIN :         //�л� ���� �ݳ� ����
               view = stb.stdBook();
               break;
            case View.S_RSVBOOK :         //����
                view=resvS.rsvService();
                break;
            case View.S_LOAN :
            	view = ls.loanAsStudent();
            default:
               break;
            }
         }
      }else {                                       //�����ڸ޴�
         int view = View.M_MAIN;
         while(true) {
        	if(JDBCUtil.loginUser==null) break;
            switch (view) {
            case View.MAIN :            //����
                view = ma.main();
                break;
            case View.M_MAIN :            //����
               view=m2.main();
               break;
            case View.S_SRHBOOK :            //���� �˻�
               view = s1.selectBookList();
               break;
            case View.M_NEWBOOK :      //���� ���
               view=newB.newBooksService();
               break;
            case View.M_DSCBOOK :      //���� ���
               view=dcb.discardBooks();
               break;
            case View.M_MANBOOK :      //���� ����(���, ���)
               view=m3.manBook();
               break;
            case View.M_LOANM :            //�������
               view= ls.loanAsManager();
               break;
            case View.M_RETURNM :            //�ݳ�����
               view=reB.returnBookForManager();
               break;
            case View.M_STDBOOK :            //����ݳ����� �޴�
               view=stdB.stdBook();
               break;
            case View.M_SOSTMT :            //��ü��Ȳ��ȸ
               view=s1.selectOverStatement();
               break;
            case View.M_RQSTMT :            //���� ��û ��Ȳ ��ȸ �� Ʃ�� ����
               view=s1.selectRequestStatement();
               break;
            case View.S_LRMAIN :         //�л� ���� �ݳ� ����
                view = stb.stdBook();
                break;
            case View.M_MODI : //�л����� ����
            	view = modi.mdfServiceM();
                
                
            default:
               break;
            }
         }
      }
   }
   }
   }


class Main{
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	LoginService login = LoginService.getInstance();
	
	private static Main instance = null;

	   private Main() {
	   }

	   public static Main getInstance() {
	      if (instance == null)
	         instance = new Main();
	      return instance;
	   }

	public int main() {
        System.out.println("============�ý��� ȭ��============");
        System.out.println("1. �α���");
        System.out.println("2. �ý��� ����");
        String menu0 = ScanUtil.nextLine();
        switch (menu0) {
        case "1":
           return login.loginService();
        case "2":
           System.out.println("�ý����� �����մϴ�.");
           jdbc.disconnectConn();
           return 0;
        default:
           System.out.println("�߸��� �Է��Դϴ�.");
           return View.MAIN;
        
	}
}
}


class MainS {
   /* ������ : �輮ȣ  �����Ͻ� 230615 11:50
    * �������� : ���� / ����, �α׾ƿ� �߰�
    */
   StudBook stb = StudBook.getInstance();
   LogoutService logout = LogoutService.getInstance();
   private static MainS instance = null;

   private MainS() {}

   public static MainS getInstance() {
      if (instance == null)
         instance = new MainS();
      return instance;
   }
   
   public int main() {
      try {
         Thread.sleep(1500);

      } catch (Exception e) {
      }

      for (int i = 0; i < 80; i++) {
         System.out.println();
      }
      System.out.println("============ ��  �� ============");
      System.out.println("1. ���� �˻�");
      System.out.println("2. ��õ���� �˻�");
      System.out.println("3. ������Ȳ ��ȸ");
      System.out.println("4. ���� ��û");
      System.out.println("5. ����������");
      System.out.println("6. ���� �� �ݳ�");
      System.out.println("7. �α׾ƿ�");
      System.out.print("============ �޴� ���� :");
      String view = ScanUtil.nextLine();
         switch (view) {
         case "1":
            return View.S_SRHBOOK;
         case "2":
            return View.S_RECOBOOK;
         case "3":
            return View.S_LENDSTMT;
         case "4":
            return View.S_REQBOOK;
         case "5":
            return View.S_MYPAGE;
         case "6":
            return View.S_LRMAIN;
         case "7":
            return logout.logout();
         default:
            System.out.println("�߸��� �Է��Դϴ�.");
            return View.S_MAIN;
         }
      }
}

class MainM {
	LogoutService logout = LogoutService.getInstance();
   private static MainM instance = null;

   private MainM() {
   }

   public static MainM getInstance() {
      if (instance == null)
         instance = new MainM();
      return instance;
   }

   public int main() {
	   try {
	         Thread.sleep(1500);

	      } catch (Exception e) {
	      }

      for (int i = 0; i < 80; i++) {
         System.out.println();
      }
      System.out.println("============ ��  �� ============");
      System.out.println("1. ���� �˻�");
      System.out.println("2. ���� ����");
      System.out.println("3. ���� �� �ݳ� ����");
      System.out.println("4. ��ü��Ȳ ��ȸ");
      System.out.println("5. ���� ��û ��Ȳ ��ȸ �� Ʃ�� ����");
      System.out.println("6. �л���������");
      System.out.println("7. �α׾ƿ�");
      System.out.print("============ �޴� ���� :");
      String view = ScanUtil.nextLine();
      switch (view) {
      case "1":
         return View.S_SRHBOOK;
      case "2":
         return View.M_MANBOOK;
      case "3":
         return View.M_STDBOOK;
      case "4":
         return View.M_SOSTMT;
      case "5":
         return View.M_RQSTMT;
      case "6" :
    	  return View.M_MODI;
      case "7":
          return logout.logout();
      default:
         System.out.println("�߸��� �Է��Դϴ�.");
         return View.M_MAIN;
      }
   }
}

class ManBook {

   private static ManBook instance = null;

   private ManBook() {
   }

   public static ManBook getInstance() {
      if (instance == null)
         instance = new ManBook();
      return instance;
   }

   public int manBook() {
      System.out.println(" [ ���� ��� �� ��� ] ");
      System.out.println("============ ��  �� ============");
      System.out.println("1. ���� ���");
      System.out.println("2. ���� ���");
      System.out.println("3. �ڷΰ���");
      System.out.print("============ �޴� ���� :");
      String view = ScanUtil.nextLine();
      switch (view) {
      case "1":
         return View.M_NEWBOOK;
      case "2":
         return View.M_DSCBOOK;
      case "3":
          return View.M_MAIN;
      default:
         System.out.println("�߸��� �Է��Դϴ�.");
         return View.M_MANBOOK;
      }
   }
}

class MyPage {

   private static MyPage instance = null;

   private MyPage() {
   }

   public static MyPage getInstance() {
      if (instance == null)
         instance = new MyPage();
      return instance;
   }

   ModifyStudentService mdfSS = ModifyStudentService.getInstance();
   RsvService rsvS = RsvService.getInstance();
   SelectService ss = SelectService.getInstance();
   public int myPage() {
      /* ������� ǥ������ ���� */
      System.out.println(" [ ���������� ] ");
      System.out.println("�й� : " + JDBCUtil.loginUser.get("STD_NO"));
      System.out.println("�̸� : " + JDBCUtil.loginUser.get("STD_NAME"));
      /* ���� ���� �Ǽ� */
      ss.viewMypageLendInfo();
      /* ���� ��Ȳ null or å���� , ���Ⱑ�ɿ��� */
      ss.viewMypageReserveInfo();
      System.out.println("============ ��� ���� ============");
      System.out.println("1. ��й�ȣ ����\t2. ���� ���\t3. �ڷ� ����");
      System.out.print("============ �޴� ���� :");
      String view = ScanUtil.nextLine();
      switch (view) {
      case "1":
         return mdfSS.mdfServiceS();
//      case "2":
//         return rsvS.cancRsvService();
      case "3":
         return View.S_MAIN;
      default:
         System.out.println("�߸��� �Է��Դϴ�.");
         return View.S_MYPAGE;
      }
   }
}

class StudentBook {
   ReturnBooksService reB = ReturnBooksService.getInstance();
   LoanService l1=LoanService.getInstance();

   private static StudentBook instance = null;
   private StudentBook() {}

   public static StudentBook getInstance() {
      if (instance == null)
         instance = new StudentBook();
      return instance;
   }
   

   public int stdBook() {
      System.out.println(" [ ���� �� �ݳ� ���� ] ");
      System.out.println("============ ��� ���� ============");
      System.out.println("1. ����");
      System.out.println("2. �ݳ�");
      System.out.println("3. �ڷΰ���");
      System.out.print("============ �޴� ���� :");
      String view = ScanUtil.nextLine();
      switch (view) {
      case "1":
         return l1.loanAsManager();      //�������޼ҵ�
      case "2":
         return reB.returnBookForManager();      //�ݳ�����޼ҵ�
      case "3":
         return View.M_MAIN;
      default:
         System.out.println("�߸��� �Է��Դϴ�.");
         return View.M_STDBOOK;
      }
   }
}



class RequestS{
   
   private static RequestS instance = null;
   private RequestS() {}

   public static RequestS getInstance() {
      if (instance == null)
         instance = new RequestS();
      return instance;
   }
   
   SelectService s1=SelectService.getInstance();
   RequestService rqsS =RequestService.getInstance();
   
   public int requestS() {
      System.out.println(" [ ������û��Ȳ ��ȸ �� ���� ] ");
      System.out.println("============ ��� ���� ============");
      System.out.println("1. ������û ��Ȳ ��ȸ");
      System.out.println("2. ������û ����");
      System.out.print("============ �޴� ���� :");
      String view = ScanUtil.nextLine();
      switch (view) {
      case "1":
         return s1.selectRequestStatement();      //������û ��Ȳ��ȸ
      case "2":
         return rqsS.requestClear();   // ������û ����
      default:
         System.out.println("�߸��� �Է��Դϴ�.");
         return View.M_RQSTMT;
      }
   }
}

/* ������ : �輮ȣ
 * �߰����� : �л� �������� �� �ݳ���� �޴� �߰�
 * ���� �Ͻ� : 2023.06.15 11:40
 */
class StudBook{
   private static StudBook instance = null;
   private StudBook() {}

   public static StudBook getInstance() {
      if (instance == null)
         instance = new StudBook();
      return instance;
   }
   ReturnBooksService reB = ReturnBooksService.getInstance();
   LoanService l1=LoanService.getInstance();
   
   public int stdBook() {
      System.out.println(" [ ���� �� �ݳ� ] ");
      System.out.println("============ ��� ���� ============");
      System.out.println("1. ����");
      System.out.println("2. �ݳ�");
      System.out.println("3. �ڷΰ���");
      System.out.print("============ �޴� ���� :");
      String view = ScanUtil.nextLine();
      switch (view) {
      case "1":
         return l1.loanAsStudent();      //����޼ҵ�
      case "2":
         return reB.returnBookForStudent();      //�ݳ��޼ҵ�
      case "3":
         return View.S_MAIN;
      default:
         System.out.println("�߸��� �Է��Դϴ�.");
         return View.S_LRMAIN;
      }
   }
   
   
   
}