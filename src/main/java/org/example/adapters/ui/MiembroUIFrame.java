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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MiembroUIFrame extends JFrame {
    private MiembroServicePort miembroService = new MiembroServiceImpl(new HibernateMiembroRepositoryAdapter());
    private JTextField nombreActualizarField;
    private JTextField apellidoActualizarField;
    private JTextField edadActualizarField;
    private JTextField numeroMembresiaActualizarField;
    private JTextArea registroEntradasArea;
    private JButton entradaButton;
    private JButton salidaButton;


    private Set<Integer> numerosMembresiasIngresados = new HashSet<>();
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField edadField;
    private JTextField numeroMembresiaField;
    private JTextArea miembrosArea;
    private JTextField entradaMembresiaField;

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
        registroPanel.setBackground(new Color(0,0,0)); // Color azul claro

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
        registrarButton.setBackground(new Color(255,165,0));
        registrarButton.setForeground(Color.BLACK);

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
        actualizarPanel.setBackground(new Color(0, 0, 0)); // Color azul claro

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
        buscarButton.setBackground(new Color(255,165,0));
        buscarButton.setForeground(Color.BLACK);

        JButton actualizarButton = new JButton("Actualizar Miembro");
        actualizarButton.setBackground(new Color(255,165,0));
        actualizarButton.setForeground(Color.BLACK);

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
        entradaPanel.setBackground(new Color(0,0,0)); // Color verde oscuro

        GridBagConstraints gbca = new GridBagConstraints();
        gbca.insets = new Insets(5, 5, 5, 5);

        JLabel entradaMembresiaLabel = new JLabel("Ingrese cedula:");
        entradaMembresiaLabel.setForeground(Color.black);
        JTextField entradaMembresiaField = new JTextField(16);

        gbca.gridx = -2;
        gbca.gridy = 0;
        gbca.anchor = GridBagConstraints.CENTER;
        entradaPanel.add(entradaMembresiaLabel, gbca);

        gbca.gridx = 1;
        gbca.anchor = GridBagConstraints.WEST;
        entradaPanel.add(entradaMembresiaField, gbca);

        gbca.gridx = -1;
        gbca.gridy = 1;
        gbca.gridwidth = 2;
        gbca.anchor = GridBagConstraints.CENTER;
        entradaButton = new JButton("Entrada al Gimnasio");
        entradaButton.setBackground(new Color(255,165,0)); // Color verde oscuro
        entradaButton.setForeground(Color.BLACK);
        entradaPanel.add(entradaButton, gbca);

        gbca.gridy = 2;
        salidaButton = new JButton("Salida del Gimnasio");
        salidaButton.setBackground(new Color(255,165,0)); // Color naranja
        salidaButton.setForeground(Color.BLACK);
        entradaPanel.add(salidaButton, gbca);

        add(entradaPanel, BorderLayout.SOUTH);


        // Acción del botón de entrada
        // Crea un HashSet para almacenar los números de membresía ingresados

        entradaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroMembresia = entradaMembresiaField.getText();

                if (numeroMembresia != null && !numeroMembresia.isEmpty()) {
                    int numMembresia = Integer.parseInt(numeroMembresia);

                    // Verifica si el número de membresía ya fue ingresado
                    if (numerosMembresiasIngresados.contains(numMembresia)) {
                        JOptionPane.showMessageDialog(MiembroUIFrame.this, "Ya ingresaste este número de membresía.");
                    } else {
                        // Verificar si el número de membresía está registrado
                        Miembro miembro = miembroService.obtenerMiembroPorNumeroMembresia(numMembresia);
                        if (miembro != null) {
                            mostrarMensajeBienvenida(miembro.getNombre());
                            // Agrega el número de membresía al conjunto de ingresados
                            numerosMembresiasIngresados.add(numMembresia);
                        } else {
                            JOptionPane.showMessageDialog(MiembroUIFrame.this, "El número de membresía no está registrado.");
                        }
                    }
                }
            }
        });


        // Acción del botón de salida
        salidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroMembresia = entradaMembresiaField.getText();

                if (numeroMembresia != null && !numeroMembresia.isEmpty()) {
                    int numMembresia = Integer.parseInt(numeroMembresia);
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String horaSalida = sdf.format(new Date());
                    // Verificar si el número de membresía está registrado
                    Miembro miembro = miembroService.obtenerMiembroPorNumeroMembresia(numMembresia);
                    if (miembro != null) {
                        mostrarMensajeDespedida(miembro.getNombre());
                        // Elimina el número de membresía del conjunto de ingresados
                        numerosMembresiasIngresados.remove(numMembresia);
                    } else {
                        JOptionPane.showMessageDialog(MiembroUIFrame.this, "El número de membresía no está registrado.");
                    }
                }
            }
        });


        // Panel de Eliminación
        JPanel eliminarPanel = new JPanel(new GridBagLayout());
        eliminarPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        eliminarPanel.setBackground(new Color(0, 0, 0)); // Color naranja claro

        JLabel eliminarNumeroMembresiaLabel = new JLabel("Número de membresía (Cédula):");
        eliminarNumeroMembresiaLabel.setForeground(Color.black);
        JTextField eliminarNumeroMembresiaField = new JTextField(17);

        JButton eliminarButton = new JButton("Ingrese la cedula del cliente");
        eliminarButton.setBackground(new Color(255,165,0));
        eliminarButton.setForeground(Color.BLACK);

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
        mostrarPanel.setBackground(new Color(0, 0, 0)); // Color amarillo claro

        miembrosArea = new JTextArea();
        miembrosArea.setEditable(false);
        miembrosArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPanel = new JScrollPane(miembrosArea);
        JButton mostrarButton = new JButton("Mostrar Todos los Miembros");
        mostrarButton.setBackground(new Color(255,165,0));
        mostrarButton.setForeground(Color.BLACK);

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

                // Verificar si el número de membresía ya está registrado
                Miembro miembroExistente = miembroService.obtenerMiembroPorNumeroMembresia(numeroMembresia);
                if (miembroExistente != null) {
                    JOptionPane.showMessageDialog(MiembroUIFrame.this, "Número de membresía ya utilizado.");
                    return; // Detener la ejecución del método
                }

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

    private void mostrarMensajeBienvenida(String nombre) {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = horaActual.format(formatter);
        JOptionPane.showMessageDialog(this, "🎉 ¡Bienvenido al gimnasio, " + nombre + "! 🏋️‍♂️\n ¡Que tengas una excelente sesión! 🌟\n Hora de entrada: " + horaFormateada);
    }

    private void mostrarMensajeDespedida(String nombre) {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = horaActual.format(formatter);
        JOptionPane.showMessageDialog(this, "😢 ¡Hasta pronto, " + nombre + "! 😔\n ¡Esperamos verte de nuevo pronto! 🕒\n Hora de salida: " + horaFormateada);
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
