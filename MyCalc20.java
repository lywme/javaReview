import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalc20
{
   public static void main(String [] args)
   {
      MyCalcClass mycalcObject = new MyCalcClass();
      MyCalcGUIFrame mycalcClient = new MyCalcGUIFrame();

      mycalcObject.setMyCalcClient(mycalcClient);
      mycalcClient.setMyCalcObject(mycalcObject);
   }
} // end of public class MyCalc20


// MyCalcNumber data type
class MyCalcNumber
{
   // precision
   public static final int MYCALC_NUMBER_MAX_LENGTH = 8;

   private StringBuilder strbdrNumber;

   MyCalcNumber()
   {
      strbdrNumber = new StringBuilder();
   }

   public int setNumber(String number)
   {
      strbdrNumber = new StringBuilder(number);
      return 0;
   }

   public int setNumber(int number)
   {
      strbdrNumber = new StringBuilder();
      strbdrNumber.append(number);
      return 0;
   }

   public int setNumber(double number)
   {
      strbdrNumber = new StringBuilder();
      strbdrNumber.append(number);
      return 0;
   }

   public boolean containPeriod()
   {
      if(strbdrNumber.indexOf(".") >= 0)
      {
         return true;
      }
      return false;
   }

   public int appendDigit(int digit)
   {
      if(strbdrNumber.length() == MYCALC_NUMBER_MAX_LENGTH)
      {
         // ignore the key
         return 1;
      }

      if(digit == 0)
      {
         if(strbdrNumber.length() == 1)
         {
            if(strbdrNumber.charAt(0) == '0')
            {
               // ignore the key
               return 2;
            }
         }
      }
      strbdrNumber.append(digit);
      return 0;
   }

   public int appendPeriod()
   {
      if(strbdrNumber.indexOf(".")>=0)
      {
         return 1;
      }
      strbdrNumber.append(".");
      return 0;
   }

   public String toString()
   {
      if(strbdrNumber.indexOf(".") >= 0)
      {
         return strbdrNumber.toString();
      }
      return strbdrNumber.toString() + ".";
   }

   public void removeTailZero()
   {
      if(strbdrNumber.indexOf(".") >= 0)
      {
         while(strbdrNumber.charAt(strbdrNumber.length() - 1) == '0')
         {
            strbdrNumber.deleteCharAt(strbdrNumber.length() - 1);
         }
      }
   }

   public String toStringNoTailZero()
   {
      StringBuilder bdr = new StringBuilder(strbdrNumber.toString());
            
      if(bdr.indexOf(".") >= 0)
      {
         while(bdr.charAt(bdr.length() - 1) == '0')
         {
            bdr.deleteCharAt(bdr.length() - 1);
         }
      }
      return bdr.toString();
   }

}// end of class MyCalcNumber


// mycalc interface constants
interface MyCalcConstants
{
   // MyCalc Internal Keys
   public static final int MYCALC_IK_NULL = 0x00000000;

   public static final int MYCALC_IK_DIGIT_BEGIN  = 0x00010100;
   public static final int MYCALC_IK_DIGIT_0      = 0x00010100;
   public static final int MYCALC_IK_DIGIT_1      = 0x00010101;
   public static final int MYCALC_IK_DIGIT_2      = 0x00010102;
   public static final int MYCALC_IK_DIGIT_3      = 0x00010103;
   public static final int MYCALC_IK_DIGIT_4      = 0x00010104;
   public static final int MYCALC_IK_DIGIT_5      = 0x00010105;
   public static final int MYCALC_IK_DIGIT_6      = 0x00010106;
   public static final int MYCALC_IK_DIGIT_7      = 0x00010107;
   public static final int MYCALC_IK_DIGIT_8      = 0x00010108;
   public static final int MYCALC_IK_DIGIT_9      = 0x00010109;
   public static final int MYCALC_IK_DIGIT_PERIOD = 0x00010110;
   public static final int MYCALC_IK_DIGIT_END    = 0x00010110;

