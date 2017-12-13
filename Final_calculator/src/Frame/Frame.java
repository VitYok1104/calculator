package Frame;

import static java.awt.PageAttributes.MediaType.A;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Frame extends javax.swing.JFrame {
    
    double num, numN , num3 ,N ,num2 , ans;
    int calculation ,nu;

    String crf ,key,str;

    static boolean isDelim(char c) {
		return c == ' ';
    }
    static boolean isOperator(char c) {
	return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '√'||
                c == '%' || c == 's' || c =='c' && c =='t' || c=='!' || c=='l'
                || c =='S' || c =='C' || c=='T' || c=='L';
	}
	static int priority(char op) {
		switch (op) {
			
                    case '+':
			case '-':
				return 1;
			case '*':
			case '/':
     
				return 2;
                                 case '√':
 
                                 return 3;
                        case '!':
                        case 'l':
                        case 's':
                        case 'c':
                        case 't':
                        case '^':    
                        case 'S':
                        case 'C':
                        case 'T':
                        case 'L':
                            return 4;
			default:
				return -1;
		}
	}
       
  
	static void processOperator(LinkedList<Double> st, char op) {
        
	      
                
 
         double l;
         double t;
		switch (op) {
			case '+':
                            	 l = st.removeLast();
                t = st.removeLast();
  
			        st.add(t + l);
                             //   st.add(-t + l);
                            //  st.add(t + -l);
                              // st.add(-t + -l);
				break;
			case '-':
                            	 l = st.removeLast();
                t = st.removeLast();
                          
				st.add(t - l);
				break;
			case '*':
                            	 l = st.removeLast();
                t = st.removeLast();
				st.add(t * l);
				break;
			case '/':
                            	 l = st.removeLast();
                t = st.removeLast();
				st.add(t / l);
				break;
                                case '%':
                                    	 l = st.removeLast();
                t = st.removeLast();
				st.add(t % l);
				break;
			case '^':
                            	 l = st.removeLast();
                t = st.removeLast();
				st.add(Math.pow(t ,l));
				break;
                        case '!':
                            double ret = 1.0;
                        
                            l = ' ';
                t = st.removeLast();
        for (int i = 1; i <= t; ++i) ret *= i;
        st.add(ret);  
       // jLabel1.setText(Double.toString(t));
        break;
   case '√':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.sqrt(Double.valueOf(t)));  
				break;
                                case 's':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.sin(Double.valueOf(t)));  
				break;
                                  case 'c':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.cos(Double.valueOf(t)));  
				break;
                                  case 't':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.tan(Double.valueOf(t)));  
				break;
		
                               case 'l':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.log(Double.valueOf(t)));  
				break;
                                      case 'S':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.asin(Double.valueOf(t)));  
				break;
                                      case 'C':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.acos(Double.valueOf(t)));  
				break;
                                         case 'T':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.atan(Double.valueOf(t)));  
				break;
                                         case 'L':
                           	 l = ' ';
                t = st.removeLast();
                           st.add(Math.log10(Double.valueOf(t)));  
				break;
                }
		}
	
        
	public static Double eval(StringBuilder s, Double indexOf) {
		LinkedList<Double> st = new LinkedList<Double>();
		LinkedList<Character> op = new LinkedList<Character>();
                                                   String operand = "";
                                                   char y;   
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
                       y = ' ';
         if (i !=s.length()-1){
              i++;
              y =s.charAt(i);
                        i--;
         }
                                          	String t = String.valueOf(c);
				   Pattern p = Pattern.compile("^[0-9]*[.,]?+$");
			        Matcher m = p.matcher(t);        
			if (isDelim(c))
				continue;
			if (c == '(')
				op.add('(');
			else if (c == ')') {
				while (op.getLast() != '(')
					processOperator(st, op.removeLast());
				op.removeLast();
			} else if (isOperator(c)) {
				while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
					processOperator(st, op.removeLast());
				op.add(c);
                        
			}
                    /*    else if (i == s.length()-1  ){
                              operand += s.charAt(i++);
                             System.out.println(operand);
                         st.add(Double.parseDouble(operand));
                        }*/
                        else {
				while (i < s.length() && m.find() )
					operand += s.charAt(i++);
				--i;
                               
                         if (y == '+' || y == '-' || y == '*' || y == '/'  || y == '^' || y == '(' || y == ')'){
                          System.out.println(s.charAt(i));
                          st.add(Double.parseDouble(operand));
                          operand="";
                          }
                         else if ( i == s.length()-1 ){
      
                                   st.add(Double.parseDouble(operand));
                                  }
                          }
                }
		while (!op.isEmpty())
			processOperator(st, op.removeLast());
		return st.get(0);
	}
    public Frame() {
        initComponents();
        jMenuItem_ON.setEnabled(false);        
    }

        public int livesum(){
            
                Scanner s = new Scanner(jTextField1.getText());
            
        String b = s.next();
double x;
        do{
           
            StringBuilder a = new StringBuilder(b);
            Double mn =eval(a,Double.valueOf(a.indexOf(""+'(')));
           String formattedDouble = String.format("%.1f", mn);
           x = mn;
   
         
           if (x % 1 == 0)
           {
            jLabel1.setText(""+eval(a,Double.valueOf(a.indexOf(""+'('))) ) ;
           }
         
           
           else {
            jLabel1.setText(formattedDouble);
           }
        
            }
            while ( (b = s.next()) != "null");
           
         return 0;
       }

    public int mathematic()
    {
        switch (calculation)
        {      
            case 6:
                num = Double.parseDouble(jTextField1.getText());
                ans = 1 / num;
                jLabel1.setText(Double.toString(ans)); 
                
                break;
                
            case 8:
                ans =num * -1;
                jLabel1.setText(Double.toString(ans));
                break;
                
            case 9:
              /*  ans = Math.sin(num);
                jLabel1.setText(Double.toString(ans));
                break;*/
                
            case 10:
                ans = Math.cos(num);
                jLabel1.setText(Double.toString(ans));
                break;
                
            case 11:
                ans = Math.tan(num);
                jLabel1.setText(Double.toString(ans));
                break;
                
            case 12:
                ans = Math.sinh(num);
                jLabel1.setText(Double.toString(ans));
                break;
                
            case 13:
                ans = Math.cosh(num);
                jLabel1.setText(Double.toString(ans));
                break; 
                
            case 14:
                ans = Math.tanh(num);
                jLabel1.setText(Double.toString(ans));
                break;
                
            case 15:
                ans = Math.log(num);
                jLabel1.setText(Double.toString(ans));
                break;
                
            case 16:
                ans = Math.exp(num);
                jLabel1.setText(Double.toString(ans));
                break;
                 case 17:
                ans = Math.round(num);
                jLabel1.setText(Double.toString(ans));
                break;
         case 18:
             jLabel1.setText(Integer.toString(Integer.parseInt(jTextField1.getText()),2));

                break;
        
             case 19:
                   jLabel1.setText(Integer.toString(Integer.parseInt(jTextField1.getText()),16));
 
                break;
                  case 20:
                        ans = Math.ceil(num);
                jLabel1.setText(Double.toString(ans));
 
 
                break;
                  case 21:
                   jLabel1.setText(Integer.toString(Integer.parseInt(jTextField1.getText()),8));
 
                break; 
                 case 22:
              
 
      /*   double ret = 1.0;
        for (int i = 1; i <= num; ++i) ret *= i;
        jLabel1.setText(Double.toString(ret));
        break;*/
            case 23:
                ans = Math.log10(num);
                jLabel1.setText(Double.toString(ans));
                break;
        }
                return 0;

    }
