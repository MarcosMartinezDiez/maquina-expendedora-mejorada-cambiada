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

    private int maximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioBillete, int maxBillete) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        verPremio = premioBillete;
        maximoBilletes= maxBillete;
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
            System.out.println("la m?quina tiene una operaci?n en curso");
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
        if (maximoBilletes > numeroBilletesVendidos){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;

            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }        
        }
        else {
            System.out.println("No hay m?s billetes");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta=precioBillete - balanceClienteActual;
        if( maximoBilletes > numeroBilletesVendidos ){
            if (cantidadDeDineroQueFalta <= 0) { 
                if (verPremio==true) {
                    if( numeroBilletesVendidos % 4 == 3 ){
                        System.out.println("Enhorabuena has ganado un descuento de "+(precioBillete*0.25)+"? en el OF de la hermana de Mauro.");
                    }
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
        else {
            System.out.println("Maximo numero de billetes alcanzado");
        }
    }

    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }

    public void imprimirNumeroBilletesVendidos(){
        System.out.println("N?mero de billetes impresos: "+numeroBilletesVendidos);
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
