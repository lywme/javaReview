import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCalc30
{
   public static void main(String[] args)
   {
      // TODO Auto-generated method stub
      MyCalcKernel kernel = new MyCalcKernel();
      MyCalcGUIFrame client = new MyCalcGUIFrame();

      // client.set_kernel(kernel);
      // kernel.start();
      // client.start();

      // kernel.set_output_client(client);
      client.setMyCalcObject(kernel);
   }
}

// MyCalc internal key constants
interface MyCalcInternalKey
{
   public static final int MYCALC_IK_NULL = 0x00000000;
   public static final int MYCALC_IK_DIGIT_0 = 0x00010100;
   public static final int MYCALC_IK_DIGIT_1 = 0x00010101;
   public static final int MYCALC_IK_DIGIT_2 = 0x00010102;
   public static final int MYCALC_IK_DIGIT_3 = 0x00010103;
   public static final int MYCALC_IK_DIGIT_4 = 0x00010104;
   public static final int MYCALC_IK_DIGIT_5 = 0x00010105;
   public static final int MYCALC_IK_DIGIT_6 = 0x00010106;
   public static final int MYCALC_IK_DIGIT_7 = 0x00010107;
   public static final int MYCALC_IK_DIGIT_8 = 0x00010108;
   public static final int MYCALC_IK_DIGIT_9 = 0x00010109;
   public static final int MYCALC_IK_DIGIT_A = 0x0001010A;
   public static final int MYCALC_IK_DIGIT_B = 0x0001010B;
   public static final int MYCALC_IK_DIGIT_C = 0x0001010C;
   public static final int MYCALC_IK_DIGIT_D = 0x0001010D;
   public static final int MYCALC_IK_DIGIT_E = 0x0001010E;
   public static final int MYCALC_IK_DIGIT_F = 0x0001010F;
   public static final int MYCALC_IK_DIGIT_PERIOD = 0x000101F1;
   public static final int MYCALC_IK_OPERATOR_SIGN = 0x00010201;
   public static final int MYCALC_IK_OPERATOR_PLUS = 0x00010202;
   public static final int MYCALC_IK_OPERATOR_SUBTRACT = 0x00010203;
   public static final int MYCALC_IK_OPERATOR_MULTIPLY = 0x00010204;
   public static final int MYCALC_IK_OPERATOR_DIVIDE = 0x00010205;
   public static final int MYCALC_IK_OPERATOR_RESULT = 0x00010206;
   public static final int MYCALC_IK_CLEAR_C = 0x00010301;
   public static final int MYCALC_IK_CLEAR_CE = 0x00010302;
   public static final int MYCALC_IK_MEMORY_MC = 0x00010401;
   public static final int MYCALC_IK_MEMORY_MR = 0x00010402;
   public static final int MYCALC_IK_MEMORY_MS = 0x00010403;
   public static final int MYCALC_IK_MEMORY_MA = 0x00010404;
}

// MyCalc input interface
interface MyCalcInputInterface
{
   public abstract int mycalc_if_input_key(int key);
}

// MyCalc output interface
interface MyCalcOutputInterface
{
   // output text
   public abstract int mycalc_if_output_text(String text);

   // output memory
   public abstract int mycalc_if_output_memory(String memory);
}

class MyCalcKernel
{
   MyCalcKernel()
   {
      init();
   }

   // ### Section: MCM - MyCalc Manager

   // kernel interface

   // input interface
   public int input_internal_key(int key)
   {
      Trace.output("[MyCalcKernel::input_internal_key] key=" + Trace.get_string_of_key(key));
      ioc_input_internal_key(key);
      Trace.output("[MyCalcKernel::input_internal_key] state=" + Trace.get_string_of_key(mycalc_state));
      Trace.output("[MyCalcKernel::input_internal_key] first_number=" + first_number);
      Trace.output("[MyCalcKernel::input_internal_key] second_number=" + second_number);
      Trace.output("[MyCalcKernel::input_internal_key] result_number=" + result_number);
      Trace.output("[MyCalcKernel::input_internal_key] current_oprator=" + Trace.get_string_of_key(current_operator));
      return 0;
   }