public void vkl()
    {
        jTextField1.setEnabled(true);
        jMenu_infa.setEnabled(true);
       
        
        jMenuItem_ON.setEnabled(false);
        jMenuItem_OFF.setEnabled(true);
        
        jButton_clean.setEnabled(true);
        jButton_C.setEnabled(true);
        jButton_1.setEnabled(true);
        jButton_plus.setEnabled(true);
        jButton_2.setEnabled(true);
        jButton_3.setEnabled(true);
        jButton_minus.setEnabled(true);
        jButton_4.setEnabled(true);
        jButton_5.setEnabled(true);
        jButton_6.setEnabled(true);
        jButton_multiplication.setEnabled(true);
        jButton_7.setEnabled(true);
        jButton_8.setEnabled(true);
        jButton_9.setEnabled(true);
        jButton_division.setEnabled(true);
        jButton_0.setEnabled(true);
        jButton_point.setEnabled(true);
        jButton_sum.setEnabled(true);
        jButton_power.setEnabled(true);
        jButton_korin.setEnabled(true);
        jButton_reverse.setEnabled(true);
        jButton_1x.setEnabled(true);
        jButton_P.setEnabled(true);
        jButton_P1.setEnabled(true);
        jButton_P2.setEnabled(true);
        jButton_E.setEnabled(true);
        jButton_E1.setEnabled(true);
        jButton_E2.setEnabled(true);
        jButton_sinh.setEnabled(true);
        jButton_cos.setEnabled(true);
        jButton_sin.setEnabled(true);
        jButton_cosh.setEnabled(true);
        jButton_tan.setEnabled(true);
        jButton_tanh.setEnabled(true);
        jButton_log.setEnabled(true);
        jButton_log1.setEnabled(true);
        jButton_log2.setEnabled(true);
        jButton_log3.setEnabled(true);
        jButton_log4.setEnabled(true);
        jButton_log5.setEnabled(true);
    }
    
    public void vykl()
    {
        jTextField1.setEnabled(false);
        jMenu_infa.setEnabled(false);
  
        
        jMenuItem_OFF.setEnabled(false);
        jMenuItem_ON.setEnabled(true);
        
        jButton_clean.setEnabled(false);
        jButton_C.setEnabled(false);
        jButton_1.setEnabled(false);
        jButton_plus.setEnabled(false);
        jButton_2.setEnabled(false);
        jButton_3.setEnabled(false);
        jButton_minus.setEnabled(false);
        jButton_4.setEnabled(false);
        jButton_5.setEnabled(false);
        jButton_6.setEnabled(false);
        jButton_multiplication.setEnabled(false);
        jButton_7.setEnabled(false);
        jButton_8.setEnabled(false);
        jButton_9.setEnabled(false);
        jButton_division.setEnabled(false);
        jButton_0.setEnabled(false);
        jButton_point.setEnabled(false);
        jButton_sum.setEnabled(false);
        jButton_power.setEnabled(false);
        jButton_korin.setEnabled(false);
        jButton_reverse.setEnabled(false);
        jButton_1x.setEnabled(false);
        jButton_P.setEnabled(false);
        jButton_P1.setEnabled(false);
        jButton_P2.setEnabled(false);
        jButton_E.setEnabled(false);
        jButton_E1.setEnabled(false);
        jButton_E2.setEnabled(false);
        jButton_sinh.setEnabled(false);
        jButton_cos.setEnabled(false);
        jButton_sin.setEnabled(false);
        jButton_cosh.setEnabled(false);
        jButton_tan.setEnabled(false);
        jButton_tanh.setEnabled(false);
        jButton_log.setEnabled(false);
        jButton_log1.setEnabled(false);
        jButton_log2.setEnabled(false);
        jButton_log3.setEnabled(false);
        jButton_log4.setEnabled(false);
        jButton_log5.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton_clean = new javax.swing.JButton();
        jButton_C = new javax.swing.JButton();
        jButton_1 = new javax.swing.JButton();
        jButton_plus = new javax.swing.JButton();
        jButton_2 = new javax.swing.JButton();
        jButton_3 = new javax.swing.JButton();
        jButton_minus = new javax.swing.JButton();
        jButton_4 = new javax.swing.JButton();
        jButton_5 = new javax.swing.JButton();
        jButton_6 = new javax.swing.JButton();
        jButton_multiplication = new javax.swing.JButton();
        jButton_7 = new javax.swing.JButton();
        jButton_8 = new javax.swing.JButton();
        jButton_9 = new javax.swing.JButton();
        jButton_division = new javax.swing.JButton();
        jButton_0 = new javax.swing.JButton();
        jButton_point = new javax.swing.JButton();
        jButton_sum = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton_power = new javax.swing.JButton();
        jButton_korin = new javax.swing.JButton();
        jButton_reverse = new javax.swing.JButton();
        jButton_1x = new javax.swing.JButton();
        jButton_P = new javax.swing.JButton();
        jButton_cos = new javax.swing.JButton();
        jButton_sinh = new javax.swing.JButton();
        jButton_log = new javax.swing.JButton();
        jButton_tan = new javax.swing.JButton();
        jButton_tanh = new javax.swing.JButton();
        jButton_sin = new javax.swing.JButton();
        jButton_cosh = new javax.swing.JButton();
        jButton_E = new javax.swing.JButton();
        jButton_log1 = new javax.swing.JButton();
        jButton_log2 = new javax.swing.JButton();
        jButton_log3 = new javax.swing.JButton();
        jButton_P1 = new javax.swing.JButton();
        jButton_E1 = new javax.swing.JButton();
        jButton_log4 = new javax.swing.JButton();
        jButton_P2 = new javax.swing.JButton();
        jButton_E2 = new javax.swing.JButton();
        jButton_log5 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Kalculator = new javax.swing.JMenu();
        jMenuItem_ON = new javax.swing.JMenuItem();
        jMenuItem_OFF = new javax.swing.JMenuItem();
        jMenuItem_close = new javax.swing.JMenuItem();
        jMenu_infa = new javax.swing.JMenu();
        jMenuItem_info = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusable(false);
        setLocation(new java.awt.Point(500, 250));
        setPreferredSize(new java.awt.Dimension(585, 330));
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 3, 23)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setMaximumSize(new java.awt.Dimension(488, 45));
        jTextField1.setMinimumSize(new java.awt.Dimension(221, 45));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton_clean.setFont(new java.awt.Font("Thames", 1, 18)); // NOI18N
        jButton_clean.setText("del");
        jButton_clean.setMaximumSize(new java.awt.Dimension(33, 33));
        jButton_clean.setMinimumSize(new java.awt.Dimension(16, 16));
        jButton_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cleanActionPerformed(evt);
            }
        });

        jButton_C.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_C.setText("C");
        jButton_C.setToolTipText("Ctrl+BackSpace");
        jButton_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CActionPerformed(evt);
            }
        });

        jButton_1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_1.setText("1");
        jButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1ActionPerformed(evt);
            }
        });

        jButton_plus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_plus.setText("+");
        jButton_plus.setToolTipText("");
        jButton_plus.setRequestFocusEnabled(false);
        jButton_plus.setRolloverEnabled(false);
        jButton_plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_plusActionPerformed(evt);
            }
        });
        jButton_plus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton_plusKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton_plusKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton_plusKeyTyped(evt);
            }
        });

        jButton_2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_2.setText("2");
        jButton_2.setToolTipText("");
        jButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_2ActionPerformed(evt);
            }
        });

        jButton_3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_3.setText("3");
        jButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_3ActionPerformed(evt);
            }
        });

        jButton_minus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_minus.setText("-");
        jButton_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_minusActionPerformed(evt);
            }
        });

        jButton_4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_4.setText("4");
        jButton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_4ActionPerformed(evt);
            }
        });

        jButton_5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_5.setText("5");
        jButton_5.setToolTipText("");
        jButton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_5ActionPerformed(evt);
            }
        });

        jButton_6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_6.setText("6");
        jButton_6.setToolTipText("");
        jButton_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_6ActionPerformed(evt);
            }
        });

        jButton_multiplication.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_multiplication.setText("*");
        jButton_multiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_multiplicationActionPerformed(evt);
            }
        });

        jButton_7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_7.setText("7");
        jButton_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_7ActionPerformed(evt);
            }
        });

        jButton_8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_8.setText("8");
        jButton_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_8ActionPerformed(evt);
            }
        });

        jButton_9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_9.setText("9");
        jButton_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_9ActionPerformed(evt);
            }
        });

        jButton_division.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_division.setText("/");
        jButton_division.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_divisionActionPerformed(evt);
            }
        });

        jButton_0.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_0.setText("0");
        jButton_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_0ActionPerformed(evt);
            }
        });

        jButton_point.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_point.setText(".");
        jButton_point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_pointActionPerformed(evt);
            }
        });

        jButton_sum.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_sum.setText("=");
        jButton_sum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sumActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("0");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jButton_power.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_power.setText("^");
        jButton_power.setToolTipText("Shift+Q");
        jButton_power.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_powerActionPerformed(evt);
            }
        });

        jButton_korin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_korin.setText("√");
        jButton_korin.setToolTipText("Shift+K");
        jButton_korin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_korinActionPerformed(evt);
            }
        });

        jButton_reverse.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_reverse.setText("±");
        jButton_reverse.setToolTipText("Shift+F");
        jButton_reverse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reverseActionPerformed(evt);
            }
        });

        jButton_1x.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton_1x.setText("1/x");
        jButton_1x.setToolTipText("Shift+D");
        jButton_1x.setAlignmentY(0.0F);
        jButton_1x.setMaximumSize(new java.awt.Dimension(49, 33));
        jButton_1x.setMinimumSize(new java.awt.Dimension(49, 33));
        jButton_1x.setPreferredSize(new java.awt.Dimension(49, 33));
        jButton_1x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1xActionPerformed(evt);
            }
        });

        jButton_P.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_P.setText("П");
        jButton_P.setToolTipText("Shiftl+P");
        jButton_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PActionPerformed(evt);
            }
        });

        jButton_cos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_cos.setText("cos");
        jButton_cos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cosActionPerformed(evt);
            }
        });

        jButton_sinh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_sinh.setText("sinh");
        jButton_sinh.setMaximumSize(new java.awt.Dimension(60, 23));
        jButton_sinh.setMinimumSize(new java.awt.Dimension(60, 23));
        jButton_sinh.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_sinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sinhActionPerformed(evt);
            }
        });

        jButton_log.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log.setText("log");
        jButton_log.setToolTipText("Натуральний логорифм");
        jButton_log.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logActionPerformed(evt);
            }
        });

        jButton_tan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_tan.setText("tan");
        jButton_tan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tanActionPerformed(evt);
            }
        });

        jButton_tanh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_tanh.setText("tanh");
        jButton_tanh.setPreferredSize(new java.awt.Dimension(60, 23));
        jButton_tanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tanhActionPerformed(evt);
            }
        });

        jButton_sin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_sin.setText("sin");
        jButton_sin.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sinActionPerformed(evt);
            }
        });

        jButton_cosh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_cosh.setText("cosh");
        jButton_cosh.setMaximumSize(new java.awt.Dimension(60, 23));
        jButton_cosh.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_cosh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_coshActionPerformed(evt);
            }
        });

        jButton_E.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_E.setText("e");
        jButton_E.setToolTipText("Ctrl+E");
        jButton_E.setMaximumSize(new java.awt.Dimension(49, 33));
        jButton_E.setMinimumSize(new java.awt.Dimension(49, 33));
        jButton_E.setPreferredSize(new java.awt.Dimension(49, 33));
        jButton_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EActionPerformed(evt);
            }
        });

        jButton_log1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log1.setText("(");
        jButton_log1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log1ActionPerformed(evt);
            }
        });

        jButton_log2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log2.setText(")");
        jButton_log2.setMinimumSize(new java.awt.Dimension(37, 27));
        jButton_log2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log2ActionPerformed(evt);
            }
        });

        jButton_log3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log3.setText("round");
        jButton_log3.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log3ActionPerformed(evt);
            }
        });

        jButton_P1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_P1.setText("hex");
        jButton_P1.setToolTipText("Шістнадцяткова СЧ");
        jButton_P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_P1ActionPerformed(evt);
            }
        });

        jButton_E1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_E1.setText("bin");
        jButton_E1.setToolTipText("Двійкова СЧ");
        jButton_E1.setMaximumSize(new java.awt.Dimension(49, 33));
        jButton_E1.setMinimumSize(new java.awt.Dimension(49, 33));
        jButton_E1.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_E1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_E1ActionPerformed(evt);
            }
        });

        jButton_log4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log4.setText("log10");
        jButton_log4.setToolTipText("Десятковий логорифм");
        jButton_log4.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log4ActionPerformed(evt);
            }
        });

        jButton_P2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_P2.setText("octal");
        jButton_P2.setToolTipText("Вісімкова СЧ");
        jButton_P2.setMaximumSize(new java.awt.Dimension(53, 23));
        jButton_P2.setMinimumSize(new java.awt.Dimension(53, 23));
        jButton_P2.setPreferredSize(new java.awt.Dimension(53, 23));
        jButton_P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_P2ActionPerformed(evt);
            }
        });

        jButton_E2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_E2.setText("PRC");
        jButton_E2.setToolTipText("Точність суми");
        jButton_E2.setMaximumSize(new java.awt.Dimension(53, 33));
        jButton_E2.setMinimumSize(new java.awt.Dimension(53, 33));
        jButton_E2.setPreferredSize(new java.awt.Dimension(53, 33));
        jButton_E2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_E2ActionPerformed(evt);
            }
        });

        jButton_log5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log5.setText("!n");
        jButton_log5.setToolTipText("Факторіал");
        jButton_log5.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log5ActionPerformed(evt);
            }
        });

        jMenu_Kalculator.setText("Калькулятор");

        jMenuItem_ON.setText("Вкл");
        jMenuItem_ON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ONActionPerformed(evt);
            }
        });
        jMenu_Kalculator.add(jMenuItem_ON);

        jMenuItem_OFF.setText("Викл");
        jMenuItem_OFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_OFFActionPerformed(evt);
            }
        });
        jMenu_Kalculator.add(jMenuItem_OFF);

        jMenuItem_close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem_close.setText("Закрити");
        jMenuItem_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_closeActionPerformed(evt);
            }
        });
        jMenu_Kalculator.add(jMenuItem_close);

        jMenuBar1.add(jMenu_Kalculator);

        jMenu_infa.setText("Інфо");

        jMenuItem_info.setText("Про програму");
        jMenuItem_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_infoActionPerformed(evt);
            }
        });
        jMenu_infa.add(jMenuItem_info);

        jMenuBar1.add(jMenu_infa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(241, 241, 241))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_0, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_point, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton_log2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton_log1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_clean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton_C, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton_3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton_6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton_9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton_plus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton_minus, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton_division, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton_log3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jButton_cos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton_multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton_sin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(115, 115, 115)
                                        .addComponent(jButton_log5, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_E1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton_sinh, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jButton_cosh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_sum, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_tan, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_tanh, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_P2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jButton_power, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_log4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_E, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_reverse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_P, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_korin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_E2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(jButton_1x, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_P1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(225, 225, 225))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton_E, jButton_P, jButton_sinh});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_plus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_minus))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton_C, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton_3))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton_clean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_2)
                                        .addComponent(jButton_1)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton_log1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(jButton_log2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_P1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_P2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_log5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_E1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_log4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton_E2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_log, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_log3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton_P, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_sinh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_sin, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_E, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_division)
                                    .addComponent(jButton_9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jButton_8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jButton_7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_sum)
                            .addComponent(jButton_point)
                            .addComponent(jButton_0))
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_cos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_cosh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton_power)
                                .addComponent(jButton_korin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_1x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_reverse, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_tanh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_tan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_7, jButton_8, jButton_9, jButton_division});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_4, jButton_5, jButton_6, jButton_multiplication});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_E, jLabel1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {                                     
        
        char non =evt.getKeyChar();
        if((Character.isDigit(non) || non == KeyEvent.VK_K || non == KeyEvent.VK_F 
                || non == KeyEvent.VK_P || non == KeyEvent.VK_E || non == KeyEvent.VK_D
                || non == KeyEvent.VK_Q || evt.getKeyCode()==81  ) ){
           evt.consume();
        }
    }  
    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
