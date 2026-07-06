# Climalert - Motor de Monitoreo Meteorológico

## Arquitectura y Perfiles
El sistema implementa arquitectura de puertos y adaptadores, dividiendo su ejecución en dos entornos estrictos:

*   **Perfil `dev` (Desarrollo):** Aísla la red. Utiliza simuladores (`Mocks`) para inyectar condiciones climáticas extremas e intercepta el envío de correos, volcando la salida directamente en la consola. Ideal para pruebas de concurrencia.
*   **Perfil `prod` (Producción):** Conecta con la API real de WeatherAPI y habilita el adaptador SMTP para el despacho de alertas vía Gmail.

## Configuración de Entorno (Obligatoria)
Para ejecutar el sistema en el perfil `prod`, el motor requiere la inyección de credenciales externas. No modifique el archivo `application.properties`. Inyecte las siguientes variables de entorno en su IDE o terminal antes de iniciar:

*   `WEATHER_API_KEY`: Token de autenticación de WeatherAPI.
*   `MAIL_USER`: Dirección de correo electrónico del remitente (Gmail).
*   `MAIL_PASS`: Contraseña de Aplicación de Google (App Password de 16 caracteres).
