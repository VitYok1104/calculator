/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package calculator;
 
 
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

public class Calculator extends javax.swing.JFrame {

    /**
     * Creates new form calc
     */
    
    double num, numN , num3 ,N ,num2 , ans;
    int calculation;

    String crf ,key, a, b;	

	public static String calc(String a, String b, String operator){

				switch (operator) {

		case "+": return Double.valueOf(a) + Double.valueOf(b)+"";
		case "~": return Double.valueOf(a) - Double.valueOf(b)+"";
			case "*": return Double.valueOf(a) * Double.valueOf(b)+"";

			case "/": return Double.valueOf(a) / Double.valueOf(b)+"";
                        case "&": return Math.pow(Double.valueOf(a) , Double.valueOf(b))+"";
                        
                        
				   case "√": return Math.sqrt(Double.valueOf(a)) + "";
                                   
				}
				
				return null;

			}
			
		//щоб відрізнити  знак "-" від оператора "-", заміняю оператор на тильду.
		
		public static String minustotild(String s){

		String result = ""+s.charAt(0);
				
		for (int i = 1; i < s.length(); i++){

				if ((s.charAt(i) == '-') &&  ("^+-&*(/~".indexOf(s.charAt(i-1)) == -1))   // якщо попередній  символ не є оператором то міняєм на тильду..

					result += ""+'~';
            
					else result +=""+s.charAt(i);

        

				}

		return result;

			}

		public static String operate(String expression){


				String num[];
                                int index = -1;  
		Character priorityOperator='/';  // default
		String operators;
	while (!((  operators = expression.replaceAll("[^*&+/~]","")  ).isEmpty()))     // поки є оператори
					{	
						
	if ( (index = operators.indexOf('/')) == -1){        //вибираєм пріорітетний оператор  
					priorityOperator = '*';
                                        if ( (index = operators.indexOf('&')) == -1){        //вибираєм пріорітетний оператор  
				//priorityOperator=operators.charAt();
							index = operators.indexOf(priorityOperator);
                        }
			if 	( (index = operators.indexOf('*')) == -1){
						priorityOperator=operators.charAt(0);
							index = operators.indexOf(priorityOperator);
                        }
                                                     
						}
				num = expression.split("[^0-9\\-.]"); // сплітаєм всі числа
						
						// заміняємо рядкове представлення арифметики на рядковий результат за допомогою калк(). 
					expression=expression.replaceFirst(num[index]+"\\"+priorityOperator+num[index+1], calc(num[index],num[index+1],""+priorityOperator)); 

					}

			return expression;

			}


	public static String operateBracket(StringBuilder s, int startIndex ){
				// ''
				// 3+4+(4+(3+3)+5)+(4+)
			if (startIndex == -1) {        //  якщо дужок не має 
				return (operate(s.toString()));
			}
		else {   
			int k = 1;
                        
				for (int i=startIndex+1; i < s.length(); i++){

				if (s.charAt(i) == '(')  
						k++;
					else if ((s.charAt(i) == ')')) 
			               
                                        
                                        {
				if (k == 1) {    // знайшли кінець першої дужки  )
                                      //  CloseBracket=i;
                                       String newBracket = s.substring(startIndex+1, i);
   
       /*         String subString=new String();
                newBracket=s.substring(startIndex+1, i);
               s.delete(startIndex+1, i+1);
             //   StringBuilder mainString=new StringBuilder(s);
            operate(newBracket);  // )
             //  mainString.insert(startIndex+1,s.toString());
           //  s.delete(0, s.length());
              // s.insert(0, mainString.toString());
            //   operate(s.toString());
            */
    s=s.replace(startIndex,i+1,operateBracket(new StringBuilder(newBracket), newBracket.indexOf(""+'(')));										
						}                           
                              
					k--;
						}

					}
					}

				return operate(s.toString());

			}
         
    
        
