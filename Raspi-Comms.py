import serial
import requests

arduino = serial.Serial("/dev/ttyACM0", 9600)
while True :
  msg = arduino.readline()
  msg = str(msg)
  requests.put("https://mralpaca.pythonanywhere.com/put", data=msg)
