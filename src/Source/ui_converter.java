package Source;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ui_converter extends javax.swing.JFrame {
    static String fileName = "";
    static double fileSize = 0;

    public ui_converter() {
        this.setIconImage(new ImageIcon(getClass().getResource("pspvideotool_icon.png")).getImage());
        initComponents();
    }

    public void disableUI() {
        input_file.setEnabled(false);
        output_path.setEnabled(false);
        btn_input_search.setEnabled(false);
        btn_output_path.setEnabled(false);
        btn_convert.setEnabled(false);
        btn_info.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ui_log = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        input_file = new javax.swing.JTextField();
        output_path = new javax.swing.JTextField();
        btn_input_search = new javax.swing.JButton();
        btn_output_path = new javax.swing.JButton();
        btn_convert = new javax.swing.JButton();
        status_thumbnail = new javax.swing.JLabel();
        status_filename = new javax.swing.JLabel();
        status_filesize = new javax.swing.JLabel();
        btn_info = new javax.swing.JButton();

        ui_log.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        ui_log.setTitle("Working...");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Converting video...");

        javax.swing.GroupLayout ui_logLayout = new javax.swing.GroupLayout(ui_log.getContentPane());
        ui_log.getContentPane().setLayout(ui_logLayout);
        ui_logLayout.setHorizontalGroup(
            ui_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ui_logLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        ui_logLayout.setVerticalGroup(
            ui_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ui_logLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PSP Video Converter Tool v1.0");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paths"));

        jLabel1.setText("Input video file:");

        jLabel2.setText("Output path:");

        input_file.setToolTipText("Supported formats: MP4, MKV, AVI, MOV, FLV, WEBM");

        btn_input_search.setText("Search");
        btn_input_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_input_searchActionPerformed(evt);
            }
        });

        btn_output_path.setText("Search");
        btn_output_path.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_output_pathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(output_path, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_output_path))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(input_file, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_input_search)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(input_file, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_input_search))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(output_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_output_path))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btn_convert.setText("Convert");
        btn_convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_convertActionPerformed(evt);
            }
        });

        status_thumbnail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        status_filename.setText("File name:");

        status_filesize.setText("File size:");

        btn_info.setText("?");
        btn_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_infoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_info)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_convert, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(status_filesize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(status_filename, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(status_thumbnail, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(status_thumbnail, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_convert, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(status_filename)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status_filesize))
                    .addComponent(btn_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_output_pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_output_pathActionPerformed
        try {
            JFileChooser output_choose = new JFileChooser();
            output_choose.setCurrentDirectory(new java.io.File("."));
            output_choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            output_choose.setApproveButtonText("Select folder");
            output_choose.showOpenDialog(null);
            File file_output_path = output_choose.getSelectedFile();
            output_path.setText(file_output_path.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_output_pathActionPerformed

    private void btn_input_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_input_searchActionPerformed
        status_thumbnail.setIcon(new javax.swing.ImageIcon());
        File thumbnail_path = new File("bin\\thumbnail.jpg");
        JFileChooser input_file_choose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Video files", "mp4", "avi", "webm", "mkv", "mov", "flv");
        input_file_choose.setFileFilter(filter);

        int result = input_file_choose.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = input_file_choose.getSelectedFile();
            input_file.setText(selectedFile.getAbsolutePath());
            fileName = selectedFile.getName();
            long temp_size = selectedFile.length();
            fileSize = temp_size / (1024.0 * 1024.0);
            DecimalFormat df = new DecimalFormat("#.##");
            String fileSizeFormatted = df.format(fileSize);
            status_filename.setText("File name: " + fileName);
            status_filesize.setText("File size: " + fileSizeFormatted + " MB");

            try {
                String[] command = {"bin/ffmpeg.exe", "-i", input_file.getText(), "-ss", "00:00:01.000", "-vframes", "1", "-vf", "scale=155:145", "\"bin\\thumbnail_" + fileName + ".jpg\""};

                // Crear el proceso
                ProcessBuilder processBuilder = new ProcessBuilder(command);
                    // Iniciar el proceso
                    Process process = processBuilder.start();
                Thread.sleep(2000);
            } catch (IOException | InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            status_thumbnail.setIcon(new javax.swing.ImageIcon("bin\\thumbnail_" + fileName + ".jpg"));
        } else {
            System.out.println("File not selected.");
        }
    }//GEN-LAST:event_btn_input_searchActionPerformed

    private void btn_convertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_convertActionPerformed
        ui_log.setVisible(true);
        ui_log.setLocationRelativeTo(null);
        try {
            String[] command = {
                "bin/ffmpeg.exe",
                "-i", input_file.getText(),
                "-c:a", "aac",
                "-c:v", "libx264",
                "-profile:v", "main",
                "-level:v", "3.0",
                "-x264opts", "ref=3:b-pyramid=none:weightp=1",
                "-r", "29.97",
                "-s", "480x272",
                "-pix_fmt", "yuv420p",
                "-b:v", "768k",
                "-ar", "48000",
                "-ab", "192k",
                output_path.getText() + "\\PSP" + fileName
            };

            // Crear el proceso
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            // Redirigir la salida de error para poder capturarla
            processBuilder.redirectErrorStream(true);
            // Iniciar el proceso
            Process process = processBuilder.start();

            // Leer la salida del proceso
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                ui_log.dispose();
                JOptionPane.showMessageDialog(null, "Video converted succesfully!", "Done!", 1);
            } else {
                System.out.println("Error during convertion: " + exitCode);
            }
        } catch (IOException | InterruptedException ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_convertActionPerformed

    private void btn_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_infoActionPerformed
        JOptionPane.showMessageDialog(null, "Developed by Rammaken\nVersion: 1.0\n\nUsed libraries:\n- ffmpeg", "Information", 1);
    }//GEN-LAST:event_btn_infoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ui_converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ui_converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ui_converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ui_converter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ui_converter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_convert;
    private javax.swing.JButton btn_info;
    private javax.swing.JButton btn_input_search;
    private javax.swing.JButton btn_output_path;
    private javax.swing.JTextField input_file;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField output_path;
    private javax.swing.JLabel status_filename;
    private javax.swing.JLabel status_filesize;
    private javax.swing.JLabel status_thumbnail;
    private javax.swing.JDialog ui_log;
    // End of variables declaration//GEN-END:variables
}
