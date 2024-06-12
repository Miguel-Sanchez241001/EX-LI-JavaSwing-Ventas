/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatgpt;

/**
 *
 * @author AUTONOMA
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioDeCompras extends JFrame {

    private JTextField numField, fechaField, horaField;
    private JTextField idField, nombresField, apellidosField;
    private JTextField idProvField, desProvField, dirProvField;
    private JTextField idArtField, desArtField, pcoField, canField, totalField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField totalGeneralField;

    public FormularioDeCompras() {
        setTitle("Formulario de Compras");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 1));
        add(panel, BorderLayout.NORTH);

        // Primera fila: Número, Fecha, Hora
        JPanel fila1 = new JPanel(new FlowLayout());
        fila1.add(new JLabel("Número:"));
        numField = new JTextField(10);
        fila1.add(numField);
        fila1.add(new JLabel("Fecha:"));
        fechaField = new JTextField(10);
        fila1.add(fechaField);
        fila1.add(new JLabel("Hora:"));
        horaField = new JTextField(10);
        fila1.add(horaField);
        panel.add(fila1);

        // Segunda fila: Datos de Funcionarios
        JPanel fila2 = new JPanel(new FlowLayout());
        fila2.add(new JLabel("ID:"));
        idField = new JTextField(5);
        fila2.add(idField);
        fila2.add(new JLabel("Nombres:"));
        nombresField = new JTextField(10);
        fila2.add(nombresField);
        fila2.add(new JLabel("Apellidos:"));
        apellidosField = new JTextField(10);
        fila2.add(apellidosField);
        panel.add(fila2);

        // Tercera fila: Datos de Proveedor
        JPanel fila3 = new JPanel(new FlowLayout());
        fila3.add(new JLabel("ID Proveedor:"));
        idProvField = new JTextField(5);
        fila3.add(idProvField);
        fila3.add(new JLabel("Descripción:"));
        desProvField = new JTextField(10);
        fila3.add(desProvField);
        fila3.add(new JLabel("Dirección:"));
        dirProvField = new JTextField(10);
        fila3.add(dirProvField);
        panel.add(fila3);

        // Cuarta fila: Datos de Artículo
        JPanel fila4 = new JPanel(new FlowLayout());
        fila4.add(new JLabel("ID Artículo:"));
        idArtField = new JTextField(5);
        fila4.add(idArtField);
        fila4.add(new JLabel("Descripción:"));
        desArtField = new JTextField(10);
        fila4.add(desArtField);
        fila4.add(new JLabel("Precio de Compra:"));
        pcoField = new JTextField(5);
        fila4.add(pcoField);
        fila4.add(new JLabel("Stock:"));
        canField = new JTextField(5);
        fila4.add(canField);
        fila4.add(new JLabel("Cantidad:"));
        totalField = new JTextField(5);
        fila4.add(totalField);
        panel.add(fila4);

        // Quinta fila: Botones Agregar y Eliminar
        JPanel fila5 = new JPanel(new FlowLayout());
        JButton agregarButton = new JButton("Agregar");
        fila5.add(agregarButton);
        JButton eliminarButton = new JButton("Eliminar");
        fila5.add(eliminarButton);
        panel.add(fila5);

        // Sexta fila: Tabla de artículos
        String[] columnNames = {"ID", "Artículo", "Precio de Compra", "Cantidad", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Botones de control
        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton nuevoButton = new JButton("Nuevo");
        controlPanel.add(nuevoButton);
        JButton guardarButton = new JButton("Guardar");
        controlPanel.add(guardarButton);
        JButton cancelarButton = new JButton("Cancelar");
        controlPanel.add(cancelarButton);
        JLabel totalGeneralLabel = new JLabel("Total General:");
        controlPanel.add(totalGeneralLabel);
        totalGeneralField = new JTextField(10);
        controlPanel.add(totalGeneralField);
        add(controlPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idArt = idArtField.getText();
                String desArt = desArtField.getText();
                String pco = pcoField.getText();
                String can = canField.getText();
                String total = totalField.getText();

                tableModel.addRow(new Object[]{idArt, desArt, pco, can, total});
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para limpiar todos los campos
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código para guardar los datos
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioDeCompras().setVisible(true);
            }
        });
    }
}