//this.setResizable(true);
      
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER ){
 Scanner s = new Scanner(jTextField1.getText());
        String b = s.next();
double x;
        do{
           
            StringBuilder a = new StringBuilder(b);
            Double mn =eval(a,Double.valueOf(a.indexOf(""+'(')));
           String formattedDouble = String.format("%.1f", mn);
           x = mn;
          
           if (x % 1 == 0)
           {
            jTextField1.setText(""+eval(a,Double.valueOf(a.indexOf(""+'('))) ) ;
            jLabel1.setText("");
           }
         
           
           else{
            jTextField1.setText(formattedDouble);
                 jLabel1.setText("");
           }
        
        
            }
            while ( (b = s.next()) != "null");
           
            }
    
            else if(c ==KeyEvent.VK_DELETE ){
        jTextField1.setText("");   
            
        }   
            else if(evt.getKeyCode()==112 && (evt.isControlDown() ) ){                     
        jTextField1.setText(jTextField1.getText() + Math.PI);
        
        }

                                    
            else if(evt.getKeyCode()==101 && (evt.isControlDown() ) ){
        jTextField1.setText(jTextField1.getText() + Math.exp(1));
        
        }
            else if(evt.getKeyCode()==80 && (evt.isShiftDown() ) ){                     
        jTextField1.setText(jTextField1.getText() + Math.PI);
        
        }
            else if(evt.getKeyCode()==75 && (evt.isShiftDown() ) ){
jTextField1.setText(jTextField1.getText() + "√");

                  livesum();
        }
                   else if(evt.getKeyCode()==81 && (evt.isShiftDown() ) ){
jTextField1.setText(jTextField1.getText() + "^");

                  livesum();
        }
           
                  else if(evt.getKeyCode()==69 && (evt.isShiftDown() ) ){
        num = Double.parseDouble(jTextField1.getText());

                  }
                          else if(evt.getKeyCode()==68 && (evt.isShiftDown() ) ){
                               num = Double.parseDouble(jTextField1.getText());
                                   
        calculation = 6;
       jLabel1.setText("-" + ans);
 livesum();
                          }
                                    else if(evt.getKeyCode()==70 && (evt.isShiftDown() ) ){
                                          num = Double.parseDouble(jTextField1.getText());
        calculation = 8;
        jLabel1.setText("-" + num);
        jTextField1.setText("");
                       livesum();
                                    }    
                 else if(evt.getKeyCode()==101 && (evt.isShiftDown() ) ){
        num = Double.parseDouble(jTextField1.getText()+Math.E);
jTextField1.setText(jTextField1.getText() + Math.exp(1));

            }
                 
                 else  if(c ==KeyEvent.VK_1 ){     
    jTextField1.setText(jTextField1.getText() + "1");
       livesum();
        }
          else if(c ==KeyEvent.VK_2 ){     
    jTextField1.setText(jTextField1.getText() + "2");
       livesum();
        }
            else if(c ==KeyEvent.VK_3 ){     
    jTextField1.setText(jTextField1.getText() + "3");
       livesum();
        }
                 else if(c ==KeyEvent.VK_4 ){     
    jTextField1.setText(jTextField1.getText() + "4");
       livesum();
        }
                      else if(c ==KeyEvent.VK_5 ){     
    jTextField1.setText(jTextField1.getText() + "5");
       livesum();
        }
                           else if(c ==KeyEvent.VK_6 ){     
    jTextField1.setText(jTextField1.getText() + "6");
       livesum();
        }
    
            else if(c ==KeyEvent.VK_7 ){ 

    jTextField1.setText(jTextField1.getText() + "7");
        livesum();
        }
                else if(c ==KeyEvent.VK_8 ){     
    jTextField1.setText(jTextField1.getText() + "8");
       livesum();
        }
                     else if(c ==KeyEvent.VK_9 ){     
    jTextField1.setText(jTextField1.getText() + "9");
       livesum();
        }
                     else if(c ==KeyEvent.VK_0 ){     
    jTextField1.setText(jTextField1.getText() + "0");
       livesum();
                     }
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased
/*
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

    }//GEN-LAST:event_jTextField1KeyTyped
*/
    private void jButton_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cleanActionPerformed
        int length = jTextField1.getText().length();
        int number = jTextField1.getText().length() - 1;
        String store;

        if(length > 0)
        {
            StringBuilder back = new StringBuilder(jTextField1.getText());
            back.deleteCharAt(number);
            store = back.toString();
            jTextField1.setText(store);
        }
    }//GEN-LAST:event_jButton_cleanActionPerformed

    private void jButton_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CActionPerformed
        jTextField1.setText("");
        jLabel1.setText("");
    }//GEN-LAST:event_jButton_CActionPerformed

    private void jButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1ActionPerformed
        jTextField1.setText(jTextField1.getText() + "1");
               livesum();
    }//GEN-LAST:event_jButton_1ActionPerformed

    private void jButton_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_plusActionPerformed
        jTextField1.setText(jTextField1.getText() + "+");
                       livesum();
    }//GEN-LAST:event_jButton_plusActionPerformed

    private void jButton_plusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_plusKeyPressed

    }//GEN-LAST:event_jButton_plusKeyPressed

    private void jButton_plusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_plusKeyReleased

    }//GEN-LAST:event_jButton_plusKeyReleased

    private void jButton_plusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_plusKeyTyped

    }//GEN-LAST:event_jButton_plusKeyTyped

    private void jButton_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_2ActionPerformed

        jTextField1.setText(jTextField1.getText() + "2");
               livesum();
    }//GEN-LAST:event_jButton_2ActionPerformed

    private void jButton_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_3ActionPerformed
       
        jTextField1.setText(jTextField1.getText() + "3");
                livesum();
    }//GEN-LAST:event_jButton_3ActionPerformed

    private void jButton_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_minusActionPerformed
        jTextField1.setText(jTextField1.getText() + "-");
                       livesum();
    }//GEN-LAST:event_jButton_minusActionPerformed

    private void jButton_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_4ActionPerformed
       jTextField1.setText(jTextField1.getText() + "4");
               livesum();
    }//GEN-LAST:event_jButton_4ActionPerformed

    private void jButton_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_5ActionPerformed
        
        jTextField1.setText(jTextField1.getText() + "5");
               livesum();
    }//GEN-LAST:event_jButton_5ActionPerformed

    private void jButton_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_6ActionPerformed
          
        jTextField1.setText(jTextField1.getText() + "6");
               livesum();
    }//GEN-LAST:event_jButton_6ActionPerformed

    private void jButton_multiplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_multiplicationActionPerformed
    jTextField1.setText(jTextField1.getText() + "*");
                       livesum();
    }//GEN-LAST:event_jButton_multiplicationActionPerformed

    private void jButton_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_7ActionPerformed
      
        jTextField1.setText(jTextField1.getText() + "7");
               livesum();
    }//GEN-LAST:event_jButton_7ActionPerformed
      
    private void jButton_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_8ActionPerformed
  
       jTextField1.setText(jTextField1.getText() + "8");
               livesum();
  
    }//GEN-LAST:event_jButton_8ActionPerformed

    private void jButton_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_9ActionPerformed
        
        jTextField1.setText(jTextField1.getText() + "9");
       livesum();
        
    }//GEN-LAST:event_jButton_9ActionPerformed

    private void jButton_divisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_divisionActionPerformed
