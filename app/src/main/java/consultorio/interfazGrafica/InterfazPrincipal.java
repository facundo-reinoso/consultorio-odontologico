/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package consultorio.interfazGrafica;

/**
 *
 * @author facun
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form InterfazPrincipal
     */
    public InterfazPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menuAgregarPaciente = new javax.swing.JMenu();
        menuAgregarOdontologo = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        menuEliminarPaciente = new javax.swing.JMenu();
        menuEliminarOdontologo = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuListaPaciente = new javax.swing.JMenu();
        menuListaOdontologo = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        menuVerAgendas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelEscritorioLayout = new javax.swing.GroupLayout(panelEscritorio);
        panelEscritorio.setLayout(panelEscritorioLayout);
        panelEscritorioLayout.setHorizontalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelEscritorioLayout.setVerticalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        jMenu4.setText("Agregar");

        menuAgregarPaciente.setText("Paciente");
        menuAgregarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAgregarPacienteMouseClicked(evt);
            }
        });
        jMenu4.add(menuAgregarPaciente);

        menuAgregarOdontologo.setText("Odontologo");
        menuAgregarOdontologo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAgregarOdontologoMouseClicked(evt);
            }
        });
        jMenu4.add(menuAgregarOdontologo);

        jMenu1.add(jMenu4);

        jMenu6.setText("Eliminar");

        menuEliminarPaciente.setText("Paciente");
        menuEliminarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEliminarPacienteMouseClicked(evt);
            }
        });
        jMenu6.add(menuEliminarPaciente);

        menuEliminarOdontologo.setText("Odontologo");
        menuEliminarOdontologo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEliminarOdontologoMouseClicked(evt);
            }
        });
        jMenu6.add(menuEliminarOdontologo);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Ver");

        menuListaPaciente.setText("Lista Pacientes");
        menuListaPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuListaPacienteMouseClicked(evt);
            }
        });
        jMenu3.add(menuListaPaciente);

        menuListaOdontologo.setText("Lista Odontologos");
        menuListaOdontologo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuListaOdontologoMouseClicked(evt);
            }
        });
        jMenu3.add(menuListaOdontologo);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Agenda");

        menuVerAgendas.setText("Ver Agendas");
        menuVerAgendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuVerAgendasMouseClicked(evt);
            }
        });
        jMenu2.add(menuVerAgendas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAgregarOdontologoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAgregarOdontologoMouseClicked
        VentanaAgregarOdontologo v = new VentanaAgregarOdontologo();
        panelEscritorio.add(v);
        v.show();
    }//GEN-LAST:event_menuAgregarOdontologoMouseClicked

    private void menuAgregarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAgregarPacienteMouseClicked
        VentanaAgregarPaciente v = new VentanaAgregarPaciente();
        panelEscritorio.add(v);
        v.show();
    }//GEN-LAST:event_menuAgregarPacienteMouseClicked

    private void menuEliminarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEliminarPacienteMouseClicked
        VentanaEliminarPaciente v = new VentanaEliminarPaciente();
        panelEscritorio.add(v);
        v.show();
    }//GEN-LAST:event_menuEliminarPacienteMouseClicked

    private void menuEliminarOdontologoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEliminarOdontologoMouseClicked
        VentanaEliminarOdontologo v = new VentanaEliminarOdontologo();
        panelEscritorio.add(v);
        v.show();
    }//GEN-LAST:event_menuEliminarOdontologoMouseClicked

    private void menuListaPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuListaPacienteMouseClicked
        VentanaListaPacientes v = new VentanaListaPacientes();
        panelEscritorio.add(v);
        v.show();
    }//GEN-LAST:event_menuListaPacienteMouseClicked

    private void menuListaOdontologoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuListaOdontologoMouseClicked
        VentanaListaOdontologos v = new VentanaListaOdontologos();
        panelEscritorio.add(v);
        v.show();
    }//GEN-LAST:event_menuListaOdontologoMouseClicked

    private void menuVerAgendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVerAgendasMouseClicked
        VentanaAgenda v = new VentanaAgenda();
        panelEscritorio.add(v);
        v.show();
    }//GEN-LAST:event_menuVerAgendasMouseClicked

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
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAgregarOdontologo;
    private javax.swing.JMenu menuAgregarPaciente;
    private javax.swing.JMenu menuEliminarOdontologo;
    private javax.swing.JMenu menuEliminarPaciente;
    private javax.swing.JMenu menuListaOdontologo;
    private javax.swing.JMenu menuListaPaciente;
    private javax.swing.JMenu menuVerAgendas;
    public static javax.swing.JDesktopPane panelEscritorio;
    // End of variables declaration//GEN-END:variables
}