   public static final int MYCALC_IK_OPERATOR_BEGIN  = 0x00010201;
   public static final int MYCALC_IK_OPERATOR_SIGN   = 0x00010201;
   public static final int MYCALC_IK_OPERATOR_PLUS   = 0x00010202;
   public static final int MYCALC_IK_OPERATOR_SUB    = 0x00010203;
   public static final int MYCALC_IK_OPERATOR_MUL    = 0x00010204;
   public static final int MYCALC_IK_OPERATOR_DIV    = 0x00010205;
   public static final int MYCALC_IK_OPERATOR_RESULT = 0x00010206;
   public static final int MYCALC_IK_OPERATOR_END    = 0x00010206;

   public static final int MYCALC_IK_CLEAR_BEGIN = 0x00010301;
   public static final int MYCALC_IK_CLEAR_C     = 0x00010301;
   public static final int MYCALC_IK_CLEAR_CE    = 0x00010302;
   public static final int MYCALC_IK_CLEAR_END   = 0x00010302;

   public static final int MYCALC_IK_MEMORY_BEGIN = 0x00010401;
   public static final int MYCALC_IK_MEMORY_MC    = 0x00010401;
   public static final int MYCALC_IK_MEMORY_MR    = 0x00010402;
   public static final int MYCALC_IK_MEMORY_MS    = 0x00010403;
   public static final int MYCALC_IK_MEMORY_MA    = 0x00010404;
   public static final int MYCALC_IK_MEMORY_END   = 0x00010404;

   // internal key type
   public static final int MYCALC_IKTYPE_BEGIN    = 0x00020101;
   public static final int MYCALC_IKTYPE_DIGIT    = 0x00020101;
   public static final int MYCALC_IKTYPE_OPERATOR = 0x00020102;
   public static final int MYCALC_IKTYPE_CLEAR    = 0x00020103;
   public static final int MYCALC_IKTYPE_MEMORY   = 0x00020104;
   public static final int MYCALC_IKTYPE_UNKNOWN  = 0x00020105;
   public static final int MYCALC_IKTYPE_END      = 0x00020105;

   // calculate state
   public static final int MYCALC_STATE_BEGIN    = 0x00020201;
   public static final int MYCALC_STATE_READY    = 0x00020201;
   public static final int MYCALC_STATE_FIRST    = 0x00020202;
   public static final int MYCALC_STATE_OPERATOR = 0x00020203;
   public static final int MYCALC_STATE_SECOND   = 0x00020204;
   public static final int MYCALC_STATE_END      = 0x00020204;

} // end of interface MyCalcConstants


interface MyCalcInterface
{
   // MyCalc interface methods
   public abstract void mycalc_if_outputText(String text);
   public abstract void mycalc_if_outputMemory(String memory);
} // end of interface MyCalcInterface


// MyCalc Internal Key
class MyCalcInternalKey implements MyCalcConstants
{
   private int internalKey;

   MyCalcInternalKey()
   {
      internalKey = MYCALC_IK_NULL;
   }

   MyCalcInternalKey(int ik)
   {
      internalKey = ik;
   }

   public int getType()
   {
      if(internalKey >= MYCALC_IK_DIGIT_BEGIN && internalKey <= MYCALC_IK_DIGIT_END)
      {
         return MYCALC_IKTYPE_DIGIT;
      }
      else if(internalKey >= MYCALC_IK_OPERATOR_BEGIN && internalKey <= MYCALC_IK_OPERATOR_END)
      {
         return MYCALC_IKTYPE_OPERATOR;
      }
      else if(internalKey >= MYCALC_IK_CLEAR_BEGIN && internalKey <= MYCALC_IK_CLEAR_END)
      {
         return MYCALC_IKTYPE_CLEAR;
      }
      else if(internalKey >= MYCALC_IK_MEMORY_BEGIN && internalKey <= MYCALC_IK_MEMORY_END)
      {
         return MYCALC_IKTYPE_MEMORY;
      }

      Trace.output("MyCalcOperator:: unknown internal key type " + internalKey);
      return MYCALC_IKTYPE_UNKNOWN;
   }