   // output interface
   public int set_output_client(MyCalcOutputInterface client)
   {
      output_client = client;
      return 0;
   }

   // function
   public void init()
   {
      Trace.output("[MyCalcKernel::init] state=" + Trace.get_string_of_key(mycalc_state));
      Trace.output("[MyCalcKernel::init] first_number=" + first_number);
      Trace.output("[MyCalcKernel::init] second_number=" + second_number);
      Trace.output("[MyCalcKernel::init] result_number=" + result_number);
      Trace.output("[MyCalcKernel::init] current_oprator=" + Trace.get_string_of_key(current_operator));
   }

   // ### Section: IKM - Internal Key Manager

   public static final int MYCALC_ERROR_UNRECOGNIZEDKEY = 0x00030101;
   public static final int MYCALC_ERROR_UNRECOGNIZEDSTATE = 0x00030102;

   private int ikm_input_internal_key(int key)
   {
      switch(key)
      {
      case MyCalcInternalKey.MYCALC_IK_DIGIT_0:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_1:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_2:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_3:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_4:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_5:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_6:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_7:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_8:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_9:
      case MyCalcInternalKey.MYCALC_IK_DIGIT_PERIOD:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_SIGN:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_RESULT:
      case MyCalcInternalKey.MYCALC_IK_CLEAR_C:
      case MyCalcInternalKey.MYCALC_IK_CLEAR_CE:
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MC:
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MR:
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MS:
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MA:
         cik_input_key(key);
         return 0;
      default:
         return 1;
      }
   }

   private static final String MYCALC_EXCEPTION_NUMBER_OVERFLOW = "ÊýÖµ³¬³ö·¶Î§";

   private int ikm_number_is_overflow()
   {
      ioc_show_message(MYCALC_EXCEPTION_NUMBER_OVERFLOW);
      return 0;
   }

   // number
   private int ikm_number_refreshed(String number)
   {
      ioc_show_number(number);
      return 0;
   }

   // message
   private int ikm_message_refreshed(String message)
   {
      ioc_show_message(message);
      return 0;
   }

   // ### Section: ClassifyInternalKey

   // state
   public static final int MYCALC_STATE_READY = 0x00020201;
   public static final int MYCALC_STATE_FIRST = 0x00020202;
   public static final int MYCALC_STATE_OPERATOR = 0x00020203;
   public static final int MYCALC_STATE_SECOND = 0x00020204;

   private int mycalc_state = MYCALC_STATE_READY;