jTextField1.setText(jTextField1.getText() + "/");
               livesum();
    }//GEN-LAST:event_jButton_divisionActionPerformed

    private void jButton_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_0ActionPerformed
             jTextField1.setText(jTextField1.getText() + "0");
               livesum();
    }//GEN-LAST:event_jButton_0ActionPerformed

    private void jButton_pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_pointActionPerformed
        jTextField1.setText(jTextField1.getText() + ".");
    }//GEN-LAST:event_jButton_pointActionPerformed
@SuppressWarnings("empty-statement")
    private void jButton_sumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sumActionPerformed
                Scanner s = new Scanner(jTextField1.getText());
        String b = s.next();
double x;
        do{
           
            StringBuilder a = new StringBuilder(b);
            Double mn =eval(a,Double.valueOf(a.indexOf(""+'(')));
           String formattedDouble = String.format("%.1f", mn);
           x = mn;
          
           if (x % 1 == 0)
           {
            jTextField1.setText(""+eval(a,Double.valueOf(a.indexOf(""+'('))) ) ;
            jLabel1.setText("");
           }
         
           
           else{
            jTextField1.setText(formattedDouble);
                 jLabel1.setText("");
           }
        
        
            }
            while ( (b = s.next()) != "null");
           
         //return 0;
       
      
    }//GEN-LAST:event_jButton_sumActionPerformed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
        //      jLabel1.setSize(416, 23);
    }//GEN-LAST:event_jLabel1AncestorAdded

    private void jButton_powerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_powerActionPerformed

        jTextField1.setText(jTextField1.getText() + "^");
               livesum();
    }//GEN-LAST:event_jButton_powerActionPerformed

    private void jButton_korinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_korinActionPerformed