   public int getDigitValue()
   {
      int value;
      
      if(internalKey < MYCALC_IK_DIGIT_BEGIN || internalKey > MYCALC_IK_DIGIT_END)
      {
         return -1;
      }

      value = internalKey - MYCALC_IK_DIGIT_0;
      return value;
   }

   public int getInternalValue()
   {
      return internalKey;
   }

}

class MyCalcClass implements MyCalcConstants
{

   // --------------------------------------------------------------------
   // MyCalc instance variables
   // --------------------------------------------------------------------

   private MyCalcNumber firstNumber;
   private MyCalcNumber secondNumber;
   private MyCalcNumber resultNumber;
   private int mycalcOperator;
   private int mycalcState;
   private MyCalcInterface mycalcClient;


   // --------------------------------------------------------------------
   // MyCalc Methods
   // --------------------------------------------------------------------

   // constructor
   MyCalcClass()
   {
      init();
   }

   private void init()
   {
      firstNumber = new MyCalcNumber();
      secondNumber = new MyCalcNumber();
      resultNumber = new MyCalcNumber();
      mycalcOperator = MYCALC_IK_OPERATOR_PLUS;
      mycalcState = MYCALC_STATE_READY;

      Trace.output("init:: firstNumber=" + firstNumber.toString() + ", secondNumber=" + secondNumber.toString());
   }

   public void setMyCalcClient(MyCalcInterface client)
   {
      mycalcClient = client;
   }

   // ---------------------------------------
   // Section: InternalKeyManager
   // ---------------------------------------
   public int ikm_inputKey(MyCalcInternalKey ik)
   {
      cik_inputKey(ik);
      return 0;
   }

   public int ikm_dataRefreshed(double d)
   {
      ioc_outputNumber(d);
      return 0;
   }

   public int ikm_dataRefreshed(int number)
   {
      String str = new String();
      str = Integer.toString(number);
      str = str + ".";
      ioc_outputText(str);
      return 0;
   }

   public int ikm_textRefreshed(String text)
   {
      ioc_outputText(text);
      return 0;
   }

   public int ikm_clearAll()
   {
      init();
      mycalcClient.mycalc_if_outputText("0.");
      return 0;
   }
   
   // ---------------------------------------
   // Section: ClassifyInternalKey
   // ---------------------------------------
   private int cik_inputKey(MyCalcInternalKey ik)
   {
      switch(ik.getType())
      {
      case MYCALC_IKTYPE_DIGIT:
         pik_processDigit(ik);
         break;

      case MYCALC_IKTYPE_OPERATOR:
         pik_processOperator(ik);
         break;

      case MYCALC_IKTYPE_CLEAR:
         pik_processClear(ik);
         break;

      case MYCALC_IKTYPE_MEMORY:
         pik_processMemory(ik);
         break;

      default:
         Trace.output("cik_inputKey:: unknown internal key type " + ik.toString());
         break;
      }
      
      return 0;
   }

   public void test()
   {
   }


   // ---------------------------------------
   // Section: ProcessInternalKey
   // ---------------------------------------

