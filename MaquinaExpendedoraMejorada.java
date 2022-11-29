public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private int numeroBilletesVendidos;
    
    private boolean verPremio;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioBillete) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        verPremio = premioBillete; 
    }
     public MaquinaExpendedoraMejorada(boolean premioBillete) {
        precioBillete = 45;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Mandril";
        estacionDestino = "Barcelona";
        numeroBilletesVendidos = 0;
        verPremio = premioBillete;
    }
    public int vaciarDinero () {
        int vaciarDinero = balanceClienteActual + totalDineroAcumulado;
        if(balanceClienteActual==0) {
        
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
    }
        else{
            System.out.println("la máquina tiene una operación en curso");
            vaciarDinero=-1;
            
            
        }
            
        
        return vaciarDinero;
    }
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }
    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta=precioBillete - balanceClienteActual;
        if (cantidadDeDineroQueFalta <= 0) { 
            if (verPremio==true) {
                System.out.println("Has ganado un 25%" + (0.25git * precioBillete) +"de descuento(€) en el OF de la hermana de Mauro");
            }
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();
            
            numeroBilletesVendidos += 1;
        
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
        
    }
        else {
            System.out.println("Cantidad De Dinero Que Falta" + cantidadDeDineroQueFalta);

     
        }
        
    }
     public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    public void imprimirNumeroBilletesVendidos(){
        System.out.println("Número de billetes impresos: "+numeroBilletesVendidos);
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