    public Calculator() {
        initComponents();
      
        jMenuItem_ON.setEnabled(false);

        
    }
  public void mathematic()
    {
        switch (calculation)
        {
          /*  case 1:
                num = Double.parseDouble(jTextField1.getText());
                ans = num + Double.parseDouble(jTextField1.getText());
                jTextField1.setText(Double.toString(ans));
                num =0;
                break;
                
            case 2:
                  numN = Double.parseDouble(jTextField1.getText());
                ans = num - Double.parseDouble(jTextField1.getText());
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 3:
                  num = Double.parseDouble(jTextField1.getText());
                ans = num * Double.parseDouble(jTextField1.getText());
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 4: 
                  num = Double.parseDouble(jTextField1.getText());
                ans = num / Double.parseDouble(jTextField1.getText());
                jTextField1.setText(Double.toString(ans));
                break;
        
            case 5:
                  num = Double.parseDouble(jTextField1.getText());
                ans = Math.pow(num,Double.parseDouble(jTextField1.getText()));
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 6:
                ans = 1 / num;
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 7:
                ans = Math.sqrt(num);
                //  numN = Double.parseDouble(jTextField1.getText());
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 8:
                ans =num * -1;
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 9:
                ans = Math.sin(num);
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 10:
                ans = Math.cos(num);
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 11:
                ans = Math.tan(num);
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 12:
                ans = Math.sinh(num);
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 13:
                ans = Math.cosh(num);
                jTextField1.setText(Double.toString(ans));
                break; 
                
            case 14:
                ans = Math.tanh(num);
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 15:
                ans = Math.log(num);
                jTextField1.setText(Double.toString(ans));
                break;
                
            case 16:
                ans = Math.exp(num);
                jTextField1.setText(Double.toString(ans));
                break;
        */
        }
        
    }

    public void vkl()
    {
        jTextField1.setEnabled(true);
        jMenu_infa.setEnabled(true);
        jMenu_view.setEnabled(true);
        
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
        jMenu_view.setEnabled(false);
        
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        buttonGroup2 = new javax.swing.ButtonGroup();
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
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTextField2 = new javax.swing.JTextField();
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
        jMenu_view = new javax.swing.JMenu();
        jMenuItem_standart = new javax.swing.JMenuItem();
        jMenuItem_sientific = new javax.swing.JMenuItem();
        jMenu_infa = new javax.swing.JMenu();
        jMenuItem_info = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Калькулятор");
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
        getContentPane().setLayout(null);

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
        getContentPane().add(jTextField1);
        jTextField1.setBounds(10, 11, 220, 45);

        jButton_clean.setFont(new java.awt.Font("Thames", 1, 18)); // NOI18N
        jButton_clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator/c.png"))); // NOI18N
        jButton_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cleanActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_clean);
        jButton_clean.setBounds(67, 90, 51, 56);

