/*
 * ManageBook.java
 *
 * Created on 30 Maret 2008, 20:48
 */
package usu.perpustakaan.buku.widget.guest;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import usu.perpustakaan.buku.data.DefaultBookGuest;
import usu.perpustakaan.buku.widget.admin.ManageOperator;
import usu.perpustakaan.buku.widget.template.TableCellRenderChekBox;
import usu.perpustakaan.buku.widget.template.TableModelBookGuest;
import usu.perpustakaan.buku.widget.template.TextBoxGlass;
import usu.widget.ButtonGlass;

/**
 *
 * @author  usu
 */
public class ManageBook extends javax.swing.JPanel {

    private static final long serialVersionUID = -1;
    private TableModelBookGuest model;
    private DefaultBookGuest book;

    /** Creates new form ManageBook */
    public ManageBook() {
        model = new TableModelBookGuest();
        initComponents();
        table.setModel(model);
        for (int i = 0; i < table.getColumnCount() - 1; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ManageOperator.RenderTable());
        }
        table.getColumnModel().getColumn(table.getColumnCount() - 1).setCellRenderer(new TableCellRenderChekBox());
        textSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable(textSearch.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable(textSearch.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable(textSearch.getText());
            }
        });
    }

    /**
     * 
     * @return
     */
    public ButtonGlass getButtonFilter() {
        return buttonFilter;
    }

    /**
     * 
     * @param text
     */
    @SuppressWarnings("unchecked")
    public void filterTable(String text) {
        if (text.trim().equals("")) {
            ((TableRowSorter<TableModel>) table.getRowSorter()).setRowFilter(null);
        } else {
            ((TableRowSorter<TableModel>) table.getRowSorter()).setRowFilter(RowFilter.regexFilter(text));
        }
    }

    /**
     * 
     * @return
     */
    public DefaultBookGuest getBookGuest() {
        book = new DefaultBookGuest();
        if (!textAuthor.isEnabled()) {
            book.setAuthor(null);
        } else {
            book.setAuthor(textAuthor.getText());
        }
        if (!textBorrow.isEnabled()) {
            book.setBorrow(null);
        } else {
            book.setBorrow(textBorrow.isSelected());
        }
        if (!textId.isEnabled()) {
            book.setId(null);
        } else {
            book.setId(textId.getText());
        }
        if (!textKind.isEnabled()) {
            book.setKind(null);
        } else {
            book.setKind(textKind.getText());
        }
        if (!textPenerbit.isEnabled()) {
            book.setPublisher(null);
        } else {
            book.setPublisher(textPenerbit.getText());
        }
        if (!textTitle.isEnabled()) {
            book.setTitle(null);
        } else {
            book.setTitle(textTitle.getText());
        }
        return book;
    }

    /**
     * 
     * @return
     */
    public TableModelBookGuest getModel() {
        return model;
    }

    /**
     * 
     * @return
     */
    public ButtonGlass getButtonRefresh() {
        return buttonRefresh;
    }

    /**
     * 
     * @return
     */
    public JTable getTable() {
        return table;
    }

    /**
     * 
     * @return
     */
    public TextBoxGlass getTextSearch() {
        return textSearch;
    }

    /**
     * 
     * @param b
     */
    public void setFreeze(boolean b) {
        textSearch.setEnabled(!b);
        table.setEnabled(!b);
        buttonRefresh.setEnabled(!b);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usu.perpustakaan.buku.widget.template.ViewPortGlass viewPortGlass1 = new usu.perpustakaan.buku.widget.template.ViewPortGlass();
        table = new javax.swing.JTable();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        textSearch = new usu.perpustakaan.buku.widget.template.TextBoxGlass();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        buttonRefresh = new usu.widget.ButtonGlass();
        buttonFilter = new usu.widget.ButtonGlass();
        usu.perpustakaan.buku.widget.template.PanelTranparan panelTranparan1 = new usu.perpustakaan.buku.widget.template.PanelTranparan();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        textId = new usu.perpustakaan.buku.widget.template.TextBoxGlass();
        textTitle = new usu.perpustakaan.buku.widget.template.TextBoxGlass();
        textAuthor = new usu.perpustakaan.buku.widget.template.TextBoxGlass();
        textPenerbit = new usu.perpustakaan.buku.widget.template.TextBoxGlass();
        textKind = new usu.perpustakaan.buku.widget.template.TextBoxGlass();
        textBorrow = new javax.swing.JCheckBox();
        cekId = new javax.swing.JCheckBox();
        cektitle = new javax.swing.JCheckBox();
        cekauthor = new javax.swing.JCheckBox();
        cekpublisher = new javax.swing.JCheckBox();
        cekkind = new javax.swing.JCheckBox();
        cekborrow = new javax.swing.JCheckBox();

        viewPortGlass1.setView(table);

        table.setAutoCreateRowSorter(true);
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setToolTipText("Tabel buku");
        table.setFillsViewportHeight(true);
        table.setOpaque(false);
        table.setSelectionBackground(new java.awt.Color(51, 255, 52));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));

        setOpaque(false);

        jLabel1.setDisplayedMnemonic('C');
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cari (case sensitive) ");

        textSearch.setForeground(new java.awt.Color(255, 255, 255));
        textSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textSearch.setToolTipText("Masukkan kata yang akan dicari");
        textSearch.setFocusAccelerator('C');
        textSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewport(viewPortGlass1);

        buttonRefresh.setMnemonic('S');
        buttonRefresh.setText("Segarkan");
        buttonRefresh.setToolTipText("Klik untuk meload ulang seluruh buku");
        buttonRefresh.setRoundRect(true);

        buttonFilter.setMnemonic('A');
        buttonFilter.setText("Saring");
        buttonFilter.setToolTipText("Klik untuk memulai penyaringan data buku");
        buttonFilter.setRoundRect(true);

        panelTranparan1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelTranparan1.setRound(false);

        jLabel2.setDisplayedMnemonic('I');
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id");

        jLabel3.setDisplayedMnemonic('J');
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Judul");

        jLabel4.setDisplayedMnemonic('P');
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pengarang");

        jLabel5.setDisplayedMnemonic('E');
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Penerbit");

        jLabel6.setDisplayedMnemonic('J');
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jenis Buku");

        jLabel7.setDisplayedMnemonic('D');
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Dipinjam");

        textId.setForeground(new java.awt.Color(255, 255, 255));
        textId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textId.setToolTipText("Masukkan id buku yang akan dicari");
        textId.setFocusAccelerator('I');
        textId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        textTitle.setForeground(new java.awt.Color(255, 255, 255));
        textTitle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textTitle.setToolTipText("Masukkan judul buku yang akan dicari");
        textTitle.setFocusAccelerator('J');
        textTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        textAuthor.setForeground(new java.awt.Color(255, 255, 255));
        textAuthor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textAuthor.setToolTipText("Masukkan nama pengarang buku yang akan dicari");
        textAuthor.setFocusAccelerator('P');
        textAuthor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        textPenerbit.setForeground(new java.awt.Color(255, 255, 255));
        textPenerbit.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPenerbit.setToolTipText("Masukkan penerbit buku yang akan dicari");
        textPenerbit.setFocusAccelerator('E');
        textPenerbit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        textKind.setForeground(new java.awt.Color(255, 255, 255));
        textKind.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textKind.setToolTipText("Masukkan jenis buku yang akan dicari");
        textKind.setFocusAccelerator('J');
        textKind.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        textBorrow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        textBorrow.setForeground(new java.awt.Color(255, 255, 255));
        textBorrow.setMnemonic('D');
        textBorrow.setSelected(true);
        textBorrow.setText("Sedang Dipinjam");
        textBorrow.setToolTipText("Cek untuk merubah dipinjam atau tidak dipinjam");
        textBorrow.setOpaque(false);
        textBorrow.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                textBorrowItemStateChanged(evt);
            }
        });

        cekId.setSelected(true);
        cekId.setToolTipText("");
        cekId.setOpaque(false);
        cekId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cekIdItemStateChanged(evt);
            }
        });

        cektitle.setSelected(true);
        cektitle.setOpaque(false);
        cektitle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cektitleItemStateChanged(evt);
            }
        });

        cekauthor.setSelected(true);
        cekauthor.setOpaque(false);
        cekauthor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cekauthorItemStateChanged(evt);
            }
        });

        cekpublisher.setSelected(true);
        cekpublisher.setOpaque(false);
        cekpublisher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cekpublisherItemStateChanged(evt);
            }
        });

        cekkind.setSelected(true);
        cekkind.setOpaque(false);
        cekkind.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cekkindItemStateChanged(evt);
            }
        });

        cekborrow.setSelected(true);
        cekborrow.setToolTipText("");
        cekborrow.setOpaque(false);
        cekborrow.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cekborrowItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelTranparan1Layout = new javax.swing.GroupLayout(panelTranparan1);
        panelTranparan1.setLayout(panelTranparan1Layout);
        panelTranparan1Layout.setHorizontalGroup(
            panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranparan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textKind, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(textPenerbit, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(textAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(textTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(textId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(textBorrow, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cekId)
                    .addComponent(cektitle)
                    .addComponent(cekauthor)
                    .addComponent(cekpublisher)
                    .addComponent(cekkind)
                    .addComponent(cekborrow))
                .addContainerGap())
        );
        panelTranparan1Layout.setVerticalGroup(
            panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranparan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekId)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cektitle)
                    .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekauthor)
                    .addComponent(textAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekpublisher)
                    .addComponent(textPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekkind)
                    .addComponent(textKind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTranparan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekborrow)
                    .addComponent(jLabel7)
                    .addComponent(textBorrow))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTranparan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                        .addComponent(buttonFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTranparan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void cekIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cekIdItemStateChanged
    textId.setEnabled(cekId.isSelected());
}//GEN-LAST:event_cekIdItemStateChanged

