 /* Sensor de temperatura Directo
 * ------------------ 
 * Laboratorio IoT para Arquitectura de Software 2016-20
 * Universidad de los Andes
 * 
 * el ejemplo lee una entrada analoga del sensor de temperatura y
 * la transmite por el puerto serial como un string cada segundo.
 * 
 * creado el 18 de julio de 2016
 */
 #include <string.h>
 // Selecciona el pin de entrada analoga a leer.
 int tempPin = 4;
 // variable para guardar el valor del sensor de temperatura.j
 //char tempUnit = 'C';
  // variable para guardar el valor del sensor de temperatura.
 int tempC = 0;
 
 // arreglo de chars para envio final del dato del sensor.
 int tempArray[5] = {0,0,0,0,0};
 //id, frecuencia,presion1,presion2,estres
 // variable temporal de conteo
 int i = 0;
 // preparacion del proceso
  int id=0;
 void setup() 
 { 
   // Abre puerto serial y lo configura a 9600 bps bits por segunfdo
     Serial.begin(9600);
     // se fija la unidad de trabajo del sensor de temperatura.
     tempArray[0] = id;
 }
 // ejecuta el procesamiento del sensor

 void loop() 
 {
   // lee el valor del sensor de temperatura en Volts
   tempC = analogRead(tempPin);
   // Convierte el valor a temperatura a grados centigrados y de analogo a digital
   // DEPENDE DEL SENSOR, REVISAR DATASHEET
   tempC = (4.9 * tempC * 100.0)/1024.0;
   
   // se transforma el dato int de temperatura a un char
   //tempArray[0] = String(tempC);
   tempArray[1]=3*tempC+20;
   tempArray[2]=3*tempC+33;
   tempArray[3]=4*tempC;
   tempArray[4]=2*tempC+15;
   // Envia los datos uno por uno del arreglo del sensor por puerto serial
   
   for (i=0; i<5; i++)
   {
     // imprime el elemento del arreglo por el puerto serial
     Serial.print(tempArray[i]);
     // espacio para diferenciar elementos en el arreglo
     if (i < 4)
     {
       Serial.print("\t");      
     }
   }
   // final de la trama de datos
   Serial.println("");
   // espera 1 segundo para repetir el procedimiento
   delay(1000);
   //Serial.println(tempArray[0]);
 }
