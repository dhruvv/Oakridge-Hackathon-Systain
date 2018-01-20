void setup() {
  Serial.begin(9600);

}

void loop() {
  int value = analogRead(A0);
  float volatage = (value/1024);
  Serial.println(voltage);
  delay(500);

}
