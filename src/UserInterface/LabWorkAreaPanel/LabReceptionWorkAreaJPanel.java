/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.LabWorkAreaPanel;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.LabWorkQueueArea.RequestLabWorkAreaRequest;
import Business.LabWorkQueueArea.RequestLabWorkRequest;
import Business.Network.Network;
import Business.Organisation.DoctorOrganization;
import Business.Organisation.LabReceptionOrganization;
import Business.Organisation.Organization;
import Business.RequestBloodWorkQueue.RequestBloodFromDoctorWorkRequest;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puja_
 */
public class LabReceptionWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private Business business;
    private Organization organization;
    private LabReceptionOrganization labReceptionorganization;
    /**
     * Creates new form LabReceptionWorkAreaJPanel
     */
    public LabReceptionWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, LabReceptionOrganization labReceptionorganization, Enterprise enterprise, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business= business;
        this.labReceptionorganization = labReceptionorganization;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model1 = (DefaultTableModel) labrequestJTable.getModel();
         model1.setRowCount(0);
         for(RequestLabWorkAreaRequest rlwar :labReceptionorganization.getReceiveLabRequest().getLabWorkRequestList() ){
             Object[] row = new Object[6];
             row[0] = rlwar;
             row[1] = rlwar.getTestType();
             row[2]= rlwar.getSender();
             row[3] = rlwar.getReceiver();
             row[4] = rlwar.getStatus();
             row[5] = rlwar.getResult();
             model1.addRow(row);
         }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        labrequestJTable = new javax.swing.JTable();
        sendBtn = new javax.swing.JButton();
        SendToDoctorBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 248, 248));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pathology Lab Reception Work Area");

        labrequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Test Type", "Sender", "Receiver", "Status", "Result"
            }
        ));
        jScrollPane1.setViewportView(labrequestJTable);

        sendBtn.setBackground(new java.awt.Color(0, 153, 153));
        sendBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendBtn.setText("Send To Lab Assistant ");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        SendToDoctorBtn.setBackground(new java.awt.Color(0, 153, 153));
        SendToDoctorBtn.setForeground(new java.awt.Color(255, 255, 255));
        SendToDoctorBtn.setText("Send result to Doctor");
        SendToDoctorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendToDoctorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SendToDoctorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sendBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(144, 144, 144)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendBtn)
                    .addComponent(SendToDoctorBtn))
                .addContainerGap(235, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
    int selectedRow = labrequestJTable.getSelectedRow();
    if(selectedRow < 0)
    {
        JOptionPane.showMessageDialog(null,"No Request Selected");
         return;
    }
    RequestLabWorkAreaRequest rowr = (RequestLabWorkRequest)labrequestJTable.getModel().getValueAt(selectedRow, 0);
    rowr.setStatus("Sent to Lab Test Request Assistant");
    }//GEN-LAST:event_sendBtnActionPerformed

    private void SendToDoctorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendToDoctorBtnActionPerformed
int selectedRow = labrequestJTable.getSelectedRow();
if(selectedRow < 0)
{
    JOptionPane.showMessageDialog(null,"No Request Selected");
    return;
}
RequestLabWorkRequest workRequest = (RequestLabWorkRequest)labrequestJTable.getModel().getValueAt(selectedRow, 0);
for(Network network: business.getNetworkList() )
{
   for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList())
   {
       if(enterprise instanceof HospitalEnterprise)
       {
           for(Organization organization: enterprise.getOrganizationDirectory().getOrganizationList())
           {
               if(organization instanceof DoctorOrganization)
               {
                    
        workRequest.setSender(account);
        workRequest.setStatus("lab result received by doctor");
        workRequest.getGdwr().setStatus("lab result received by doctor");
               }
           }
       }
   }
}
DefaultTableModel model1 = (DefaultTableModel) labrequestJTable.getModel();
model1.removeRow(selectedRow);        // TODO add your handling code here:
    }//GEN-LAST:event_SendToDoctorBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SendToDoctorBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable labrequestJTable;
    private javax.swing.JButton sendBtn;
    // End of variables declaration//GEN-END:variables
}