private void cektitleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cektitleItemStateChanged
    textTitle.setEnabled(cektitle.isSelected());
}//GEN-LAST:event_cektitleItemStateChanged

private void cekauthorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cekauthorItemStateChanged
    textAuthor.setEnabled(cekauthor.isSelected());
}//GEN-LAST:event_cekauthorItemStateChanged

private void cekpublisherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cekpublisherItemStateChanged
    textPenerbit.setEnabled(cekpublisher.isSelected());
}//GEN-LAST:event_cekpublisherItemStateChanged

private void cekkindItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cekkindItemStateChanged
    textKind.setEnabled(cekkind.isSelected());
}//GEN-LAST:event_cekkindItemStateChanged

private void cekborrowItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cekborrowItemStateChanged
    textBorrow.setEnabled(cekborrow.isSelected());
}//GEN-LAST:event_cekborrowItemStateChanged

private void textBorrowItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_textBorrowItemStateChanged
    if (textBorrow.isSelected()) {
        textBorrow.setText("Sedang Dipinjam");
    } else {
        textBorrow.setText("Tidak Dipinjam");
    }
}//GEN-LAST:event_textBorrowItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    usu.widget.ButtonGlass buttonFilter;
    usu.widget.ButtonGlass buttonRefresh;
    javax.swing.JCheckBox cekId;
    javax.swing.JCheckBox cekauthor;
    javax.swing.JCheckBox cekborrow;
    javax.swing.JCheckBox cekkind;
    javax.swing.JCheckBox cekpublisher;
    javax.swing.JCheckBox cektitle;
    javax.swing.JTable table;
    usu.perpustakaan.buku.widget.template.TextBoxGlass textAuthor;
    javax.swing.JCheckBox textBorrow;
    usu.perpustakaan.buku.widget.template.TextBoxGlass textId;
    usu.perpustakaan.buku.widget.template.TextBoxGlass textKind;
    usu.perpustakaan.buku.widget.template.TextBoxGlass textPenerbit;
    usu.perpustakaan.buku.widget.template.TextBoxGlass textSearch;
    usu.perpustakaan.buku.widget.template.TextBoxGlass textTitle;
    // End of variables declaration//GEN-END:variables
}
