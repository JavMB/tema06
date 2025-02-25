package com.javier.lib;

public class IO {
//******************************** SOLICITAR ********************************\\
    public enum Condicion{
    MAXIMO, MINIMO
    }
    //----------INT----------\\

    /**
     * Solicita un 'int' sin condiciones.
     *
     * @param solicitud Mensaje que se imprime para solicitar el 'int'.
     * @return Devuelve el 'int' una vez validado.
     */
    public static int solicitarInt(String solicitud) {
        return solicitarInt(solicitud, Integer.MIN_VALUE, Integer.MAX_VALUE, "ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
    }

    /**
     * Solicita un 'int' sin condiciones.
     *
     * @param solicitud Mensaje que se imprime para solicitar el 'int'.
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve el 'int' una vez validado.
     */
    public static int solicitarInt(String solicitud, String mensajeError) {
        return solicitarInt(solicitud, Integer.MIN_VALUE, Integer.MAX_VALUE, mensajeError);
    }

    /**
     * Solicita un 'int' mediante un mensaje, validando que sea un valor superior a un mínimo.
     *
     * @param solicitud Mensaje que se imprime para solicitar el 'int'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede valer el 'int'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @return Devuelve el 'int' una vez validado.
     */
    public static int solicitarInt(String solicitud, int valor, Condicion condicion) {
        if (condicion == Condicion.MAXIMO){
            return solicitarInt(solicitud, Integer.MIN_VALUE, valor, "ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
        } else {
            return solicitarInt(solicitud, valor, Integer.MAX_VALUE, "ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
        }

    }

    /**
     * Solicita un int mediante un mensaje, validando que esté comprendido dentro de un rango.
     *
     * @param solicitud Mensaje que se imprime para solicitar el 'int'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede valer el 'int'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve el 'int' una vez validado.
     */
    public static int solicitarInt(String solicitud, int valor, Condicion condicion, String mensajeError) {
        if (condicion == Condicion.MAXIMO){
            return solicitarInt(solicitud, Integer.MIN_VALUE, valor, mensajeError);
        } else {
            return solicitarInt(solicitud, valor, Integer.MAX_VALUE, mensajeError);
        }

    }

    /**
     * Solicita un 'int' y valida que se encuentre en el rango comprendido entre un mínimo y un máximo.
     *
     * @param mensajeSolicitud Mensaje que se le muestra al usuario.
     * @param minimo Número mínimo valido que puede valer el 'int'.
     * @param maximo Número máximo válido que puede valer el 'int'.
     * @return Devuelve un 'int' validado.
     * @author luklpz
     */
    public static int solicitarInt(String mensajeSolicitud, int minimo, int maximo) {
        return solicitarInt(mensajeSolicitud,minimo,maximo,"ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
    }

    /**
     * Solicita un 'int' y valida que se encuentre en el rango comprendido entre un mínimo y un máximo.
     *
     * @param mensajeSolicitud Mensaje que se le muestra al usuario.
     * @param minimo Número mínimo valido que puede valer el 'int'.
     * @param maximo Número máximo válido que puede valer el 'int'.
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve un 'int' validado.
     * @author luklpz
     */
    public static int solicitarInt(String mensajeSolicitud, int minimo, int maximo, String mensajeError) {
        int respuesta;
        do {
            //Solicitamos el 'int'
            System.out.print(mensajeSolicitud);
            respuesta = Integer.parseInt(retirarCaracteresNoNumericos(Escaner.lector.nextLine().trim()));
            //Validamos la respuesta
            if (respuesta<minimo||respuesta>maximo) {
                System.err.print(mensajeError);
            }
        } while (respuesta<minimo||respuesta>maximo);
        return respuesta;
    }


    //----------DOUBLE----------\\

    /**
     * Solicita un 'double' sin condiciones.
     * @param solicitud Mensaje que se imprime para solicitar el 'double'.
     * @return Devuelve el 'double' una vez validado.
     */
    public static double solicitarDouble(String solicitud) {
        return solicitarDouble(solicitud, "ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
    }

    /**
     * Solicita un 'double' sin condiciones.
     * @param solicitud Mensaje que se imprime para solicitar el 'double'.
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve el 'double' una vez validado.
     */
    public static double solicitarDouble(String solicitud, String mensajeError) {
        return solicitarDouble(solicitud, Integer.MIN_VALUE, Integer.MAX_VALUE, mensajeError);
    }

    /**
     * Solicita un 'double' mediante un mensaje, validando que sea un valor superior a un mínimo.
     *
     * @param solicitud Mensaje que se imprime para solicitar el 'double'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede valer el 'double'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @return Devuelve el 'double' una vez validado.
     */
    public static double solicitarDouble(String solicitud, double valor, Condicion condicion) {
        if (condicion == Condicion.MAXIMO){
            return solicitarDouble(solicitud, Double.MIN_VALUE, valor, "ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
        } else {
            return solicitarDouble(solicitud, valor, Double.MAX_VALUE, "ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
        }

    }

    /**
     * Solicita un 'double' mediante un mensaje, validando que sea un valor superior a un mínimo.
     *
     * @param solicitud Mensaje que se imprime para solicitar el 'double'.
     * @param valor Valor que máximo o mínimo, según la condición, que puede valer el 'double'.
     * @param condicion Condición que indica si el valor indicado es un máximo o un mínimo.
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve el 'double' una vez validado.
     */
    public static double solicitarDouble(String solicitud, double valor, Condicion condicion, String mensajeError) {
        if (condicion == Condicion.MAXIMO){
            return solicitarDouble(solicitud, Double.MIN_VALUE, valor, mensajeError);
        } else {
            return solicitarDouble(solicitud, valor, Double.MAX_VALUE, mensajeError);
        }

    }

    /**
     * Solicita un 'double' y valida que se encuentre en el rango comprendido entre un mínimo y un máximo.
     *
     * @param mensajeSolicitud Mensaje que se le muestra al usuario.
     * @param minimo Número mínimo válido que puede valer el 'double'.
     * @param maximo Número máximo válido que puede valer el 'double'.
     * @return Devuelve un 'Double' validado en un rango.
     */
    public static double solicitarDouble(String mensajeSolicitud, double minimo, double maximo) {
        return solicitarDouble(mensajeSolicitud,minimo,maximo,"ERROR: Valor fuera del rango comprendido entre el máximo posible y el mínimo posible.");
    }

    /**
     * Solicita un 'double' y valida que se encuentre en el rango comprendido entre un mínimo y un máximo.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param minimo Número mínimo válido que puede valer el 'double'.
     * @param maximo Número máximo válido que puede valer el 'double'.
     * @param mensajeError Mensaje de error que se muestra al introducir un valor inválido.
     * @return Devuelve un 'Double' validado en un rango.
     */
    public static double solicitarDouble(String mensaje, double minimo, double maximo, String mensajeError) {
        double respuesta;
        do {
            //Solicitamos el 'double'
            System.out.println(mensaje);
            respuesta = Double.parseDouble(Escaner.lector.nextLine().trim().replaceAll("\\s+",""));
            //Validamos la respuesta
            if (respuesta<minimo||respuesta>maximo) {
                System.err.println(mensajeError);
            }
        } while (respuesta<minimo||respuesta>maximo);
        return respuesta;
    }

    //----------------------------------------------------
    /**
     * Retorna un 'int' proveniente de retirar todos los caracteres no numericos de un 'String'.
     *
     * @param texto Texto sobre el cual trabajar.
     * @return Devuelve un "String" de los caracteres numericos de un 'String'.
     */
    public static String retirarCaracteresNoNumericos(String texto){
        if (texto.isEmpty()){
            return "";
        }
        return (texto.trim()).replaceAll("\\D+","");
    }

    //----------STRING----------\\

    /**
     * Solicita un 'String'
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @return String que ingresa el usuario.
     */
    public static String solicitarString(String mensaje, Boolean numerico){
        String respuesta;
        System.out.print(mensaje);
        respuesta=Escaner.lector.nextLine();
        if (numerico){
            respuesta=respuesta.replaceAll("\\D+","");
        }
        return respuesta;
    }

    /**
     * Solicita un 'String' y valida que su longitud esté comprendida entre una longitud mínima 'lngMin' y una longitud máxima 'lngMax'.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param lngMin  Número mínimo de caracteres que debe tener el 'String'.
     * @param lngMax  Número máximo de caracteres que puede tener el 'String'.
     * @return Devuelve el 'String' validado.
     */
    public static String solicitarString(String mensaje, int lngMin, int lngMax){
        return solicitarString(mensaje,lngMin,lngMax,String.format("La respuesta proporcionada no puede tener una longitud inferior a %s, ni superior a %s caracteres.\n\n", lngMin, lngMax));
    }

    /**
     * Solicita un 'String' y valida que su longitud esté comprendida entre una longitud mínima 'lngMin' y una longitud máxima 'lngMax'.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param lngMin  Número mínimo de caracteres que debe tener el 'String'.
     * @param lngMax  Número máximo de caracteres que puede tener el 'String'.
     * @param mensajeError Mensaje que se muestra si la validación falla.
     * @return Devuelve el 'String' validado.
     * @author luklpz
     */
    public static String solicitarString(String mensaje, int lngMin, int lngMax, String mensajeError) {
        return solicitarString(mensaje, lngMin, lngMax, mensajeError, false);
    }

        /**
         * Solicita un 'String' y valida que su longitud esté comprendida entre una longitud mínima 'lngMin' y una longitud máxima 'lngMax'.
         *
         * @param mensaje Mensaje que se le muestra al usuario.
         * @param lngMin  Número mínimo de caracteres que debe tener el 'String'.
         * @param lngMax  Número máximo de caracteres que puede tener el 'String'.
         * @param mensajeError Mensaje que se muestra si la validación falla.
         * @param soloNumeros Si se marca como 'true' eliminará todos los caracteres no numericos antes de validar.
         * @return Devuelve el 'String' validado.
         * @author luklpz
         */
    public static String solicitarString(String mensaje, int lngMin, int lngMax, String mensajeError, boolean soloNumeros) {
        String respuesta;
        do {
            //Solicitamos el 'String'
            System.out.print(mensaje);
            respuesta = Escaner.lector.nextLine();
            //Validamos la respuesta
            if (soloNumeros){
                respuesta=retirarCaracteresNoNumericos(respuesta);
            }
            if (respuesta.length() < lngMin || respuesta.length() > lngMax) {
                System.err.print(mensajeError);
            }
        } while (respuesta.length() < lngMin || respuesta.length() > lngMax);
        return respuesta;
    }

    //----------FLOAT----------\\

    /**
     * Solicita un 'float' y valida que se encuentre en el rango comprendido entre un mínimo 'min' y un máximo 'max'.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param min Número mínimo válido que puede valer el 'float'.
     * @param max Número máximo válido que puede valer el 'float'.
     * @return Devuelve un 'float' validado.
     * @author luklpz
     */
    public static float solicitarFloat(String mensaje, float min, float max) {
        float respuesta;
        do {
            //Solicitamos el 'float'
            System.out.println(mensaje);
            respuesta = Float.parseFloat(Escaner.lector.nextLine());
            //Validamos la respuesta
            if (respuesta<min||respuesta>max) {
                System.err.printf("El número introducido no puede ser inferior a %f, ni superior a %f.\n\n", min, max);
            }
        } while (respuesta<min||respuesta>max);
        return respuesta;
    }

    //----------CHAR----------\\

    /**
     * Solicita un 'char' y valida que se haya introducido un único caracter.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @return Devuelve un 'char' validado.
     */
    public static char solicitarChar(String mensaje){
        return solicitarChar(mensaje,"El número de carácteres introducidos es inválido.");
    }

    /**
     * Solicita un 'char' y valida que se haya introducido un único caracter.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param mensajeError Mensaje de error que se muestra al introducir un número de carácteres inválido.
     * @return Devuelve un 'char' validado.
     */
    public static char solicitarChar(String mensaje, String mensajeError){
        boolean valido=false;
        String respuesta;
        do {
            //Solicitarmos el 'char'
            System.out.print(mensaje);
            respuesta = Escaner.lector.nextLine();
            if (respuesta.length()!=1){
                System.err.println(mensajeError);
            } else {
                valido=true;
            }
        } while (!valido);
        return respuesta.charAt(0);
    }

    //----------BOOLEAN----------\\


    /**
     * Solicita un 'boolean' y valida que se haya introducido una respuesta válida.
     *
     * @param mensaje Mensaje que se le muestra al usuario.
     * @param textoTrue Texto que ha de introducir el usuario para devolver 'True'.
     * @param textoFalse Texto que ha de introducir el usuario para devolver 'False'.
     * @param mensajeError Mensaje que se muestra si la validación falla.
     * @return Devuelve true o false según la entrada del usuario.
     */
    public static boolean solicitarBoolean(String mensaje,String textoTrue, String textoFalse, String mensajeError){
        boolean valido=false;
        boolean devuelve=false;
        String respuesta;
        do{
            //Solicitamos el boolean
            System.out.print(mensaje);
            respuesta = (Escaner.lector.nextLine()).trim().replaceAll("\\s+","").toLowerCase();

            //Verificamos si la respuesta corresponde exactamente
            if (respuesta.equals(textoTrue.toLowerCase())){
                devuelve = true;
                valido = true;
            }
            else if (respuesta.equals(textoFalse.toLowerCase())) {
                valido = true;
            } else {
                System.err.print(mensajeError);
            }
        } while (!valido);
        return devuelve;
    }
}