   private int cik_input_key(int key)
   {
      switch(mycalc_state)
      {
      // source state
      case MYCALC_STATE_READY:
         switch(key)
         {
         // event
         case MyCalcInternalKey.MYCALC_IK_DIGIT_0:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_1:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_2:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_3:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_4:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_5:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_6:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_7:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_8:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_9:
            // behavior
            pik_first_number_set_by_key(key);
            // destination state
            mycalc_state = MYCALC_STATE_FIRST;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_DIGIT_PERIOD:
            pik_first_number_set_period();
            mycalc_state = MYCALC_STATE_FIRST;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SIGN:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
            pik_set_current_operator_by_key(key);
            pik_first_number_set_by_result_number();
            mycalc_state = MYCALC_STATE_OPERATOR;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_RESULT:
            pik_do_calculate_for_accumulation();
            return 0;

         case MyCalcInternalKey.MYCALC_IK_CLEAR_C:
            cik_number_clear_all();
            return 0;

         case MyCalcInternalKey.MYCALC_IK_CLEAR_CE:

         case MyCalcInternalKey.MYCALC_IK_MEMORY_MC:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MR:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MS:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MA:
            return 0;

         default:
            return MYCALC_ERROR_UNRECOGNIZEDKEY;
         }

      case MYCALC_STATE_FIRST:
         switch(key)
         {
         case MyCalcInternalKey.MYCALC_IK_DIGIT_0:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_1:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_2:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_3:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_4:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_5:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_6:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_7:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_8:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_9:
            pik_first_number_append_digit_by_key(key);
            // no state transition
            return 0;

         case MyCalcInternalKey.MYCALC_IK_DIGIT_PERIOD:
            pik_first_number_append_period();
            // no state transition
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SIGN:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
            pik_set_current_operator_by_key(key);
            mycalc_state = MYCALC_STATE_OPERATOR;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_RESULT:
            mycalc_state = MYCALC_STATE_READY;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_CLEAR_C:
            cik_number_clear_all();
            return 0;

         case MyCalcInternalKey.MYCALC_IK_CLEAR_CE:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MC:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MR:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MS:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MA:
            return 0;
         default:
            return 1;
         }

      case MYCALC_STATE_OPERATOR:
         switch(key)
         {
         case MyCalcInternalKey.MYCALC_IK_DIGIT_0:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_1:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_2:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_3:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_4:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_5:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_6:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_7:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_8:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_9:
            pik_second_number_set_by_key(key);
            mycalc_state = MYCALC_STATE_SECOND;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_DIGIT_PERIOD:
            pik_second_number_set_period();
            mycalc_state = MYCALC_STATE_SECOND;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SIGN:
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
            pik_set_current_operator_by_key(key);
            // no state transition
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_RESULT:
         case MyCalcInternalKey.MYCALC_IK_CLEAR_C:
            cik_number_clear_all();
            return 0;

         case MyCalcInternalKey.MYCALC_IK_CLEAR_CE:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MC:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MR:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MS:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MA:
            return 0;
         default:
            return 1;
         }

      case MYCALC_STATE_SECOND:
         switch(key)
         {
         case MyCalcInternalKey.MYCALC_IK_DIGIT_0:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_1:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_2:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_3:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_4:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_5:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_6:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_7:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_8:
         case MyCalcInternalKey.MYCALC_IK_DIGIT_9:
            pik_second_number_append_digit_by_key(key);
            // no state transition
            return 0;

         case MyCalcInternalKey.MYCALC_IK_DIGIT_PERIOD:
            pik_second_number_append_period();
            // no state transition
            return 0;

         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SIGN:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
         case MyCalcInternalKey.MYCALC_IK_OPERATOR_RESULT:
            pik_do_calculate_for_result();
            mycalc_state = MYCALC_STATE_READY;
            return 0;

         case MyCalcInternalKey.MYCALC_IK_CLEAR_C:
            cik_number_clear_all();
            return 0;

         case MyCalcInternalKey.MYCALC_IK_CLEAR_CE:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MC:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MR:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MS:
         case MyCalcInternalKey.MYCALC_IK_MEMORY_MA:
            return 0;
         default:
            return 1;
         }

      default:
      }
      return 0;
   }

   private int cik_number_clear_all()
   {
      mycalc_state = MYCALC_STATE_READY;
      pik_number_clear_all();
      return 0;
   }

   // ### Section: PIK - Process Internal Key

   // mycalc numbers
   private StringBuilder first_number = new StringBuilder();
   private StringBuilder second_number = new StringBuilder();
   private StringBuilder result_number = new StringBuilder();
   private int current_operator = MyCalcInternalKey.MYCALC_IK_NULL;

   public static final int MYCALC_ERROR_NOTDIGITKEY = 0x00030103;

   private int pik_number_clear_all()
   {
      first_number.setLength(0);
      second_number.setLength(0);
      result_number.setLength(0);
      current_operator = MyCalcInternalKey.MYCALC_IK_NULL;

      pik_number_refreshed(first_number);
      return 0;
   }

   // key to digit
   private int pik_digit_value_of_key(int key)
   {
      if(key >= MyCalcInternalKey.MYCALC_IK_DIGIT_0 && key <= MyCalcInternalKey.MYCALC_IK_DIGIT_9)
         return key - MyCalcInternalKey.MYCALC_IK_DIGIT_0;
      return -1;
   }