   public int pik_processDigit(MyCalcInternalKey ik)
   {
      int digit;

      if(ik.getType()!= MYCALC_IKTYPE_DIGIT)
      {
         Trace.output("[exception]pik_processDigit():: ik is not a valid digit internal key");
         return 1;
      }

      if(ik.getInternalValue() == MYCALC_IK_DIGIT_PERIOD)
      {
         pik_processDigitPeriod(ik);
         return 0;
      }

      digit = ik.getDigitValue();
      switch(mycalcState)
      {
      case MYCALC_STATE_READY:
         firstNumber.setNumber(digit);
         ikm_textRefreshed(firstNumber.toString());

         mycalcState = MYCALC_STATE_FIRST;
         break;

      case MYCALC_STATE_FIRST:
         firstNumber.appendDigit(digit);
         ikm_textRefreshed(firstNumber.toString());
         break;

      case MYCALC_STATE_OPERATOR:
         secondNumber.setNumber(digit);
         ikm_textRefreshed(secondNumber.toString());

         mycalcState = MYCALC_STATE_SECOND;
         break;

      case MYCALC_STATE_SECOND:
         secondNumber.appendDigit(digit);
         ikm_textRefreshed(secondNumber.toString());
         break;

      default:
         Trace.output("pik_processDigit:: unknown mycalc state");
         break;
      }

      Trace.output("pik_processDigit:: firstNumber=" + firstNumber.toString() + ", "
                                                      + "secondNumber=" + secondNumber.toString() + ", "
                                                      + "resultNumber=" + resultNumber.toString());
      return 0;
   }

   public int pik_processDigitPeriod(MyCalcInternalKey ik)
   {
      switch(mycalcState)
      {
      case MYCALC_STATE_READY:
         firstNumber.setNumber("0.");
         ikm_textRefreshed(firstNumber.toString());

         mycalcState = MYCALC_STATE_FIRST;
         break;

      case MYCALC_STATE_FIRST:
         firstNumber.appendPeriod();
         ikm_textRefreshed(firstNumber.toString());
         break;

      case MYCALC_STATE_OPERATOR:
         secondNumber.setNumber("0.");
         ikm_textRefreshed(secondNumber.toString());

         mycalcState = MYCALC_STATE_SECOND;
         break;

      case MYCALC_STATE_SECOND:
         secondNumber.appendPeriod();
         ikm_textRefreshed(secondNumber.toString());
         break;

      default:
         Trace.output("pik_processDigit:: unknown mycalc state");
         break;
      }

      Trace.output("pik_processDigit:: firstNumber=" + firstNumber.toString() + ", "
                                                      + "secondNumber=" + secondNumber.toString() + ", "
                                                      + "resultNumber=" + resultNumber.toString());
      
      return 0;
   }

   public int pik_processOperator(MyCalcInternalKey ik)
   {
      double fn, sn, rn;

      if(ik.getType() != MYCALC_IKTYPE_OPERATOR)
      {
         Trace.output("pik_processOperator:: ik is not a valid operator internal key");
         return 1;
      }

      switch(mycalcState)
      {
      case MYCALC_STATE_READY:
         break;

      case MYCALC_STATE_FIRST:
         mycalcOperator = ik.getInternalValue();
         mycalcState = MYCALC_STATE_OPERATOR;
         break;

      case MYCALC_STATE_OPERATOR:
         mycalcOperator = ik.getInternalValue();
         break;

      case MYCALC_STATE_SECOND:
         pik_doCalculate();
         mycalcState = MYCALC_STATE_READY;
         break;

      default:
         Trace.output("pik_processDigit:: unknown mycalc state");
         break;
      }

      return 0;
   }

   public int pik_doCalculate()
   {
      double fn = Double.parseDouble(firstNumber.toString());
      double sn = Double.parseDouble(secondNumber.toString());
      double rn = 0.0;

      switch(mycalcOperator)
      {
      case MYCALC_IK_OPERATOR_SIGN:
         break;
      case MYCALC_IK_OPERATOR_PLUS:
         rn = fn + sn;
         break;

      case MYCALC_IK_OPERATOR_SUB:
         rn = fn - sn;
         break;

      case MYCALC_IK_OPERATOR_MUL:
         rn = fn * sn;
         break;

      case MYCALC_IK_OPERATOR_DIV:
         rn = fn / sn;
         break;

      case MYCALC_IK_OPERATOR_RESULT:
         break;
         
      default:
         break;

      }
      resultNumber.setNumber(rn);

      Trace.output("pik_doCalculate:: fn/firstNumber = " + Double.toString(fn) + ", "
                            + "sn/secondNumber = " + Double.toString(sn) + ", "
                            + "rn/resultNumber = " + Double.toString(rn));

      ikm_textRefreshed(resultNumber.toStringNoTailZero());

      return 0;
   }

