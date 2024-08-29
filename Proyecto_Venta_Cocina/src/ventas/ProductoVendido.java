package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ProductoVendido extends JDialog {
	String modelo;
    int cantidad;
    double importe, descuento, precio;
    
    
    public ProductoVendido(String modelo, int cantidad, double importe, double descuento, double precio) {
    	this.modelo = modelo;
        this.cantidad = cantidad;
        this.importe = importe;
        this.descuento = descuento;
        this.precio = precio;
    }
    
    public String getModelo() { return modelo; }
    public int getCantidad() { return cantidad; }
    public double getImporte() { return importe; }
    public double getDescuento() { return descuento; }
    public double getPrecio() { return precio; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setImporte(double importe) { this.importe = importe; }
    public void setDescuento(double descuento) { this.descuento = descuento; }

}