   // set number with digit by key
   private int pik_first_number_set_by_key(int key)
   {
      pik_number_set_by_key(first_number, key);
      pik_number_refreshed(first_number);
      return 0;
   }

   private int pik_second_number_set_by_key(int key)
   {
      pik_number_set_by_key(second_number, key);
      pik_number_refreshed(second_number);
      return 0;
   }

   // PIK - internal function
   private int pik_number_set_by_key(StringBuilder number, int key)
   {
      int digit = pik_digit_value_of_key(key);

      if(digit < 0 || digit > 9)
         return 1;

      number.setLength(0);
      number.append(digit);

      return 0;
   }

   private int pik_first_number_set_period()
   {
      first_number.setLength(0);
      first_number.append("0.");
      pik_number_refreshed(first_number);
      return 0;
   }

   private int pik_second_number_set_period()
   {
      second_number.setLength(0);
      second_number.append("0.");
      pik_number_refreshed(second_number);
      return 0;
   }

   private int pik_first_number_set_by_result_number()
   {
      if(result_number.equals(""))
         return 1;
      first_number.setLength(0);
      first_number.append(result_number);
      return 0;
   }

   private String pik_number_format(StringBuilder number)
   {
      // number is empty
      if(number.length() == 0)
         return "0.";

      // number contain no period
      if(number.indexOf(".") < 0)
         return number.toString() + ".";

      // erase tail zero
      int index = number.length() - 1;
      while(number.charAt(index) == '0')
         number.deleteCharAt(index--);

      
      // erase digits that after the 8th digit
      int length = MYCALC_NUMBER_MAXLENGTH;
      length = number.length();
      if(number.indexOf(".") > 0)
         length--;
      if(number.indexOf("-") > 0)
         length--;

      while(length > MYCALC_NUMBER_MAXLENGTH)
      {
         number.deleteCharAt(number.length() - 1);
         length = number.length();
         if(number.indexOf(".") > 0)
            length--;
         if(number.indexOf("-") > 0)
            length--;
      }

      return number.toString();
   }

   // output interface, send message to other component
   private int pik_number_refreshed(StringBuilder number)
   {
      String formated_number = pik_number_format(number);
      ikm_number_refreshed(formated_number);
      return 0;
   }

   // append digit by key to number
   private static final int MYCALC_NUMBER_MAXLENGTH = 8;

   private int pik_first_number_append_digit_by_key(int key)
   {
      pik_number_append_digit_by_key(first_number, key);
      pik_number_refreshed(first_number);
      //ikm_number_refreshed(first_number.toString());
      return 0;
   }

   private int pik_second_number_append_digit_by_key(int key)
   {
      pik_number_append_digit_by_key(second_number, key);
      pik_number_refreshed(second_number);
      return 0;
   }

   // PIK - internal function
   private int pik_number_append_digit_by_key(StringBuilder number, int key)
   {
      int digit = pik_digit_value_of_key(key);
      int length = MYCALC_NUMBER_MAXLENGTH;

      if(digit < 0 || digit > 9)
         return 1;

      length = number.length();
      if(number.indexOf(".") > 0)
         length--;
      if(number.indexOf("-") > 0)
         length--;

      if(length >= MYCALC_NUMBER_MAXLENGTH)
         return 2;

      if(number.toString().equals("0") && key == MyCalcInternalKey.MYCALC_IK_DIGIT_0)
         return 3;

      number.append(digit);
      return 0;
   }

   // append period to number
   private int pik_first_number_append_period()
   {
      pik_number_append_period(first_number);
      return 0;
   }

   private int pik_second_number_append_period()
   {
      pik_number_append_period(second_number);
      return 0;
   }

   private int pik_number_append_period(StringBuilder number)
   {
      if(number.indexOf(".") >= 0)
         return 1;

      number.append(".");
      return 0;
   }

   // set current operator by key
   private int pik_set_current_operator_by_key(int key)
   {
      switch(key)
      {
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
         current_operator = key;
         return 0;
      default:
      }

      return 1;
   }