   public int pik_processClear(MyCalcInternalKey ik)
   {
      ikm_clearAll();
      return 0;
   }

   public int pik_processMemory(MyCalcInternalKey ik)
   {
      return 0;
   }

   // End Section: ProcessInternalKey


   // ---------------------------------------
   // Section: InputOutputcontroller
   // ---------------------------------------

   public int ioc_inputNumber(int ik)
   {
      Trace.output("ioc_inputNumber:: received internal key " + Trace.translateMyCalcContants(ik));
      MyCalcInternalKey intkey = new MyCalcInternalKey(ik);
      ikm_inputKey(intkey);
      return 0;
   }

   public int ioc_outputNumber(double number)
   {
      String str = Double.toString(number);
      mycalcClient.mycalc_if_outputText(str);
      return 0;
   }

   public int ioc_outputText(String strText)
   {
      mycalcClient.mycalc_if_outputText(strText);
      return 0;
   }

   // end of Section: ProcessInternalKey


} // end of class MyCalcClass implements MyCalcConstants



class MyCalcGUIFrame extends JFrame implements MyCalcConstants, MyCalcInterface
{
   // --------------------------------------------------------------------
   // MyCalc frame widget
   // --------------------------------------------------------------------

   JLabel outputBox;
   JPanel pnlOutput;
   JPanel pnlKeypad;
   
   JButton btnMemIndi;

   JButton btnKey0;
   JButton btnKey1;
   JButton btnKey2;
   JButton btnKey3;
   JButton btnKey4;
   JButton btnKey5;
   JButton btnKey6;
   JButton btnKey7;
   JButton btnKey8;
   JButton btnKey9;

   JButton btnKeySign;
   JButton btnKeyPeriod;

   JButton btnKeyPlus;
   JButton btnKeySub;
   JButton btnKeyMul;
   JButton btnKeyDiv;
   JButton btnKeyResult;

   JButton btnKeyC;
   JButton btnKeyCE;

   JButton btnKeyMC;
   JButton btnKeyMR;
   JButton btnKeyMS;
   JButton btnKeyMA;

   public MyCalcClass mycalcObject;

   // --------------------------------------------------------------------
   // MyCalc methods
   // --------------------------------------------------------------------

   MyCalcGUIFrame()
   {
      init();
      test();
   }

   public void test()
   {
   }