        jButton_C.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_C.setText("C");
        jButton_C.setToolTipText("Ctrl+BackSpace");
        jButton_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_C);
        jButton_C.setBounds(124, 90, 51, 56);

        jButton_1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_1.setText("1");
        jButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_1);
        jButton_1.setBounds(10, 152, 51, 33);

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
        getContentPane().add(jButton_plus);
        jButton_plus.setBounds(181, 90, 51, 56);

        jButton_2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_2.setText("2");
        jButton_2.setToolTipText("");
        jButton_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_2);
        jButton_2.setBounds(67, 152, 51, 33);

        jButton_3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_3.setText("3");
        jButton_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_3);
        jButton_3.setBounds(124, 152, 51, 33);

        jButton_minus.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_minus.setText("-");
        jButton_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_minusActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_minus);
        jButton_minus.setBounds(181, 152, 51, 33);

        jButton_4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_4.setText("4");
        jButton_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_4);
        jButton_4.setBounds(10, 191, 51, 33);

        jButton_5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_5.setText("5");
        jButton_5.setToolTipText("");
        jButton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_5);
        jButton_5.setBounds(67, 191, 51, 33);

        jButton_6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_6.setText("6");
        jButton_6.setToolTipText("");
        jButton_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_6);
        jButton_6.setBounds(124, 191, 51, 33);

        jButton_multiplication.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_multiplication.setText("*");
        jButton_multiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_multiplicationActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_multiplication);
        jButton_multiplication.setBounds(181, 191, 51, 33);

        jButton_7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_7.setText("7");
        jButton_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_7);
        jButton_7.setBounds(10, 230, 51, 33);

        jButton_8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_8.setText("8");
        jButton_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_8);
        jButton_8.setBounds(67, 230, 51, 33);

        jButton_9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_9.setText("9");
        jButton_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_9);
        jButton_9.setBounds(124, 230, 51, 33);

        jButton_division.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_division.setText("/");
        jButton_division.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_divisionActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_division);
        jButton_division.setBounds(181, 230, 51, 33);

        jButton_0.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_0.setText("0");
        jButton_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_0ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_0);
        jButton_0.setBounds(10, 269, 51, 33);

        jButton_point.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_point.setText(".");
        jButton_point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_pointActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_point);
        jButton_point.setBounds(67, 269, 51, 33);

        jButton_sum.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_sum.setText("=");
        jButton_sum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sumActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_sum);
        jButton_sum.setBounds(124, 269, 109, 33);

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
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 62, 220, 22);

        jButton_power.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_power.setText("^");
        jButton_power.setToolTipText("Shift+S");
        jButton_power.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_powerActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_power);
        jButton_power.setBounds(376, 222, 55, 37);

        jButton_korin.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_korin.setText("√");
        jButton_korin.setToolTipText("Shift+K");
        jButton_korin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_korinActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_korin);
        jButton_korin.setBounds(437, 222, 61, 37);

        jButton_reverse.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_reverse.setText("±");
        jButton_reverse.setToolTipText("Shift+F");
        jButton_reverse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reverseActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_reverse);
        jButton_reverse.setBounds(376, 265, 55, 37);

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
        getContentPane().add(jButton_1x);
        jButton_1x.setBounds(437, 265, 61, 37);

        jButton_P.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton_P.setText("П");
        jButton_P.setToolTipText("Ctrl+P");
        jButton_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_P);
        jButton_P.setBounds(437, 179, 61, 37);

        jButton_cos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_cos.setText("cos");
        jButton_cos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cosActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_cos);
        jButton_cos.setBounds(239, 222, 65, 37);

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
        getContentPane().add(jButton_sinh);
        jButton_sinh.setBounds(310, 179, 60, 37);

        jButton_log.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log.setText("log");
        jButton_log.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_log);
        jButton_log.setBounds(310, 131, 60, 42);

        jButton_tan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_tan.setText("tan");
        jButton_tan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tanActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_tan);
        jButton_tan.setBounds(239, 265, 65, 37);

        jButton_tanh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_tanh.setText("tanh");
        jButton_tanh.setPreferredSize(new java.awt.Dimension(60, 23));
        jButton_tanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tanhActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_tanh);
        jButton_tanh.setBounds(310, 265, 60, 37);

        jButton_sin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_sin.setText("sin");
        jButton_sin.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sinActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_sin);
        jButton_sin.setBounds(239, 179, 65, 37);

        jButton_cosh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_cosh.setText("cosh");
        jButton_cosh.setMaximumSize(new java.awt.Dimension(60, 23));
        jButton_cosh.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_cosh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_coshActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_cosh);
        jButton_cosh.setBounds(310, 222, 60, 37);

        jInternalFrame1.setVisible(true);

        jTextField2.setEditable(false);
        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2)
                .addContainerGap())
        );

        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(0, 0, 0, 0);

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
        getContentPane().add(jButton_E);
        jButton_E.setBounds(376, 179, 55, 37);

        jButton_log1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log1.setText("(");
        jButton_log1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_log1);
        jButton_log1.setBounds(10, 90, 51, 27);

        jButton_log2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log2.setText(")");
        jButton_log2.setMinimumSize(new java.awt.Dimension(37, 27));
        jButton_log2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_log2);
        jButton_log2.setBounds(10, 123, 51, 23);

        jButton_log3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log3.setText("round");
        jButton_log3.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_log3);
        jButton_log3.setBounds(239, 131, 65, 42);

        jButton_P1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_P1.setText("hex");
        jButton_P1.setToolTipText("");
        jButton_P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_P1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_P1);
        jButton_P1.setBounds(437, 131, 61, 42);

        jButton_E1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_E1.setText("bin");
        jButton_E1.setToolTipText("");
        jButton_E1.setMaximumSize(new java.awt.Dimension(49, 33));
        jButton_E1.setMinimumSize(new java.awt.Dimension(49, 33));
        jButton_E1.setPreferredSize(new java.awt.Dimension(49, 33));
        jButton_E1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_E1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_E1);
        jButton_E1.setBounds(376, 131, 55, 42);

        jButton_log4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator/b.png"))); // NOI18N
        jButton_log4.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_log4);
        jButton_log4.setBounds(310, 90, 60, 35);

        jButton_P2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_P2.setText("octal");
        jButton_P2.setToolTipText("");
        jButton_P2.setMaximumSize(new java.awt.Dimension(53, 23));
        jButton_P2.setMinimumSize(new java.awt.Dimension(53, 23));
        jButton_P2.setPreferredSize(new java.awt.Dimension(53, 23));
        jButton_P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_P2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_P2);
        jButton_P2.setBounds(437, 90, 61, 35);

        jButton_E2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_E2.setText("dec");
        jButton_E2.setToolTipText("");
        jButton_E2.setMaximumSize(new java.awt.Dimension(53, 33));
        jButton_E2.setMinimumSize(new java.awt.Dimension(53, 33));
        jButton_E2.setPreferredSize(new java.awt.Dimension(53, 33));
        jButton_E2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_E2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_E2);
        jButton_E2.setBounds(376, 90, 55, 35);

        jButton_log5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_log5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator/a.png"))); // NOI18N
        jButton_log5.setPreferredSize(new java.awt.Dimension(51, 23));
        jButton_log5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_log5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_log5);
        jButton_log5.setBounds(239, 90, 65, 35);

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

        jMenu_view.setText("Вид");

        jMenuItem_standart.setText("Стандартний");
        jMenuItem_standart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_standartActionPerformed(evt);
            }
        });
        jMenu_view.add(jMenuItem_standart);

        jMenuItem_sientific.setText("Розширений");
        jMenuItem_sientific.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_sientificActionPerformed(evt);
            }
        });
        jMenu_view.add(jMenuItem_sientific);

        jMenuBar1.add(jMenu_view);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_2ActionPerformed
        jTextField1.setText(jTextField1.getText() + "2");
    }//GEN-LAST:event_jButton_2ActionPerformed

    private void jButton_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_9ActionPerformed
        jTextField1.setText(jTextField1.getText() + "9");
    }//GEN-LAST:event_jButton_9ActionPerformed

    private void jButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1ActionPerformed
        jTextField1.setText(jTextField1.getText() + "1");
    }//GEN-LAST:event_jButton_1ActionPerformed

    private void jButton_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_3ActionPerformed
        jTextField1.setText(jTextField1.getText() + "3");
    }//GEN-LAST:event_jButton_3ActionPerformed

    private void jButton_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_4ActionPerformed
        jTextField1.setText(jTextField1.getText() + "4");
    }//GEN-LAST:event_jButton_4ActionPerformed

    private void jButton_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_5ActionPerformed
        jTextField1.setText(jTextField1.getText() + "5");
    }//GEN-LAST:event_jButton_5ActionPerformed

    private void jButton_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_6ActionPerformed
        jTextField1.setText(jTextField1.getText() + "6");
    }//GEN-LAST:event_jButton_6ActionPerformed

    private void jButton_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_7ActionPerformed
        jTextField1.setText(jTextField1.getText() + "7");
    }//GEN-LAST:event_jButton_7ActionPerformed

    private void jButton_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_8ActionPerformed
        jTextField1.setText(jTextField1.getText() + "8");
        
    }//GEN-LAST:event_jButton_8ActionPerformed

    private void jButton_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_0ActionPerformed
        jTextField1.setText(jTextField1.getText() + "0");
    }//GEN-LAST:event_jButton_0ActionPerformed

    private void jButton_pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_pointActionPerformed
        jTextField1.setText(jTextField1.getText() + ".");
    }//GEN-LAST:event_jButton_pointActionPerformed

    private void jButton_divisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_divisionActionPerformed
        crf = "/";
        jTextField1.setText(jTextField1.getText() + crf);
    }//GEN-LAST:event_jButton_divisionActionPerformed

    private void jButton_multiplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_multiplicationActionPerformed
        crf = "*";
        jTextField1.setText(jTextField1.getText() + crf);
    }//GEN-LAST:event_jButton_multiplicationActionPerformed

    private void jButton_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_minusActionPerformed
        crf = "-";
        jTextField1.setText(jTextField1.getText() + crf);
    }//GEN-LAST:event_jButton_minusActionPerformed
    
    private void jButton_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_plusActionPerformed
        crf = "+";
        jTextField1.setText(jTextField1.getText() + crf);
    }//GEN-LAST:event_jButton_plusActionPerformed

    private void jButton_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CActionPerformed
        jTextField1.setText("");
        jLabel1.setText("");
    }//GEN-LAST:event_jButton_CActionPerformed

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

    @SuppressWarnings("empty-statement")
    private void jButton_sumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sumActionPerformed
        Scanner s = new Scanner(jTextField1.getText() ); 
        String b = s.next(); 

        do{
  StringBuilder a = new StringBuilder(minustotild(b)); 
  jLabel1.setText(""+operateBracket(a,a.indexOf(""+'(')));
  
    }
        while ( (b = s.next()) != "null");
    }//GEN-LAST:event_jButton_sumActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        this.setResizable(true);
            Scanner s = new Scanner(jTextField1.getText() ); 
            String b = s.next(); 

        do { 

            StringBuilder a = new StringBuilder(minustotild(b)); 
            System.out.println(" result = "+operateBracket(a,a.indexOf(""+'('))); 

            } 
    while ( (b = s.next()) != "null");   //   jTextField1.setSize(416, 39);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton_powerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_powerActionPerformed
      crf = "^";
        jTextField1.setText(jTextField1.getText() + crf);
       
 
    }//GEN-LAST:event_jButton_powerActionPerformed

    private void jButton_korinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_korinActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 7;
        jLabel1.setText("√" + num);
        crf ="√";
        jTextField1.setText("");
    }//GEN-LAST:event_jButton_korinActionPerformed

    private void jButton_reverseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reverseActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 8;
        jLabel1.setText("-" + num);
        jTextField1.setText("");
    }//GEN-LAST:event_jButton_reverseActionPerformed

    private void jButton_1xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_1xActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 6;
        jLabel1.setText("1/" + num);
        jTextField1.setText("");
    }//GEN-LAST:event_jButton_1xActionPerformed

    private void jButton_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PActionPerformed
      jTextField1.setText(jTextField1.getText() + Math.PI);
    }//GEN-LAST:event_jButton_PActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.setResizable(true);
        this.setSize(255, 380);
        
    }//GEN-LAST:event_formWindowActivated

    private void jButton_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 15;
        jLabel1.setText("log" + num);
        jTextField1.setText("");
    }//GEN-LAST:event_jButton_logActionPerformed

    private void jButton_tanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tanActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 11;
        jLabel1.setText("tan" + num);
        jTextField1.setText("");            
    }//GEN-LAST:event_jButton_tanActionPerformed

    private void jButton_tanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tanhActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 14;
        jLabel1.setText("tanh" + num);
        jTextField1.setText("");    
    }//GEN-LAST:event_jButton_tanhActionPerformed

    private void jButton_sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sinActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 9;
        jLabel1.setText("sin" + num);
        jTextField1.setText("");      
    }//GEN-LAST:event_jButton_sinActionPerformed

    private void jButton_coshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_coshActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 13;
        jLabel1.setText("cosh" + num);
        jTextField1.setText("");     
    }//GEN-LAST:event_jButton_coshActionPerformed

    private void jButton_sinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sinhActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 12;
        jLabel1.setText("sinh" + num);
        jTextField1.setText("");     
    }//GEN-LAST:event_jButton_sinhActionPerformed

    private void jButton_cosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cosActionPerformed
        num = Double.parseDouble(jTextField1.getText());
        calculation = 10;
        jLabel1.setText("cos" + num);
        jTextField1.setText("");            
    }//GEN-LAST:event_jButton_cosActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
     char non =evt.getKeyChar();
    if(!(Character.isDigit(non)) && evt.getKeyCode()==48 && evt.getKeyCode()==57  )/* || (non ==KeyEvent.VK_BACK_SPACE)) ||
            (non == KeyEvent.VK_DELETE))*/{
        evt.consume();  
    }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
 //      jLabel1.setSize(416, 23);
    }//GEN-LAST:event_jLabel1AncestorAdded

    private void jButton_plusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_plusKeyPressed
   
    }//GEN-LAST:event_jButton_plusKeyPressed

    private void jButton_plusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_plusKeyReleased

    }//GEN-LAST:event_jButton_plusKeyReleased

    private void jButton_plusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_plusKeyTyped
    }//GEN-LAST:event_jButton_plusKeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
                                      
              char c = evt.getKeyChar();
               if (c == KeyEvent.VK_ENTER ){
                   
            Scanner s = new Scanner(jTextField1.getText() ); 
            String b = s.next(); 
    
    
            do{
        StringBuilder a = new StringBuilder(minustotild(b)); 
        jLabel1.setText(""+operateBracket(a,a.indexOf(""+'(')));
}
            while ( (b = s.next()) != "null");
} 
               
               
            else if(evt.getKeyCode()== 107){
                     
    
        jTextField1.setText(jTextField1.getText()); 
          
        }              
            else  if (c == KeyEvent.VK_MINUS){
        
        jTextField1.setText(jTextField1.getText());
         
        }
            else  if(evt.getKeyCode()==106){
     
        jTextField1.setText(jTextField1.getText());
         
        }
            else  if(c == KeyEvent.VK_SLASH){
       
        jTextField1.setText(jTextField1.getText());
         
        }
            else if(c ==KeyEvent.VK_DELETE ){
        jTextField1.setText("");   
            
        }   
            else if(evt.getKeyCode()==80 && (evt.isControlDown() ) ){                     
        jTextField1.setText(jTextField1.getText() + Math.PI);
        
        }

                                    
            else if(evt.getKeyCode()==101 && (evt.isControlDown() ) ){
        jTextField1.setText(jTextField1.getText() + Math.exp(1));
        
        }

            else if(c ==KeyEvent.VK_PERIOD){
        jTextField1.setText(jTextField1.getText()+".");
            
        }   

    
    }//GEN-LAST:event_jTextField1KeyPressed
 
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jMenuItem_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_infoActionPerformed
        new Inf().setVisible(true);
    }//GEN-LAST:event_jMenuItem_infoActionPerformed

    private void jMenuItem_standartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_standartActionPerformed
        this.setResizable(true);
        this.setSize(255, 380);
        jTextField1.setSize(220,45);
        jLabel1.setSize(220,22);
        
    }//GEN-LAST:event_jMenuItem_standartActionPerformed

    private void jMenuItem_sientificActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_sientificActionPerformed
        this.setResizable(true);
        this.setSize(523, 380);
        jTextField1.setSize(488,45);
        jLabel1.setSize(488,22);

    }//GEN-LAST:event_jMenuItem_sientificActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_closeActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jMenuItem_closeActionPerformed

    private void jMenuItem_ONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ONActionPerformed
        vkl();
    }//GEN-LAST:event_jMenuItem_ONActionPerformed

    private void jMenuItem_OFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_OFFActionPerformed
        vykl();
    }//GEN-LAST:event_jMenuItem_OFFActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_log3ActionPerformed

    private void jButton_P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_P1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_P1ActionPerformed

    private void jButton_E1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_E1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_E1ActionPerformed

    private void jButton_log4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_log4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_log4ActionPerformed

    private void jButton_P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_P2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_P2ActionPerformed

    private void jButton_E2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_E2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_E2ActionPerformed

    private void jButton_log5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_log5ActionPerformed

    }//GEN-LAST:event_jButton_log5ActionPerformed


        public static void main(String args[]) {
            

            /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html */
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
        
    }

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_OFF;
    private javax.swing.JMenuItem jMenuItem_ON;
    private javax.swing.JMenuItem jMenuItem_close;
    private javax.swing.JMenuItem jMenuItem_info;
    private javax.swing.JMenuItem jMenuItem_sientific;
    private javax.swing.JMenuItem jMenuItem_standart;
    private javax.swing.JMenu jMenu_Kalculator;
    private javax.swing.JMenu jMenu_infa;
    private javax.swing.JMenu jMenu_view;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
