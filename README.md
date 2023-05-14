# PaySafe

*Por David Toderas, Alvar Gómez, Victor De Marco , Diego Urbaneja*

PaySafe es una aplicación de pagos mediante NFC que ofrece a sus usuarios una alternativa similar al pago *contactless*. Tiene la ventaja añadida de que puede usarte tanto para pago en comercios como para pagar entre pares.

## Consideraciones

Antes de utilizar la aplicación una serie de consideraciones para comprender ciertos aspectos importantes:

* En cuanto al **login** es funcional guardando las parejas de usuario-clave en un registro local del dispositivo, lo cual quiere decir que si es la primera vez que se ejecuta la aplicación, no habrá ningún usuario ni contraseña guardados, por lo tanto para acceder, se deberá o bien registrar creando una cuenta o utilizar la contraseña maestra que es `12345`. Una vez creada la cuenta se podrá acceder empleando la pareja de usuario y clave registrada.

* En el **registro**, como comentamos en clase, para los diferentes campos, si se quiere continuar al siguiente campo se ha de hacer mediante el teclado propio del teléfono y la flecha verde de siguiente que aparece en el mismo, de lo contrario, si se usa el tabulador del teclado físico del ordenador, al pulsar el tabulador salta a otro campo que no es el siguiente.

* A al hora de **recibir** o **enviar** pagos, el pin de confirmación válido es `1111` y el único destinatario admitido es `123456`.

* El **modo empresa** está pensado para ser utilizado a modo de datáfono de tal manera que al entrar en modo recibir se oscurecerá la pantalla y se pondrá en modo receptor.

* Los **ajustes** de la aplicación son funcioanles en cuando a guardar las preferencias del usuario independientemente de si la aplicación se cierra.

## Ejecución

Para poder ejecutar la app se necesitarán las siguientes dependencias:

* [Java SE Development Kit](https://www.oracle.com/java/technologies/downloads/#java17) (recomendada 17 o superior)

* [Git](https://git-scm.com/downloads)

* [Android Studio Electric Ell](https://developer.android.com/studio) o más nueva.

### Mediante IDE

Si se desea usar Android Studio para ejecutar la app se debe primero clonar el repositorio usando:

```shell
git clone https://github.com/Urbii22/Paysafe1.0.git
```

Al abrir Android Studio abrir la carpeta en la que se clono el repositorio y se debería de importar el proyecto al editor.
Tras importar el proyecto se podrá ejecutar mediante el botón *Run* en la parte superior o pulsando 'Ctrl + F5' por defecto.

> :warning: **Importante:** el terminal usado para las pruebas de la aplicación es un Nexus 6. La compatibilidad con otros terminales puede ser limitada.

### Mediante Gradle

Para buildear usando Gradle podemos usar la siguiente secuencia de comandos:

```shell
git clone https://github.com/Urbii22/Paysafe1.0.git
cd Paysafe1.0
.\gradlew.bat assembleRelease
```

> :warning: **Muy importante:** tener el PATH bien configurado con el SDK de Android para poder buildear correctamente la app. El SDK mínimo es 24.

La APK resultante quedará en el directorio `Paysafe1.0/app/build/outputs/apk/release` y tendrá el nombre `app-release-unsigned.apk`. Esta APK se debe cargar e instalar en un terminal Android o emulador para poder ejecutar la aplicación.

## Disclaimer

La aplicación es un *mockup*, solo está hecha desde un punto de diseño y la mayoría de las funcionalidades finales no están representadas.