   private void init()
   {
      // MyCalc frame
      Container c = getContentPane();
      BorderLayout bl = new BorderLayout();
      c.setLayout(bl);

      // OutputBox Panel
      pnlOutput = new JPanel();
      BorderLayout blOutput = new BorderLayout();
      pnlOutput.setLayout(blOutput);

      outputBox = new JLabel("0.", JLabel.RIGHT);
      pnlOutput.add(BorderLayout.CENTER, outputBox);

      // Keypad Panel
      pnlKeypad = new JPanel();

      GridLayout glKeypad = new GridLayout(4,6);
      pnlKeypad.setLayout(glKeypad); 

      // 
      btnKey0 = new JButton("0");
      btnKey1 = new JButton("1");
      btnKey2 = new JButton("2");
      btnKey3 = new JButton("3");
      btnKey4 = new JButton("4");
      btnKey5 = new JButton("5");
      btnKey6 = new JButton("6");
      btnKey7 = new JButton("7");
      btnKey8 = new JButton("8");
      btnKey9 = new JButton("9");

      btnKeySign = new JButton("+/-");
      btnKeyPeriod = new JButton(".");

      btnKeyPlus = new JButton("+");
      btnKeySub = new JButton("-");
      btnKeyMul = new JButton("*");
      btnKeyDiv = new JButton("/");
      btnKeyResult = new JButton("=");

      btnKeyC = new JButton("C");
      btnKeyCE = new JButton("CE");

      btnKeyMC = new JButton("MC");
      btnKeyMR = new JButton("MR");
      btnKeyMS = new JButton("MS");
      btnKeyMA = new JButton("MA");

      btnMemIndi = new JButton("");

      //
      btnKey0.addActionListener(new ButtonListenerBtnKey0());
      btnKey1.addActionListener(new ButtonListenerBtnKey1());
      btnKey2.addActionListener(new ButtonListenerBtnKey2());
      btnKey3.addActionListener(new ButtonListenerBtnKey3());
      btnKey4.addActionListener(new ButtonListenerBtnKey4());
      btnKey5.addActionListener(new ButtonListenerBtnKey5());
      btnKey6.addActionListener(new ButtonListenerBtnKey6());
      btnKey7.addActionListener(new ButtonListenerBtnKey7());
      btnKey8.addActionListener(new ButtonListenerBtnKey8());
      btnKey9.addActionListener(new ButtonListenerBtnKey9());
   
      btnKeySign.addActionListener(new ButtonListenerBtnKeySign());
      btnKeyPeriod.addActionListener(new ButtonListenerBtnKeyPeriod());
   
      btnKeyPlus.addActionListener(new ButtonListenerBtnKeyPlus());
      btnKeySub.addActionListener(new ButtonListenerBtnKeySub());
      btnKeyMul.addActionListener(new ButtonListenerBtnKeyMul());
      btnKeyDiv.addActionListener(new ButtonListenerBtnKeyDiv());
      btnKeyResult.addActionListener(new ButtonListenerBtnKeyResult());
   
      btnKeyC.addActionListener(new ButtonListenerBtnKeyC());
      btnKeyCE.addActionListener(new ButtonListenerBtnKeyCE());
   
      btnKeyMC.addActionListener(new ButtonListenerBtnKeyMC());
      btnKeyMR.addActionListener(new ButtonListenerBtnKeyMR());
      btnKeyMS.addActionListener(new ButtonListenerBtnKeyMS());
      btnKeyMA.addActionListener(new ButtonListenerBtnKeyMA());

      btnMemIndi.addActionListener(new ButtonListenerBtnMemIndi());

      //

      pnlKeypad.add(btnKey1);
      pnlKeypad.add(btnKey2);
      pnlKeypad.add(btnKey3);
      pnlKeypad.add(btnKeyPlus);
      pnlKeypad.add(btnKeyCE);
      pnlKeypad.add(btnKeyC);

      pnlKeypad.add(btnKey4);
      pnlKeypad.add(btnKey5);
      pnlKeypad.add(btnKey6);
      pnlKeypad.add(btnKeySub);
      pnlKeypad.add(btnKeyResult);
      pnlKeypad.add(btnMemIndi);

      pnlKeypad.add(btnKey7);
      pnlKeypad.add(btnKey8);
      pnlKeypad.add(btnKey9);
      pnlKeypad.add(btnKeyMul);
      pnlKeypad.add(btnKeyMR);
      pnlKeypad.add(btnKeyMC);

      pnlKeypad.add(btnKeyPeriod);
      pnlKeypad.add(btnKey0);
      pnlKeypad.add(btnKeySign);
      pnlKeypad.add(btnKeyDiv);
      pnlKeypad.add(btnKeyMS);
      pnlKeypad.add(btnKeyMA);

      c.add(BorderLayout.NORTH, pnlOutput);
      c.add(BorderLayout.CENTER, pnlKeypad);

      MyCalcGUIFrameListener cl = new MyCalcGUIFrameListener();
      addWindowListener(cl);

      setTitle("My Calculator");
      pack();
      setVisible(true);
   }

   public void setMyCalcObject(MyCalcClass obj)
   {
      mycalcObject = obj;
   }