jTextField1.setText(jTextField1.getText() + "√");
                  livesum();
    }//GEN-LAST:event_jButton_korinActionPerformed

    private void jButton_reverseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reverseActionPerformed
   num = Double.parseDouble(jTextField1.getText());
        calculation = 8;
           mathematic();
    }//GEN-LAST:event_jButton_reverseActionPerformed

    private void jButton_1xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1xActionPerformed
  num = Double.parseDouble(jTextField1.getText());
        calculation = 6;
       // jLabel1.setText("1/ " + num);
     mathematic();
    }//GEN-LAST:event_jButton_1xActionPerformed

    private void jButton_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PActionPerformed
        jTextField1.setText(jTextField1.getText() + Math.PI);
    }//GEN-LAST:event_jButton_PActionPerformed

    private void jButton_cosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cosActionPerformed
  jTextField1.setText(jTextField1.getText() + "c");
                 livesum();
    }//GEN-LAST:event_jButton_cosActionPerformed

    private void jButton_sinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sinhActionPerformed
 jTextField1.setText(jTextField1.getText() + "S");
                livesum();
    }//GEN-LAST:event_jButton_sinhActionPerformed

    private void jButton_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logActionPerformed
  jTextField1.setText(jTextField1.getText() + "l");
                    livesum();
    }//GEN-LAST:event_jButton_logActionPerformed

    private void jButton_tanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tanActionPerformed
 jTextField1.setText(jTextField1.getText() + "t");
                     livesum();
    }//GEN-LAST:event_jButton_tanActionPerformed

    private void jButton_tanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tanhActionPerformed
 jTextField1.setText(jTextField1.getText() + "T");
                   livesum();
    }//GEN-LAST:event_jButton_tanhActionPerformed

    private void jButton_sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sinActionPerformed
 jTextField1.setText(jTextField1.getText() + "s");
               livesum();
    }//GEN-LAST:event_jButton_sinActionPerformed

    private void jButton_coshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_coshActionPerformed
 jTextField1.setText(jTextField1.getText() + "C");
               livesum();
    }//GEN-LAST:event_jButton_coshActionPerformed

    private void jButton_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EActionPerformed
        jTextField1.setText(jTextField1.getText() + Math.exp(1));
    }//GEN-LAST:event_jButton_EActionPerformed

    private void jButton_log1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_log1ActionPerformed
        jTextField1.setText(jTextField1.getText() + "(");
    }//GEN-LAST:event_jButton_log1ActionPerformed

    private void jButton_log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_log2ActionPerformed
        jTextField1.setText(jTextField1.getText() + ")");
    }//GEN-LAST:event_jButton_log2ActionPerformed

    private void jButton_log3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_log3ActionPerformed
      
 num = Double.parseDouble(jTextField1.getText());
        calculation = 17;

             mathematic();
    }//GEN-LAST:event_jButton_log3ActionPerformed

    private void jButton_P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_P1ActionPerformed
               
     num = Double.parseDouble(jTextField1.getText());
        calculation = 19;
        jLabel1.setText("" + num); // hex
         mathematic();
    }//GEN-LAST:event_jButton_P1ActionPerformed

    private void jButton_E1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_E1ActionPerformed

        num = Double.parseDouble(jTextField1.getText());
 
        calculation = 18;
        jLabel1.setText("" + num);  // bin
          mathematic();
        
    }//GEN-LAST:event_jButton_E1ActionPerformed

    private void jButton_log4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_log4ActionPerformed
  jTextField1.setText(jTextField1.getText() + "L");
                        livesum();
    }//GEN-LAST:event_jButton_log4ActionPerformed

    private void jButton_P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_P2ActionPerformed
                  
        num = Double.parseDouble(jTextField1.getText());
 
        calculation = 21;          //octal
        jLabel1.setText("" + num);
          mathematic();
        
   
    }//GEN-LAST:event_jButton_P2ActionPerformed

    private void jButton_E2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_E2ActionPerformed
   Scanner s = new Scanner(jTextField1.getText());
       
        String b = s.next();
