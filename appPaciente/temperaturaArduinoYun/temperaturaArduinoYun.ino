#include <MD5.h>
#include <string.h>

// Selecciona el pin de entrada analoga a leer.
int tempPin = 4;

// variable para guardar el valor del sensor de temperatura.
int tempC = 0;

/*
    arreglo de chars para envio final del dato del sensor.
    id, frecuencia,presion1,presion2,estres
*/

float voltageValue[5] = {1, 0, 0, 0, 0};

int led = 13;
char inbyte = 0;

void setup()
{
  // Abre puerto serial y lo configura a 9600 bps bits por segundo
  Serial.begin(9600);

  // Abre puerto serial1 y lo configura a 9600 bps bits por segundo
  // Este es el del bluetooth
  Serial1.begin(9600);

  pinMode(led, OUTPUT);
  digitalWrite(led, LOW);
}
// ejecuta el procesamiento del sensor
void realizarMedicion()
{
  // lee el valor del sensor de temperatura en Volts
  tempC = analogRead(tempPin)+10;
  Serial.println(tempC);
  voltageValue[1] = tempC+26;
  voltageValue[2] = tempC + 9;
  voltageValue[3] = tempC+28;
  if (tempC + 7 < 100)
  {
    voltageValue[4] = tempC + 7;
  }
  else
  {
    voltageValue[4] = 99;
  }
}

void sendAndroidValues()
{
  Serial1.print('#'); //hay que poner # para el comienzo de los datos, así Android sabe que empieza el String de datos
  for (int k = 0; k < 5; k++)
  {
    Serial1.print(voltageValue[k]);
    Serial1.print('+'); //separamos los datos con el +, así no es más fácil debuggear la información que enviamos
  }
  Serial1.print('~'); //con esto damos a conocer la finalización del String de datos
  Serial1.println();
  delay(10);        //agregamos este delay para eliminar tramisiones faltantes
}
void loop()
{
  // Si hay un mensaje via bluetooth
  if (Serial1.available() > 0)
  {
    inbyte = Serial1.read();
    //Serial1.println(inbyte);
    Serial.println(inbyte);
    if (inbyte == '1')
    {
      digitalWrite(led, HIGH); //LED on
      realizarMedicion();
      sendAndroidValues();
    }
    digitalWrite(led, LOW); //LED off
    realizarMedicion();
  }
  
}


/*

  // lee el valor del sensor de temperatura en Volts
  tempC = analogRead(tempPin);
  // Convierte el valor a temperatura a grados centigrados y de analogo a digital
  // DEPENDE DEL SENSOR, REVISAR DATASHEET
  //tempC = (4.9 * tempC * 100.0)/1024.0;
  tempC = tempC / 8;
  // se transforma el dato int de temperatura a un char
  //tempArray[0] = String(tempC);
  tempArray[1] = tempC;
  tempArray[2] = tempC + 13;
  tempArray[3] = tempC;
  if (tempC + 7 < 100)
  {
   tempArray[4] = tempC + 7;
  }
  else
  {
   tempArray[4] = 100;
  }

  String arreglo = "";

  arreglo = arreglo + tempArray[1];
  //Serial.print(arreglo+"\n");

  char charBuf[50];
  arreglo.toCharArray(charBuf, 50);



  unsigned char* hash = MD5::make_hash(charBuf);
  //generate the digest (hex encoding) of our hash
  char * md5str = MD5::make_digest(hash, 16);
  //print it on our serial monitor


  // Envia los datos uno por uno del arreglo del sensor por puerto serial

  for (i = 0; i < 5; i++)
  {
   // imprime el elemento del arreglo por el puerto serial
   Serial.print(tempArray[i]);
   // espacio para diferenciar elementos en el arreglo
   if (i < 5)
   {
     Serial.print("\t");
   }
  }
  Serial.print(md5str);
  // final de la trama de datos
  Serial.println("");
  // espera 1 segundo para repetir el procedimiento
  delay(1000);
  //Serial.println(tempArray[0]);


}
*/