   public void mycalc_if_outputText(String text)
   {
      outputBox.setText(text);
   }

   public void mycalc_if_outputMemory(String memory)
   {
   }

   // button listener
   class ButtonListenerBtnKey0 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_0);
      }
   }
   
   class ButtonListenerBtnKey1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_1);
      }
   }
   
   class ButtonListenerBtnKey2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_2);
      }
   }
   
   class ButtonListenerBtnKey3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_3);
      }
   }
   
   class ButtonListenerBtnKey4 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_4);
      }
   }
   
   class ButtonListenerBtnKey5 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_5);
      }
   }
   
   class ButtonListenerBtnKey6 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_6);
      }
   }
   
   class ButtonListenerBtnKey7 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_7);
      }
   }
   
   class ButtonListenerBtnKey8 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_8);
      }
   }
   
   class ButtonListenerBtnKey9 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_9);
      }
   }
   
   class ButtonListenerBtnKeySign implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_OPERATOR_SIGN);
      }
   }
   
   class ButtonListenerBtnKeyPeriod implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_DIGIT_PERIOD);
      }
   }
   
   class ButtonListenerBtnKeyPlus implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_OPERATOR_PLUS);
      }
   }
   
   class ButtonListenerBtnKeySub implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_OPERATOR_SUB);
      }
   }
   
   class ButtonListenerBtnKeyMul implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_OPERATOR_MUL);
      }
   }
   
   class ButtonListenerBtnKeyDiv implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_OPERATOR_DIV);
      }
   }
   
   class ButtonListenerBtnKeyResult implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_OPERATOR_RESULT);
      }
   }
   
   class ButtonListenerBtnKeyC implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_CLEAR_C);
      }
   }
   
   class ButtonListenerBtnKeyCE implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_CLEAR_CE);
      }
   }
   
   class ButtonListenerBtnKeyMC implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_MEMORY_MC);
      }
   }
   
   class ButtonListenerBtnKeyMR implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_MEMORY_MR);
      }
   }
   
   class ButtonListenerBtnKeyMS implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_MEMORY_MS);
      }
   }
   
   class ButtonListenerBtnKeyMA implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.ioc_inputNumber(MYCALC_IK_MEMORY_MA);
      }
   }
   
   class ButtonListenerBtnMemIndi implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
      }
   }

   // define a listener class to handle window events
   class MyCalcGUIFrameListener implements WindowListener
   {
      public void windowClosing(WindowEvent e)
      {
         System.out.println("MyListener::windowClosing");
         System.exit(0);
      }
      
      public void windowClosed(WindowEvent e)
      {
      }
      
      public void windowOpened(WindowEvent e)
      {
      }
      
      public void windowIconified(WindowEvent e)
      {
      }
      
      public void windowDeiconified(WindowEvent e)
      {
      }
      
      public void windowActivated(WindowEvent e)
      {
      }
    
      public void windowDeactivated(WindowEvent e)
      {
      }
   }
   // end of listener class

}


class Trace implements MyCalcConstants
{
   public static void output(String info)
   {
      System.out.println(info);
   }

