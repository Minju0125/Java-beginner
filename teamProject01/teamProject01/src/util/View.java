package util;

public interface View {
      //�ý��� - 1.�α��� 2.�ý�������
      int MAIN = 1;
      
      //�л����
      int S_MAIN = 31; // �л���� ����         O
      int S_RECOBOOK = 32; // ��õ ���� ��ȸ ����   O
      int S_MYPAGE = 33; // ���������� ����         Ox
      int S_REQBOOK = 34;   //������û            O
      int S_SRHBOOK = 35;   //���� �˻�         O
      int S_LENDSTMT = 36;   //������Ȳ��ȸ         O
      int S_LRMAIN = 37;   //���� �� �ݳ� ����      O
      int S_RSVBOOK = 38;	//����
      int S_LOAN = 39;		//�л�����
      
      //�����ڸ��
      int M_MAIN = 71;    //�����ڸ�� ����      O
      int M_MODI = 72;    //�л����� ���� ����      O
      int M_STDBOOK = 73;    //����ݳ� �븮���� ����   O
      int M_LOANM = 74;   //�������            
      int M_RETURNM = 75;   //�ݳ�����            O
      int M_MANBOOK = 76;   //�������� ����         O
      int M_NEWBOOK = 77;   //������� ����         O
      int M_DSCBOOK = 78;    //������� ����         O
      int M_SOSTMT = 79;   //��ü��Ȳ��ȸ         O
      int M_RQSTMT=80;      //���� ��û ��Ȳ ��ȸ �� Ʃ�� ����
      
      
   }