double x;
        do{
           
            StringBuilder a = new StringBuilder(b);
 
            jLabel1.setText(""+eval(a,Double.valueOf(a.indexOf(""+'('))) ) ;
     
            }
            while ( (b = s.next()) != "null");
           
     //    return 0;
                 
    }//GEN-LAST:event_jButton_E2ActionPerformed

    private void jButton_log5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_log5ActionPerformed
        jTextField1.setText(jTextField1.getText() + "!");
                       livesum();
    }//GEN-LAST:event_jButton_log5ActionPerformed

    private void jMenuItem_ONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ONActionPerformed
        vkl();
    }//GEN-LAST:event_jMenuItem_ONActionPerformed

    private void jMenuItem_OFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_OFFActionPerformed
        vykl();
    }//GEN-LAST:event_jMenuItem_OFFActionPerformed

    private void jMenuItem_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_closeActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jMenuItem_closeActionPerformed

    private void jMenuItem_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_infoActionPerformed
        //new Inf().setVisible(true);
    }//GEN-LAST:event_jMenuItem_infoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
   
    }//GEN-LAST:event_formWindowClosed
   
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       this.setResizable(false);
       this.setSize(540, 400);
       // jTextField1.setSize(230,45);
     //   jLabel1.setSize(230,22);
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_0;
    private javax.swing.JButton jButton_1;
    private javax.swing.JButton jButton_1x;
    private javax.swing.JButton jButton_2;
    private javax.swing.JButton jButton_3;
    private javax.swing.JButton jButton_4;
    private javax.swing.JButton jButton_5;
    private javax.swing.JButton jButton_6;
    private javax.swing.JButton jButton_7;
    private javax.swing.JButton jButton_8;
    private javax.swing.JButton jButton_9;
    private javax.swing.JButton jButton_C;
    private javax.swing.JButton jButton_E;
    private javax.swing.JButton jButton_E1;
    private javax.swing.JButton jButton_E2;
    private javax.swing.JButton jButton_P;
    private javax.swing.JButton jButton_P1;
    private javax.swing.JButton jButton_P2;
    private javax.swing.JButton jButton_clean;
    private javax.swing.JButton jButton_cos;
    private javax.swing.JButton jButton_cosh;
    private javax.swing.JButton jButton_division;
    private javax.swing.JButton jButton_korin;
    private javax.swing.JButton jButton_log;
    private javax.swing.JButton jButton_log1;
    private javax.swing.JButton jButton_log2;
    private javax.swing.JButton jButton_log3;
    private javax.swing.JButton jButton_log4;
    private javax.swing.JButton jButton_log5;
    private javax.swing.JButton jButton_minus;
    private javax.swing.JButton jButton_multiplication;
    private javax.swing.JButton jButton_plus;
    private javax.swing.JButton jButton_point;
    private javax.swing.JButton jButton_power;
    private javax.swing.JButton jButton_reverse;
    private javax.swing.JButton jButton_sin;
    private javax.swing.JButton jButton_sinh;
    private javax.swing.JButton jButton_sum;
    private javax.swing.JButton jButton_tan;
    private javax.swing.JButton jButton_tanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_OFF;
    private javax.swing.JMenuItem jMenuItem_ON;
    private javax.swing.JMenuItem jMenuItem_close;
    private javax.swing.JMenuItem jMenuItem_info;
    private javax.swing.JMenu jMenu_Kalculator;
    private javax.swing.JMenu jMenu_infa;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
