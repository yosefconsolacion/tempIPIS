// Numancia

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Orange
 */
import Bean.Patient;
import DAO.DAOImpl;
import DAO.DAOIntf;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringJoiner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    private CardLayout OptionsSwitch;

    private CardLayout MainUISwitch;

    private CardLayout OldPatientsUISwitch;

    private Color Enabled;

    private Color Disabled;

    private String timeStamp = "";

    private int id = 0;

    ListSelectionModel listSelectionModel;

    public MainUI() {
        initComponents();
        OptionsSwitch = new CardLayout();
        OptionsPanel.setLayout(OptionsSwitch);
        OptionsPanel.add("Today", Today);
        OptionsPanel.add("Patients", OptionsPatients);
        OptionsPanel.add("Census", OptionsCensus);

        MainUISwitch = new CardLayout();
        MainPanel.setLayout(MainUISwitch);
        MainPanel.add("Today", TodayUI);
        MainPanel.add("New Patient", NewPatientUI);
        MainPanel.add("Old Patients", OldPatientsUI);
        MainPanel.add("Daily Census", DailyCensusUI);
        MainPanel.add("Monthly Census", MonthlyCensusUI);

        OldPatientsUISwitch = new CardLayout();
        OldPatientsUI.setLayout(OldPatientsUISwitch);
        OldPatientsUI.add("Search", SearchUI);
        OldPatientsUI.add("Patient Record", PatientRecordUI);

        listSelectionModel = jTable2.getSelectionModel();
        listSelectionModel.addListSelectionListener(new MyListSelectionListener());
        jTable2.setSelectionModel(listSelectionModel);

        Enabled = new Color(0, 112, 192);
        Disabled = new Color(166, 166, 166);

        DAOImpl di = new DAOImpl();
        ArrayList<Patient> daily = new ArrayList<>();
        String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
        daily = di.searchDaily("", date);
        refresh(daily);

        setPlaceholder(jTextField6, "Search");
        setPlaceholder(jTextField2, "LAST NAME, FIRST NAME MI.");
        setPlaceholder(jTextField4, "LAST NAME, FIRST NAME MI.");
        setPlaceholder(jTextField12, "Search patient or physician name to view patient status or physician assignments");

        String theyear = new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
        int year = Integer.parseInt(theyear);
        int i;
        jComboBox3.removeAllItems();
        jComboBox12.removeAllItems();
        jComboBox22.removeAllItems();
        jComboBox28.removeAllItems();
        jComboBox3.addItem("YYYY");
        jComboBox12.addItem("YYYY");
        jComboBox22.addItem("YYYY");
        jComboBox28.addItem("YYYY");
        for (i = year; i > 1899; i--) {
            Object add = Integer.toString(i);
            jComboBox3.addItem(add);
            jComboBox12.addItem(add);
            jComboBox22.addItem(add);
            jComboBox28.addItem(add);
        }

    }

    public void OptionsToday() {
        OptionsSwitch.show(OptionsPanel, "Today");
    }

    public void OptionsPatients() {
        OptionsSwitch.show(OptionsPanel, "Patients");
    }

    public void OptionsCensus() {
        OptionsSwitch.show(OptionsPanel, "Census");
    }

    public void Today() {
        MainUISwitch.show(MainPanel, "Today");
    }

    public void OldPatients() {
        MainUISwitch.show(MainPanel, "Old Patients");
    }

    public void Search() {
        OldPatientsUISwitch.show(OldPatientsUI, "Search");
    }

    public void PatientRecord() {
        OldPatientsUISwitch.show(OldPatientsUI, "Patient Record");
    }

    public void NewPatient() {
        MainUISwitch.show(MainPanel, "New Patient");
    }

    public void DailyCensus() {
        MainUISwitch.show(MainPanel, "Daily Census");
    }

    public void MonthlyCensus() {
        MainUISwitch.show(MainPanel, "Monthly Census");
    }

    public void setPlaceholder(JTextField tf, String placeholder) {
        tf.setText(placeholder);
        tf.setForeground(Color.LIGHT_GRAY);
    }

    public void removePlaceholder(JTextField tf) {
        tf.setText("");
        tf.setForeground(Color.BLACK);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OptionsPanel = new javax.swing.JPanel();
        Today = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        OptionsPatients = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        OptionsCensus = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        TodayUI = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField12 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        OldPatientsUI = new javax.swing.JPanel();
        SearchUI = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        PatientRecordUI = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox13 = new javax.swing.JComboBox();
        jComboBox14 = new javax.swing.JComboBox();
        jComboBox15 = new javax.swing.JComboBox();
        jComboBox16 = new javax.swing.JComboBox();
        jComboBox17 = new javax.swing.JComboBox();
        jComboBox18 = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jComboBox19 = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        jComboBox20 = new javax.swing.JComboBox();
        jComboBox21 = new javax.swing.JComboBox();
        jComboBox22 = new javax.swing.JComboBox();
        jLabel43 = new javax.swing.JLabel();
        jComboBox23 = new javax.swing.JComboBox();
        jComboBox24 = new javax.swing.JComboBox();
        jComboBox25 = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        jComboBox30 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        NewPatientUI = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jComboBox29 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        DailyCensusUI = new javax.swing.JPanel();
        jComboBox26 = new javax.swing.JComboBox();
        jComboBox27 = new javax.swing.JComboBox();
        jComboBox28 = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        MonthlyCensusUI = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 112, 192));
        jLabel1.setText("Today");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 50)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 166, 166));
        jLabel2.setText("Patients");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(166, 166, 166));
        jLabel3.setText("Census");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        OptionsPanel.setLayout(new java.awt.CardLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout TodayLayout = new javax.swing.GroupLayout(Today);
        Today.setLayout(TodayLayout);
        TodayLayout.setHorizontalGroup(
            TodayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 415, Short.MAX_VALUE))
        );
        TodayLayout.setVerticalGroup(
            TodayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        OptionsPanel.add(Today, "card4");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(166, 166, 166));
        jLabel4.setText("Old Patients");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(166, 166, 166));
        jLabel5.setText("New Patient");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout OptionsPatientsLayout = new javax.swing.GroupLayout(OptionsPatients);
        OptionsPatients.setLayout(OptionsPatientsLayout);
        OptionsPatientsLayout.setHorizontalGroup(
            OptionsPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionsPatientsLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(175, 175, 175))
        );
        OptionsPatientsLayout.setVerticalGroup(
            OptionsPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsPatientsLayout.createSequentialGroup()
                .addGroup(OptionsPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        OptionsPanel.add(OptionsPatients, "card2");

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(166, 166, 166));
        jLabel6.setText("Daily");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(166, 166, 166));
        jLabel7.setText("Monthly");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout OptionsCensusLayout = new javax.swing.GroupLayout(OptionsCensus);
        OptionsCensus.setLayout(OptionsCensusLayout);
        OptionsCensusLayout.setHorizontalGroup(
            OptionsCensusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionsCensusLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(107, 107, 107))
        );
        OptionsCensusLayout.setVerticalGroup(
            OptionsCensusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionsCensusLayout.createSequentialGroup()
                .addGroup(OptionsCensusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        OptionsPanel.add(OptionsCensus, "card3");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Lock.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel8MouseReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(166, 166, 166));
        jLabel10.setText("Lock");

        MainPanel.setLayout(new java.awt.CardLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 35)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 112, 192));
        jLabel9.setText("Admitted Patients");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Priority Level", "Chart No.", "Name", "Attending Physician", "Diagnosis", "Room"
            }
        ){public boolean isCellEditable(int row, int column){return false;}});
        jScrollPane1.setViewportView(jTable1);

        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Search.png"))); // NOI18N
        jLabel45.setText("jLabel45");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel45MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel45MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel45MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel45MousePressed(evt);
            }
        });

        jLabel11.setText("Reset");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TodayUILayout = new javax.swing.GroupLayout(TodayUI);
        TodayUI.setLayout(TodayUILayout);
        TodayUILayout.setHorizontalGroup(
            TodayUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayUILayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(TodayUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TodayUILayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(151, 151, 151)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        TodayUILayout.setVerticalGroup(
            TodayUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayUILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TodayUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TodayUILayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(TodayUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        MainPanel.add(TodayUI, "card2");

        OldPatientsUI.setLayout(new java.awt.CardLayout());

        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Search.png"))); // NOI18N
        jLabel25.setText("jLabel25");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel25MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel25MouseReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(64, 64, 64));
        jLabel26.setText("Admitted Patients");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }

        ){public boolean isCellEditable(int row, int column){return false;}});
        jScrollPane3.setViewportView(jTable2);

        jLabel27.setText("Reset");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout SearchUILayout = new javax.swing.GroupLayout(SearchUI);
        SearchUI.setLayout(SearchUILayout);
        SearchUILayout.setHorizontalGroup(
            SearchUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchUILayout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addGroup(SearchUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addGroup(SearchUILayout.createSequentialGroup()
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel27)))
                .addGap(342, 460, Short.MAX_VALUE))
        );
        SearchUILayout.setVerticalGroup(
            SearchUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchUILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SearchUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel27))
                    .addComponent(jTextField6))
                .addGap(27, 27, 27)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        OldPatientsUI.add(SearchUI, "card2");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(64, 64, 64));
        jLabel28.setText("Name");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(64, 64, 64));
        jLabel29.setText("Year of Birth");

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(64, 64, 64));
        jLabel30.setText("Sex");

        jRadioButton7.setText("Male");
        jRadioButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton7MouseClicked(evt);
            }
        });

        jRadioButton8.setText("Female");
        jRadioButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton8MouseClicked(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(64, 64, 64));
        jLabel31.setText("Address");

        jRadioButton9.setText("Manila");
        jRadioButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton9MouseClicked(evt);
            }
        });

        jRadioButton10.setText("Other");
        jRadioButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton10MouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(64, 64, 64));
        jLabel32.setText("PhilHealth");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(64, 64, 64));
        jLabel33.setText("Date|Time Admitted");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(64, 64, 64));
        jLabel34.setText("|");

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox14FocusGained(evt);
            }
        });

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));
        jComboBox15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox15FocusLost(evt);
            }
        });

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HH", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "AM", "PM" }));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(64, 64, 64));
        jLabel35.setText("Attending Physician");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(64, 64, 64));
        jLabel36.setText("Diagnosis");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(64, 64, 64));
        jLabel37.setText("Room");

        jRadioButton11.setText(" MICU");
        jRadioButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton11MouseClicked(evt);
            }
        });

        jRadioButton12.setText("Ward");
        jRadioButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton12MouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(64, 64, 64));
        jLabel38.setText("Remarks");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Back.png"))); // NOI18N
        jLabel39.setText("jLabel23");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel39MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel39MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel39MouseReleased(evt);
            }
        });

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Edit.png"))); // NOI18N
        jLabel40.setText("jLabel23");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel40MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel40MouseReleased(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(64, 64, 64));
        jLabel41.setText("Disposition");

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "DISCHARGED", "HAMA", "THOC", "EXPIRED" }));
        jComboBox19.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox19FocusLost(evt);
            }
        });
        jComboBox19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox19MouseClicked(evt);
            }
        });
        jComboBox19.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox19PropertyChange(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(64, 64, 64));
        jLabel42.setText("Date|Time");

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(64, 64, 64));
        jLabel43.setText("|");

        jComboBox23.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HH", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBox24.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "AM", "PM" }));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(64, 64, 64));
        jLabel47.setText("Priority Level");

        jComboBox30.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "High", "CRITICAL" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PH MEMBER", "PH DEPENDENT", "NON-PH", "INDIGENT" }));

        javax.swing.GroupLayout PatientRecordUILayout = new javax.swing.GroupLayout(PatientRecordUI);
        PatientRecordUI.setLayout(PatientRecordUILayout);
        PatientRecordUILayout.setHorizontalGroup(
            PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientRecordUILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(519, 519, 519))
            .addGroup(PatientRecordUILayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(61, 61, 61)
                .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientRecordUILayout.createSequentialGroup()
                        .addComponent(jRadioButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton10))
                    .addGroup(PatientRecordUILayout.createSequentialGroup()
                        .addComponent(jRadioButton7)
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButton8))
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientRecordUILayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientRecordUILayout.createSequentialGroup()
                                .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42))
                                .addGap(71, 71, 71)
                                .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PatientRecordUILayout.createSequentialGroup()
                                        .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PatientRecordUILayout.createSequentialGroup()
                            .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel35)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37)
                                .addComponent(jLabel38))
                            .addGap(18, 18, 18)
                            .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PatientRecordUILayout.createSequentialGroup()
                                    .addComponent(jRadioButton11)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRadioButton12))
                                .addComponent(jTextField11)
                                .addComponent(jTextField10)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PatientRecordUILayout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(60, 60, 60)
                        .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        PatientRecordUILayout.setVerticalGroup(
            PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientRecordUILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientRecordUILayout.createSequentialGroup()
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jRadioButton11)
                            .addComponent(jRadioButton12))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel38)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43)
                            .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(PatientRecordUILayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jRadioButton9)
                            .addComponent(jRadioButton10))
                        .addGap(18, 18, 18)
                        .addGroup(PatientRecordUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        OldPatientsUI.add(PatientRecordUI, "card3");

        MainPanel.add(OldPatientsUI, "card4");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(64, 64, 64));
        jLabel12.setText("Name");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(64, 64, 64));
        jLabel13.setText("Year of Birth");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(64, 64, 64));
        jLabel14.setText("Sex");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(64, 64, 64));
        jLabel15.setText("Address");

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton3.setText("Manila");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton4.setText("Other");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(64, 64, 64));
        jLabel16.setText("PhilHealth");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(64, 64, 64));
        jLabel17.setText("Date|Time Admitted");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(64, 64, 64));
        jLabel19.setText("Attending Physician");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(64, 64, 64));
        jLabel20.setText("Diagnosis");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(64, 64, 64));
        jLabel21.setText("Room");

        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton5.setText(" MICU");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButton6.setText("Ward");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(64, 64, 64));
        jLabel22.setText("Remarks");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Cancel.png"))); // NOI18N
        jLabel23.setText("jLabel23");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel23MouseReleased(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_OK.png"))); // NOI18N
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel24MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel24MouseReleased(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(64, 64, 64));
        jLabel46.setText("Priority Level");

        jComboBox29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox29.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "High", "CRITICAL" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Use Current Time");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PH MEMBER", "PH DEPENDENT", "NON-PH", "INDIGENT" }));

        javax.swing.GroupLayout NewPatientUILayout = new javax.swing.GroupLayout(NewPatientUI);
        NewPatientUI.setLayout(NewPatientUILayout);
        NewPatientUILayout.setHorizontalGroup(
            NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPatientUILayout.createSequentialGroup()
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewPatientUILayout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewPatientUILayout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NewPatientUILayout.createSequentialGroup()
                                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(NewPatientUILayout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(NewPatientUILayout.createSequentialGroup()
                                                .addComponent(jRadioButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRadioButton4))
                                            .addGroup(NewPatientUILayout.createSequentialGroup()
                                                .addComponent(jRadioButton1)
                                                .addGap(26, 26, 26)
                                                .addComponent(jRadioButton2))
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(NewPatientUILayout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(NewPatientUILayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(NewPatientUILayout.createSequentialGroup()
                                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel46))
                                .addGap(18, 18, 18)
                                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(NewPatientUILayout.createSequentialGroup()
                                        .addComponent(jRadioButton5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton6))
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(472, Short.MAX_VALUE))
        );
        NewPatientUILayout.setVerticalGroup(
            NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPatientUILayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NewPatientUILayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17))
                    .addGroup(NewPatientUILayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(NewPatientUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        MainPanel.add(NewPatientUI, "card3");

        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox27.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox27FocusGained(evt);
            }
        });

        jComboBox28.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY" }));
        jComboBox28.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox28FocusLost(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Chart No.", "Name", "Age", "Sex", "PhilHealth", "Attending Physician", "Diagnosis", "Room", "Disposition"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button_Export.png"))); // NOI18N
        jLabel44.setText("jLabel44");
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel44MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel44MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel44MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel44MouseReleased(evt);
            }
        });

        jLabel48.setBackground(new java.awt.Color(0, 102, 255));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 102, 255));
        jLabel48.setText("Get Census");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DailyCensusUILayout = new javax.swing.GroupLayout(DailyCensusUI);
        DailyCensusUI.setLayout(DailyCensusUILayout);
        DailyCensusUILayout.setHorizontalGroup(
            DailyCensusUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DailyCensusUILayout.createSequentialGroup()
                .addGroup(DailyCensusUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DailyCensusUILayout.createSequentialGroup()
                        .addGap(608, 608, 608)
                        .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel48)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DailyCensusUILayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        DailyCensusUILayout.setVerticalGroup(
            DailyCensusUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DailyCensusUILayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DailyCensusUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox27, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DailyCensusUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48))
                    .addComponent(jComboBox26))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        MainPanel.add(DailyCensusUI, "card5");

        javax.swing.GroupLayout MonthlyCensusUILayout = new javax.swing.GroupLayout(MonthlyCensusUI);
        MonthlyCensusUI.setLayout(MonthlyCensusUILayout);
        MonthlyCensusUILayout.setHorizontalGroup(
            MonthlyCensusUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        MonthlyCensusUILayout.setVerticalGroup(
            MonthlyCensusUILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        MainPanel.add(MonthlyCensusUI, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(35, 35, 35))))
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(7, 7, 7)
                .addComponent(OptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class MyListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                if (jComboBox19.getSelectedIndex() == 0) {
                    jComboBox20.setEnabled(false);
                    jComboBox21.setEnabled(false);
                    jComboBox22.setEnabled(false);
                    jComboBox23.setEnabled(false);
                    jComboBox24.setEnabled(false);
                    jComboBox25.setEnabled(false);
                }
                Object name;
                Patient p = new Patient();
                name = jTable2.getModel().getValueAt(jTable2.getSelectedRow(), 0);

                DAOIntf di = new DAOImpl();
                ArrayList<Patient> allPatients = di.getAllPatients();

                for (int i = 0; i < allPatients.size(); i++) {
                    if (name.toString().equalsIgnoreCase(allPatients.get(i).getFullname())) {
                        p.setPatientid(allPatients.get(i).getPatientid());
                        p.setFullname(allPatients.get(i).getFullname());
                        p.setBirthday(allPatients.get(i).getBirthday());
                        p.setSex(allPatients.get(i).getSex());
                        p.setAddress(allPatients.get(i).getAddress());
                        p.setPhilhealth(allPatients.get(i).getPhilhealth());
                        p.setDateAdmitted(allPatients.get(i).getDateAdmitted());
                        p.setPhysician(allPatients.get(i).getPhysician());
                        p.setDiagnosis(allPatients.get(i).getDiagnosis());
                        p.setRoom(allPatients.get(i).getRoom());
                        p.setRemarks(allPatients.get(i).getRemarks());
                        p.setPriority(allPatients.get(i).getPriority());
                    }
                }

                String[] datetime = p.getDateAdmitted().split(" ");
                String[] date = datetime[0].split("-");
                String[] time = datetime[1].split(":");
                int month = Integer.parseInt(date[0]);
                int day = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);
                int hour = Integer.parseInt(time[0]);
                int minute = Integer.parseInt(time[1]);
                int ampm = 0;
                if (datetime[2].equalsIgnoreCase("AM")) {
                    ampm = 1;
                } else {
                    ampm = 2;
                }

                SearchUI.setVisible(false);
                PatientRecordUI.setVisible(true);

                id = p.getPatientid();
                jTextField8.setText(p.getFullname());

                for (int i = 0; i < 116; i++) {
                    jComboBox12.setSelectedIndex(i);
                    if (p.getBirthday() + jComboBox12.getSelectedIndex() == 2015) {
                        jComboBox12.setSelectedIndex(i);
                        break;
                    }
                }

                if (p.getSex().equals("M")) {
                    jRadioButton7.setSelected(true);
                    jRadioButton8.setSelected(false);
                } else {
                    jRadioButton7.setSelected(false);
                    jRadioButton8.setSelected(true);
                }
                if (p.getAddress().equals("Manila")) {
                    jRadioButton9.setSelected(true);
                    jRadioButton10.setSelected(false);
                } else {
                    jRadioButton9.setSelected(false);
                    jRadioButton10.setSelected(true);
                }

                for (int i = 0; i < 4; i++) {
                    jComboBox2.setSelectedIndex(i);
                    if (p.getPhilhealth().equalsIgnoreCase(jComboBox2.getSelectedItem().toString())) {
                        jComboBox2.setSelectedIndex(i);
                        break;
                    }
                }

                jComboBox13.setSelectedIndex(month);
                jComboBox14.setSelectedIndex(day);

                for (int i = 0; i < 116; i++) {
                    jComboBox15.setSelectedIndex(i);
                    if (year + jComboBox15.getSelectedIndex() == 2015) {
                        jComboBox15.setSelectedIndex(i);
                        break;
                    }
                }
                jComboBox16.setSelectedIndex(hour % 12);
                if (hour == 0 || hour == 12) {
                    jComboBox16.setSelectedIndex(12);
                }
                jComboBox17.setSelectedIndex(minute + 1);
                jComboBox18.setSelectedIndex(ampm);

                jTextField10.setText(p.getPhysician());
                jTextField11.setText(p.getDiagnosis());

                if (p.getAddress().equals("Manila")) {
                    jRadioButton9.setSelected(true);
                    jRadioButton10.setSelected(false);
                } else {
                    jRadioButton9.setSelected(false);
                    jRadioButton10.setSelected(true);
                }

                if (p.getRoom().equals("MICU")) {
                    jRadioButton11.setSelected(true);
                    jRadioButton12.setSelected(false);
                } else {
                    jRadioButton11.setSelected(false);
                    jRadioButton12.setSelected(true);
                }

                jTextArea2.setText(p.getRemarks());

                for (int i = 0; i < allPatients.size(); i++) {
                    if (p.getPriority().equalsIgnoreCase(allPatients.get(i).getPriority()) && p.getFullname().equalsIgnoreCase(allPatients.get(i).getFullname())) {
                        if (p.getPriority().equalsIgnoreCase("Normal")) {
                            jComboBox30.setSelectedIndex(0);
                        } else if (p.getPriority().equalsIgnoreCase("High")) {
                            jComboBox30.setSelectedIndex(1);
                        } else {
                            jComboBox30.setSelectedIndex(2);
                        }
                        break;
                    }
                }
            }
        }
    };

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        jLabel1.setForeground(Enabled);
        jLabel2.setForeground(Disabled);
        jLabel3.setForeground(Disabled);
        jLabel4.setForeground(Disabled);
        jLabel5.setForeground(Disabled);
        jLabel6.setForeground(Disabled);
        jLabel7.setForeground(Disabled);
        OptionsToday();
        Today();
        DAOImpl di = new DAOImpl();
        ArrayList<Patient> daily = new ArrayList<>();
        String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
        daily = di.searchDaily("", date);
        refresh(daily);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        jLabel1.setForeground(Disabled);
        jLabel2.setForeground(Enabled);
        jLabel3.setForeground(Disabled);
        jLabel4.setForeground(Enabled);
        jLabel5.setForeground(Disabled);
        jLabel6.setForeground(Disabled);
        jLabel7.setForeground(Disabled);
        OptionsPatients();
        OldPatients();
        Search();
        refresh();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        jLabel4.setForeground(Enabled);
        jLabel5.setForeground(Disabled);
        OldPatients();
        Search();
        refresh();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jLabel4.setForeground(Disabled);
        jLabel5.setForeground(Enabled);
        NewPatient();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        jLabel1.setForeground(Disabled);
        jLabel2.setForeground(Disabled);
        jLabel3.setForeground(Enabled);
        jLabel4.setForeground(Disabled);
        jLabel5.setForeground(Disabled);
        jLabel6.setForeground(Enabled);
        jLabel7.setForeground(Disabled);
        OptionsCensus();
        DailyCensus();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        jLabel6.setForeground(Enabled);
        jLabel7.setForeground(Disabled);
        DailyCensus();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        jLabel6.setForeground(Disabled);
        jLabel7.setForeground(Enabled);
        MonthlyCensus();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_LockClick.png"));
        jLabel8.setIcon(Button);
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_Lock.png"));
        jLabel8.setIcon(Button);
    }//GEN-LAST:event_jLabel8MouseReleased

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_CancelClick.png"));
        jLabel23.setIcon(Button);
    }//GEN-LAST:event_jLabel23MousePressed

    private void jLabel23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseReleased
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_Cancel.png"));
        jLabel23.setIcon(Button);
        jLabel1.setForeground(Enabled);
        jLabel2.setForeground(Disabled);
        jLabel3.setForeground(Disabled);
        jLabel4.setForeground(Disabled);
        jLabel5.setForeground(Disabled);
        jLabel6.setForeground(Disabled);
        jLabel7.setForeground(Disabled);
        OptionsToday();
        Today();
        DAOImpl di = new DAOImpl();
        ArrayList<Patient> daily = new ArrayList<>();
        String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
        daily = di.searchDaily("", date);
        refresh(daily);

    }//GEN-LAST:event_jLabel23MouseReleased

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MousePressed
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_SearchClick.png"));
        jLabel25.setIcon(Button);
    }//GEN-LAST:event_jLabel25MousePressed

    private void jLabel25MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseReleased
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_Search.png"));
        jLabel25.setIcon(Button);
        // Search result here
    }//GEN-LAST:event_jLabel25MouseReleased

    private void jLabel39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel39MouseEntered

    private void jLabel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel39MouseExited

    private void jLabel39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MousePressed
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_BackClick.png"));
        jLabel39.setIcon(Button);
    }//GEN-LAST:event_jLabel39MousePressed

    private void jLabel39MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseReleased
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_Back.png"));
        jLabel39.setIcon(Button);
        Search();
    }//GEN-LAST:event_jLabel39MouseReleased

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MousePressed
        // Save/Edit button
    }//GEN-LAST:event_jLabel40MousePressed

    private void jLabel40MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseReleased
        // Save/Edit button
        // Save/Edit functions
    }//GEN-LAST:event_jLabel40MouseReleased

    private void jLabel44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel44MouseEntered

    private void jLabel44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel44MouseExited

    private void jLabel44MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MousePressed
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_ExportClick.png"));
        jLabel44.setIcon(Button);
    }//GEN-LAST:event_jLabel44MousePressed

    private void jLabel44MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseReleased
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_Export.png"));
        jLabel44.setIcon(Button);
        // Export function here
    }//GEN-LAST:event_jLabel44MouseReleased

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        if (jTextField6.getText().equals("Search")) {
            removePlaceholder(jTextField6);
        }
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        if (jTextField6.getText().equals("")) {
            setPlaceholder(jTextField6, "Search");
        }
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        if (jTextField2.getText().equals("LAST NAME, FIRST NAME MI.")) {
            removePlaceholder(jTextField2);
        }
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        if (jTextField2.getText().equals("")) {
            setPlaceholder(jTextField2, "LAST NAME, FIRST NAME MI.");
        }
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
        if (jTextField4.getText().equals("LAST NAME, FIRST NAME MI.")) {
            removePlaceholder(jTextField4);
        }
    }//GEN-LAST:event_jTextField4FocusGained

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        if (jTextField4.getText().equals("")) {
            setPlaceholder(jTextField4, "LAST NAME, FIRST NAME MI.");
        }
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusGained
        if (jTextField12.getText().equals("Search patient or physician name to view patient status or physician assignments")) {
            removePlaceholder(jTextField12);
        }
    }//GEN-LAST:event_jTextField12FocusGained

    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
        if (jTextField12.getText().equals("")) {
            setPlaceholder(jTextField12, "Search patient or physician name to view patient status or physician assignments");
        }
    }//GEN-LAST:event_jTextField12FocusLost

    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel45MouseEntered

    private void jLabel45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel45MouseExited

    private void jLabel45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MousePressed
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_SearchClick.png"));
        jLabel45.setIcon(Button);
    }//GEN-LAST:event_jLabel45MousePressed

    private void jLabel45MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseReleased
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_Search.png"));
        jLabel45.setIcon(Button);
        // Today filter census based on Search
    }//GEN-LAST:event_jLabel45MouseReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLabel1.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void jLabel24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseReleased
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_OK.png"));
        jLabel24.setIcon(Button);
        // Save new patient here
    }//GEN-LAST:event_jLabel24MouseReleased

    private void jLabel24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MousePressed
        ImageIcon Button = new ImageIcon(getClass().getResource("/Images/Button_OKClick.png"));
        jLabel24.setIcon(Button);
    }//GEN-LAST:event_jLabel24MousePressed

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        String name = jTextField2.getText();
        int year = -1;
        String sex = "None";
        String address = "None";
        String philhealth = jComboBox1.getSelectedItem().toString();
        timeStamp = new SimpleDateFormat("MM-dd-yyyy hh:mm aa").format(Calendar.getInstance().getTime());
        String physician = jTextField4.getText();
        String diagnosis = jTextField5.getText();
        String room = "None";
        String remarks = jTextArea1.getText();
        String priority = jComboBox29.getSelectedItem().toString();
        String datedischarge = "MM-DD-YYYY HH-mm AM";

        if (!jComboBox3.getSelectedItem().toString().equals("YYYY")) {
            year = Integer.parseInt(jComboBox3.getSelectedItem().toString());
        }
        if (jRadioButton1.isSelected()) {
            sex = "M";
        } else if (jRadioButton2.isSelected()) {
            sex = "F";
        }
        if (jRadioButton3.isSelected()) {
            address = "Manila";
        } else if (jRadioButton4.isSelected()) {
            address = "Other";
        }
        if (jRadioButton5.isSelected()) {
            room = "MICU";
        } else if (jRadioButton6.isSelected()) {
            room = "Ward";
        }
        
        if (name.matches("LAST NAME, FIRST NAME MI.")) {
            name = "None";
        }
        
        if (physician.matches("LAST NAME, FIRST NAME MI.")) {
            physician = "None";
        }
        if (diagnosis.isEmpty()) {
            diagnosis = "None";
        }
        if (remarks.isEmpty()) {
            remarks = "None";
        }

        if (!name.matches("None") && (jTextField2.isFocusOwner() && !jTextField2.getText().isEmpty()) && year != -1 && !sex.matches("None") && !address.matches("None")
                && !physician.matches("None") && (jTextField4.isFocusOwner() && !jTextField4.getText().isEmpty()) && !room.matches("None")) {

            if (name.matches("[a-zA-Z.Ññé, -]+") && physician.matches("[a-zA-Z.Ññé, -]+")) {
                
                DAOIntf di = new DAOImpl();
                ArrayList<Patient> allPatients = di.getAllPatients();
                Patient p = new Patient();
                p.setFullname(name);
                p.setBirthday(year);
                p.setSex(sex);
                p.setAddress(address);
                p.setPhilhealth(philhealth);
                p.setDateAdmitted(timeStamp);
                p.setPhysician(physician);
                p.setDiagnosis(diagnosis);
                p.setRoom(room);
                p.setRemarks(remarks);
                p.setPriority(priority);
                p.setDateDischarged(datedischarge);

                int j = 0;
                for (int i = 0; i < allPatients.size(); i++) {
                    j = 0;
                    if (p.getFullname().equalsIgnoreCase(allPatients.get(i).getFullname())) {
                        j++;
                    }
                    if (p.getSex().equalsIgnoreCase(allPatients.get(i).getSex())) {
                        j++;
                    }
                    if (p.getBirthday() == allPatients.get(i).getBirthday()) {
                        j++;
                    }
                    if (p.getAddress().equalsIgnoreCase(allPatients.get(i).getAddress())) {
                        j++;
                    }
                    if (p.getPhilhealth().equalsIgnoreCase(allPatients.get(i).getPhilhealth())) {
                        j++;
                    }
                    if (p.getPhysician().equalsIgnoreCase(allPatients.get(i).getPhysician())) {
                        j++;
                    }
                    if (p.getDiagnosis().equalsIgnoreCase(allPatients.get(i).getDiagnosis())) {
                        j++;
                    }
                    if (p.getRoom().equalsIgnoreCase(allPatients.get(i).getRoom())) {
                        j++;
                    }
                    if (p.getRemarks().equalsIgnoreCase(allPatients.get(i).getRemarks())) {
                        j++;
                    }
                    if (p.getPriority().equalsIgnoreCase(allPatients.get(i).getPriority())) {
                        j++;
                    }
                    if (j == 10) {
                        break;
                    }
                }
                if (j == 10) {

                    int reply = JOptionPane.showConfirmDialog(null, "There is an exact same patient with these info. Are you sure you want to add this patient?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        di.addPatient(p);
                        String st = "Patient Added Successfully.";
                        JOptionPane.showMessageDialog(null, st);
                    } else {
                        String st = "Patient Not Added.";
                        JOptionPane.showMessageDialog(null, st);
                    }
                } else {
                    di.addPatient(p);
                    String st = "Patient Added Successfully.";
                    JOptionPane.showMessageDialog(null, st);

                }
                setPlaceholder(jTextField2, "LAST NAME, FIRST NAME MI.");
                setPlaceholder(jTextField4, "LAST NAME, FIRST NAME MI.");
                jTextField5.setText("");
                jTextArea1.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);
                jComboBox29.setSelectedIndex(0);
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);
                jRadioButton3.setSelected(false);
                jRadioButton4.setSelected(false);
                jRadioButton5.setSelected(false);
                jRadioButton6.setSelected(false);
                //refresh();
            } else {
                String warn = "Incorrect input for: \n";
                String warnName = "";
                String warnPhysician = "";

                if (!name.matches("[a-zA-Z.Ññé, -]+")) {
                    warnName = " Name";
                }
                if (!physician.matches("[a-zA-Z.Ññé, -]+")) {
                    warnPhysician = " Attending Physician";
                }

                if (!warnName.equals("")) {
                    warn += warnName + "\n";
                }
                if (!warnPhysician.equals("")) {
                    warn += warnPhysician + "\n";
                }

                warn += " Valid inputs are letters, spaces and commas.";
                JOptionPane.showMessageDialog(null, warn);

            }
        } else {
            String st;
            String st1 = "";
            String st2 = "";
            String st3 = "";
            String st4 = "";
            String st5 = "";
            String st6 = "";

            if (jTextField2.isFocusOwner() && jTextField2.getText().isEmpty() || name.matches("None")) {
                st1 = " Name";
            }
            if (year == -1) {
                st2 = " Year of Birth";
            }
            if (sex.matches("None")) {
                st3 = " Sex";
            }
            if (address.matches("None")) {
                st4 = " Address";
            }
            if (jTextField4.isFocusOwner() && jTextField4.getText().isEmpty() || physician.matches("None")) {
                st5 = " Physician";
            }
            
            if (room.matches("None")) {
                st6 = " Room";
            }

            st = "Incomplete! Please input the following: \n";

            if (!st1.equals("")) {
                st += st1 + "\n";
            }
            if (!st2.equals("")) {
                st += st2 + "\n";
            }
            if (!st3.equals("")) {
                st += st3 + "\n";
            }
            if (!st4.equals("")) {
                st += st4 + "\n";
            }
            if (!st5.equals("")) {
                st += st5 + "\n";
            }      
            if (!st6.equals("")) {
                st += st6 + "\n";
            }

            JOptionPane.showMessageDialog(null, st);
        }

    }//GEN-LAST:event_jLabel24MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton2.setSelected(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jRadioButton4.setSelected(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jRadioButton3.setSelected(false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        jRadioButton6.setSelected(false);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        jRadioButton5.setSelected(false);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timeStamp = new SimpleDateFormat("MM-dd-yyyy hh:mm aa").format(Calendar.getInstance().getTime());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        DAOImpl di = new DAOImpl();
        String search = jTextField12.getText();
        ArrayList<Patient> totalsearch = new ArrayList<>();
        String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
        totalsearch = di.searchDaily(search, date);
        refresh(totalsearch);

        int num = totalsearch.size();
        String st = num + " entries found.";
        JOptionPane.showMessageDialog(null, st);

        jTextField12.setText("");
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        DAOImpl di = new DAOImpl();
        ArrayList<Patient> daily = new ArrayList<>();
        String date = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
        daily = di.searchDaily("", date);
        refresh(daily);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        DAOImpl di = new DAOImpl();
        String search = jTextField6.getText();
        ArrayList<Patient> totalsearch = new ArrayList<>();
        totalsearch = di.search(search);
        refresh(totalsearch);

        int num = totalsearch.size();
        String st = num + " entries found.";
        JOptionPane.showMessageDialog(null, st);

        jTextField6.setText("");

    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        refresh();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked

    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        String name = jTextField8.getText();
        int year = -1;
        String sex = "None";
        String address = "None";
        String philhealth = jComboBox2.getSelectedItem().toString();
        String physician = jTextField10.getText();
        String diagnosis = jTextField11.getText();
        String room = "None";
        String remarks = jTextArea2.getText();
        String priority = jComboBox30.getSelectedItem().toString();
        String disposition = jComboBox19.getSelectedItem().toString();
        int check = 1;

        if (!jComboBox12.getSelectedItem().toString().equals("YYYY")) {
            year = Integer.parseInt(jComboBox12.getSelectedItem().toString());
        }
        if (jRadioButton7.isSelected()) {
            sex = "M";
        } else if (jRadioButton8.isSelected()) {
            sex = "F";
        }
        if (jRadioButton9.isSelected()) {
            address = "Manila";
        } else if (jRadioButton10.isSelected()) {
            address = "Other";
        }
        if (jRadioButton11.isSelected()) {
            room = "MICU";
        } else if (jRadioButton12.isSelected()) {
            room = "Ward";
        }
        if (physician.equals("")) {
            physician = "None";
        }
        if (diagnosis.isEmpty()) {
            diagnosis = "None";
        }
        if (remarks.isEmpty()) {
            remarks = "None";
        }

        if ((name.matches("LAST NAME, FIRST NAME MI.") || (jTextField2.isFocusOwner() && jTextField2.getText().isEmpty())) && year != -1 && !sex.matches("None") && !address.matches("None")
                && (physician.matches("LAST NAME, FIRST NAME MI.") || (jTextField4.isFocusOwner() && jTextField4.getText().isEmpty())) && !room.matches("None")) {

            if (name.matches("[a-zA-Z.Ññé, -]+") && (physician.matches("[a-zA-Z.Ññé, -]+") || jTextField10.getText().isEmpty()) && !jComboBox13.getSelectedItem().toString().equals("MM")
                    && !jComboBox14.getSelectedItem().toString().equals("DD") && !jComboBox15.getSelectedItem().toString().equals("YYYY")
                    && !jComboBox16.getSelectedItem().toString().equals("HH") && !jComboBox17.getSelectedItem().toString().equals("MM")
                    && !jComboBox18.getSelectedItem().toString().isEmpty()) {

                DAOIntf di = new DAOImpl();
                ArrayList<Patient> allPatients = di.getAllPatients();
                Patient p = new Patient();
                p.setFullname(name);
                p.setBirthday(year);
                p.setSex(sex);
                p.setAddress(address);
                p.setPhilhealth(philhealth);
                p.setPhysician(physician);
                p.setDiagnosis(diagnosis);
                p.setRoom(room);
                p.setRemarks(remarks);
                p.setPriority(priority);

                String month = jComboBox13.getSelectedItem().toString();
                String day = jComboBox14.getSelectedItem().toString();
                String admityear = jComboBox15.getSelectedItem().toString();
                String hour = jComboBox16.getSelectedItem().toString();
                String minute = jComboBox17.getSelectedItem().toString();
                String ampm = jComboBox18.getSelectedItem().toString();

                StringJoiner wholedate = new StringJoiner("-");
                wholedate.add(month);
                wholedate.add(day);
                wholedate.add(admityear);
                StringJoiner wholetime = new StringJoiner(":");
                wholetime.add(hour);
                wholetime.add(minute);
                StringJoiner editdate = new StringJoiner(" ");
                editdate.add(wholedate.toString());
                editdate.add(wholetime.toString());
                editdate.add(ampm);

                p.setDateAdmitted(editdate.toString());
                check = 1;
                
                if (jComboBox19.getSelectedIndex() != 0) {
                    if (!jComboBox20.getSelectedItem().toString().equals("MM") && !jComboBox21.getSelectedItem().toString().equals("DD")
                            && !jComboBox22.getSelectedItem().toString().equals("YYYY") && !jComboBox23.getSelectedItem().toString().equals("HH")
                            && !jComboBox24.getSelectedItem().toString().equals("MM") && jComboBox25.getSelectedIndex() != 0) {
                        
                        String outmonth = jComboBox20.getSelectedItem().toString();
                        String outday = jComboBox21.getSelectedItem().toString();
                        String outadmityear = jComboBox22.getSelectedItem().toString();
                        String outhour = jComboBox23.getSelectedItem().toString();
                        String outminute = jComboBox24.getSelectedItem().toString();
                        String outampm = jComboBox25.getSelectedItem().toString();

                        StringJoiner outwholedate = new StringJoiner("-");
                        outwholedate.add(outmonth);
                        outwholedate.add(outday);
                        outwholedate.add(outadmityear);
                        StringJoiner outwholetime = new StringJoiner(":");
                        outwholetime.add(outhour);
                        outwholetime.add(outminute);
                        StringJoiner outeditdate = new StringJoiner(" ");
                        outeditdate.add(outwholedate.toString());
                        outeditdate.add(outwholetime.toString());
                        outeditdate.add(outampm);
                        
                        p.setDateDischarged(outeditdate.toString());
                        check = 0;
                        
                    } else {
                        String warn = "Incorrect input for: \n";
                        String warnoutmonth = "";
                        String warnoutday = "";
                        String warnoutyear = "";
                        String warnouthour = "";
                        String warnoutminute = "";
                        String warnoutampm = "";

                        if (jComboBox20.getSelectedItem().toString().equals("MM")) {
                            warnoutmonth = " Disposition (Month)";
                        }
                        if (jComboBox21.getSelectedItem().toString().equals("DD")) {
                            warnoutday = " Disposition (Day)";
                        }
                        if (jComboBox22.getSelectedItem().toString().equals("YYYY")) {
                            warnoutyear = " Disposition (Year)";
                        }
                        if (jComboBox23.getSelectedItem().toString().equals("HH")) {
                            warnouthour = " Disposition (Hour)";
                        }
                        if (jComboBox24.getSelectedItem().toString().equals("MM")) {
                            warnoutminute = " Disposition (Minute)";
                        }
                        if (jComboBox25.getSelectedIndex() == 0) {
                            warnoutampm = " Disposition (AM/PM)";
                        }

                        if (!warnoutmonth.equals("")) {
                            warn += warnoutmonth + "\n";
                        }
                        if (!warnoutday.equals("")) {
                            warn += warnoutday + "\n";
                        }
                        if (!warnoutyear.equals("")) {
                            warn += warnoutyear + "\n";
                        }
                        if (!warnouthour.equals("")) {
                            warn += warnouthour + "\n";
                        }
                        if (!warnoutminute.equals("")) {
                            warn += warnoutminute + "\n";
                        }
                        if (!warnoutampm.equals("")) {
                            warn += warnoutampm + "\n";
                        }

                        check = 2;
                        
                        JOptionPane.showMessageDialog(null, warn);

                    }

                }

                int j = 0;
                for (int i = 0; i < allPatients.size(); i++) {
                    j = 0;
                    if (p.getFullname().equalsIgnoreCase(allPatients.get(i).getFullname())) {
                        j++;
                    }
                    if (p.getSex().equalsIgnoreCase(allPatients.get(i).getSex())) {
                        j++;
                    }
                    if (p.getBirthday() == allPatients.get(i).getBirthday()) {
                        j++;
                    }
                    if (p.getAddress().equalsIgnoreCase(allPatients.get(i).getAddress())) {
                        j++;
                    }
                    if (p.getPhilhealth().equalsIgnoreCase(allPatients.get(i).getPhilhealth())) {
                        j++;
                    }
                    if (p.getPhysician().equalsIgnoreCase(allPatients.get(i).getPhysician())) {
                        j++;
                    }
                    if (p.getDiagnosis().equalsIgnoreCase(allPatients.get(i).getDiagnosis())) {
                        j++;
                    }
                    if (p.getRoom().equalsIgnoreCase(allPatients.get(i).getRoom())) {
                        j++;
                    }
                    if (p.getRemarks().equalsIgnoreCase(allPatients.get(i).getRemarks())) {
                        j++;
                    }
                    if (p.getPriority().equalsIgnoreCase(allPatients.get(i).getPriority())) {
                        j++;
                    }
                    if (j == 10) {
                        break;
                    }
                }
                if (j == 10 && check == 1) {

                    int reply = JOptionPane.showConfirmDialog(null, "There is an exact same patient with these info. Are you sure you want to edit this patient with current info?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        di.editPatient(id, p);
                        String st = "Patient Edited Successfully.";
                        JOptionPane.showMessageDialog(null, st);
                    } else {
                        String st = "Patient Not Edited.";
                        JOptionPane.showMessageDialog(null, st);
                    }
                } else if (check == 0){
                    di.editPatient(id, p);
                    String st = "Patient Edited Successfully.";
                    JOptionPane.showMessageDialog(null, st);

                }
            } else {
                String warn = "Incorrect input for: \n";
                String warnName = "";
                String warnPhysician = "";
                String warnmonth = "";
                String warnday = "";
                String warnyear = "";
                String warnhour = "";
                String warnminute = "";
                String warnampm = "";

                if (!name.matches("[a-zA-Z.Ññé, -]+")) {
                    warnName = " Name";
                }
                if (!physician.matches("[a-zA-Z.Ññé, -]+")) {
                    warnPhysician = " Attending Physician";
                }
                if (jComboBox13.getSelectedItem().toString().equals("MM")) {
                    warnmonth = " Date Admission (Month)";
                }
                if (jComboBox14.getSelectedItem().toString().equals("DD")) {
                    warnday = " Date Admission (Day)";
                }
                if (jComboBox15.getSelectedItem().toString().equals("YYYY")) {
                    warnyear = " Date Admission (Year)";
                }
                if (jComboBox16.getSelectedItem().toString().equals("HH")) {
                    warnhour = " Date Admission (Hour)";
                }
                if (jComboBox17.getSelectedItem().toString().equals("MM")) {
                    warnminute = " Date Admission (Minute)";
                }
                if (jComboBox18.getSelectedItem().toString().isEmpty()) {
                    warnampm = " Date Admission (AM/PM)";
                }

                if (!warnName.equals("")) {
                    warn += warnName + "\n";
                }
                if (!warnPhysician.equals("")) {
                    warn += warnPhysician + "\n";
                }
                if (!warnmonth.equals("")) {
                    warn += warnmonth + "\n";
                }
                if (!warnday.equals("")) {
                    warn += warnday + "\n";
                }
                if (!warnyear.equals("")) {
                    warn += warnyear + "\n";
                }
                if (!warnhour.equals("")) {
                    warn += warnhour + "\n";
                }
                if (!warnminute.equals("")) {
                    warn += warnminute + "\n";
                }
                if (!warnampm.equals("")) {
                    warn += warnampm + "\n";
                }

                JOptionPane.showMessageDialog(null, warn);

            }
        } else {
            String st;
            String st1 = "";
            String st2 = "";
            String st3 = "";
            String st4 = "";
            String st5 = "";
            String st6 = "";

            if (jTextField2.isFocusOwner() && jTextField2.getText().isEmpty() || name.matches("LAST NAME, FIRST NAME MI.")) {
                st1 = " Name";
            }
            if (year == -1) {
                st2 = " Year of Birth";
            }
            if (sex.matches("None")) {
                st3 = " Sex";
            }
            if (address.matches("None")) {
                st4 = " Address";
            }
            if (jTextField4.isFocusOwner() && jTextField4.getText().isEmpty() || physician.matches("LAST NAME, FIRST NAME MI.")) {
                st5 = " Physician";
            }
            
            if (room.matches("None")) {
                st6 = " Room";
            }

            st = "Incomplete! Please input the following: \n";

            if (!st1.equals("")) {
                st += st1 + "\n";
            }
            if (!st2.equals("")) {
                st += st2 + "\n";
            }
            if (!st3.equals("")) {
                st += st3 + "\n";
            }
            if (!st4.equals("")) {
                st += st4 + "\n";
            }
            if (!st5.equals("")) {
                st += st6 + "\n";
            }
            if (!st6.equals("")) {
                st += st6 + "\n";
            }

            JOptionPane.showMessageDialog(null, st);
        }
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked

    }//GEN-LAST:event_jLabel23MouseClicked

    private void jComboBox15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox15FocusLost
        String tempmonth = jComboBox13.getSelectedItem().toString();
        String tempyear = jComboBox15.getSelectedItem().toString();
        String tempday = jComboBox14.getSelectedItem().toString();
        int month;
        int year;
        int day;
        if (!tempyear.equals("YYYY") && !tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = Integer.parseInt(tempmonth);
            day = Integer.parseInt(tempday);
        } else if (!tempyear.equals("YYYY") && !tempmonth.equals("MM") && tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = Integer.parseInt(tempmonth);
            day = 1;
        } else if (!tempyear.equals("YYYY") && tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = 1;
            day = Integer.parseInt(tempday);
        } else if (!tempyear.equals("YYYY") && tempmonth.equals("MM") && tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = 1;
            day = 1;
        } else if (tempyear.equals("YYYY") && !tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = 1900;
            month = Integer.parseInt(tempmonth);
            day = Integer.parseInt(tempday);
        } else if (tempyear.equals("YYYY") && !tempmonth.equals("MM") && tempday.equals("DD")) {
            year = 1900;
            month = Integer.parseInt(tempmonth);
            day = 1;
        } else if (tempyear.equals("YYYY") && tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = 1900;
            month = 1;
            day = Integer.parseInt(tempday);
        } else {
            year = 1900;
            month = 1;
            day = 1;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                jComboBox14.setSelectedIndex(30);
            }
        } else if (month == 2) {
            if (day > 28) {
                jComboBox14.setSelectedIndex(28);
            }
        }
    }//GEN-LAST:event_jComboBox15FocusLost

    private void jComboBox14FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox14FocusGained
        String tempmonth = jComboBox13.getSelectedItem().toString();
        String tempyear = jComboBox15.getSelectedItem().toString();
        int month;
        int year;
        if (!tempyear.equals("YYYY") && !tempmonth.equals("MM")) {
            year = Integer.parseInt(tempyear);
            month = Integer.parseInt(tempmonth);
        } else if (!tempyear.equals("YYYY") && tempmonth.equals("MM")) {
            year = Integer.parseInt(tempyear);
            month = 1;
        } else if (tempyear.equals("YYYY") && !tempmonth.equals("MM")) {
            year = 1900;
            month = Integer.parseInt(tempmonth);
        } else {
            year = 1900;
            month = 1;
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
        } else {
            jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
        }

        if (year % 4 != 0) {
            //common year
        } else if (year % 100 != 0) {
            //leap
            if (month == 2) {
                jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
            }
        } else if (year % 400 != 0) {
            // common
        } else {
            // leap
            if (month == 2) {
                jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
            }
        }

    }//GEN-LAST:event_jComboBox14FocusGained

    private void jComboBox27FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox27FocusGained
        String tempmonth = jComboBox26.getSelectedItem().toString();
        String tempyear = jComboBox28.getSelectedItem().toString();
        int month;
        int year;
        if (!tempyear.equals("YYYY") && !tempmonth.equals("MM")) {
            year = Integer.parseInt(tempyear);
            month = Integer.parseInt(tempmonth);
        } else if (!tempyear.equals("YYYY") && tempmonth.equals("MM")) {
            year = Integer.parseInt(tempyear);
            month = 1;
        } else if (tempyear.equals("YYYY") && !tempmonth.equals("MM")) {
            year = 1900;
            month = Integer.parseInt(tempmonth);
        } else {
            year = 1900;
            month = 1;
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
        } else {
            jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
        }

        if (year % 4 != 0) {
            //common year
        } else if (year % 100 != 0) {
            //leap
            if (month == 2) {
                jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
            }
        } else if (year % 400 != 0) {
            // common
        } else {
            // leap
            if (month == 2) {
                jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
            }
        }

    }//GEN-LAST:event_jComboBox27FocusGained

    private void jComboBox28FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox28FocusLost
        String tempmonth = jComboBox26.getSelectedItem().toString();
        String tempyear = jComboBox28.getSelectedItem().toString();
        String tempday = jComboBox27.getSelectedItem().toString();
        int month;
        int year;
        int day;
        if (!tempyear.equals("YYYY") && !tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = Integer.parseInt(tempmonth);
            day = Integer.parseInt(tempday);
        } else if (!tempyear.equals("YYYY") && !tempmonth.equals("MM") && tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = Integer.parseInt(tempmonth);
            day = 1;
        } else if (!tempyear.equals("YYYY") && tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = 1;
            day = Integer.parseInt(tempday);
        } else if (!tempyear.equals("YYYY") && tempmonth.equals("MM") && tempday.equals("DD")) {
            year = Integer.parseInt(tempyear);
            month = 1;
            day = 1;
        } else if (tempyear.equals("YYYY") && !tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = 1900;
            month = Integer.parseInt(tempmonth);
            day = Integer.parseInt(tempday);
        } else if (tempyear.equals("YYYY") && !tempmonth.equals("MM") && tempday.equals("DD")) {
            year = 1900;
            month = Integer.parseInt(tempmonth);
            day = 1;
        } else if (tempyear.equals("YYYY") && tempmonth.equals("MM") && !tempday.equals("DD")) {
            year = 1900;
            month = 1;
            day = Integer.parseInt(tempday);
        } else {
            year = 1900;
            month = 1;
            day = 1;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                jComboBox27.setSelectedIndex(30);
            }
        } else if (month == 2) {
            if (day > 28) {
                jComboBox27.setSelectedIndex(28);
            }
        }
    }//GEN-LAST:event_jComboBox28FocusLost

    private void jComboBox19FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox19FocusLost
        
    }//GEN-LAST:event_jComboBox19FocusLost

    private void jComboBox19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox19MouseClicked
        
    }//GEN-LAST:event_jComboBox19MouseClicked

    private void jComboBox19PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox19PropertyChange
        if (jComboBox19.getSelectedIndex() == 0) {
            jComboBox20.setEnabled(false);
            jComboBox21.setEnabled(false);
            jComboBox22.setEnabled(false);
            jComboBox23.setEnabled(false);
            jComboBox24.setEnabled(false);
            jComboBox25.setEnabled(false);
        } else {
            jComboBox20.setEnabled(true);
            jComboBox21.setEnabled(true);
            jComboBox22.setEnabled(true);
            jComboBox23.setEnabled(true);
            jComboBox24.setEnabled(true);
            jComboBox25.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox19PropertyChange

    private void jRadioButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton7MouseClicked
        if(jRadioButton8.isSelected() == true){
            jRadioButton8.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton7MouseClicked

    private void jRadioButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton8MouseClicked
        if(jRadioButton7.isSelected() == true){
            jRadioButton7.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton8MouseClicked

    private void jRadioButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton9MouseClicked
        if(jRadioButton10.isSelected() == true){
            jRadioButton10.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton9MouseClicked

    private void jRadioButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton10MouseClicked
        if(jRadioButton9.isSelected() == true){
            jRadioButton9.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton10MouseClicked

    private void jRadioButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton11MouseClicked
        if(jRadioButton12.isSelected() == true){
            jRadioButton12.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton11MouseClicked

    private void jRadioButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton12MouseClicked
        if(jRadioButton11.isSelected() == true){
            jRadioButton11.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButton12MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        DAOIntf di = new DAOImpl();
        ArrayList<Patient> daily = new ArrayList<>();
        
        String month = jComboBox26.getSelectedItem().toString();
        String day = jComboBox27.getSelectedItem().toString();
        String year = jComboBox28.getSelectedItem().toString();
        
        StringJoiner wholedate = new StringJoiner("-");
        wholedate.add(month);
        wholedate.add(day);
        wholedate.add(year);
        
        daily = di.censusDaily(wholedate.toString());
        refresh(daily);
    }//GEN-LAST:event_jLabel48MouseClicked

    public void refresh() {
        String today = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
        DateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
        Date date;
        String[] dateAdmitted;
        try {
            date = format1.parse(today);
            DateFormat format2 = new SimpleDateFormat("MMMM dd, yyyy");
            String dateString = format2.format(date);
            jLabel18.setText(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        DAOIntf di = new DAOImpl();
        ArrayList<Patient> allPatients = di.getAllPatients();
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
        model1.setRowCount(0);
        model2.setRowCount(0);
        model3.setRowCount(0);
        for (int i = 0; i < allPatients.size(); i++) {
            Patient pasyente = allPatients.get(i);
            Vector row = new Vector();
            Vector row2 = new Vector();
            Vector row3 = new Vector();
            row.add(pasyente.getPriority());
            row.add(pasyente.getPatientid());
            row.add(pasyente.getFullname());
            row.add(pasyente.getPhysician());
            row.add(pasyente.getDiagnosis());
            row.add(pasyente.getRoom());
            model1.addRow(row);
            row2.add(pasyente.getFullname());
            model2.addRow(row2);
            
            dateAdmitted = pasyente.getDateAdmitted().split(" ");
            if(today == dateAdmitted[0]) {
        
            row3.add(pasyente.getPatientid());
            row3.add(pasyente.getFullname());
            row3.add(pasyente.getBirthday());
            row3.add(pasyente.getSex());
            row3.add(pasyente.getPhilhealth());
            row3.add(pasyente.getPhysician());
            row3.add(pasyente.getDiagnosis());
            row3.add(pasyente.getRoom());
            model3.addRow(row3);
            }
        }
    }

    public void refresh(ArrayList<Patient> pasyenteList) {
        DAOIntf di = new DAOImpl();
        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel model3 = (DefaultTableModel) jTable3.getModel();
        model1.setRowCount(0);
        model2.setRowCount(0);
        model3.setRowCount(0);
        for (int i = 0; i < pasyenteList.size(); i++) {
            Patient pasyente = pasyenteList.get(i);
            Vector row = new Vector();
            Vector row2 = new Vector();
            Vector row3 = new Vector();
            row.add(pasyente.getPriority());
            row.add(pasyente.getPatientid());
            row.add(pasyente.getFullname());
            row.add(pasyente.getPhysician());
            row.add(pasyente.getDiagnosis());
            row.add(pasyente.getRoom());
            model1.addRow(row);
            row2.add(pasyente.getFullname());
            model2.addRow(row2);
        
            row3.add(pasyente.getPatientid());
            row3.add(pasyente.getFullname());
            row3.add(pasyente.getBirthday());
            row3.add(pasyente.getSex());
            row3.add(pasyente.getPhilhealth());
            row3.add(pasyente.getPhysician());
            row3.add(pasyente.getDiagnosis());
            row3.add(pasyente.getRoom());
            model3.addRow(row3);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DailyCensusUI;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MonthlyCensusUI;
    private javax.swing.JPanel NewPatientUI;
    private javax.swing.JPanel OldPatientsUI;
    private javax.swing.JPanel OptionsCensus;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.JPanel OptionsPatients;
    private javax.swing.JPanel PatientRecordUI;
    private javax.swing.JPanel SearchUI;
    private javax.swing.JPanel Today;
    private javax.swing.JPanel TodayUI;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox15;
    private javax.swing.JComboBox jComboBox16;
    private javax.swing.JComboBox jComboBox17;
    private javax.swing.JComboBox jComboBox18;
    private javax.swing.JComboBox jComboBox19;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox20;
    private javax.swing.JComboBox jComboBox21;
    private javax.swing.JComboBox jComboBox22;
    private javax.swing.JComboBox jComboBox23;
    private javax.swing.JComboBox jComboBox24;
    private javax.swing.JComboBox jComboBox25;
    private javax.swing.JComboBox jComboBox26;
    private javax.swing.JComboBox jComboBox27;
    private javax.swing.JComboBox jComboBox28;
    private javax.swing.JComboBox jComboBox29;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox30;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
