/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.programacion.gui;

import com.practica.programacion.Cliente;
import com.practica.programacion.Tienda;
import java.awt.event.ActionEvent;

/**
 *
 * @author Santiago Hernández
 */
public class ProductosProp extends ListaElementosSwing {

    /**
     * Creates new form ProductosPropios
     */
    public ProductosProp() {
        super(new ListaProductos(((Cliente) Tienda.tienda.getUsuarioLogueado()).getMisProductos()));
        init();
        setTitle("Lista de productos propios");
    }

    public void init() {
        button1.setText("Añadir");
        button2.setText("Eliminar");
    }

    @Override
    protected void button1(ActionEvent evt) {
        AñadirProductos añadirProductos = new AñadirProductos(Tienda.tienda.getVentanaPrincipal(), true);
        añadirProductos.setVisible(true);
    }

    @Override
    protected void button2(ActionEvent evt) {
        int row = tElementos.getSelectedRow();
        if (row >= 0) {
            modelo.removeRow(row);
            modelo.fireTableStructureChanged();
        }
    }

}