   private int pik_do_calculate_for_result()
   {
      pik_do_calculate(first_number, second_number, result_number);
      return 0;
   }

   private int pik_do_calculate_for_accumulation()
   {
      pik_do_calculate(result_number, second_number, result_number);
      return 0;
   }

   // do calculate
   private int pik_do_calculate(StringBuilder first_number, StringBuilder second_number, StringBuilder result_number)
   {
      Double value = pik_number_to_double(first_number);
      if(value == null)
         return 1;
      double first_value = value.doubleValue();

      value = pik_number_to_double(second_number);
      if(value == null)
         return 1;
      double second_value = value.doubleValue();

      double result_value = 0.0;

      switch(current_operator)
      {
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
         result_value = first_value + second_value;
         break;
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
         result_value = first_value - second_value;
         break;
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
         result_value = first_value * second_value;
         break;
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
         result_value = first_value / second_value;
         break;
      default:
         return 1;
      }

      // result_number
      if(pik_number_is_overflow(result_value))
      {
         // ikm_send_message(MYCALC_NUMBER_OVERFLOW);
         ikm_number_is_overflow();
         return 2;
      }

      pik_number_set_by_double(result_number, result_value);
      pik_number_refreshed(result_number);

      return 0;
   }

   private boolean pik_number_is_overflow(double value)
   {
      if(Math.abs(value) > 1.0E8 - 1.0)
         return true;
      return false;
   }

   private boolean pik_number_is_null(StringBuilder number)
   {
      if(number == null)
         return true;

      if(number.length() == 0)
         return true;

      return false;
   }

   // when number can not be cast to Double, return null
   private Double pik_number_to_double(StringBuilder number)
   {
      if(pik_number_is_null(number))
         return null;

      Double value = Double.valueOf(number.toString());
      return value;
   }

   private int pik_number_set_by_double(StringBuilder number, double value)
   {
      // overflow?
      if(Math.abs(value) > 1.0E8 - 1.0)
         return 1;

      StringBuilder strbdr_format_number = new StringBuilder();
      strbdr_format_number.append(String.format("%.7f", value));
      String str_format_number = pik_number_format(strbdr_format_number);

      number.setLength(0);
      number.append(str_format_number);
      return 0;
   }

   // ### Section: IOC - Input Output Controller
   // data
   // client
   private MyCalcOutputInterface output_client = null;

   private int ioc_input_internal_key(int key)
   {
      ikm_input_internal_key(key);
      return 0;
   }

   private int ioc_show_number(String number)
   {
      if(output_client == null)
         return 1;
      output_client.mycalc_if_output_text(number);
      return 0;
   }

   private int ioc_show_message(String message)
   {
      if(output_client == null)
         return 1;
      output_client.mycalc_if_output_text(message);
      return 0;
   }

}

class MyCalcGUIFrame extends JFrame implements MyCalcOutputInterface
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

   public MyCalcKernel mycalcObject;

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

      GridLayout glKeypad = new GridLayout(4, 6);
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

   public void setMyCalcObject(MyCalcKernel kernel)
   {
      kernel.set_output_client(this);
      mycalcObject = kernel;
   }

   public int mycalc_if_output_text(String text)
   {
      outputBox.setText(text);
      return 0;
   }

   public int mycalc_if_output_memory(String memory)
   {
      return 0;
   }

   // button listener
   class ButtonListenerBtnKey0 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_0);
      }
   }

   class ButtonListenerBtnKey1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_1);
      }
   }

   class ButtonListenerBtnKey2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_2);
      }
   }

   class ButtonListenerBtnKey3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_3);
      }
   }

   class ButtonListenerBtnKey4 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_4);
      }
   }

   class ButtonListenerBtnKey5 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_5);
      }
   }

   class ButtonListenerBtnKey6 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_6);
      }
   }

   class ButtonListenerBtnKey7 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_7);
      }
   }

   class ButtonListenerBtnKey8 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_8);
      }
   }

   class ButtonListenerBtnKey9 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_9);
      }
   }

   class ButtonListenerBtnKeySign implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_OPERATOR_SIGN);
      }
   }

   class ButtonListenerBtnKeyPeriod implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_DIGIT_PERIOD);
      }
   }

   class ButtonListenerBtnKeyPlus implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS);
      }
   }

   class ButtonListenerBtnKeySub implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT);
      }
   }

   class ButtonListenerBtnKeyMul implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY);
      }
   }

   class ButtonListenerBtnKeyDiv implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE);
      }
   }

   class ButtonListenerBtnKeyResult implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_OPERATOR_RESULT);
      }
   }

   class ButtonListenerBtnKeyC implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_CLEAR_C);
      }
   }

   class ButtonListenerBtnKeyCE implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_CLEAR_CE);
      }
   }

   class ButtonListenerBtnKeyMC implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_MEMORY_MC);
      }
   }

   class ButtonListenerBtnKeyMR implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_MEMORY_MR);
      }
   }

   class ButtonListenerBtnKeyMS implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_MEMORY_MS);
      }
   }

   class ButtonListenerBtnKeyMA implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         mycalcObject.input_internal_key(MyCalcInternalKey.MYCALC_IK_MEMORY_MA);
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

