package org.example.adapters.ui;

import org.example.adapters.persistence.HibernateMiembroRepositoryAdapter;
import org.example.application.MiembroServiceImpl;
import org.example.domain.Miembro;
import org.example.ports.in.MiembroServicePort;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MiembroUIFrame extends JFrame {
    private MiembroServicePort miembroService = new MiembroServiceImpl(new HibernateMiembroRepositoryAdapter());
    private JTextField nombreActualizarField;
    private JTextField apellidoActualizarField;
    private JTextField edadActualizarField;
    private JTextField numeroMembresiaActualizarField;
    private JTextArea registroEntradasArea;

    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JTextField numeroMembresiaField;
    private JTextArea miembrosArea;

    public MiembroUIFrame() {
        setTitle("Aplicación de Registro de Miembros");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel de Registro
        JPanel registroPanel = new JPanel(new GridBagLayout());
        registroPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        registroPanel.setBackground(new Color(107, 185, 240)); // Color azul claro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        nombreField = new JTextField(20);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setForeground(Color.WHITE);
        apellidoField = new JTextField(20);

        JLabel edadLabel = new JLabel("Edad:");
        edadLabel.setForeground(Color.WHITE);
        edadField = new JTextField(20);

        JLabel numeroMembresiaLabel = new JLabel("Número de membresía (Cédula):");
        numeroMembresiaLabel.setForeground(Color.WHITE);
        numeroMembresiaField = new JTextField(20);

        JButton registrarButton = new JButton("Registrar Miembro");
        registrarButton.setBackground(new Color(0, 120, 215));
        registrarButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        registroPanel.add(nombreLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        registroPanel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        registroPanel.add(apellidoLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        registroPanel.add(apellidoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        registroPanel.add(edadLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        registroPanel.add(edadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        registroPanel.add(numeroMembresiaLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        registroPanel.add(numeroMembresiaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        registroPanel.add(registrarButton, gbc);




// Panel de Actualización
        JPanel actualizarPanel = new JPanel(new GridBagLayout());
        actualizarPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        actualizarPanel.setBackground(new Color(107, 185, 240)); // Color azul claro

        GridBagConstraints gbcActualizar = new GridBagConstraints();
        gbcActualizar.insets = new Insets(5, 5, 5, 5);

        JLabel numeroMembresiaActualizarLabel = new JLabel("Número de membresía (Cédula):");
        numeroMembresiaActualizarLabel.setForeground(Color.WHITE);
        JTextField numeroMembresiaActualizarField = new JTextField(20);

        JLabel nombreActualizarLabel = new JLabel("Nombre:");
        nombreActualizarLabel.setForeground(Color.WHITE);
        JTextField nombreActualizarField = new JTextField(20);

        JLabel apellidoActualizarLabel = new JLabel("Apellido:");
        apellidoActualizarLabel.setForeground(Color.WHITE);
        JTextField apellidoActualizarField = new JTextField(20);

        JLabel edadActualizarLabel = new JLabel("Edad:");
        edadActualizarLabel.setForeground(Color.WHITE);
        JTextField edadActualizarField = new JTextField(20);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBackground(new Color(0, 120, 215));
        buscarButton.setForeground(Color.WHITE);

        JButton actualizarButton = new JButton("Actualizar Miembro");
        actualizarButton.setBackground(new Color(0, 120, 215));
        actualizarButton.setForeground(Color.WHITE);

        gbcActualizar.gridx = 0;
        gbcActualizar.gridy = 0;
        gbcActualizar.anchor = GridBagConstraints.EAST;
        actualizarPanel.add(numeroMembresiaActualizarLabel, gbcActualizar);

        gbcActualizar.gridx = 1;
        gbcActualizar.anchor = GridBagConstraints.WEST;
        actualizarPanel.add(numeroMembresiaActualizarField, gbcActualizar);

        gbcActualizar.gridx = 0;
        gbcActualizar.gridy = 1;
        gbcActualizar.anchor = GridBagConstraints.EAST;
        actualizarPanel.add(nombreActualizarLabel, gbcActualizar);

        gbcActualizar.gridx = 1;
        gbcActualizar.anchor = GridBagConstraints.WEST;
        actualizarPanel.add(nombreActualizarField, gbcActualizar);

        gbcActualizar.gridx = 0;
        gbcActualizar.gridy = 2;
        gbcActualizar.anchor = GridBagConstraints.EAST;
        actualizarPanel.add(apellidoActualizarLabel, gbcActualizar);

        gbcActualizar.gridx = 1;
        gbcActualizar.anchor = GridBagConstraints.WEST;
        actualizarPanel.add(apellidoActualizarField, gbcActualizar);

        gbcActualizar.gridx = 0;
        gbcActualizar.gridy = 3;
        gbcActualizar.anchor = GridBagConstraints.EAST;
        actualizarPanel.add(edadActualizarLabel, gbcActualizar);

        gbcActualizar.gridx = 1;
        gbcActualizar.anchor = GridBagConstraints.WEST;
        actualizarPanel.add(edadActualizarField, gbcActualizar);

        gbcActualizar.gridx = 0;
        gbcActualizar.gridy = 4;
        gbcActualizar.gridwidth = 2;
        gbcActualizar.anchor = GridBagConstraints.CENTER;
        actualizarPanel.add(buscarButton, gbcActualizar);

        gbcActualizar.gridy = 5;
        actualizarPanel.add(actualizarButton, gbcActualizar);


// Panel de Entrada al Gimnasio
        JPanel entradaPanel = new JPanel(new GridBagLayout());
        entradaPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        entradaPanel.setBackground(new Color(120, 180, 120)); // Color verde claro

        JLabel numeroMembresiaEntradaLabel = new JLabel("Número de membresía (Cédula):");
        numeroMembresiaEntradaLabel.setForeground(Color.WHITE);
        JTextField numeroMembresiaEntradaField = new JTextField(20);

        JButton entradaButton = new JButton("Entrada al Gimnasio");
        entradaButton.setBackground(new Color(0, 150, 136)); // Color verde oscuro
        entradaButton.setForeground(Color.WHITE);

        JButton salidaButton = new JButton("Salida del Gimnasio");
        salidaButton.setBackground(new Color(255, 87, 34)); // Color naranja
        salidaButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        entradaPanel.add(numeroMembresiaEntradaLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        entradaPanel.add(numeroMembresiaEntradaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        entradaPanel.add(entradaButton, gbc);

        gbc.gridy = 2;
        entradaPanel.add(salidaButton, gbc);

// Agregar el panel de entrada al gimnasio al tabbedPane
        tabbedPane.addTab("Entrada", entradaPanel);

// Acciones de los botones
        entradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroMembresia = numeroMembresiaEntradaField.getText();
                boolean estaRegistrado = verificarMembresiaRegistrada(numeroMembresia);
                if (estaRegistrado) {
                    JOptionPane.showMessageDialog(MiembroUIFrame.this, "¡Bienvenido al gimnasio!");
                } else {
                    JOptionPane.showMessageDialog(MiembroUIFrame.this, "Lo sentimos, su número de membresía no está registrado.");
                }
            }
        });
        salidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroMembresia = JOptionPane.showInputDialog(MiembroUIFrame.this, "Ingrese el número de membresía del miembro que sale del gimnasio:");

                if (numeroMembresia != null && !numeroMembresia.isEmpty()) {
                    // Verificar si el número de membresía está registrado
                    if (verificarMembresiaRegistrada(numeroMembresia)) {
                        // Obtener la hora actual
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        String horaSalida = sdf.format(new Date());

                        // Agregar el registro de salida al JTextArea
                        registroEntradasArea.append("Usuario con número de membresía " + numeroMembresia + " salió a las " + horaSalida + "\n");


                        // Limpiar el campo de número de membresía
                        numeroMembresiaField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(MiembroUIFrame.this, "El número de membresía no está registrado.");
                    }
                }
            }
        });

        // Panel de Eliminación
        JPanel eliminarPanel = new JPanel(new GridBagLayout());
        eliminarPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        eliminarPanel.setBackground(new Color(255, 138, 101)); // Color naranja claro

        JLabel eliminarNumeroMembresiaLabel = new JLabel("Número de membresía (Cédula):");
        eliminarNumeroMembresiaLabel.setForeground(Color.WHITE);
        JTextField eliminarNumeroMembresiaField = new JTextField(20);

        JButton eliminarButton = new JButton("Ingrese la cedula del cliente");
        eliminarButton.setBackground(new Color(255, 69, 58));
        eliminarButton.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        eliminarPanel.add(eliminarNumeroMembresiaLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        eliminarPanel.add(eliminarNumeroMembresiaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        eliminarPanel.add(eliminarButton, gbc);

        // Panel de Mostrar Miembros
        JPanel mostrarPanel = new JPanel(new BorderLayout(10, 10));
        mostrarPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mostrarPanel.setBackground(new Color(255, 211, 105)); // Color amarillo claro

        miembrosArea = new JTextArea();
        miembrosArea.setEditable(false);
        miembrosArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPanel = new JScrollPane(miembrosArea);
        JButton mostrarButton = new JButton("Mostrar Todos los Miembros");
        mostrarButton.setBackground(new Color(0, 150, 136));
        mostrarButton.setForeground(Color.WHITE);

        mostrarPanel.add(scrollPanel, BorderLayout.CENTER);
        mostrarPanel.add(mostrarButton, BorderLayout.SOUTH);

        // Añadir los paneles al tabbedPane
        tabbedPane.addTab("Registrar", registroPanel);
        tabbedPane.addTab("Actualizar datos", actualizarPanel);
        tabbedPane.addTab("Eliminar", eliminarPanel);
        tabbedPane.addTab("Mostrar miembros", mostrarPanel);

        // Añadir el tabbedPane al JFrame
        add(tabbedPane);

        // Acciones de los botones
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int edad = Integer.parseInt(edadField.getText());
                int numeroMembresia = Integer.parseInt(numeroMembresiaField.getText());

                Miembro miembro = new Miembro(nombre, apellido, edad, numeroMembresia);
                miembroService.registrarMiembro(miembro);
                JOptionPane.showMessageDialog(MiembroUIFrame.this, "Miembro registrado correctamente.");
                limpiarCampos();
            }
        });


        // Acciones de los botones
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroMembresia = Integer.parseInt(numeroMembresiaActualizarField.getText());
                Miembro miembro = miembroService.obtenerMiembroPorNumeroMembresia(numeroMembresia);
                if (miembro != null) {
                    nombreActualizarField.setText(miembro.getNombre());
                    apellidoActualizarField.setText(miembro.getApellido());
                    edadActualizarField.setText(String.valueOf(miembro.getEdad()));
                } else {
                    JOptionPane.showMessageDialog(MiembroUIFrame.this, "No se encontró ningún miembro con ese número de membresía.");
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroMembresia = Integer.parseInt(numeroMembresiaActualizarField.getText());
                String nombre = nombreActualizarField.getText();
                String apellido = apellidoActualizarField.getText();
                int edad = Integer.parseInt(edadActualizarField.getText());

                Miembro miembro = miembroService.obtenerMiembroPorNumeroMembresia(numeroMembresia);
                if (miembro != null) {
                    miembro.setNombre(nombre);
                    miembro.setApellido(apellido);
                    miembro.setEdad(edad);
                    miembroService.actualizarMiembro(miembro);
                    JOptionPane.showMessageDialog(MiembroUIFrame.this, "Miembro actualizado correctamente.");
                    limpiarCamposActualizar();
                } else {
                    JOptionPane.showMessageDialog(MiembroUIFrame.this, "No se encontró ningún miembro con el número de membresía proporcionado.");
                }
            }
        });



        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroMembresia = Integer.parseInt(eliminarNumeroMembresiaField.getText());

                // Pedir confirmación al usuario antes de eliminar
                int confirmacion = JOptionPane.showConfirmDialog(MiembroUIFrame.this, "¿Estás seguro de que quieres eliminar este miembro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // Intentar eliminar el miembro
                    miembroService.eliminarMiembro(numeroMembresia);

                    // Refrescar la lista de miembros mostrada en la ventana
                    mostrarMiembros();

                    JOptionPane.showMessageDialog(MiembroUIFrame.this, "Miembro eliminado correctamente.");
                    eliminarNumeroMembresiaField.setText("");
                }
            }
        });




        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMiembros();
            }
        });
    }


    private void registrarMiembro() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        int edad = Integer.parseInt(edadField.getText());
        int numeroMembresia = Integer.parseInt(numeroMembresiaField.getText());

        Miembro miembro = new Miembro(nombre, apellido, edad, numeroMembresia);
        miembroService.registrarMiembro(miembro);
        JOptionPane.showMessageDialog(this, "Miembro registrado correctamente.");
        limpiarCampos();
    }

    private void actualizarMiembro() {
        int numeroMembresia = Integer.parseInt(numeroMembresiaField.getText());
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        int edad = Integer.parseInt(edadField.getText());

        Miembro miembro = new Miembro(nombre, apellido, edad, numeroMembresia);
        miembroService.actualizarMiembro(miembro);
        JOptionPane.showMessageDialog(this, "Miembro actualizado correctamente.");
        limpiarCampos();
    }


    private void mostrarMiembros() {
        // Obtener la lista de miembros del servicio
        List<Miembro> miembros = miembroService.obtenerMiembros();

        // Verificar si la lista está vacía
        if (miembros.isEmpty()) {
            // Si la lista está vacía, mostrar un mensaje en el área de texto
            miembrosArea.setText("No hay miembros registrados.");
        } else {
            // Si la lista no está vacía, mostrar los miembros en el área de texto
            miembrosArea.setText("");
            for (Miembro miembro : miembros) {
                miembrosArea.append(miembro.toString() + "\n");
            }
        }
    }


    private void limpiarCamposActualizar() {
        nombreActualizarField.setText("");
        apellidoActualizarField.setText("");
        edadActualizarField.setText("");
        numeroMembresiaActualizarField.setText("");
    }

    private void limpiarCampos() {
        nombreField.setText("");
        apellidoField.setText("");
        edadField.setText("");
        numeroMembresiaField.setText("");
    }
    // Método para verificar si el número de membresía está registrado
    private boolean verificarMembresiaRegistrada(String numeroMembresia) {
        // Consultar la base de datos para verificar si el número de membresía está registrado
        Miembro miembro = miembroService.obtenerMiembroPorNumeroMembresia(Integer.parseInt(numeroMembresia));
        return miembro != null; // Devolver true si se encontró un miembro con ese número de membresía, false si no se encontró
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MiembroUIFrame().setVisible(true);
            }
        });
    }
}