   public static String translateMyCalcContants(int ik)
   {
      switch(ik)
      {
         case MYCALC_IK_NULL: return "";
         //case MYCALC_IK_DIGIT_BEGIN: return "";
         case MYCALC_IK_DIGIT_0: return "MYCALC_IK_DIGIT_0";
         case MYCALC_IK_DIGIT_1: return "MYCALC_IK_DIGIT_1";
         case MYCALC_IK_DIGIT_2: return "MYCALC_IK_DIGIT_2";
         case MYCALC_IK_DIGIT_3: return "MYCALC_IK_DIGIT_3";
         case MYCALC_IK_DIGIT_4: return "MYCALC_IK_DIGIT_4";
         case MYCALC_IK_DIGIT_5: return "MYCALC_IK_DIGIT_5";
         case MYCALC_IK_DIGIT_6: return "MYCALC_IK_DIGIT_6";
         case MYCALC_IK_DIGIT_7: return "MYCALC_IK_DIGIT_7";
         case MYCALC_IK_DIGIT_8: return "MYCALC_IK_DIGIT_8";
         case MYCALC_IK_DIGIT_9: return "MYCALC_IK_DIGIT_9";
         case MYCALC_IK_DIGIT_PERIOD: return "MYCALC_IK_DIGIT_PERIOD";
         //case MYCALC_IK_DIGIT_END: return "MYCALC_IK_DIGIT_END";

         //case MYCALC_IK_OPERATOR_BEGIN: return "MYCALC_IK_OPERATOR_BEGIN";
         case MYCALC_IK_OPERATOR_SIGN: return "MYCALC_IK_OPERATOR_SIGN";
         case MYCALC_IK_OPERATOR_PLUS: return "MYCALC_IK_OPERATOR_PLUS";
         case MYCALC_IK_OPERATOR_SUB: return "MYCALC_IK_OPERATOR_SUB";
         case MYCALC_IK_OPERATOR_MUL: return "MYCALC_IK_OPERATOR_MUL";
         case MYCALC_IK_OPERATOR_DIV: return "MYCALC_IK_OPERATOR_DIV";
         case MYCALC_IK_OPERATOR_RESULT: return "MYCALC_IK_OPERATOR_RESULT";
         //case MYCALC_IK_OPERATOR_END: return "MYCALC_IK_OPERATOR_END";

         //case MYCALC_IK_CLEAR_BEGIN: return "MYCALC_IK_CLEAR_BEGIN";
         case MYCALC_IK_CLEAR_C: return "MYCALC_IK_CLEAR_C";
         case MYCALC_IK_CLEAR_CE: return "MYCALC_IK_CLEAR_CE";
         //case MYCALC_IK_CLEAR_END: return "MYCALC_IK_CLEAR_END";

         //case MYCALC_IK_MEMORY_BEGIN: return "MYCALC_IK_MEMORY_BEGIN";
         case MYCALC_IK_MEMORY_MC: return "MYCALC_IK_MEMORY_MC";
         case MYCALC_IK_MEMORY_MR: return "MYCALC_IK_MEMORY_MR";
         case MYCALC_IK_MEMORY_MS: return "MYCALC_IK_MEMORY_MS";
         case MYCALC_IK_MEMORY_MA: return "MYCALC_IK_MEMORY_MA";
         //case MYCALC_IK_MEMORY_END: return "MYCALC_IK_MEMORY_END";

         // internal key type
         //case MYCALC_IKTYPE_BEGIN: return "MYCALC_IKTYPE_BEGIN";
         case MYCALC_IKTYPE_DIGIT: return "MYCALC_IKTYPE_DIGIT";
         case MYCALC_IKTYPE_OPERATOR: return "MYCALC_IKTYPE_OPERATOR";
         case MYCALC_IKTYPE_CLEAR: return "MYCALC_IKTYPE_CLEAR";
         case MYCALC_IKTYPE_MEMORY: return "MYCALC_IKTYPE_MEMORY";
         case MYCALC_IKTYPE_UNKNOWN: return "MYCALC_IKTYPE_UNKNOWN";
         //case MYCALC_IKTYPE_END: return "MYCALC_IKTYPE_END";

         // calculate state
         //case MYCALC_STATE_BEGIN: return "MYCALC_STATE_BEGIN";
         case MYCALC_STATE_READY: return "MYCALC_STATE_READY";
         case MYCALC_STATE_FIRST: return "MYCALC_STATE_FIRST";
         case MYCALC_STATE_OPERATOR: return "MYCALC_STATE_OPERATOR";
         case MYCALC_STATE_SECOND: return "MYCALC_STATE_SECOND";
         //case MYCALC_STATE_END: return "MYCALC_STATE_END";
         default: return "unkown contant";
      }
  }
}