class Trace
{
   public static void output(String info)
   {
      System.out.println(info);
   }

   public static String get_string_of_key(int ik)
   {
      switch(ik)
      {
      case MyCalcInternalKey.MYCALC_IK_NULL:
         return "MYCALC_IK_NULL";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_0:
         return "MYCALC_IK_DIGIT_0";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_1:
         return "MYCALC_IK_DIGIT_1";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_2:
         return "MYCALC_IK_DIGIT_2";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_3:
         return "MYCALC_IK_DIGIT_3";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_4:
         return "MYCALC_IK_DIGIT_4";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_5:
         return "MYCALC_IK_DIGIT_5";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_6:
         return "MYCALC_IK_DIGIT_6";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_7:
         return "MYCALC_IK_DIGIT_7";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_8:
         return "MYCALC_IK_DIGIT_8";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_9:
         return "MYCALC_IK_DIGIT_9";
      case MyCalcInternalKey.MYCALC_IK_DIGIT_PERIOD:
         return "MYCALC_IK_DIGIT_PERIOD";
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_SIGN:
         return "MYCALC_IK_OPERATOR_SIGN";
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_PLUS:
         return "MYCALC_IK_OPERATOR_PLUS";
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_SUBTRACT:
         return "MYCALC_IK_OPERATOR_SUBTRACT";
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_MULTIPLY:
         return "MYCALC_IK_OPERATOR_MULTIPLY";
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_DIVIDE:
         return "MYCALC_IK_OPERATOR_DIVIDE";
      case MyCalcInternalKey.MYCALC_IK_OPERATOR_RESULT:
         return "MYCALC_IK_OPERATOR_RESULT";
      case MyCalcInternalKey.MYCALC_IK_CLEAR_C:
         return "MYCALC_IK_CLEAR_C";
      case MyCalcInternalKey.MYCALC_IK_CLEAR_CE:
         return "MYCALC_IK_CLEAR_CE";
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MC:
         return "MYCALC_IK_MEMORY_MC";
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MR:
         return "MYCALC_IK_MEMORY_MR";
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MS:
         return "MYCALC_IK_MEMORY_MS";
      case MyCalcInternalKey.MYCALC_IK_MEMORY_MA:
         return "MYCALC_IK_MEMORY_MA";

         // mycalc state
      case MyCalcKernel.MYCALC_STATE_READY:
         return "MYCALC_STATE_READY";
      case MyCalcKernel.MYCALC_STATE_FIRST:
         return "MYCALC_STATE_FIRST";
      case MyCalcKernel.MYCALC_STATE_OPERATOR:
         return "MYCALC_STATE_OPERATOR";
      case MyCalcKernel.MYCALC_STATE_SECOND:
         return "MYCALC_STATE_SECOND"; // case MYCALC_STATE_END: return

      default:
         return "unkown contant";
      }
   }
}
